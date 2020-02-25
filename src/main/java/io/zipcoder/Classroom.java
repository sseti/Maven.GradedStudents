package io.zipcoder;

import java.util.*;

import static java.util.Arrays.sort;

public class Classroom {
    private Integer currentAmountOfStudents;
    private Integer maxNumberOfStudents;
    private Student[] students;

    public Classroom(Integer maxNumberOfStudents){
        students = new Student[maxNumberOfStudents];
        this.maxNumberOfStudents = maxNumberOfStudents;
        currentAmountOfStudents = 0;
    }
    public Classroom(Student[] students) {
        this.students = students;
        currentAmountOfStudents = students.length;
        maxNumberOfStudents = students.length;
    }
    public Classroom(){
        this(30);
    }
    public Student[] getStudents(){
        List<Student> studentList = new ArrayList<>();
        for (Student student: students)
            if (student != null)
                studentList.add(student);
        return studentList.toArray(new Student[studentList.size()]);
    }
    private Integer studentNoScores(){
        Integer count = 0;
        for(Student student : getStudents())
            if (student.getNumberOfExamsTaken() == 0)
                count ++;

        return count;
    }
    public Double getAverageExamScore(){
        Double sumOfAverageScore = 0.0;
        Student[] allStudents = getStudents();
        for(Student student : allStudents)
            sumOfAverageScore += student.getAverageExamScore();

        return sumOfAverageScore / (double) (allStudents.length - studentNoScores());
    }
    public Boolean addStudent(Student student) {
        for (Integer index = 0; index < students.length; index++)
            if (students[index] == null) {
                students[index] = student;
                currentAmountOfStudents++;
                return true;
            }
        return false;
    }
    public Student[] getStudentUseScore(){
        Comparator<Student> nameComparator = Comparator.comparing(Student::getAverageExamScore).reversed().thenComparing(Student::getLastName);
        Student[] sortedStudents = getStudents();
        Arrays.sort(sortedStudents, nameComparator);

        return sortedStudents;
    }
    public void removeStudent(String firstName, String lastName){
        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
        for (Student student : getStudents()){
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                studentList.remove(student);
                currentAmountOfStudents--;
                break;
            }
        }
        students = studentList.toArray(new Student[maxNumberOfStudents]);
    }
    public HashMap getGradeBook(){
        HashMap<Student, Character> grades = new HashMap<>();
        Student[] sortedStudents = getStudentUseScore();
        Integer rankings = 1;

        for(Student student : sortedStudents){
            double percentGrades = ((double)(rankings) / (double)currentAmountOfStudents) * (double)100;

            if(student.getNumberOfExamsTaken() == 0)
                grades.put(student, ' ');
            else if (percentGrades <= 10)
                grades.put(student, 'A');
            else if (percentGrades <= 29)
                grades.put(student, 'B');
            else if (percentGrades <= 50)
                grades.put(student, 'C');
            else if (percentGrades <= 89)
                grades.put(student, 'D');
            else
                grades.put(student, 'F');
            rankings++;
        }
        return grades;
    }
    public void printGrades(){
        HashMap grades = getGradeBook();
        for(Student student : getStudentUseScore())
            System.out.print(student.getFirstName() + " " + student.getLastName() + ", " + grades.get(student));
    }
    @Override
    public String toString(){
        String names = "";
        Student[] allStudents = getStudents();
        for(Student student : allStudents)
            names += (student.getFirstName() + " " + student.getLastName() + "\n");

        return "Class room: \n"
                + "Capacity of classroom: " + maxNumberOfStudents + "\n"
                + "Current amount of students: " + currentAmountOfStudents + "\n"
                + names;
    }
}