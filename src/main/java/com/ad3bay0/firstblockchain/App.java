package com.ad3bay0.firstblockchain;

import java.util.ArrayList;

import com.ad3bay0.firstblockchain.block.Block;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	private static int difficulty = 5;
	
	
    public static void main( String[] args )
    {
    	
    	
    	Block genesisBlock = new Block("BLOCK 1", "0");
    	addBlock(genesisBlock);
     
        
        Block secondBlock = new Block("BLOCK 2", blockchain.get(blockchain.size()-1).hash );
        addBlock(secondBlock);
 
        
        Block thirdBlock =  new Block("BLOCK 3", blockchain.get(blockchain.size()-1).hash);
        addBlock(thirdBlock);
        
        
        
        
        String blockchainjson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainjson);
        
        System.out.println("Block Chain is valid: "+isChainValid());
        
        
    
    }
    
    public static Boolean isChainValid() {
    	
    	Block currentBlock;
    	Block previousBlock;
    	
    	//loop through blockchain to check hashes
    	
    	for(int i = 1;i<blockchain.size();i++) {
    		
    		currentBlock = blockchain.get(i);
    		previousBlock = blockchain.get(i-1);
    		
    		if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
    				
    			System.out.println("Current Hashes not equal!");
    			
    			return false;
    		}
    		
    		
    		if(!previousBlock.hash.equals(previousBlock.calculateHash())) {
				
    			System.out.println("Previous Hashes not equal!");
    			
    			return false;
    		}
    		
    	}
    	
    	return true;
    	
    }
    
    private static void addBlock(Block newBlock) {
    	
    	newBlock.mineBlock(difficulty);
    	blockchain.add(newBlock);
    	
    }
    
    
}
