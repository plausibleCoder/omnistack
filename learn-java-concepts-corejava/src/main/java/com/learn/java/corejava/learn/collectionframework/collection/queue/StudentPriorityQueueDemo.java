package com.learn.java.corejava.learn.collectionframework.collection.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class StudentPriorityQueueDemo {
    public static void main(String[] args) {
        // Create student objects with their data
        Student student1 = new Student("Alice", 101, createStudentSubjects(
            new Results("Math", 90), new Results("Science", 85),
            new Results("Math", 85), new Results("Science", 92)
        ));

        Student student2 = new Student("Bob", 102, createStudentSubjects(
            new Results("Math", 95), new Results("Science", 88),
            new Results("Math", 88), new Results("Science", 91),
            new Results("Math", 92), new Results("Science", 87)
        ));

        Student student3 = new Student("Charlie", 103, createStudentSubjects(
            new Results("Math", 80), new Results("Science", 78),
            new Results("Math", 85), new Results("Science", 82)
        ));
        
        Student student4 = new Student("David", 104, createStudentSubjects(
            new Results("Math", 95), new Results("Science", 88),
            new Results("Math", 88), new Results("Science", 91),
            new Results("Math", 92), new Results("Science", 87)
        )); // Same average as Bob

        // Create the custom Comparator for highest average math marks
        Comparator<Student> mathMarksComparator = (s1, s2) -> {
            double avg1 = s1.getAverageMathMarks();
            double avg2 = s2.getAverageMathMarks();
            return Double.compare(avg2, avg1);
        };

        // Create the PriorityQueue with the custom comparator
        Queue<Student> mathPriorityQueue = new PriorityQueue<>(mathMarksComparator);

        // Add students to the queue
        mathPriorityQueue.offer(student1);
        mathPriorityQueue.offer(student2);
        mathPriorityQueue.offer(student3);
        mathPriorityQueue.offer(student4);

        System.out.println("--- Polling students by highest average math marks ---");

        // Polling students in order of priority (highest average marks first)
        while (!mathPriorityQueue.isEmpty()) {
            System.out.println("Polling (highest priority): " + mathPriorityQueue.poll());
        }
    }
    
    // Helper method to create a Map of results for a student across semesters
    private static Map<Integer, List<Results>> createStudentSubjects(Results... allResults) {
        Map<Integer, List<Results>> semesterData = new HashMap<>();
        int semesterCounter = 1;
        
        for (int i = 0; i < allResults.length; i += 2) {
            List<Results> resultsList = new ArrayList<>();
            if (i < allResults.length) resultsList.add(allResults[i]);
            if (i + 1 < allResults.length) resultsList.add(allResults[i + 1]);
            semesterData.put(semesterCounter++, resultsList);
        }
        return semesterData;
    }
}

// Represents the result of a single subject
class Results {
    String subject;
    int marks;

    public Results(String subject, int marks) {
        this.subject = subject;
        this.marks = marks;
    }
}

// Represents a student with their semester-wise results
class Student {
    String name;
    int rollNumber;
    Map<Integer, List<Results>> semesterWiseSubjects;

    public Student(String name, int rollNumber, Map<Integer, List<Results>> semesterWiseSubjects) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.semesterWiseSubjects = semesterWiseSubjects;
    }

    // Calculates the student's average math score across all semesters
    public double getAverageMathMarks() {
        double totalMarks = 0;
        int mathSemestersCount = 0;

        for (List<Results> resultsList : semesterWiseSubjects.values()) {
            for (Results result : resultsList) {
                if (result.subject.equals("Math")) {
                    totalMarks += result.marks;
                    mathSemestersCount++;
                }
            }
        }
        
        // Return average if math results exist, otherwise return 0
        return mathSemestersCount > 0 ? totalMarks / mathSemestersCount : 0;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", rollNumber=" + rollNumber +
               ", avgMathMarks=" + getAverageMathMarks() +
               '}';
    }
}
