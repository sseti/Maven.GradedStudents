package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentTest {

    @Test
    public void getFirstName() {
        Student student = new Student("John", "Smith", new Double[]{40.0, 50.0});
        Assert.assertEquals("John", student.getFirstName());
    }


    @Test
    public void getLastName() {
        Student student = new Student("John", "Smith", new Double[]{40.0, 50.0});
        Assert.assertEquals("Smith", student.getLastName());
    }

    @Test
    public void getNumberOfExamsTakenTest() {
        Student student = new Student("John", "Smith", new Double[]{80.0, 90.0, 100.0});
        Assert.assertEquals(3, (int) student.getNumberOfExamsTaken());
    }

    @Test
    public void getNumberOfExamTakenNoneTest() {
        Student student = new Student("John", "Smith", null);
        Assert.assertEquals(0, (int) student.getNumberOfExamsTaken());
    }

    @Test
    public void addExamScoreTest() {
        Student student = new Student("John", "Smith", new Double[]{70.0, 80.0, 99.0, 35.0});
        student.addExamScore(55.0);
        System.out.println(student.toString());
        Assert.assertEquals(55.0, student.getExamScore(5), 0.0001);
    }

    @Test
    public void addExamScoreNullTest() {
        Student student = new Student("John", "Smith", new Double[] {});
        student.addExamScore(80.0);
        Assert.assertEquals(80.0, student.getExamScore(1), 0.0001);
    }

    @Test
    public void setExamScoresTest() {
        Student student = new Student("John", "Smith", new Double[] {60.0, 70.0, 85.0,90.0});
        student.setExamScores(1, 86.0);
        System.out.println(student.toString());
        Assert.assertEquals(86.0, student.getExamScore(1), 0.0001);
    }

    @Test
    public void getAverageExamScoreTest(){
        Student student = new Student("John", "Smith", new Double [] {25.0,35.0,45.0});
        System.out.println(student.toString());
        Assert.assertEquals(35.0, student.getAverageExamScore(), 0.0001);
    }
}