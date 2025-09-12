package collectionsDSA.queue;

import java.util.*;

public class ArrayDequeDSA {
    public static void main(String[] args) {
        // 1. CREATION
        ArrayDeque<String> deque = new ArrayDeque<>();  // Default capacity
        ArrayDeque<Integer> deque2 = new ArrayDeque<>(32);  // Initial capacity
        
        // 2. BASIC DEQUE OPERATIONS (Double-ended queue)
        
        // Add operations at both ends - O(1) amortized time
        deque.add("A");           // Add to tail (end)
        deque.addFirst("Start");  // O(1) - Add to head (beginning)
        deque.addLast("End");     // O(1) - Add to tail (end)
        
        System.out.println("Deque after adds: " + deque);
        
        // Offer operations (alternative to add)
        deque.offerFirst("VeryStart");  // O(1) - Add to head
        deque.offerLast("VeryEnd");     // O(1) - Add to tail
        System.out.println("Deque after offers: " + deque);
        
        // 3. ACCESS OPERATIONS
        
        // Peek operations - O(1) time (view without removing)
        String firstElement = deque.peekFirst();  // O(1) - View head
        String lastElement = deque.peekLast();    // O(1) - View tail
        String headElement = deque.peek();        // O(1) - View head (same as peekFirst)
        
        System.out.println("First element (peekFirst): " + firstElement);
        System.out.println("Last element (peekLast): " + lastElement);
        System.out.println("Head element (peek): " + headElement);
        System.out.println("Deque unchanged: " + deque);
        
        // 4. REMOVE OPERATIONS
        
        // Remove operations - O(1) time
        String removedFirst = deque.removeFirst();  // O(1) - Remove from head
        String removedLast = deque.removeLast();    // O(1) - Remove from tail
        String removedHead = deque.remove();        // O(1) - Remove from head (same as removeFirst)
        
        System.out.println("Removed first: " + removedFirst);
        System.out.println("Removed last: " + removedLast);
        System.out.println("Removed head: " + removedHead);
        System.out.println("Deque after removals: " + deque);
        
        // Poll operations (alternative to remove, returns null if empty)
        String polledFirst = deque.pollFirst();  // O(1) - Remove from head
        String polledLast = deque.pollLast();    // O(1) - Remove from tail
        String polledHead = deque.poll();        // O(1) - Remove from head
        
        System.out.println("Polled first: " + polledFirst);
        System.out.println("Polled last: " + polledLast);
        System.out.println("Polled head: " + polledHead);
        System.out.println("Deque after polls: " + deque);
        
        // 5. STACK OPERATIONS (LIFO - Last In First Out)
        
        System.out.println("\n=== Stack Operations ===");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        // Push operations - O(1)
        stack.push(10);  // O(1) - Add to head
        stack.push(20);  // O(1) - Add to head
        stack.push(30);  // O(1) - Add to head
        System.out.println("Stack after pushes: " + stack);
        
        // Peek operation - O(1)
        Integer topElement = stack.peek();  // O(1) - View head
        System.out.println("Top element (peek): " + topElement);
        
        // Pop operations - O(1)
        Integer popped = stack.pop();  // O(1) - Remove from head
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after pop: " + stack);
        
        // 6. QUEUE OPERATIONS (FIFO - First In First Out)
        
        System.out.println("\n=== Queue Operations ===");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        // Enqueue operations - O(1)
        queue.offer(100);  // O(1) - Add to tail
        queue.offer(200);  // O(1) - Add to tail
        queue.offer(300);  // O(1) - Add to tail
        System.out.println("Queue after enqueues: " + queue);
        
        // Peek operation - O(1)
        Integer headElementQueue = queue.peek();  // O(1) - View head
        System.out.println("Head element (peek): " + headElementQueue);
        
        // Dequeue operations - O(1)
        Integer dequeued = queue.poll();  // O(1) - Remove from head
        System.out.println("Dequeued element: " + dequeued);
        System.out.println("Queue after dequeue: " + queue);
        
        // 7. COLLECTION OPERATIONS
        
        ArrayDeque<String> collectionDeque = new ArrayDeque<>();
        collectionDeque.add("One");
        collectionDeque.add("Two");
        collectionDeque.add("Three");
        
        // Contains operations - O(n)
        boolean hasTwo = collectionDeque.contains("Two");
        System.out.println("\nContains 'Two': " + hasTwo);
        
        // Size and empty check - O(1)
        System.out.println("Deque size: " + collectionDeque.size());
        System.out.println("Is deque empty: " + collectionDeque.isEmpty());
        
        // 8. ITERATION
        
        System.out.println("\n=== Iteration Methods ===");
        ArrayDeque<String> iterateDeque = new ArrayDeque<>();
        iterateDeque.add("First");
        iterateDeque.add("Second");
        iterateDeque.add("Third");
        iterateDeque.add("Fourth");
        
        System.out.println("Deque: " + iterateDeque);
        
        // Enhanced for loop
        System.out.println("Enhanced for loop:");
        for (String element : iterateDeque) {
            System.out.println("  " + element);
        }
        
        // Iterator (head to tail order)
        System.out.println("Iterator (head to tail):");
        Iterator<String> iterator = iterateDeque.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }
        
