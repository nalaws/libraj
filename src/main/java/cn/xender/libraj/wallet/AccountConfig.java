package cn.xender.libraj.wallet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.libra.types.AccountStateBlobOuterClass.AccountStateBlob;

import cn.xender.libraj.common.Unitl;

public class AccountConfig {
	public static final String ACCOUNT_MODULE_NAME = "LibraAccount";
	public static final String ACCOUNT_STRUCT_NAME = "T";
	
	public String coreCodeAddress() {
		return "0000000000000000000000000000000000000000000000000000000000000000";
	}

	public byte[] accountResourcePath() {
		StructTag tag = new StructTag(coreCodeAddress(), ACCOUNT_MODULE_NAME, ACCOUNT_STRUCT_NAME, new StructTag[]{});
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		AccessPath path = new AccessPath();
		try {
			buffer.write(path.resourceAccessVec(tag, null));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buffer.toByteArray();
	}
	
	public byte[] accountSentEventPath() {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
			buffer.write(accountResourcePath());
			buffer.write('/');
			buffer.write("sent_events_count".getBytes());
			buffer.write('/');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			buffer.reset();
		}
		return buffer.toByteArray();
	}
	
	public byte[] accountReceivedEventPath() {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
			buffer.write(accountResourcePath());
			buffer.write('/');
			buffer.write("received_events_count".getBytes());
			buffer.write('/');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			buffer.reset();
		}
		return buffer.toByteArray();
	}
	
	public AccountResource getAccountResourceOrDefault(AccountStateBlob blob) {
		byte[] accountResourceBytes = getAccountResourceBytes(blob);
		if(accountResourceBytes == null) {
			return new AccountResource();
		} else {
			return new AccountResource(accountResourceBytes);
		}
	}
	
	@SuppressWarnings("unused")
	private byte[] getAccountResourceBytes(AccountStateBlob blob) {
		if(blob.getBlob().size() == 0) {
			return null;
		}
		byte[] blobBytes = blob.getBlob().toByteArray();
		int pos = 0;
		byte[] countBytes = new byte[4];
		System.arraycopy(blobBytes, pos, countBytes, 0, 4);
		pos += 4;
		int count = Unitl.bytes2Int(Unitl.reverseBytes(countBytes));
		for(int i = 0; i < count; i++) {
			byte[] keylenBytes = new byte[4];
			System.arraycopy(blobBytes, pos, keylenBytes, 0, 4);
			pos += 4;
			int keylen = Unitl.bytes2Int(Unitl.reverseBytes(keylenBytes));
			byte[] key = new byte[keylen];
			System.arraycopy(blobBytes, pos, key, 0, keylen);
			pos += keylen;
			byte[] valuelenBytes = new byte[4];
			System.arraycopy(blobBytes, pos, valuelenBytes, 0, 4);
			pos += 4;
			int valuelen = Unitl.bytes2Int(Unitl.reverseBytes(valuelenBytes));
			byte[] value = new byte[valuelen];
			System.arraycopy(blobBytes, pos, value, 0, valuelen);
			pos += valuelen;
			if(Arrays.equals(key, accountResourcePath())) {
				return value;
			}
		}
		return null;
	}
}
