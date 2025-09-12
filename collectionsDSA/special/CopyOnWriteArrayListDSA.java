package collectionsDSA.special;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDSA {
    public static void main(String[] args) {
        // 1. CREATION
        CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<Integer> cowList2 = new CopyOnWriteArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5)
        );
        
        // 2. BASIC OPERATIONS
        
        // Add operations - O(n) time due to copy, O(n) space
        cowList.add("A");           // O(n) - creates new array
        cowList.add("B");           // O(n) - creates new array
        cowList.add(0, "Start");    // O(n) - creates new array
        cowList.addIfAbsent("C");   // O(n) - adds only if not present
        
        System.out.println("COW List: " + cowList);
        
        // Access operations - O(1) time
        String first = cowList.get(0);    // O(1) - direct access
        String last = cowList.get(cowList.size() - 1);  // O(1)
        
        System.out.println("First: " + first + ", Last: " + last);
        
        // Modify operations
        cowList.set(0, "NewStart");  // O(n) - creates new array
        System.out.println("After set: " + cowList);
        
        // Remove operations - O(n) time, O(n) space
        String removed = cowList.remove(0);  // O(n) - creates new array
        boolean removed2 = cowList.remove("B");  // O(n) - creates new array
        System.out.println("After removals: " + cowList);
        
        // 3. THREAD-SAFE ITERATION WITHOUT SYNCHRONIZATION
        
        CopyOnWriteArrayList<Integer> threadSafeList = new CopyOnWriteArrayList<>();
        threadSafeList.addAll(Arrays.asList(1, 2, 3, 4, 5));
        
        // Reader thread - can iterate without blocking writers
        Thread reader = new Thread(() -> {
            System.out.println("Reader started...");
            for (Integer num : threadSafeList) {
                System.out.println("Reading: " + num);
                try {
                    Thread.sleep(100);  // Simulate processing time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Reader finished");
        });
        
        // Writer thread - can write without blocking readers
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(50);  // Let reader start first
                System.out.println("Writer adding elements...");
                threadSafeList.add(6);
                threadSafeList.add(7);
                threadSafeList.remove(0);
                System.out.println("Writer finished");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        reader.start();
        writer.start();
        
        try {
            reader.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final list: " + threadSafeList);
        
        // 4. ITERATOR BEHAVIOR (WEAKLY CONSISTENT)
        
        CopyOnWriteArrayList<String> listForIterator = new CopyOnWriteArrayList<>(
            Arrays.asList("A", "B", "C")
        );
        
        Iterator<String> iterator = listForIterator.iterator();
        System.out.println("Iterator created");
        
        // Modify list while iterating
        listForIterator.add("D");
        listForIterator.remove("A");
        System.out.println("List modified during iteration: " + listForIterator);
        
        // Iterator still sees original snapshot
        System.out.println("Iterator contents (original snapshot):");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        // New iterator sees current state
        Iterator<String> newIterator = listForIterator.iterator();
        System.out.println("New iterator contents (current state):");
        while (newIterator.hasNext()) {
            System.out.println(newIterator.next());
        }
        
        // 5. USEFUL METHODS
        
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(
            Arrays.asList(1, 2, 3, 2, 4, 1)
        );
        
        // addIfAbsent - O(n) time
        boolean added = numbers.addIfAbsent(5);
        System.out.println("Added 5: " + added);
        boolean addedAgain = numbers.addIfAbsent(2);
        System.out.println("Added 2 again: " + addedAgain + ", List: " + numbers);
        
        // addAllAbsent - O(n*m) time where n=list size, m=collection size
        List<Integer> toAdd = Arrays.asList(6, 7, 2, 8);
        int addedCount = numbers.addAllAbsent(toAdd);
        System.out.println("Added " + addedCount + " new elements: " + numbers);
        
        // 6. PERFORMANCE DEMONSTRATION
        
        System.out.println("\n=== Performance Characteristics ===");
        CopyOnWriteArrayList<Integer> perfList = new CopyOnWriteArrayList<>();
        
        // Measure add performance
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            perfList.add(i);
        }
        long addTime = System.nanoTime() - startTime;
        
        // Measure read performance
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            perfList.get(i);
        }
        long readTime = System.nanoTime() - startTime;
        
        System.out.println("Time to add 1000 elements: " + addTime + " ns");
        System.out.println("Time to read 1000 elements: " + readTime + " ns");
        System.out.println("Note: Add operations are O(n) due to copying");
        System.out.println("Note: Read operations are O(1) - very fast");
        
        // 7. CONCURRENT ITERATION EXAMPLE
        
        System.out.println("\n=== Concurrent Iteration Example ===");
        CopyOnWriteArrayList<String> concurrentList = new CopyOnWriteArrayList<>();
        concurrentList.addAll(Arrays.asList("Task1", "Task2", "Task3", "Task4"));
        
        // Multiple readers can iterate simultaneously
        Runnable readerTask = () -> {
            System.out.println(Thread.currentThread().getName() + " started reading");
            for (String task : concurrentList) {
                System.out.println(Thread.currentThread().getName() + " reading: " + task);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + " finished reading");
        };
        
        Thread reader1 = new Thread(readerTask, "Reader-1");
        Thread reader2 = new Thread(readerTask, "Reader-2");
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(25);
                System.out.println("Writer adding new task");
                concurrentList.add("Task5");
                System.out.println("Writer finished");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Writer");
        
        reader1.start();
        reader2.start();
        writerThread.start();
        
        try {
            reader1.join();
            reader2.join();
            writerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final list: " + concurrentList);
    }
}

