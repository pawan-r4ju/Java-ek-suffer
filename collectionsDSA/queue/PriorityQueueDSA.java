package collectionsDSA.queue;

import java.util.*;

public class PriorityQueueDSA {
    public static void main(String[] args) {
        // 1. CREATION
        PriorityQueue<String> stringQueue = new PriorityQueue<>();  // Natural ordering
        PriorityQueue<Integer> intQueue = new PriorityQueue<>();    // Natural ordering (min-heap)
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap
        PriorityQueue<Task> customQueue = new PriorityQueue<>();    // Custom ordering
        
        // 2. BASIC PRIORITY QUEUE OPERATIONS (MIN-HEAP by default)
        
        // Add operations - O(log n) time
        intQueue.offer(5);    // O(log n) - Add element
        intQueue.offer(2);    // O(log n) - Add element
        intQueue.offer(8);    // O(log n) - Add element
        intQueue.offer(1);    // O(log n) - Add element
        intQueue.offer(3);    // O(log n) - Add element
        
        System.out.println("PriorityQueue (min-heap): " + intQueue);
        System.out.println("Note: Internal order may not reflect heap structure");
        
        // 3. ACCESS OPERATIONS
        
        // Peek operations - O(1) time (view without removing)
        Integer headElement = intQueue.peek();  // O(1) - View smallest element
        System.out.println("Head element (peek - smallest): " + headElement);
        System.out.println("Queue unchanged: " + intQueue);
        
        // Element operation - O(1) time (throws exception if empty)
        Integer element = intQueue.element();  // O(1) - View head element
        System.out.println("Element (head): " + element);
        
        // 4. REMOVE OPERATIONS
        
        // Remove operations - O(log n) time
        Integer removedHead = intQueue.poll();  // O(log n) - Remove and return smallest
        System.out.println("Removed head element: " + removedHead);
        System.out.println("Queue after removal: " + intQueue);
        
        // Remove specific element - O(n) time
        boolean removedSpecific = intQueue.remove(8);  // O(n) - Remove specific element
        System.out.println("Removed element 8: " + removedSpecific);
        System.out.println("Queue after specific removal: " + intQueue);
        
        // 5. CUSTOM PRIORITY WITH COMPARATOR
        
        System.out.println("\n=== Custom Priority Example ===");
        
        // Task with priority - higher number = higher priority
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>(
            (t1, t2) -> Integer.compare(t2.priority, t1.priority)  // Reverse order for max-heap
        );
        
        // Add tasks with different priorities
        priorityQueue.offer(new Task("Low Priority Task", 1));
        priorityQueue.offer(new Task("High Priority Task", 10));
        priorityQueue.offer(new Task("Medium Priority Task", 5));
        priorityQueue.offer(new Task("Critical Task", 15));
        
        System.out.println("Tasks in queue: " + priorityQueue);
        System.out.println("Note: Display order doesn't reflect priority order");
        
        // Process tasks in priority order
        System.out.println("Processing tasks in priority order:");
        while (!priorityQueue.isEmpty()) {
            Task task = priorityQueue.poll();
            System.out.println("Processing: " + task);
        }
        
        // 6. STRING PRIORITY QUEUE (LEXICOGRAPHIC ORDERING)
        
        System.out.println("\n=== String Priority Queue ===");
        PriorityQueue<String> stringPQ = new PriorityQueue<>();
        stringPQ.addAll(Arrays.asList("Charlie", "Alice", "Bob", "David", "Eve"));
        
        System.out.println("Strings in queue: " + stringPQ);
        System.out.println("Processing in alphabetical order:");
        
        while (!stringPQ.isEmpty()) {
            String name = stringPQ.poll();
            System.out.println("Processing: " + name);
        }
        
        // 7. COLLECTION OPERATIONS
        
        PriorityQueue<Integer> collectionQueue = new PriorityQueue<>();
        collectionQueue.addAll(Arrays.asList(5, 2, 8, 1, 9, 3));
        System.out.println("\nCollection operations:");
        System.out.println("Queue with added elements: " + collectionQueue);
        
        // Contains operations - O(n) time
        boolean hasThree = collectionQueue.contains(3);
        boolean hasTen = collectionQueue.contains(10);
        System.out.println("Contains 3: " + hasThree + ", Contains 10: " + hasTen);
        
        // Size and empty check - O(1) time
        System.out.println("Queue size: " + collectionQueue.size());
        System.out.println("Is queue empty: " + collectionQueue.isEmpty());
        
        // 8. ITERATION (NO PARTICULAR ORDER)
        
        System.out.println("\n=== Iteration Example ===");
        PriorityQueue<String> iterateQueue = new PriorityQueue<>();
        iterateQueue.addAll(Arrays.asList("Zebra", "Apple", "Monkey", "Banana"));
        
        System.out.println("PriorityQueue: " + iterateQueue);
        System.out.println("Note: Iterator order is NOT priority order");
        
        // Iterate through elements (no guaranteed order)
        System.out.println("Iterator traversal (not priority order):");
        for (String elementStr : iterateQueue) {
            System.out.println("Iterating: " + elementStr);
        }
        
        // Take elements in priority order
        System.out.println("Priority order processing:");
        PriorityQueue<String> copyQueue = new PriorityQueue<>(iterateQueue);
        while (!copyQueue.isEmpty()) {
            System.out.println("Priority processing: " + copyQueue.poll());
        }
        
        // 9. PRACTICAL USE CASE: TOP K ELEMENTS
        
        System.out.println("\n=== Top K Elements Example ===");
        int[] numbers = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        int k = 3;
        List<Integer> topK = findTopKElements(numbers, k);
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Top " + k + " elements: " + topK);
        
        // 10. PRACTICAL USE CASE: MERGE SORTED ARRAYS
        
        System.out.println("\n=== Merge Sorted Arrays Example ===");
        List<List<Integer>> sortedArrays = Arrays.asList(
            Arrays.asList(1, 4, 7),
            Arrays.asList(2, 5, 8),
            Arrays.asList(3, 6, 9)
        );
        List<Integer> merged = mergeSortedArrays(sortedArrays);
        System.out.println("Sorted arrays: " + sortedArrays);
        System.out.println("Merged result: " + merged);
        
        // 11. HEAP PROPERTY DEMONSTRATION
        
        System.out.println("\n=== Heap Property ===");
        PriorityQueue<Integer> heapDemo = new PriorityQueue<>();
        int[] elements = {10, 7, 5, 3, 2, 1};
        
        System.out.println("Adding elements in order: " + Arrays.toString(elements));
        for (int elem : elements) {
            heapDemo.offer(elem);
        }
        
        System.out.println("PriorityQueue maintains min-heap property");
        System.out.println("Smallest element is always at the head");
        
        // Extract elements in sorted order
        System.out.println("Extracting elements in sorted order:");
        while (!heapDemo.isEmpty()) {
            System.out.println("Extracted: " + heapDemo.poll());
        }
        
        // 12. PERFORMANCE COMPARISON
        
        System.out.println("\n=== Performance Characteristics ===");
        PriorityQueue<Integer> perfQueue = new PriorityQueue<>();
        
        // Add elements
        long startTime = System.nanoTime();
        for (int i = 1000; i >= 1; i--) {
            perfQueue.offer(i);
        }
        long addTime = System.nanoTime() - startTime;
        
        // Remove elements
        startTime = System.nanoTime();
        while (!perfQueue.isEmpty()) {
            perfQueue.poll();
        }
        long removeTime = System.nanoTime() - startTime;
        
        System.out.println("Time to add 1000 elements: " + addTime + " ns");
        System.out.println("Time to remove 1000 elements: " + removeTime + " ns");
        System.out.println("Average time per operation: " + (addTime + removeTime) / 2000 + " ns");
    }
    
