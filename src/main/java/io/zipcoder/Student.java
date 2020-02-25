package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

        String firstName;
        String lastName;
        ArrayList<Double> examScores;

        public Student(String firstName, String lastName, Double[] testScores){
            this.firstName = firstName;
            this.lastName = lastName;
            if (testScores != null)
                examScores = new ArrayList(Arrays.asList(testScores));
        }
        public String getFirstName(){
            return firstName;
        }
        public void setFirstName(String newName){
            firstName = newName;
        }
        public String getLastName(){
            return lastName;
        }
        public void setLastName(String newLastName){
            lastName = newLastName;
        }
        public Integer getNumberOfExamsTaken(){
            return examScores == null ? 0 : examScores.size();
        }
        public String getExamScores(){
            String output = "";
            Integer a = 1;
            for(Double i : examScores)
                output += "Exam " + a++ + " = " + i + "\n";

            return output;
        }
        public void addExamScore(Double examScore) {
            if (examScore == null)
                examScores = new ArrayList<>(0);

            else
                examScores.add(examScore);
        }
        public void setExamScores(Integer nthValue, Double examScore){
            examScores.set(nthValue - 1, examScore);
        }
        public Double getExamScore(Integer nthValue){
            return examScores.get(nthValue - 1);
        }
        public Double getAverageExamScore(){
            Double sum = 0.0;
            if (examScores == null)
                return 0.0;

            for (Double score : examScores)
                sum += score;
            return sum / (double) getNumberOfExamsTaken();
        }
        @Override
        public String toString(){
            return String.format("Student Name: %s %s\n"+
                    "> Average Score: %f\n"+
                    "%s", firstName, lastName, getAverageExamScore(), getExamScores());
        }
    }