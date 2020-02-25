package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class ClassroomTest {
    private Classroom presetRoom;
    private Classroom presetRoomWithStudent;
    private Classroom presetRoomMultipleStudents;
    private final double DELTA = 0.001;
    private Student[] presetStudent = new Student[]{
            new Student(" Zach", "Ertz", new Double[]{90.0, 89.0}),
            new Student("Carson", "Wentz", new Double[]{99.0, 95.0, 91.0}),
            new Student(" Miles", "Sanders", null)
    };

    @Before
    public void settings() {
        presetRoomWithStudent = new Classroom(presetStudent);
        presetRoomMultipleStudents = new Classroom(10);
        presetRoom = new Classroom();

        presetRoomMultipleStudents.addStudent(presetStudent[0]);
        presetRoomMultipleStudents.addStudent(presetStudent[1]);
    }
    @Test
    public void getGrades(){
        HashMap<Student, Character> expected = new HashMap<>();
        expected.put(presetStudent[0], 'D');
        expected.put(presetStudent[1], 'C');
        expected.put(presetStudent[2], ' ');

        Assert.assertEquals(expected, presetRoomWithStudent.getGradeBook());
    }
    @Test
    public void getAverageExamScoreMultiple(){
        Assert.assertEquals(92.25, presetRoomMultipleStudents.getAverageExamScore(), DELTA);
    }
    @Test
    public void getAverageExamScorePresetStudent(){
        Assert.assertEquals(92.25, presetRoomWithStudent.getAverageExamScore(), DELTA);
    }
    @Test
    public void addStudentPresetRoomBool(){
        Assert.assertTrue(presetRoom.addStudent(presetStudent[0]));
    }
    @Test
    public void addStudentPresetRoom(){
        presetRoom.addStudent(presetStudent[0]);
        Assert.assertEquals(presetRoom.getStudents()[0], presetStudent[0]);
    }
    @Test
    public void addMultipleStudentPresetRoomBool(){
        Assert.assertTrue(presetRoomMultipleStudents.addStudent(presetStudent[2]));
    }
    @Test
    public void addStudentNoSpace(){
        Assert.assertFalse(presetRoomWithStudent.addStudent(new Student("George", "Washington", null)));
    }
    @Test
    public void removeNonexistent(){
        presetRoomWithStudent.removeStudent("bleep","bloop");
        Assert.assertArrayEquals(presetStudent, presetRoomWithStudent.getStudents());
    }
    @Test
    public void getMultipleStudentWithScore(){
        Student[] expectedStudent = new Student[]{
                presetStudent[1],
                presetStudent[0]};

        Assert.assertArrayEquals(expectedStudent, presetRoomMultipleStudents.getStudentUseScore());
    }
    @Test
    public void getStudentsScorePreset(){
        Student[] expectedStudent = new Student[]{
                presetStudent[1],
                presetStudent[0],
                presetStudent[2]};
        presetRoomWithStudent.printGrades();
        Assert.assertArrayEquals(expectedStudent, presetRoomWithStudent.getStudentUseScore());
    }
}