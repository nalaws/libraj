package cn.xender.libraj.wallet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import cn.xender.libraj.common.Hex;
import cn.xender.libraj.common.Unitl;
import cn.xender.libraj.crypto.LibraHash;
import cn.xender.libraj.crypto.Sha3Util;

public class StructTag {
	public String address;
	public String module;
	public String name;
	public StructTag[] typeParams;
	
	public StructTag() {
		
	}
	
	public StructTag(String address, String module, String name, StructTag[] typeParams) {
		this.address = address;
		this.module = module;
		this.name = name;
		this.typeParams = typeParams;
	}
	
	public byte[] canonicalSerialize() {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
			byte[] addressBytes = Hex.Hex2Bytes(this.address);
			buffer.write(Unitl.reverseBytes(Unitl.int2Bytes(addressBytes.length)));
			buffer.write(addressBytes);
			byte[] moduleBytes = this.module.getBytes("UTF-8");
			buffer.write(Unitl.reverseBytes(Unitl.int2Bytes(moduleBytes.length)));
			buffer.write(moduleBytes);
			byte[] nameBytes = this.name.getBytes("UTF-8");
			buffer.write(Unitl.reverseBytes(Unitl.int2Bytes(nameBytes.length)));
			buffer.write(nameBytes);
			if (this.typeParams == null) {
				this.typeParams = new StructTag[]{};
			}
			buffer.write(Unitl.reverseBytes(Unitl.int2Bytes(this.typeParams.length)));
			for (StructTag param : this.typeParams) {
				buffer.write(param.canonicalSerialize());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			buffer.reset();
		}
		
		return buffer.toByteArray();
	}
	
	public byte[] hash() {
		return Sha3Util.sha3256(LibraHash.accessPathExpr(), canonicalSerialize());
	}
}
