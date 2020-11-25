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

public class SerializationMgr {

	public static void main(String[] args) {
		
//		// Load Data	
//		SystemBackend.uploadStaffData();
//		SystemBackend.uploadStudentData();
//		SystemBackend.uploadCourseData();
//		serializeMap((HashMap)SystemBackend.StudentAccountMap, "studentData.mystars");
//		serializeMap((HashMap)SystemBackend.StaffAccountMap, "staffData.mystars");
//		serializeMap((HashMap)SystemBackend.CourseMap, "courseData.mystars");
	}
	
	
	public static void serializeMap(HashMap mapsave, String filename) {
		// Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename, false); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
 
            // Method for serialization of object 
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
	
	public static HashMap deserializeMap(String filename) {
//      De-serialization 
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
//        // Display content using Iterator
//        Set set = map.entrySet();
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()) {
//           Map.Entry mentry = (Map.Entry)iterator.next();
//           System.out.print("key: "+ mentry.getKey() + " & Value: ");
//           System.out.println(mentry.getValue());
//        }
		return map;
	}
}