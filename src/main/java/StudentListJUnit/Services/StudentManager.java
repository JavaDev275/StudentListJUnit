package StudentListJUnit.Services;

import java.util.Random;
import java.util.Arrays;

public class StudentManager
{
    private StudentStorage storage;
    private Random rand;
    private final String studentEntryDelimiter = ",";
    private String studentList;
    public String[] students;

    public StudentManager(StudentStorage storage)
    {
        this.storage = storage;
        this.rand = new Random();
        studentList = storage.loadStudentList();
        students = studentList.split(studentEntryDelimiter);
    }

    public String pickRandomStudent()
    {
        String[] students = studentList.split(studentEntryDelimiter);
        int randomIndex = rand.nextInt(students.length);
        return students[randomIndex];
    }

    public void addStudent(String newStudent)
    {
        studentList += studentEntryDelimiter + newStudent;
        storage.updateStudentList(studentList);
    }

    public boolean studentExists(String student)
    {
        String[] students = studentList.split(studentEntryDelimiter);
        return Arrays.asList(students).contains(student);
    }
}