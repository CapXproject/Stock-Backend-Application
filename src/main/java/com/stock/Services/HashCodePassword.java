package com.stock.Services;
import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;
public class HashCodePassword {

	 public  String sha256Hash(String input) throws NoSuchAlgorithmException {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hashBytes = digest.digest(input.getBytes());
	        StringBuilder hexString = new StringBuilder();
	        for (byte hashByte : hashBytes) {
	            String hex = Integer.toHexString(0xff & hashByte);
	            if (hex.length() == 1) {
	                hexString.append('0');
	            }
	            hexString.append(hex);
	        }
	        return hexString.toString();
	    }
}