        // Descending iterator (tail to head order)
        System.out.println("Descending iterator (tail to head):");
        Iterator<String> descendingIterator = iterateDeque.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println("  " + descendingIterator.next());
        }
        
        // 9. PRACTICAL USE CASE: PALINDROME CHECKER
        
        System.out.println("\n=== Palindrome Checker Example ===");
        String palindrome = "racecar";
        boolean isPalindrome = checkPalindrome(palindrome);
        System.out.println("\"" + palindrome + "\" is palindrome: " + isPalindrome);
        
        String notPalindrome = "hello";
        boolean isNotPalindrome = checkPalindrome(notPalindrome);
        System.out.println("\"" + notPalindrome + "\" is palindrome: " + isNotPalindrome);
        
        // 10. PRACTICAL USE CASE: SLIDING WINDOW MAXIMUM
        
        System.out.println("\n=== Sliding Window Maximum Example ===");
        int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
        int windowSize = 3;
        int[] maxInWindows = slidingWindowMaximum(array, windowSize);
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Window size: " + windowSize);
        System.out.println("Maximums in windows: " + Arrays.toString(maxInWindows));
        
        // 11. PERFORMANCE DEMONSTRATION
        
        System.out.println("\n=== Performance Characteristics ===");
        ArrayDeque<Integer> perfDeque = new ArrayDeque<>();
        
        // Add elements to demonstrate circular array behavior
        for (int i = 0; i < 10; i++) {
            perfDeque.addLast(i);
        }
        System.out.println("Initial deque: " + perfDeque);
        
        // Remove from front and add to back to show circular behavior
        for (int i = 0; i < 5; i++) {
            Integer removed = perfDeque.pollFirst();
            perfDeque.addLast(10 + i);
            System.out.println("Removed: " + removed + ", Added: " + (10 + i) + 
                             ", Deque: " + perfDeque);
        }
        
        // 12. ARRAY RESIZING DEMONSTRATION
        
        System.out.println("\n=== Array Resizing ===");
        ArrayDeque<Integer> resizeDeque = new ArrayDeque<>(4);  // Small initial capacity
        
        System.out.println("Adding elements to trigger resize:");
        for (int i = 1; i <= 10; i++) {
            resizeDeque.add(i);
            System.out.println("Added " + i + ", Size: " + resizeDeque.size());
        }
        System.out.println("Final deque: " + resizeDeque);
    }
    
    // Palindrome checker using ArrayDeque
    public static boolean checkPalindrome(String str) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        
        // Add all characters to deque
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }
        
        // Compare characters from both ends
        while (deque.size() > 1) {
            Character first = deque.pollFirst();
            Character last = deque.pollLast();
            if (!first.equals(last)) {
                return false;
            }
        }
        return true;
    }
    
    // Sliding window maximum using ArrayDeque
    public static int[] slidingWindowMaximum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();  // Stores indices
        
        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            
            // Remove indices whose corresponding values are less than current value
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // Add current index
            deque.offerLast(i);
            
            // Add maximum for current window to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}

