package com.learn.dsa.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * Demonstrates a Race Condition by separating the "Check" from the "Act".
 * Even with AtomicInteger, if logic spans multiple steps, it's not safe.
 */
public class AtomicRaceCondition {
    
    // Shared resource: Initial balance is 100
    private static AtomicInteger balance = new AtomicInteger(100);

    public static void main(String[] args) {
        System.out.println("Starting Balance: " + balance.get());

        // --- STEP 1: TRANSACTION 1 READS ---
        int readByTxn1 = balance.get(); 
        System.out.println("Txn 1 reads balance: " + readByTxn1);

        // --- STEP 2: TRANSACTION 2 READS (STALE DATA) ---
        // In a race, Txn 2 reads before Txn 1 writes back.
        int readByTxn2 = balance.get();
        System.out.println("Txn 2 reads balance: " + readByTxn2);

        // --- STEP 3: TRANSACTION 1 ACTS ---
        if (readByTxn1 >= 100) {
            balance.addAndGet(-100);
            System.out.println("Txn 1 withdrew 100. Current Balance: " + balance.get());
        }

        // --- STEP 4: TRANSACTION 2 ACTS (FAIL) ---
        // Txn 2 still thinks it's 100 because it hasn't re-checked!
        if (readByTxn2 >= 100) {
            balance.addAndGet(-100);
            System.out.println("Txn 2 withdrew 100. Current Balance: " + balance.get());
        }

        System.out.println("Final Balance: " + balance.get());
        System.out.println("--------------------------------------------------");
        
        // --- THE SOLUTION: ATOMIC CHECK-AND-ACT ---
        resetBalance();
        demonstrateFix();
    }

    private static void resetBalance() {
        balance.set(100);
        System.out.println("Reseting Balance to: " + balance.get() + " for Fix Demo");
    }

    private static void demonstrateFix() {
        int readByTxn3 = balance.get(); // Reads 100
        
        // Simulate someone else changing it first
        balance.set(0); 
        System.out.println("Someone else emptied the account! Current: " + balance.get());

        // This is the ATOMIC FIX: compareAndSet
        // "Update to 0 ONLY IF the current value is still 100"
        boolean success = balance.compareAndSet(readByTxn3, readByTxn3 - 100);

        if (success) {
            System.out.println("Txn 3 Success! New Balance: " + balance.get());
        } else {
            System.out.println("Txn 3 FAILED: Race condition prevented by compareAndSet.");
            System.out.println("Actual Final Balance preserved at: " + balance.get());
        }
    }
}
