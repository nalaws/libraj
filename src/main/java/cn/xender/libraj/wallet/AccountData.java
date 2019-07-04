package cn.xender.libraj.wallet;

public class AccountData {
	public String AccountAddress;
	public ExtendedPrivKey.KeyPair keyPair;
	public long sequenceNumber;
	public AccountStatus status;
	
	public enum AccountStatus {
		Local,
	    Persisted,
	    Unknown;
	}
	
	public AccountData() {
		
	}
}
