package cn.xender.libraj.wallet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import cn.xender.libraj.common.Unitl;

public class AccessPath {
	public static final byte CODE_TAG = 0x00;
	public static final byte RESOURCE_TAG = 0x01; 
	

	public byte[] resourceAccessVec(StructTag tag, StringBuilder accesses) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
			buffer.write(RESOURCE_TAG);
			buffer.write(tag.hash());
			if(accesses != null) {
				byte[] accessBytes = accesses.toString().getBytes();
				buffer.write(Unitl.reverseBytes(Unitl.int2Bytes(accessBytes.length)));
				buffer.write(accessBytes);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			buffer.reset();
		}
		return buffer.toByteArray();
	}
}
