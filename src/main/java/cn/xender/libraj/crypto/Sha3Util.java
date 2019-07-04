package cn.xender.libraj.crypto;

import static java.lang.System.arraycopy;

import java.security.GeneralSecurityException;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.HKDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;


public class Sha3Util {

    public static byte[] sha3224(byte[]... inputs) {
    	return sha3(224, inputs);
    }
    
    public static byte[] sha3256(byte[]... inputs) {
    	return sha3(256, inputs);
    }
    
    public static byte[] sha3384(byte[]... inputs) {
    	return sha3(384, inputs);
    }
    
    public static byte[] sha3512(byte[]... inputs) {
    	return sha3(512, inputs);
    }
    
    private static byte[] sha3(int byteslen, byte[]... inputs) {
    	Digest digest = new SHA3Digest(byteslen);
    	for (byte[] input : inputs) {
    		digest.update(input, 0, input.length);
    	}
        byte[] rsData = new byte[digest.getDigestSize()];
        digest.doFinal(rsData, 0);
		return rsData;
    }
    
    public static Mac macSha256(byte[] key) {
    	Digest digest = new SHA3Digest(256);
    	HMac hmac = new HMac(digest);
    	CipherParameters param = new KeyParameter(key);
    	hmac.init(param);
		return hmac;
    }
    
    public static byte[] hmacSha256(byte[] key, byte[] message) {
    	Digest digest = new SHA3Digest(256);
    	HMac hmac = new HMac(digest);
    	CipherParameters param = new KeyParameter(key);
    	hmac.init(param);
    	if(message != null && message.length > 0) {
    		hmac.update(message, 0, message.length);
    	}
    	byte[] out = new byte[32];
    	hmac.doFinal(out, 0);
		return out;
    }
    
    public static byte[] hkdfExpend(byte[] prk, byte[] info) {
    	HKDFBytesGenerator generator = new HKDFBytesGenerator(new SHA3Digest(256));
    	DerivationParameters param = HKDFParameters.skipExtractParameters(prk, info);
		generator.init(param);
    	byte[] out = new byte[32];
		generator.generateBytes(out, 0, 32);
		return out;
    }
    
    public static void pbkdf2(Mac mac, byte[] S, int c, byte[] DK, int dkLen) throws GeneralSecurityException {
        int hLen = mac.getMacSize();
        if (dkLen > (Math.pow(2, 32) - 1) * hLen) {
            throw new GeneralSecurityException("Requested key length too long");
        }

        byte[] U      = new byte[hLen];
        byte[] T      = new byte[hLen];
        byte[] block1 = new byte[S.length + 4];

        int l = (int) Math.ceil((double) dkLen / hLen);
        int r = dkLen - (l - 1) * hLen;

        arraycopy(S, 0, block1, 0, S.length);

        for (int i = 1; i <= l; i++) {
            block1[S.length + 0] = (byte) (i >> 24 & 0xff);
            block1[S.length + 1] = (byte) (i >> 16 & 0xff);
            block1[S.length + 2] = (byte) (i >> 8  & 0xff);
            block1[S.length + 3] = (byte) (i >> 0  & 0xff);

            mac.update(block1, 0 , block1.length);
            mac.doFinal(U, 0);
            arraycopy(U, 0, T, 0, hLen);

            for (int j = 1; j < c; j++) {
                mac.update(U, 0, U.length);
                mac.doFinal(U, 0);

                for (int k = 0; k < hLen; k++) {
                    T[k] ^= U[k];
                }
            }

            arraycopy(T, 0, DK, (i - 1) * hLen, (i == l ? r : hLen));
        }
    }
}
