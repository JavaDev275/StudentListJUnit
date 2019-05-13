package StudentListJUnit;

import org.junit.Test;
import org.junit.Assert;
import StudentListJUnit.Services.*;
import org.mockito.Mockito;
import java.util.*;

public class StudentManager_Should
{
    StudentStorage mockStorage;

    public StudentManager_Should()
    {
        mockStorage = Mockito.mock(StudentStorage.class);
        Mockito.when(
            mockStorage.loadStudentList()).thenReturn(
                "student1,student2,student3,student4"
            );
    }

    @Test
    public void returnListOfStudents()
    {
        // Arrange
        StudentManager sut = new StudentManager(mockStorage);

        // Act
        String[] actual = sut.getAllStudents();

        // Assert
        Assert.assertEquals(String[].class, actual.getClass());
        Assert.assertTrue(actual.length == 4);
        Assert.assertTrue(Arrays.asList(actual).contains("student2"));
    }
}