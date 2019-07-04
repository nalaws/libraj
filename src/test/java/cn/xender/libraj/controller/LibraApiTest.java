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
		long amount = api.getBalance("b552b1d8d82dbe6b600dc7259bafe3293a7d3fcd6c158f117693254f2096aee1");
		log.info("balance: "+amount);
	}
	
	@Test
	public void testGetAddress() {
		LibraApi api = new LibraApi();
		byte[] master = api.generateMasterKey(mnemonic);
		ExtendedPrivKey prvkey0 = api.generatePrivateKey(master, 0);
		ExtendedPrivKey prvkey1 = api.generatePrivateKey(master, 1);
		log.info("Created/retrieved account #" + 0 +" address " + api.getAddress(prvkey0));
		log.info("Created/retrieved account #" + 1 +" address " + api.getAddress(prvkey1));
	}
	
	@Test
	public void testTransfer() {
		String recver = "6669ebf71a0b8dc0ba9274e853a36f75262e9626bb6bdd31121a30ad7c544b65";
		long amount = 1000000;
		LibraApi api = new LibraApi();
		byte[] master = api.generateMasterKey(mnemonic);
		long child = 0;
		KeyPair keyPair = api.generateKeyPair(master, child);
		api.transfer(keyPair.privateKey.getAddress(), keyPair, recver, amount);
	}
	
	@Test
	public void testGetTransaction() {
		LibraApi api = new LibraApi();
		LibraTransaction tx = api.getTransactionByAccountSequence("b552b1d8d82dbe6b600dc7259bafe3293a7d3fcd6c158f117693254f2096aee1", 1, false);
		log.info(tx.toJson());
	}
	
	@Test
	public void testGetEvent() {	
		LibraApi api = new LibraApi();
		List<LibraEvent> events = api.getEventsByEventAccessPath("b552b1d8d82dbe6b600dc7259bafe3293a7d3fcd6c158f117693254f2096aee1", EventType.received,  0, true, 2);
	    for(LibraEvent e: events) {
	    	log.info(e.toJson());
	    }
	}
}
