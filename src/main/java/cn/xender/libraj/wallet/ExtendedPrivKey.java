package cn.xender.libraj.wallet;

import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import cn.xender.libraj.common.Hex;
import cn.xender.libraj.crypto.Sha3Util;



public class ExtendedPrivKey {	
	private long childNumber;
	private Ed25519PrivateKeyParameters privateKey;
	
	public ExtendedPrivKey(long childNumber, Ed25519PrivateKeyParameters privateKey) {
		this.childNumber = childNumber;
		this.privateKey = privateKey;
	}
	
	public long getChildNumber() {
		return childNumber;
	}

	public void setChildNumber(long childNumber) {
		this.childNumber = childNumber;
	}
	
	public byte[] getPrivateKey() {
		return this.privateKey.getEncoded();
	}

	public byte[] getPublicKey() {
		return this.privateKey.generatePublicKey().getEncoded();
	}
	
	public String getAddress() {
		byte[] pubkey = getPublicKey();
		byte[] hash = Sha3Util.sha3256(pubkey);
		return Hex.Bytes2Hex(hash);
	}
	
	public byte[] sign(byte[] message) throws DataLengthException, CryptoException {
    	Signer signer = new Ed25519Signer();
        signer.init(true, privateKey);
        signer.update(message, 0, message.length);
        return signer.generateSignature();
    }
    
    public static boolean verify(byte[] message, byte[] signature, byte[] pubkey) {
    	Ed25519PublicKeyParameters pubParameters = new Ed25519PublicKeyParameters(pubkey, 0);
    	Signer verifier = new Ed25519Signer();
        verifier.init(false, pubParameters);
        verifier.update(message, 0, message.length);
        return verifier.verifySignature(signature);
    }
    
    public static class KeyPair {
    	public final ExtendedPrivKey privateKey;
    	public final byte[] publicKey;
    	
    	public KeyPair(ExtendedPrivKey privateKey,  byte[] publicKey) {
            this.privateKey = privateKey;
            this.publicKey = publicKey;
        }

        public static KeyPair fromComponents(byte[] master, long child) {
        	ExtendedPrivKey prvkey = KeyFactory.privateChild(master, child);
            return new KeyPair(prvkey, prvkey.getPublicKey());
        }
    }
}