/*
 ============================================================================
                    COPYONWRITEARRAYLIST TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | get(index)                   | O(1)           | O(1)            | Direct access by index
 | set(index, element)          | O(n)           | O(n)            | Copy + modify single element
 | add(element)                 | O(n)           | O(n)            | Copy + add to end
 | add(index, element)          | O(n)           | O(n)            | Copy + insert at index
 | addIfAbsent(element)         | O(n)           | O(n)            | Search + copy if absent
 | addAll(collection)           | O(n+m)         | O(n+m)          | Copy + add m elements
 | addAllAbsent(collection)     | O(n*m)         | O(n+m)          | Search all + copy absent
 | remove(index)                | O(n)           | O(n)            | Copy excluding element
 | remove(object)               | O(n)           | O(n)            | Search + copy excluding
 | removeAll(collection)        | O(n*m)         | O(n)            | Search + copy excluding
 | contains(element)            | O(n)           | O(1)            | Linear search
 | indexOf(element)             | O(n)           | O(1)            | Linear search
 | lastIndexOf(element)         | O(n)           | O(1)            | Backward linear search
 | size()                       | O(1)           | O(1)            | Return size field
 | isEmpty()                    | O(1)           | O(1)            | Check size
 | clear()                      | O(1)           | O(1)            | Set array to empty
 | iterator()                   | O(1)           | O(1)            | Create snapshot iterator
 | toArray()                    | O(n)           | O(n)            | Copy to array
 | clone()                      | O(n)           | O(n)            | Shallow copy
 
 ============================================================================
                    WHEN TO USE COPYONWRITEARRAYLIST
 ============================================================================
 
 ✓ Concurrent read-heavy scenarios
 ✓ Iteration while modifications happen
 ✓ Thread-safe iteration without explicit synchronization
 ✓ When iterator consistency is important
 ✓ Read-mostly collections with occasional writes
 ✓ Publisher-subscriber patterns
 ✓ Event listener lists
 ✓ Configuration lists that rarely change

 ============================================================================
                    WHEN TO AVOID COPYONWRITEARRAYLIST
 ============================================================================
 
 ✗ Write-heavy scenarios (performance overhead)
 ✗ Large collections (high memory overhead)
 ✓ When you need strong consistency
 ✗ Frequent modifications
 ✗ Memory-constrained environments
 ✗ When ArrayList + synchronization is sufficient
 ✗ Real-time performance requirements

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Copy-On-Write Mechanism:
 - Every modification creates complete copy of internal array
 - Readers always see consistent snapshot
 - No locking between readers and writers
 - Writers block other writers but not readers

 Thread Safety:
 - All operations are thread-safe
 - No explicit synchronization needed
 - Lock-free for read operations
 - Write operations use ReentrantLock

 Iterator Behavior:
 - Weakly consistent (snapshot of array at creation time)
 - Never throw ConcurrentModificationException
 - Reflect state at iterator creation, not current state
 - Deterministic behavior during iteration

 ============================================================================
                    COMPARISON WITH OTHER CONCURRENT COLLECTIONS
 ============================================================================
 
 | Feature              | CopyOnWriteArrayList | Vector | Collections.synchronizedList()
 |----------------------|---------------------|--------|-------------------------------
 | Thread Safety        | Yes (lock-free)     | Yes    | Yes
 | Iterator Consistency | Weak (snapshot)     | Fail-fast | Fail-fast
 | Write Performance    | Poor (copy)         | Poor (sync) | Poor (sync)
 | Read Performance     | Excellent           | Good   | Good
 | Memory Overhead      | High (copy)         | Low    | Low
 | Blocking             | No                  | Yes    | Yes
 | Best For             | Read-heavy          | Legacy | Simple sync needs

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Difference between CopyOnWriteArrayList and synchronized collections
 2. When to use CopyOnWriteArrayList vs ConcurrentHashMap
 3. Iterator behavior and consistency guarantees
 4. Memory implications of copy-on-write strategy
 5. Performance comparison with other concurrent collections
 6. Use cases for weakly consistent iterators
 7. Thread safety without explicit locking
 8. Trade-offs between consistency and performance
 9. Publisher-subscriber pattern implementation
 10. Event handling with CopyOnWriteArrayList

 ============================================================================
                    MEMORY AND PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Memory Usage Pattern:
 - Each modification creates complete copy of internal array
 - Old arrays become garbage after modification
 - High garbage collection pressure with frequent writes
 - Memory spikes during modification operations
 - Snapshots consume additional memory during iteration

 Performance:
 - Read operations: O(1) time complexity - excellent performance
 - Write operations: O(n) time complexity - poor performance
 - Memory overhead: High due to copying
 - Garbage collection: Frequent with write-heavy workloads
 - Concurrency: Excellent - no reader-writer blocking

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Use for read-heavy, write-light scenarios
 2. Avoid for frequently modified collections
 3. Consider memory impact of frequent copies
 4. Use iterator() for consistent snapshots
 5. Prefer addIfAbsent() over contains() + add()
 6. Monitor garbage collection with frequent writes
 7. Size appropriately to minimize resizing
 8. Consider alternatives for write-heavy use cases

 ============================================================================
*/