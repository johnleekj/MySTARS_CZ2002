package com.mySTARS.Control;

import java.io.Console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.mySTARS.Boundary.GenericBoundary;
/**
 * 
 * This EncryptionMgr class is what is used to mask the passwords that user inputs
 *
 */
public class EncryptionMgr {

	/*
	* This EncryptionMgr class is what is used to mask the passwords that user inputs
	*/
	
	/**
	 * method to hash a password
	 * @param inputPassword password to be hashed
	 * @return hashed password
	 */
	public static String hashPassword(String inputPassword) {
		
		String hashedPW = null;
    	try {
    		/*
			* (MessageDigest md = MessageDigest.getInstance()) (Create MessageDigest instance for MD5 and adds password bytes to digest)
			* (md.update(inputPassword.getBytes())) (Get the hash's bytes)
			* (byte[] bytes) (This bytes[] has bytes in decimal format, converts it to hexadecimal format)
			*/
    		MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(inputPassword.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            /*
        	* (hashedPW = sb.toString()) (Get the password in hashed format)
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
	
	/**
	 * Read in user input as username
	 * @return returns username
	 */
	public static String readUsername() {
		/*
		* Reading in user input as username
		* (username = GenericBoundary.readStringInputUPPER("Enter username: ").trim()) (Calling GenericBoundary class which reads in String input and places it in the object username)
		*/
		String username = GenericBoundary.readStringInputUPPER("Enter username: ").trim();
		return username;
	}
	
	/**
	 * read in user input as password. Will mask input in console.
	 * @return password value
	 */
	public static String readPassword() {
		/*
		* Reading in user input as password
		* (password = GenericBoundary.readStringInputCaseSensitive("Enter password: ").trim()) (Calling GenericBoundary class which reads in String input and places it in the object password)
		*/
		Console console = System.console();
        if (console == null) {
        	String password = GenericBoundary.readStringInputCaseSensitive("Enter password: ").trim();
    		return password;
        } else {
        
        /*
        * (char[] passwordArray = console.readPassword("Enter password: ")) (console.printf("Password entered was: %s%n", new String(passwordArray)))
        */
        char[] passwordArray = console.readPassword("Enter password: ");    
        return new String(passwordArray).trim();	
        }        
	}
}
