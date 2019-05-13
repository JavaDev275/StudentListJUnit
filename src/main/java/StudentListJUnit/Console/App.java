package StudentListJUnit.Console;

import java.util.*;
import StudentListJUnit.Services.StudentManager;

import java.io.*;

public class App {
    public static void main(String[] args) throws Exception 
    {
        // Check for valid arguments
        if(args == null || args.length != 1){
            showUsage();
            return;
        }
 
        StudentManager studentManager = new StudentManager();

        if(args[0].equals(Constants.ShowAll)) 
        {                                    
            for(String student : studentManager.students) 
            {
                System.out.println(student);
            }

        } 
        else if(args[0].equals(Constants.ShowRandom))
        {      
            System.out.println(studentManager.pickRandomStudent());

        }         
        else if(args[0].contains(Constants.AddEntry))
        {                          
            String newEntry = args[0].substring(1);        
            studentManager.addStudent(newEntry);
        } 
        else if(args[0].startsWith(Constants.FindEntry))
        {
            String searchTerm = args[0].substring(1);

            if(studentManager.studentExists(searchTerm))
            {
                System.out.printf("Entry %s found", searchTerm);
            } 
            else 
            {
                System.out.printf("Entry %s does not exist", searchTerm);
            }

        } 
        else if(args[0].equals(Constants.ShowCount)) 
        {
            System.out.printf("%d students found", studentManager.students.length);
        }
        else 
        {
            showUsage();
        }
    }

    public static String loadStudentList(){

        // Variable used to organize code and allow buffered reader to close
        String bufferedStudentList = " ";  

        // The try...catch block handles the possible error that may occur if 
        // there was an issue with accessing the file.        
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Constants.StudentList));
            bufferedStudentList = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException exception){
            System.out.println(exception);
        } 

        return bufferedStudentList;        
    }

    public static void updateStudentList(String content){
        String timestamp = String.format("List last updated %s", new Date());
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.StudentList));        
            writer.write(content);
            writer.newLine();
            writer.append(timestamp);            
            writer.close();
        } catch (IOException exception){
            System.out.println(exception);
        }
        
    }

    public static void showUsage(){
        System.out.printf("java app.App (-a | -r | -c | +WORD | ?WORD)");
    }
}