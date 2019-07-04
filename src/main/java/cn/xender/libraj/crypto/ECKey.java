package cn.xender.libraj.crypto;

import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;

public class ECKey {
	
	private Ed25519PrivateKeyParameters privateKey;
	private Ed25519PublicKeyParameters publicKey;
	
	public ECKey(Ed25519PrivateKeyParameters privateKey) {
		this.privateKey = privateKey;
		this.publicKey = privateKey.generatePublicKey();
	}
	
    
    public static ECKey fromPrivate(byte[] privKeyBytes) {
        Ed25519PrivateKeyParameters privateKey = new  Ed25519PrivateKeyParameters(privKeyBytes, 0);   	
        return new ECKey(privateKey);
    }
    
    public byte[] getPublicKey() {
    	return publicKey.getEncoded();
    }
    
    public byte[] sign(byte[] message) throws DataLengthException, CryptoException {
    	Signer signer = new Ed25519Signer();
        signer.init(true, privateKey);
        signer.update(message, 0, message.length);
        return signer.generateSignature();
    }
    
    public boolean verify(byte[] message, byte[] signature, byte[] pubkey) {
    	Ed25519PublicKeyParameters pubParameters = new Ed25519PublicKeyParameters(pubkey, 0);
    	Signer verifier = new Ed25519Signer();
        verifier.init(false, pubParameters);
        verifier.update(message, 0, message.length);
        return verifier.verifySignature(signature);
    }
}