    // Find top K elements using min-heap
    public static List<Integer> findTopKElements(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        
        List<Integer> result = new ArrayList<>(minHeap);
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
    
    // Merge k sorted arrays using min-heap
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        
        // Initialize heap with first element from each array
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            if (!array.isEmpty()) {
                minHeap.offer(new ArrayEntry(array.get(0), i, 0));
            }
        }
        
        // Extract minimum and add next element from same array
        while (!minHeap.isEmpty()) {
            ArrayEntry entry = minHeap.poll();
            result.add(entry.value);
            
            List<Integer> array = arrays.get(entry.arrayIndex);
            if (entry.elementIndex + 1 < array.size()) {
                minHeap.offer(new ArrayEntry(
                    array.get(entry.elementIndex + 1),
                    entry.arrayIndex,
                    entry.elementIndex + 1
                ));
            }
        }
        
        return result;
    }
    
    // Task class implementing Comparable for natural ordering
    static class Task implements Comparable<Task> {
        String name;
        int priority;
        
        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }
        
        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }
        
        @Override
        public String toString() {
            return "Task{name='" + name + "', priority=" + priority + "}";
        }
    }
    
    // Helper class for merge sorted arrays
    static class ArrayEntry implements Comparable<ArrayEntry> {
        int value;
        int arrayIndex;
        int elementIndex;
        
        public ArrayEntry(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
        
        @Override
        public int compareTo(ArrayEntry other) {
            return Integer.compare(this.value, other.value);
        }
    }
}