/*
 ============================================================================
                    ARRAYDEQUE TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | add(element)                 | O(1) amortized | O(1)            | Add to tail
 | addFirst(element)            | O(1) amortized | O(1)            | Add to head
 | addLast(element)             | O(1) amortized | O(1)            | Add to tail
 | offer(element)               | O(1) amortized | O(1)            | Add to tail
 | offerFirst(element)          | O(1) amortized | O(1)            | Add to head
 | offerLast(element)           | O(1) amortized | O(1)            | Add to tail
 | remove()                     | O(1)           | O(1)            | Remove from head
 | removeFirst()                | O(1)           | O(1)            | Remove from head
 | removeLast()                 | O(1)           | O(1)            | Remove from tail
 | poll()                       | O(1)           | O(1)            | Remove from head
 | pollFirst()                  | O(1)           | O(1)            | Remove from head
 | pollLast()                   | O(1)           | O(1)            | Remove from tail
 | push(element)                | O(1) amortized | O(1)            | Add to head (stack)
 | pop()                        | O(1)           | O(1)            | Remove from head (stack)
 | peek()                       | O(1)           | O(1)            | View head
 | peekFirst()                  | O(1)           | O(1)            | View head
 | peekLast()                   | O(1)           | O(1)            | View tail
 | getFirst()                   | O(1)           | O(1)            | View head (throws if empty)
 | getLast()                    | O(1)           | O(1)            | View tail (throws if empty)
 | element()                    | O(1)           | O(1)            | View head (throws if empty)
 | size()                       | O(1)           | O(1)            | Return size field
 | isEmpty()                    | O(1)           | O(1)            | Check size
 | contains(element)            | O(n)           | O(1)            | Linear search
 | remove(object)               | O(n)           | O(1)            | Linear search + remove
 | clear()                      | O(1)           | O(1)            | Clear all elements
 | iterator()                   | O(1)           | O(1)            | Create iterator
 | descendingIterator()         | O(1)           | O(1)            | Create reverse iterator
 | toArray()                    | O(n)           | O(n)            | Copy to array

 ============================================================================
                    WHEN TO USE ARRAYDEQUE
 ============================================================================
 
 ✓ When you need both stack and queue operations
 ✓ Better performance than Stack class (not synchronized)
 ✓ Better performance than LinkedList for deque operations
 ✓ When you need fast add/remove operations at both ends
 ✓ Memory-efficient compared to LinkedList
 ✓ When you don't need index-based access
 ✓ Cache-friendly due to array-based implementation

 ============================================================================
                    WHEN TO AVOID ARRAYDEQUE
 ============================================================================
 
 ✗ When you need index-based access to elements
 ✗ When you need to frequently insert/remove from middle
 ✗ When thread safety is required without external synchronization
 ✗ When you need the List interface methods
 ✗ When memory overhead of array resizing is unacceptable
 ✗ When you need the legacy Stack methods not in Deque

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Internal Structure:
 - Circular array implementation
 - Resizes when capacity is exceeded
 - Maintains head and tail indices
 - No node overhead like LinkedList
 - Better cache locality than LinkedList

 Performance:
 - O(1) amortized time for add operations
 - O(1) time for remove operations
 - Resizing doubles capacity when needed
 - Circular array allows efficient use of space
 - Better performance than Stack and LinkedList for deque operations

 Memory:
 - More memory efficient than LinkedList
 - Array overhead but no node overhead
 - Resizing may cause temporary memory spike
 - Predictable memory usage pattern

 ============================================================================
                    COMPARISON WITH OTHER COLLECTIONS
 ============================================================================
 
 | Feature              | ArrayDeque | LinkedList | Stack<Class> | ArrayList
 |----------------------|------------|------------|--------------|----------
 | Add/Remove Ends      | O(1)       | O(1)       | O(1)         | O(1)/O(n)
 | Add/Remove Middle    | O(n)       | O(n)       | N/A          | O(n)
 | Memory Efficiency    | High       | Low        | Medium       | High
 | Cache Performance    | Good       | Poor       | Good         | Good
 | Index Access         | No         | O(n)       | No           | O(1)
 | Thread Safety        | No         | No         | Yes          | No
 | Resizing             | Yes        | No         | No           | Yes

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Internal implementation of ArrayDeque (circular array)
 2. Difference between ArrayDeque and LinkedList
 3. Why ArrayDeque is better than Stack class
 4. Circular array behavior and resizing
 5. Stack and queue operations with ArrayDeque
 6. Performance comparison with other deque implementations
 7. Memory usage and efficiency characteristics
 8. Iterator behavior and fail-fast guarantees
 9. Use cases for double-ended queue
 10. Sliding window algorithms with ArrayDeque
 11. Palindrome checking using deque
 12. Thread safety considerations

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Speed:
 - O(1) amortized for add operations at both ends
 - O(1) for remove operations at both ends
 - Better than LinkedList due to array access patterns
 - Better than Stack class due to lack of synchronization
 - Resizing overhead is amortized over multiple operations

 Memory:
 - More memory efficient than LinkedList (no node overhead)
 - Less memory efficient than raw arrays (some unused space)
 - Resizing doubles capacity (temporary memory spike)
 - Circular array allows efficient space utilization

 Scalability:
 - Good scalability for deque operations
 - Resizing overhead decreases with larger datasets
 - Cache-friendly access patterns improve performance
 - Predictable performance characteristics

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Use ArrayDeque instead of Stack class for better performance
 2. Choose appropriate initial capacity to avoid resizing
 3. Use for both stack and queue operations seamlessly
 4. Leverage circular array for efficient space utilization
 5. Consider memory overhead for large datasets
 6. Use push/pop for stack operations, offer/poll for queue operations
 7. Profile performance for high-frequency operations
 8. Monitor resizing behavior in performance-critical applications
 9. Use iterator() for head-to-tail traversal, descendingIterator() for reverse
 10. Avoid using as List when index access is needed
 11. Consider thread safety requirements for concurrent access
 12. Use contains() sparingly due to O(n) complexity

 ============================================================================
*/