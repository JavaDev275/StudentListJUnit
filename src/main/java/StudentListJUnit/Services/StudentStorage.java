package StudentListJUnit.Services;

import java.io.*;
import java.util.Date;

public class StudentStorage {
    private final String STUDENT_LIST = "students.txt";
    
    /**
     * Replaces the contents of the student storage with the given string of content.
     * Also updates the timestamp in the student storage.
     * @param content The new content for the student storage.
     */
    public void updateStudentList(String content) {
        String timestamp = String.format("List last updated %s", new Date());
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT_LIST));        
            writer.write(content);
            writer.newLine();
            writer.append(timestamp);            
            writer.close();
        } catch (IOException exception){
            System.out.println(exception);
        }
    }

    /**
     * Reads student data from student storage
     * @return A string of student names
     */
    public String loadStudentList() {        
        String bufferedStudentList = " ";  

        // The try...catch block handles the possible error that may occur if 
        // there was an issue with accessing the file.        
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(STUDENT_LIST));
            bufferedStudentList = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException exception){
            System.out.println(exception);
        } 

        return bufferedStudentList;    
    }
}