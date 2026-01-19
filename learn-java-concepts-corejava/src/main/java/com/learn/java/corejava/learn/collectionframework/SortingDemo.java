package com.learn.java.corejava.learn.collectionframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingDemo {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 103, 3.5));
        students.add(new Student("Alice", 101, 3.8));
        students.add(new Student("Bob", 102, 3.2));

        System.out.println("Original list: " + students);

        // --- Sorting using Comparable (natural ordering) ---
        // The Collections.sort() method automatically uses the compareTo() method.
        Collections.sort(students);
        System.out.println("\nSorted by Roll No (using Comparable): " + students);

        // --- Sorting using Comparator (custom ordering) ---
        // Pass the static NameComparator to the sort method.
        Collections.sort(students, Student.NameComparator);
        System.out.println("Sorted by Name (using Comparator): " + students);

        // Pass the static GpaComparator to the sort method.
        Collections.sort(students, Student.GpaComparator);
        System.out.println("Sorted by GPA (using Comparator): " + students);
    }
}
