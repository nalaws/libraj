package cn.xender.libraj.controller;

import com.alibaba.fastjson.JSONObject;

public class LibraEvent {
	public long transactionVersion;
	public String from;
	public long sequence;
	public String to;
	public long amount;
	
	public LibraEvent(long transactionVersion, String from, long sequence, String to, long amount) {
		this.transactionVersion = transactionVersion;
		this.from = from;
		this.sequence = sequence;
		this.to = to;
		this.amount = amount;
	}
	
	public String toJson() {
		JSONObject jobj = new JSONObject();
		jobj.put("transaction_version", transactionVersion);
		jobj.put("from", from);
		jobj.put("sequence", sequence);
		jobj.put("to", to);
		jobj.put("amount", amount);
		return jobj.toJSONString();
	}

}
