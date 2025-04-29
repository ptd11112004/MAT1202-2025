package hus.oop.sorteddatastructure;

import java.util.Random;

public class TestSortedDataStructure {
    public static void main(String[] args) {
        System.out.println("Test SortedArrayList:");
        testSortedArrayList();
        System.out.println();
        
        System.out.println("Test SortedLinkedList:");
        testSortedLinkedList();
    }

    public static void testSortedArrayList() {
        Random rand = new Random();
        int n = rand.nextInt(11) + 20; // [20, 30]
        MySortedList list = new MySortedArrayList();
        
        System.out.println("Number of elements (n) = " + n);
        
        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(91) + 10; // [10, 100]
            list.add(value);
            System.out.println(list);
        }

        System.out.println("--- Testing contains() and binarySearch() ---");
        for (int i = 0; i < 5; i++) { // thử 5 số ngẫu nhiên
            int testValue = rand.nextInt(91) + 10;
            boolean exists = list.contains(testValue);
            if (exists) {
                System.out.println(testValue + " exists at index " + list.binarySearch(testValue));
            } else {
                System.out.println(testValue + " does not exist in the list.");
            }
        }
    }

    public static void testSortedLinkedList() {
        Random rand = new Random();
        int n = rand.nextInt(11) + 20; // [20, 30]
        MySortedList list = new MySortedLinkedList();
        
        System.out.println("Number of elements (n) = " + n);
        
        for (int i = 0; i < n; i++) {
            int value = rand.nextInt(91) + 10; // [10, 100]
            list.add(value);
            System.out.println(list);
        }

        System.out.println("--- Testing contains() and binarySearch() ---");
        for (int i = 0; i < 5; i++) { // thử 5 số ngẫu nhiên
            int testValue = rand.nextInt(91) + 10;
            boolean exists = list.contains(testValue);
            if (exists) {
                System.out.println(testValue + " exists at index " + list.binarySearch(testValue));
            } else {
                System.out.println(testValue + " does not exist in the list.");
            }
        }
    }
}
