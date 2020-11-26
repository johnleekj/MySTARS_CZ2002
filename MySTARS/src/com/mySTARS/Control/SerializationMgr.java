package com.mySTARS.Control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.mySTARS.Control.FileMgr;
import com.mySTARS.Entities.StaffAccount;
import com.mySTARS.Entities.StudentAccount;
import com.mySTARS.Entities.StudentInformation;
import com.mySTARS.Entities.SystemBackend;
/**
 * Serialization manager to handle serialization and deserialization of data
 * 
 *
 */
public class SerializationMgr {

	public static void main(String[] args) {
		
		/*
    	* Code beneath is for loading of data
    	*/
//		SystemBackend.uploadStaffData();
//		SystemBackend.uploadStudentData();
//		SystemBackend.uploadCourseData();
//		serializeMap((HashMap)SystemBackend.StudentAccountMap, "studentData.mystars");
//		serializeMap((HashMap)SystemBackend.StaffAccountMap, "staffData.mystars");
//		serializeMap((HashMap)SystemBackend.CourseMap, "courseData.mystars");
	}
	
	/**
	 * Serialization of data from hashmaps into filenames
	 * @param mapsave hashmap to be serialized
	 * @param filename name of serialized file
	 */
	public static void serializeMap(HashMap mapsave, String filename) {
		/*
    	* Serialization done here
    	*/
        try
        {    
        	/*
        	* Saving object in a file
        	*/
            FileOutputStream file = new FileOutputStream(filename, false); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
 
            /*
        	* Method for Serialization of object
        	*/
            out.writeObject(mapsave); 
            
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        }
	}
	/**
	 * Serialization of data from hashmaps into filenames
	 * @param filename name of de-serialized file
	 * @return returns serialised data
	 */
	public static HashMap deserializeMap(String filename) {
		/*
    	* De-serialization done here
    	*/
        HashMap<Integer, String> map = null;
        try
        {
           FileInputStream fis = new FileInputStream(filename);
           ObjectInputStream ois = new ObjectInputStream(fis);
           map = (HashMap) ois.readObject();
           ois.close();
           fis.close();
        }catch(IOException ioe)
        {
           ioe.printStackTrace();
        }catch(ClassNotFoundException c)
        {
           System.out.println("Class not found");
           c.printStackTrace();
        }
        System.out.println("Deserialized HashMap..");
        
		return map;
	}
}