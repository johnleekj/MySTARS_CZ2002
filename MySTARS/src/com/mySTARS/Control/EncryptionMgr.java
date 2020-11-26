package com.mySTARS.Control;

import java.io.Console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.mySTARS.Boundary.GenericBoundary;

public class EncryptionMgr {

	/**
	* @param This EncryptionMgr class is what is used to mask the passwords that user inputs
	*/
	
	public static String hashPassword(String inputPassword) {
		
		String hashedPW = null;
    	try {
    		/**
			* @param (MessageDigest md = MessageDigest.getInstance()) (Create MessageDigest instance for MD5 and adds password bytes to digest)
			* @param (md.update(inputPassword.getBytes())) (Get the hash's bytes)
			* @param (byte[] bytes) (This bytes[] has bytes in decimal format, converts it to hexadecimal format)
			*/
    		MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(inputPassword.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            /**
        	* @param (hashedPW = sb.toString()) (Get the password in hashed format)
        	*/
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
        
        /**
    	* @param (char[] passwordArray = console.readPassword("Enter password: ")) (console.printf("Password entered was: %s%n", new String(passwordArray)))
    	*/
        char[] passwordArray = console.readPassword("Enter password: ");
        
        return new String(passwordArray).trim();
    }
	
	public static String readUsername() {
		/**
		* @param Reading in user input as username
		* @param (username = GenericBoundary.readStringInputUPPER("Enter username: ").trim()) (Calling GenericBoundary class which reads in String input and places it in the object username)
		*/
		String username = GenericBoundary.readStringInputUPPER("Enter username: ").trim();
		return username;
	}

	public static String readPassword() {
		/**
		* @param Reading in user input as password
		* @param (password = GenericBoundary.readStringInputCaseSensitive("Enter password: ").trim()) (Calling GenericBoundary class which reads in String input and places it in the object password)
		*/
		Console console = System.console();
        if (console == null) {
        	String password = GenericBoundary.readStringInputCaseSensitive("Enter password: ").trim();
    		return password;
        } else {
        
        /**
        * @param (char[] passwordArray = console.readPassword("Enter password: ")) (console.printf("Password entered was: %s%n", new String(passwordArray)))
        */
        char[] passwordArray = console.readPassword("Enter password: ");    
        return new String(passwordArray).trim();	
        }

        
	}
}
