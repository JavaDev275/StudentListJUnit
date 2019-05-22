package StudentListJUnit.Services;

import java.util.Random;
import java.util.Arrays;

public class StudentManager {
    private StudentStorage storage;
    private Random rand;
    private final String studentEntryDelimiter = ",";
    private String studentList;
    public String[] students;

    public StudentManager() {
        this.storage = new StudentStorage();
        this.rand = new Random();
        studentList = storage.loadStudentList();
        students = studentList.split(studentEntryDelimiter);
    }

    /**
     * Initalizes a new instance of the StudentManager class
     * @param storage The backing student storage
     */
    public StudentManager(StudentStorage storage) {
        this.storage = storage;
        this.rand = new Random();
        studentList = storage.loadStudentList();
        students = studentList.split(studentEntryDelimiter);
    }

    /**
     * Returns a studuent randomly from the student list
     * @return The random student
     */
    public String pickRandomStudent() {
        String[] students = studentList.split(studentEntryDelimiter);
        int randomIndex = rand.nextInt(students.length);
        return students[randomIndex];
    }

    /**
     * Adds the student with the given studuent name to the list of students
     * @param newStudent The name of the new student
     */
    public void addStudent(String newStudent) {
        studentList += studentEntryDelimiter + newStudent;
        storage.updateStudentList(studentList);
    }

    /**
     * Determines whether a student exists in the student list
     * @param student The student to check
     * @return True if the student exists in the list, false otherwise.
     */
    public boolean studentExists(String student) {
        String[] students = studentList.split(studentEntryDelimiter);
        return Arrays.asList(students).contains(student);
    }
}