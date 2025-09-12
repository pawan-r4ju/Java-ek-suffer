package collectionsDSA.list;

import java.util.*;

public class ArrayListDSA {
    public static void main(String[] args) {
        // 1. CREATION
        ArrayList<String> list = new ArrayList<>();  // Default capacity 10
        ArrayList<Integer> list2 = new ArrayList<>(20);  // Initial capacity 20
        
        // 2. BASIC OPERATIONS
        // Add operations
        list.add("A");           // O(1) amortized - add to end
        list.add("B");           // O(1) amortized
        list.add(0, "Start");    // O(n) - insert at beginning
        list.add(1, "Middle");   // O(n) - insert at index
        
        System.out.println("List: " + list);
        
        // Access operations - O(1) random access
        String first = list.get(0);    // O(1)
        String last = list.get(list.size() - 1);  // O(1)
        
        System.out.println("First: " + first + ", Last: " + last);
        
        // Modify operations
        list.set(0, "NewStart");  // O(1) - update by index
        System.out.println("After set: " + list);
        
        // Remove operations
        String removed = list.remove(0);  // O(n) - remove by index
        boolean removed2 = list.remove("B");  // O(n) - remove by object
        System.out.println("After removals: " + list);
        
        // 3. COMMON DSA OPERATIONS
        
        // Sorting - O(n log n)
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        System.out.println("Before sort: " + numbers);
        Collections.sort(numbers);  // O(n log n)
        System.out.println("After sort: " + numbers);
        
        // Searching
        int index = numbers.indexOf(5);  // O(n)
        boolean contains = numbers.contains(5);  // O(n)
        System.out.println("Index of 5: " + index + ", Contains 5: " + contains);
        
        // Binary search (requires sorted list) - O(log n)
        int binaryIndex = Collections.binarySearch(numbers, 5);  // O(log n)
        System.out.println("Binary search index of 5: " + binaryIndex);
        
        // 4. FREQUENTLY ASKED DSA PROBLEMS
        
        // Find duplicates
        ArrayList<Integer> withDuplicates = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 1));
        System.out.println("Array with duplicates: " + withDuplicates);
        System.out.println("Duplicates: " + findDuplicates(withDuplicates));
        
        // Remove duplicates
        ArrayList<Integer> noDuplicates = removeDuplicates(new ArrayList<>(withDuplicates));
        System.out.println("After removing duplicates: " + noDuplicates);
        
        // Rotate array - O(n)
        ArrayList<Integer> toRotate = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Before rotation: " + toRotate);
        Collections.rotate(toRotate, 2);  // O(n)
        System.out.println("After rotating by 2: " + toRotate);
    }
    
    // Find duplicates - O(n) time, O(n) space
    public static List<Integer> findDuplicates(ArrayList<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();
        
        for (Integer num : list) {
            if (!seen.add(num)) {  // add returns false if element already exists
                duplicates.add(num);
            }
        }
        return duplicates;
    }
    
    // Remove duplicates - O(n) time, O(n) space
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }
}

/*
 ============================================================================
                    ARRAYLIST TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | get(index)                   | O(1)           | O(1)            | Direct access by index
 | set(index, element)          | O(1)           | O(1)            | Direct modification
 | add(element)                 | O(1) amortized | O(1) amortized  | Add to end
 | add(index, element)          | O(n)           | O(1)            | Shift elements right
 | addAll(collection)           | O(m)           | O(m)            | Add m elements to end
 | addAll(index, collection)    | O(m+n)         | O(m)            | Shift + add m elements
 | remove(index)                | O(n)           | O(1)            | Shift elements left
 | remove(object)               | O(n)           | O(1)            | Search + shift
 | removeAll(collection)        | O(m*n)         | O(1)            | Remove m elements
 | contains(element)            | O(n)           | O(1)            | Linear search
 | indexOf(element)             | O(n)           | O(1)            | Linear search
 | lastIndexOf(element)         | O(n)           | O(1)            | Linear search backward
 | size()                       | O(1)           | O(1)            | Return size field
 | isEmpty()                    | O(1)           | O(1)            | Check size
 | clear()                      | O(1)           | O(1)            | Reset size
 | iterator()                   | O(1)           | O(1)            | Create iterator
 | sort()                       | O(n log n)     | O(n)            | TimSort algorithm
 | binarySearch()               | O(log n)       | O(1)            | Requires sorted list
 | toArray()                    | O(n)           | O(n)            | Copy to array
 
 ============================================================================
                    WHEN TO USE ARRAYLIST
 ============================================================================
 
 ✓ Frequent random access by index: O(1)
 ✓ More read operations than write operations
 ✓ Known or approximate final size
 ✓ Need for sorting/searching operations
 ✓ Cache-performance critical applications
 ✓ Memory efficiency requirements

 ============================================================================
                    WHEN TO AVOID ARRAYLIST
 ============================================================================
 
 ✗ Frequent insertions/deletions in middle: O(n)
 ✗ Unknown final size with frequent resizing
 ✗ When you need thread safety (use synchronized wrapper)
 ✗ When LinkedList operations are more suitable
 ✗ Real-time performance requirements for add/remove

 ============================================================================
                    COMPARISON WITH LINKEDLIST
 ============================================================================
 
 | Feature        | ArrayList  | LinkedList | When to Choose
 |----------------|------------|------------|----------------
 | Access Time    | O(1)       | O(n)       | ArrayList for random access
 | Insert/Delete  | O(n)       | O(1)*      | LinkedList for frequent add/remove
 | Memory Usage   | Lower      | Higher     | ArrayList for memory efficiency
 | Cache Perf     | Good       | Poor       | ArrayList for cache-friendly access
 | * = at ends only
 
 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Find duplicates in array - O(n) time using HashSet
 2. Remove duplicates from sorted array - Two-pointer technique
 3. Rotate array by k positions - O(n) time, O(1) space
 4. Find missing number in array - XOR or sum approach
 5. Maximum subarray sum - Kadane's algorithm O(n)
 6. Two sum problem - HashMap approach O(n)
 7. Merge two sorted arrays - O(m+n) time
 8. Move zeros to end - Two-pointer technique
 9. Find peak element - Binary search O(log n)
 10. Search in rotated sorted array - Modified binary search
 
 ============================================================================
*/