/*
 ============================================================================
                    PRIORITYQUEUE TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | add(element)                 | O(log n)       | O(1)            | Add to heap
 | offer(element)               | O(log n)       | O(1)            | Add to heap
 | remove()                     | O(log n)       | O(1)            | Remove head and reheapify
 | poll()                       | O(log n)       | O(1)            | Remove head and reheapify
 | element()                    | O(1)           | O(1)            | View head (throws if empty)
 | peek()                       | O(1)           | O(1)            | View head (null if empty)
 | remove(object)               | O(n)           | O(1)            | Linear search + remove
 | contains(object)             | O(n)           | O(1)            | Linear search
 | size()                       | O(1)           | O(1)            | Return size field
 | isEmpty()                    | O(1)           | O(1)            | Check size
 | clear()                      | O(1)           | O(1)            | Clear all elements
 | iterator()                   | O(1)           | O(1)            | Create iterator
 | toArray()                    | O(n log n)     | O(n)            | Heap sort to array
 | addAll(collection)           | O(m log n)     | O(m)            | Add m elements

 ============================================================================
                    WHEN TO USE PRIORITYQUEUE
 ============================================================================
 
 ✓ When you need to process elements in priority order
 ✓ Top K elements problems
 ✓ Dijkstra's shortest path algorithm
 ✓ Huffman coding
 ✓ Event-driven simulations
 ✓ Job scheduling systems
 ✓ Heap sort implementation
 ✓ Merge sorted data streams
 ✓ Median finding algorithms
 ✓ Graph algorithms requiring priority processing

 ============================================================================
                    WHEN TO AVOID PRIORITYQUEUE
 ============================================================================
 
 ✗ When you need FIFO processing (use Queue)
 ✗ When you need LIFO processing (use Stack)
 ✗ When you need random access to elements
 ✗ When you need to frequently access middle elements
 ✗ When iterator order needs to match priority order
 ✗ When you need guaranteed sorting of all elements at once
 ✗ Performance-critical applications where O(log n) is too slow

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Internal Structure:
 - Binary heap implementation (min-heap by default)
 - Complete binary tree stored in array
 - Parent at index i has children at indices 2i+1 and 2i+2
 - No ordering guarantee for iterator traversal
 - Automatic heap maintenance on insertions/removals

 Priority Ordering:
 - Min-heap by default (smallest element at head)
 - Custom ordering with Comparator
 - Natural ordering for Comparable elements
 - Head element is always the highest priority
 - Priority determined by compareTo() or Comparator.compare()

 Memory:
 - Array-based storage (no node overhead)
 - Resizes when capacity exceeded
 - Memory efficient compared to tree-based structures
 - Predictable memory usage pattern

 ============================================================================
                    COMPARISON WITH OTHER COLLECTIONS
 ============================================================================
 
 | Feature              | PriorityQueue | TreeSet    | ArrayList  | LinkedList
 |----------------------|---------------|------------|------------|------------
 | Time Complexity      | O(log n)      | O(log n)   | O(1)/O(n)  | O(1)/O(n)
 | Ordering             | Heap order    | Sorted     | Insertion  | Insertion
 | Memory Efficiency    | High          | Medium     | High       | Low
 | Random Access        | No            | No         | O(1)       | O(n)
 | Iterator Order       | No guarantee  | Sorted     | Insertion  | Insertion
 | Use Case             | Priority      | Sorted     | General    | Dynamic

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Internal implementation of PriorityQueue (binary heap)
 2. Difference between min-heap and max-heap
 3. Time complexity analysis of heap operations
 4. Top K elements algorithms using PriorityQueue
 5. Merge K sorted arrays/lists
 6. Dijkstra's algorithm implementation
 7. Heap sort vs PriorityQueue
 8. Custom Comparator implementation
 9. Iterator behavior in PriorityQueue
 10. Memory usage and efficiency characteristics
 11. Thread safety of PriorityQueue operations
 12. Use cases for priority-based processing

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Insertion:
 - O(log n) for each insertion
 - Heap maintenance overhead
 - Amortized over multiple operations
 - Better than linear search for ordering

 Removal:
 - O(log n) for head element removal
 - Heap reorganization required
 - Consistent performance regardless of element position
 - Better than sorting for priority processing

 Memory:
 - O(n) space complexity
 - Array-based storage (efficient)
 - No per-element node overhead
 - Resizing doubles capacity when needed

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Use appropriate initial capacity for performance
 2. Implement Comparable correctly or provide proper Comparator
 3. Choose min-heap vs max-heap based on requirements
 4. Use for priority-based processing scenarios
 5. Consider memory overhead for large datasets
 6. Profile performance for high-frequency operations
 7. Use peek() instead of poll() when you don't want to remove
 8. Avoid contains() and remove(object) for large queues
 9. Use for streaming data with priority requirements
 10. Consider alternative implementations for real-time systems
 11. Monitor heap property maintenance overhead
 12. Document priority ordering for maintenance

 ============================================================================
*/