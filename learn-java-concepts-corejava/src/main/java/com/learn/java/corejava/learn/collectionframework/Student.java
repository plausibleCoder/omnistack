package com.learn.java.corejava.learn.collectionframework;
import java.util.Comparator;

// A custom class implementing the Comparable interface for natural sorting
public class Student implements Comparable<Student> {
    private String name;
    private int rollNo;
    private double gpa;

    public Student(String name, int rollNo, double gpa) {
        this.name = name;
        this.rollNo = rollNo;
        this.gpa = gpa;
    }

    public String getName() { return name; }
    public int getRollNo() { return rollNo; }
    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", rollNo=" + rollNo +
               ", gpa=" + gpa +
               '}';
    }

    // This method defines the "natural ordering" for Student objects.
    // We choose to sort by roll number by default.
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.rollNo, other.rollNo);
    }
    
    // Static Comparator for sorting by name
    public static Comparator<Student> NameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getName().compareTo(s2.getName());
        }
    };
    
    // Static Comparator for sorting by GPA
    public static Comparator<Student> GpaComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s1.getGpa(), s2.getGpa());
        }
    };
}
