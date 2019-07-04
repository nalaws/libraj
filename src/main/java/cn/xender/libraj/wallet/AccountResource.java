package cn.xender.libraj.wallet;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import cn.xender.libraj.common.Unitl;

public class AccountResource {
	private long balance;
	private long sequenceNumber;
    private byte[] authenticationKey;
    private long sentEventsCount;
    private long receivedEventsCount;
    
    public AccountResource() {
    	
    }
    
    public AccountResource(byte[] payload) {
    	this.libraDeserialize(payload);
    }
    
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public long getSequenceNumber() {
		return sequenceNumber;
	}
	
	public void setSequenceNumber(long sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	
	public byte[] getAuthenticationKey() {
		return authenticationKey;
	}
	
	public void setAuthenticationKey(byte[] authenticationKey) {
		this.authenticationKey = authenticationKey;
	}
	
	public long getSentEventsCount() {
		return sentEventsCount;
	}
	
	public void setSentEventsCount(long sentEventsCount) {
		this.sentEventsCount = sentEventsCount;
	}
	
	public long getReceivedEventsCount() {
		return receivedEventsCount;
	}
	
	public void setReceived_events_count(long receivedEventsCount) {
		this.receivedEventsCount = receivedEventsCount;
	}
	
	public final byte[] libraSerialize() {
		return null;
	}
	
	public final void libraDeserialize(byte[] payload) {
		if (payload == null) {
			return;
		}
		int pos = 0;
		byte[] lenBytes = new byte[4];
		System.arraycopy(payload, 0, lenBytes, 0, 4);
		pos += 4;
		ByteArrayInputStream klenStream = new ByteArrayInputStream(Unitl.reverseBytes(lenBytes));
		DataInputStream klenInput = new DataInputStream(klenStream);
		int klen = 0;
		try {
			klen = klenInput.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.authenticationKey = new byte[klen];
		System.arraycopy(payload, pos, this.authenticationKey, 0, klen);
		pos += klen;
		byte[] balanceBytes = new byte[8];
		System.arraycopy(payload, pos, balanceBytes, 0, 8);
		pos += 8;
		ByteArrayInputStream balanceStream = new ByteArrayInputStream(Unitl.reverseBytes(balanceBytes));
		DataInputStream balanceInput = new DataInputStream(balanceStream);
		try {
			this.balance = balanceInput.readLong();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] revEventCountBytes = new byte[8];
		System.arraycopy(payload, pos, revEventCountBytes, 0, 8);
		pos += 8;
		ByteArrayInputStream revEventCountStream = new ByteArrayInputStream(Unitl.reverseBytes(revEventCountBytes));
		DataInputStream revEventCountInput = new DataInputStream(revEventCountStream);
		try {
			this.receivedEventsCount = revEventCountInput.readLong();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] sentEventCountBytes = new byte[8];
		System.arraycopy(payload, pos, sentEventCountBytes, 0, 8);
		pos += 8;
		ByteArrayInputStream sentEventCountStream = new ByteArrayInputStream(Unitl.reverseBytes(sentEventCountBytes));
		DataInputStream sentEventCountInput = new DataInputStream(sentEventCountStream);
		try {
			this.sentEventsCount = sentEventCountInput.readLong();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] seqNumBytes = new byte[8];
		System.arraycopy(payload, pos, seqNumBytes, 0, 8);
		pos += 8;
		ByteArrayInputStream seqNumStream = new ByteArrayInputStream(Unitl.reverseBytes(seqNumBytes));
		DataInputStream seqNumInput = new DataInputStream(seqNumStream);
		try {
			this.sequenceNumber = seqNumInput.readLong();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
