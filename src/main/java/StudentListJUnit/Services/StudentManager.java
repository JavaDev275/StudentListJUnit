package StudentListJUnit.Services;

public class StudentManager
{
    private StudentStorage storage;

    public StudentManager(StudentStorage storage)
    {
        this.storage = storage;
    }

    public String[] getAllStudents()
    {
        String studentList = storage.LoadStudentList();
        return studentList.split(",");
    }

    public int CountStudents()
    {
        String studentList = storage.LoadStudentList();
        return studentList.split(",").length;
    }
}