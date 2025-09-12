package collectionsDSA.list;

import java.util.*;

public class LinkedListDSA {
    public static void main(String[] args) {
        // 1. CREATION
        LinkedList<String> list = new LinkedList<>();
        
        // 2. BASIC OPERATIONS
        // Add operations - O(1) at ends
        list.add("A");           // Add to end
        list.addFirst("Start");  // O(1)
        list.addLast("End");     // O(1)
        list.add(1, "Middle");   // O(n) - insert at index
        
        System.out.println("List: " + list);
        
        // Access operations
        String first = list.getFirst();    // O(1)
        String last = list.getLast();      // O(1)
        String middle = list.get(1);       // O(n)
        
        System.out.println("First: " + first + ", Last: " + last + ", Middle: " + middle);
        
        // Remove operations - O(1) at ends
        String removedFirst = list.removeFirst();  // O(1)
        String removedLast = list.removeLast();    // O(1)
        String removedMiddle = list.remove(1);     // O(n)
        
        System.out.println("After removals: " + list);
        
        // 3. COMMON DSA OPERATIONS
        
        // Stack operations (LIFO)
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1); stack.push(2); stack.push(3);  // O(1)
        System.out.println("Stack: " + stack);
        System.out.println("Pop: " + stack.pop());    // O(1)
        
        // Queue operations (FIFO)
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1); queue.offer(2); queue.offer(3);  // O(1)
        System.out.println("Queue: " + queue);
        System.out.println("Poll: " + queue.poll());     // O(1)
        
        // 4. FREQUENTLY ASKED DSA PROBLEMS
        
        // Reverse LinkedList
        LinkedList<Integer> toReverse = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original: " + toReverse);
        Collections.reverse(toReverse);
        System.out.println("Reversed: " + toReverse);
        
        // Find middle element (slow-fast pointer technique)
        LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer middleElement = findMiddle(numbers);
        System.out.println("Middle element: " + middleElement);
        
        // Detect cycle (Floyd's cycle detection)
        System.out.println("Has cycle: " + hasCycle(numbers));
    }
    
    // Find middle element - O(n) time, O(1) space
    public static <T> T findMiddle(LinkedList<T> list) {
        if (list.isEmpty()) return null;
        
        ListIterator<T> slow = list.listIterator();
        ListIterator<T> fast = list.listIterator();
        
        T middle = null;
        while (fast.hasNext()) {
            middle = slow.next();
            fast.next();
            if (fast.hasNext()) {
                fast.next();
            }
        }
        return middle;
    }
    
    // Cycle detection - O(n) time, O(1) space
    public static <T> boolean hasCycle(LinkedList<T> list) {
        // In real scenario with custom nodes, use slow-fast pointers
        // For Java LinkedList, this is just demonstration
        return false; // Java LinkedList doesn't have cycles by design
    }
}

/*
 ============================================================================
                    LINKEDLIST TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | get(index)                   | O(n)           | O(1)            | Traverse to index
 | getFirst()                   | O(1)           | O(1)            | Direct access to first
 | getLast()                    | O(1)           | O(1)            | Direct access to last
 | set(index, element)          | O(n)           | O(1)            | Traverse + update
 | add(element)                 | O(1)           | O(1)            | Add to end
 | add(index, element)          | O(n)           | O(1)            | Traverse + insert
 | addFirst(element)            | O(1)           | O(1)            | Add to beginning
 | addLast(element)             | O(1)           | O(1)            | Add to end
 | remove(index)                | O(n)           | O(1)            | Traverse + remove
 | removeFirst()                | O(1)           | O(1)            | Remove from beginning
 | removeLast()                 | O(1)           | O(1)            | Remove from end
 | remove(object)               | O(n)           | O(1)            | Search + remove
 | contains(element)            | O(n)           | O(1)            | Linear search
 | indexOf(element)             | O(n)           | O(1)            | Linear search
 | size()                       | O(1)           | O(1)            | Return size field
 | isEmpty()                    | O(1)           | O(1)            | Check size
 | clear()                      | O(1)           | O(1)            | Reset pointers
 | peek()                       | O(1)           | O(1)            | View first element
 | poll()                       | O(1)           | O(1)            | Remove first element
 | push(element)                | O(1)           | O(1)            | Add to beginning
 | pop()                        | O(1)           | O(1)            | Remove from beginning
 
 ============================================================================
                    WHEN TO USE LINKEDLIST
 ============================================================================
 
 ✓ Frequent insertions/deletions at ends: O(1)
 ✓ Implementing stacks and queues
 ✓ Unknown final size with frequent modifications
 ✓ When you need Deque functionality
 ✓ When random access is not critical

 ============================================================================
                    WHEN TO AVOID LINKEDLIST
 ============================================================================
 
 ✗ Frequent random access by index: O(n)
 ✗ Memory-constrained environments (node overhead)
 ✗ Cache-performance critical applications
 ✗ When ArrayList performance is sufficient

 ============================================================================
                    COMPARISON WITH ARRAYLIST
 ============================================================================
 
 | Feature        | LinkedList | ArrayList | When to Choose
 |----------------|------------|-----------|----------------
 | Access Time    | O(n)       | O(1)      | ArrayList for random access
 | Insert/Delete  | O(1)*      | O(n)      | LinkedList for frequent add/remove
 | Memory Usage   | Higher     | Lower     | ArrayList for memory efficiency
 | Cache Perf     | Poor       | Good      | ArrayList for cache-friendly access
 | * = at ends only
 
 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Reverse a LinkedList - O(n) time, O(1) space
 2. Find middle element - Use slow-fast pointers
 3. Detect cycle - Floyd's cycle detection algorithm
 4. Merge two sorted LinkedLists - O(m+n) time
 5. Remove nth node from end - Two-pass or one-pass approach
 6. Palindrome check - Reverse half and compare
 7. Intersection point of two LinkedLists
 8. Flatten multilevel LinkedList
 9. Rotate LinkedList by k positions
 10. Remove duplicates from sorted LinkedList
 
 ============================================================================
*/