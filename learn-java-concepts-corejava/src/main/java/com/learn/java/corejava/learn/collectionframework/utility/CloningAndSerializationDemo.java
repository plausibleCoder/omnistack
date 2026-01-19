package com.learn.java.corejava.learn.collectionframework.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

// A simple class that is both Cloneable and Serializable
class MyListContainer implements Serializable, Cloneable {
    private String name;
    private ArrayList<String> data;

    public MyListContainer(String name, ArrayList<String> data) {
        this.name = name;
        this.data = data;
    }

    // Default clone() performs a shallow copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // A method to perform a deep copy
    public MyListContainer deepCopy() throws CloneNotSupportedException {
        MyListContainer cloned = (MyListContainer) super.clone();
        cloned.data = (ArrayList<String>) this.data.clone(); // Clone the list as well
        return cloned;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Data: " + data;
    }

    public ArrayList<String> getData() {
        return data;
    }
}

public class CloningAndSerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
        System.out.println("--- Demonstrating Serialization, Shallow Copy, and Deep Copy ---");

        // Initial object setup
        ArrayList<String> initialData = new ArrayList<>();
        initialData.add("Item 1");
        initialData.add("Item 2");
        MyListContainer original = new MyListContainer("Original", initialData);
        System.out.println("Original object: " + original);

        // 1. Shallow Copy (using clone())
        System.out.println("\n--- Shallow Copy (Cloneable) ---");
        MyListContainer shallowCopy = (MyListContainer) original.clone();
        System.out.println("Shallow copy before modification: " + shallowCopy);
        original.getData().add("Item 3"); // Modifying the list in the original object
        System.out.println("Original object after modification: " + original);
        System.out.println("Shallow copy after modification: " + shallowCopy); // Modification affects both objects
        System.out.println("Note: The list in the shallow copy was also modified because they share the same reference.");

        // 2. Deep Copy (custom implementation)
        System.out.println("\n--- Deep Copy ---");
        MyListContainer deepCopy = original.deepCopy();
        System.out.println("Deep copy before modification: " + deepCopy);
        original.getData().add("Item 4");
        System.out.println("Original object after another modification: " + original);
        System.out.println("Deep copy after original's modification: " + deepCopy); // Deep copy is unaffected
        System.out.println("Note: The deep copy is independent of the original.");

        // 3. Serialization (Deep Copy)
        System.out.println("\n--- Serialization (which performs a deep copy) ---");
        final String filename = "object.ser";

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(original);
            System.out.println("Object serialized to " + filename);
        }

        // Deserialize the object
        MyListContainer deserialized;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            deserialized = (MyListContainer) ois.readObject();
            System.out.println("Object deserialized from " + filename);
        }

        System.out.println("Original object: " + original);
        System.out.println("Deserialized object: " + deserialized);
        original.getData().add("Item 5"); // Modify the original object
        System.out.println("Original object after final modification: " + original);
        System.out.println("Deserialized object is unchanged: " + deserialized);
        System.out.println("Note: Serialization creates a completely new, independent copy of the object and all its members.");
    }
}
