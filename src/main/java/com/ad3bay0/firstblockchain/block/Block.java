package com.ad3bay0.firstblockchain.block;

import java.util.Date;

import com.ad3bay0.firstblockchain.util.StringUtil;

public class Block {
	
	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;
	private int nonce;
	
	public Block(String data, String previusHash) {
		
		this.data = data;
		this.previousHash = previusHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
		
	}
	
	public String calculateHash() {
		
		String calculatehash =  StringUtil.applySha256(previousHash+Long.toString(timeStamp)+nonce+data);
		
		return calculatehash;
		
	}
	
	
	public void mineBlock(int difficulty) {
		
		String target =  new String(new char[difficulty]).replace('\0', '0');
		
		while(!hash.substring(0,difficulty).equals(target)) {
			
			nonce++;
			hash =  calculateHash();	
		}
		
		System.out.println("Block Mined!! : "+hash);
		
		
	}
	
}
