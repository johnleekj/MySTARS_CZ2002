package com.mySTARS.Control;

import java.io.Console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionMgr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hashPassword("hi"));
		passwordMask();
	}
	
	public static String hashPassword(String inputPassword) {
		
		String hashedPW = null;
    	try {
            // Create MessageDigest instance for MD5
        	MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(inputPassword.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
        	//Get complete hashed password in hex format
            hashedPW = sb.toString();
            return hashedPW;
        } 
        catch (NoSuchAlgorithmException e) 
    	{
        	e.printStackTrace();
        }
		return "Hash Failed";
	}
	
	public static String passwordMask() {        
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        char[] passwordArray = console.readPassword("Enter password: ");
//        console.printf("Password entered was: %s%n", new String(passwordArray));
        
        return new String(passwordArray).trim();
    }
}
