package cn.xender.libraj.wallet;

import java.security.GeneralSecurityException;

import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;

import cn.xender.libraj.common.Unitl;
import cn.xender.libraj.crypto.Sha3Util;

public class KeyFactory {
	public final static String MNEMONIC_SALT_PREFIX = "LIBRA WALLET: mnemonic salt prefix$";
	public final static String MASTER_KEY_SALT = "LIBRA WALLET: master key salt$";
	public final static String INFO_PREFIX = "LIBRA WALLET: derived key$";
	
	private byte[] seed;
	private byte[] master;

	public KeyFactory() {
		
	}
	
	public KeyFactory(byte[] seed) {
		this.seed = seed;	
	}
	
	public byte[] newSeed(String mnemonic, String salt) {
		byte[] msalt = (MNEMONIC_SALT_PREFIX+salt).getBytes();
		Mac mac = Sha3Util.macSha256(mnemonic.getBytes());
		this.seed = new byte[32];
		try {
			Sha3Util.pbkdf2(mac, msalt, 2048, this.seed, 32);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.seed;
	}
	
	public byte[] newMaster(byte[] seed) {
		this.master = Sha3Util.hmacSha256(MASTER_KEY_SALT.getBytes(), seed);
		return this.master;
	}
	
	public static ExtendedPrivKey privateChild(byte[]parent, long childNumber) {
		byte[] childBytes = Unitl.long2Bytes(childNumber);
		byte[] childLe = Unitl.reverseBytes(childBytes);
		byte[] infoPrefix = KeyFactory.INFO_PREFIX.getBytes();
		byte[] info = new byte[childLe.length + infoPrefix.length];
		System.arraycopy(infoPrefix, 0, info, 0, infoPrefix.length);
		System.arraycopy(childLe, 0, info, infoPrefix.length, childLe.length);
		byte[] prvkeyBytes = Sha3Util.hkdfExpend(parent, info); 	
		return new ExtendedPrivKey(childNumber, new Ed25519PrivateKeyParameters(prvkeyBytes, 0));
	}
}
