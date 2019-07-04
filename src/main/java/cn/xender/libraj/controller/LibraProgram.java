package cn.xender.libraj.controller;

import com.alibaba.fastjson.JSONObject;

public class LibraProgram {
	public String transaction;
	public String to;
	public long amount;
	
	public LibraProgram(String transaction, String to, long amount) {
		this.transaction = transaction;
		this.to = to;
		this.amount = amount;
	}
	
	public String toJson() {
		JSONObject jobj = new JSONObject();
		jobj.put("transaction", transaction);
		jobj.put("to", to);
		jobj.put("amount", amount);
		return jobj.toJSONString();
	}
}
