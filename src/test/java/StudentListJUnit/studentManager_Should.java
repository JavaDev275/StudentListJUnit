package StudentListJUnit;

import org.junit.Test;
import org.junit.Assert;
import StudentListJUnit.Services.*;
import org.mockito.Mockito;
import java.util.*;

public class StudentManager_Should {
    StudentStorage mockStorage;

    public StudentManager_Should() {
        mockStorage = Mockito.mock(StudentStorage.class);
        Mockito.when(
            mockStorage.loadStudentList()).thenReturn(
                "student1,student2,student3,student4"
            );
    }

    @Test
    public void returnListOfStudents() {
        
        // Arrange
        StudentManager sut = new StudentManager(mockStorage);

        // Act
        String[] actual = sut.students;

        // Assert
        Assert.assertEquals(String[].class, actual.getClass());
        Assert.assertTrue(actual.length == 4);
        Assert.assertTrue(Arrays.asList(actual).contains("student2"));
    }

    @Test
    public void returnCorrectStudentCount() {
        
        // Arrange
        StudentManager sut = new StudentManager(mockStorage);

        // Act
        int actual = sut.students.length;

        // Assert
        Assert.assertEquals(4, actual);
    }

    @Test
    public void returnRandomStudent() {
        
        // Arrange
        StudentManager sut = new StudentManager(mockStorage);
        String actualString = mockStorage.loadStudentList();

        // Act
        String expectedSubString = sut.pickRandomStudent();

        // Assert
        Assert.assertTrue(actualString.contains(expectedSubString));
    }

    @Test
    public void call_UpdateStudentList_When_StudentAdded() {
        
        // Arrange
        StudentManager sut = new StudentManager(mockStorage);
        String originalList = mockStorage.loadStudentList();
        String newStudent = "testStudent";
        String updatedList = originalList + "," + newStudent;

        // Act
        sut.addStudent(newStudent);

        // Assert
        Mockito.verify(mockStorage).updateStudentList(updatedList);
    }

    @Test
    public void returnTrue_When_SearchForExistingStudent() {
        
        // Arrange
        StudentManager sut = new StudentManager(mockStorage);
        String existingStudent = "student1";

        // Act
        Boolean actual = sut.studentExists(existingStudent);

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void returnFalse_When_SearchForNonExistentStudent() {
        
        // Arrange
        StudentManager sut = new StudentManager(mockStorage);
        String fakeStudent = "fakeStudent";

        // Act
        Boolean actual = sut.studentExists(fakeStudent);

        // Assert
        Assert.assertFalse(actual);
    }
}