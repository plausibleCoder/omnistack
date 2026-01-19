package com.learn.java.corejava.learn.interviewquestions;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashCodeEqualsDoubleEquals {

    public static void main(String[] args) {
        // Demonstrate == and equals()
        System.out.println("--- Demonstrating `==` vs. `equals()` ---");
        Employee emp1 = new Employee(101, "Alice");
        Employee emp2 = new Employee(101, "Alice"); // Logically equal, but a different instance
        Employee emp3 = emp1; // A reference to the same instance as emp1

        // `==` checks for referential equality (memory addresses)
        System.out.println("emp1 == emp2: " + (emp1 == emp2)); // Output: false
        System.out.println("emp1 == emp3: " + (emp1 == emp3)); // Output: true

        // `equals()` checks for value-based equality (content)
        System.out.println("emp1.equals(emp2): " + emp1.equals(emp2)); // Output: true
        System.out.println("emp1.equals(emp3): " + emp1.equals(emp3)); // Output: true

        // Demonstrate hash code with collections
        System.out.println("\n--- Demonstrating `hashCode()` contract with collections ---");
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(emp1);
        System.out.println("Set size after adding emp1: " + employeeSet.size()); // Output: 1

        // Adding emp2, which is logically equal to emp1, but a different instance.
        // The `HashSet` will use `hashCode()` and then `equals()` to determine
        // that it is a duplicate, so the size remains unchanged.
        employeeSet.add(emp2);
        System.out.println("Set size after adding emp2: " + employeeSet.size()); // Output: 1

        // Search for an employee with the same values. It will be found.
        System.out.println("Set contains new Employee(101, \"Alice\"): " + employeeSet.contains(new Employee(101, "Alice"))); // Output: true

        // Demonstrate negative cases (broken implementations)
        System.out.println("\n--- Demonstrating negative cases (Broken classes) ---");
        
        // Case 1: Overriding equals() but not hashCode()
        // Logically equal objects will have different hash codes, violating the contract.
        Set<BrokenEqualsOnly> brokenSet1 = new HashSet<>();
        BrokenEqualsOnly be1 = new BrokenEqualsOnly("SKU-123");
        BrokenEqualsOnly be2 = new BrokenEqualsOnly("SKU-123");

        brokenSet1.add(be1);
        brokenSet1.add(be2);

        System.out.println("Broken set size (equals() only): " + brokenSet1.size()); // Output: 2 (Incorrect!)
        System.out.println("Contains logically equal object: " + brokenSet1.contains(new BrokenEqualsOnly("SKU-123"))); // Output: false (Incorrect!)

        // Case 2: Mismatched fields in equals() and hashCode()
        // equals() uses SKU, but hashCode() uses name, violating the contract.
        Set<BrokenMismatch> brokenSet2 = new HashSet<>();
        BrokenMismatch bm1 = new BrokenMismatch("SKU-456", "Product A");
        BrokenMismatch bm2 = new BrokenMismatch("SKU-456", "Product B"); // Same SKU, different name

        brokenSet2.add(bm1);
        brokenSet2.add(bm2);

        System.out.println("Broken set size (mismatched): " + brokenSet2.size()); // Output: 2 (Incorrect!)
        System.out.println("Contains bm1 (by new object): " + brokenSet2.contains(new BrokenMismatch("SKU-456", "Product B"))); // Output: false (Incorrect!)

        // Case 3: Mutable field used in hashCode()
        // The object's state changes while in the collection, breaking the contract.
        Set<BrokenMutable> brokenSet3 = new HashSet<>();
        BrokenMutable bmut = new BrokenMutable("SKU-789", "Initial Name");
        brokenSet3.add(bmut);
        System.out.println("Size before mutation: " + brokenSet3.size()); // Output: 1

        bmut.setName("Changed Name"); // Mutable field used in hashCode() is changed
        System.out.println("Can find object after mutation: " + brokenSet3.contains(bmut)); // Output: false (Incorrect!)
    }
}

/**
 * A correct implementation of a class demonstrating equals() and hashCode().
 */
class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Overrides the default `equals()` method to provide value-based equality.
     * The logical identity of an `Employee` is defined by its `id` and `name`.
     */
    @Override
    public boolean equals(Object obj) {
        // Fast check for same instance
        if (this == obj) return true;
        
        // Null and class type check (getClass() is more robust than instanceof here)
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // Cast to Employee and compare significant fields
        Employee employee = (Employee) obj;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    /**
     * Overrides `hashCode()` to be consistent with `equals()`.
     * It uses the same fields (`id` and `name`) that determine equality.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}

/**
 * Negative Case 1: Overrides equals() but not hashCode().
 * This violates the contract and will cause logically equal objects to be treated as different
 * in hash-based collections like `HashSet` and `HashMap`.
 */
class BrokenEqualsOnly {
    private String sku;

    public BrokenEqualsOnly(String sku) {
        this.sku = sku;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BrokenEqualsOnly other = (BrokenEqualsOnly) obj;
        return Objects.equals(sku, other.sku);
    }
    
    // Default hashCode() from Object class is used, which compares memory addresses.
    // So, two instances with the same SKU will have different hash codes.
}

/**
 * Negative Case 2: Mismatched fields in equals() and hashCode().
 * This also violates the contract because equal objects do not guarantee the same hash code.
 */
class BrokenMismatch {
    private String sku;
    private String name;

    public BrokenMismatch(String sku, String name) {
        this.sku = sku;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BrokenMismatch other = (BrokenMismatch) obj;
        // equality is determined only by SKU
        return Objects.equals(sku, other.sku); 
    }

    @Override
    public int hashCode() {
        // hashCode uses name, which is NOT used in equals()
        return Objects.hash(name); 
    }
}

/**
 * Negative Case 3: Using a mutable field in hashCode().
 * Modifying the object after it has been added to a hash-based collection
 * will change its hash code, making it "disappear" from the collection.
 */
class BrokenMutable {
    private String sku;
    private String name; // Mutable field

    public BrokenMutable(String sku, String name) {
        this.sku = sku;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BrokenMutable other = (BrokenMutable) obj;
        return Objects.equals(sku, other.sku);
    }

    @Override
    public int hashCode() {
        // Using a mutable field (`name`) to compute the hash code
        return Objects.hash(sku, name);
    }
}
