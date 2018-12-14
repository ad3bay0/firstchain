package com.ad3bay0.firstblockchain.util;

import java.security.MessageDigest;

public class StringUtil {
	
	private static final  String SHA_256 = "SHA-256";
	private static final String UTF_8 = "UTF-8";
	
	//applies sha256 to a string and return string
	public static String applySha256(String input) {
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance(SHA_256);
			
			//applies sha256 to our input
			byte[] hash = digest.digest(input.getBytes(UTF_8));
			
			StringBuffer hexString =  new StringBuffer();
			
			for(int i = 0; i < hash.length; i++) {
				
				String hex =  Integer.toHexString(0xff & hash[i]);
				
				if(hex.length()==1) hexString.append('0');
				
				hexString.append(hex);	
				
			}
			
			return hexString.toString();
			
		}catch(Exception e) {
			
			throw new RuntimeException(e);
		}
		
		
	}

}
