package cn.xender.libraj.crypto;

public class LibraHash {
	public final static String LIBRA_HASH_SUFFIX = "@@$$LIBRA$$@@";
	public final static String RAWTRANSACTION_EXPR = "RawTransaction";
	public final static String VM_ACCESS_PATH_EXPR = "VM_ACCESS_PATH";
	
	public static byte[] rawTransactionExpr() {
		String expr = RAWTRANSACTION_EXPR + LIBRA_HASH_SUFFIX;
		return Sha3Util.sha3256(expr.getBytes());
	}
	
	public static byte[] accessPathExpr() {
		String expr = VM_ACCESS_PATH_EXPR + LIBRA_HASH_SUFFIX;
		return Sha3Util.sha3256(expr.getBytes());
	}
}
