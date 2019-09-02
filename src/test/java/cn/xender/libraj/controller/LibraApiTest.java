package cn.xender.libraj.controller;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.xender.libraj.controller.LibraApi.EventType;
import cn.xender.libraj.wallet.ExtendedPrivKey;
import cn.xender.libraj.wallet.ExtendedPrivKey.KeyPair;

public class LibraApiTest {
	private Logger log = LoggerFactory.getLogger(LibraApiTest.class);
	
	private String mnemonic = "basic crew trap board afraid about cream drama horror soda audit rack damp also inner humor flee dad apology segment oval doll duck run"; // bip39: 24 words
	
	@Test
	public void testGetBalance() {
		LibraApi api = new LibraApi();
		String amount = api.getBalance("ab1e3cba16891ecc38dbdd035443574234b28a7f5b3b318c59dd2bfd870e01f9");
		log.info("balance: "+amount);
	}
	
	//@Test
	public void testGetAddress() {
		LibraApi api = new LibraApi();
		byte[] master = api.generateMasterKey(mnemonic);
		ExtendedPrivKey prvkey0 = api.generatePrivateKey(master, 0);
		ExtendedPrivKey prvkey1 = api.generatePrivateKey(master, 1);
		log.info("Created/retrieved account #" + 0 +" address " + api.getAddress(prvkey0)); // a59e8f96ed27faf439d4552ac963093498b1c55380d95f582cb87b3c91beeabb
		log.info("Created/retrieved account #" + 1 +" address " + api.getAddress(prvkey1)); // 1fe09871b63749db95ef73a606db72679e751d888fd93a9e2c0990a99aa7db46
	}
	
	//@Test
	public void testTransfer() {
		String recver = "ab1e3cba16891ecc38dbdd035443574234b28a7f5b3b318c59dd2bfd870e01f9";
		long amount = 1010000;
		LibraApi api = new LibraApi();
		byte[] master = api.generateMasterKey(mnemonic);
		long child = 0;
		KeyPair keyPair = api.generateKeyPair(master, child);
		api.transfer(keyPair.privateKey.getAddress(), keyPair, recver, amount);
	}
	
	//@Test
	public void testGetTransaction() {
		LibraApi api = new LibraApi();
		LibraTransaction tx = api.getTransactionByAccountSequence("b552b1d8d82dbe6b600dc7259bafe3293a7d3fcd6c158f117693254f2096aee1", 1, false);
		log.info(tx.toJson());
	}
	
	//@Test
	public void testGetEvent() {	
		LibraApi api = new LibraApi();
		List<LibraEvent> events = api.getEventsByEventAccessPath("c6917610b39a0b5b5df4f80e7d200763b779453f2cfe4d45f876fcf45efca2bf", EventType.received,  0, true, 10);
	    for(LibraEvent e: events) {
	    	log.info(e.toJson());
	    }
	}
}
