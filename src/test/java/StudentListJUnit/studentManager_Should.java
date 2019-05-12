package StudentListJUnit;

import org.junit.Test;
import org.junit.Assert;
import StudentListJUnit.Services.*;
import org.mockito.Mockito;
import java.util.*;

public class studentManager_Should
{
    StudentStorage mockStorage;

    public studentManager_Should()
    {
        mockStorage = Mockito.mock(StudentStorage.class);
        Mockito.when(
            mockStorage.LoadStudentList()).thenReturn(
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
        Assert.assertTrue(actual.length > 0);
        Assert.assertTrue(Arrays.asList(actual).contains("student2"));
    }
}