package collectionsDSA.map;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentHashMapDSA {
    public static void main(String[] args) {
        // 1. CREATION
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>(16);  // Initial capacity
        ConcurrentHashMap<String, Integer> map3 = new ConcurrentHashMap<>(16, 0.75f, 16);  // Capacity, load factor, concurrency level
        
        // 2. BASIC MAP OPERATIONS
        
        // Put operations - O(1) average time
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);
        System.out.println("Map after puts: " + map);
        
        // Get operations - O(1) average time
        Integer appleCount = map.get("Apple");
        System.out.println("Apple count: " + appleCount);
        
        // PutIfAbsent - O(1) average time
        Integer oldValue = map.putIfAbsent("Apple", 50);  // Won't replace since Apple exists
        System.out.println("Old value for Apple: " + oldValue);
        Integer newValue = map.putIfAbsent("Grape", 40);  // Will add since Grape doesn't exist
        System.out.println("New value for Grape: " + newValue);
        System.out.println("Map after putIfAbsent: " + map);
        
        // Remove operations - O(1) average time
        Integer removed = map.remove("Banana");
        System.out.println("Removed Banana: " + removed);
        System.out.println("Map after removal: " + map);
        
        // Replace operations
        boolean replaced = map.replace("Orange", 30, 35);  // Replace only if current value is 30
        System.out.println("Replaced Orange: " + replaced);
        System.out.println("Map after replace: " + map);
        
        // 3. THREAD-SAFE OPERATIONS DEMONSTRATION
        
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        
        // Multiple threads accessing the same map
        Runnable producer = () -> {
            for (int i = 1; i <= 5; i++) {
                String key = "Thread-" + Thread.currentThread().getName() + "-Item-" + i;
                concurrentMap.put(key, i);
                System.out.println("Put: " + key + " = " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        
        // Start multiple producer threads
        Thread thread1 = new Thread(producer, "1");
        Thread thread2 = new Thread(producer, "2");
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final concurrent map size: " + concurrentMap.size());
        System.out.println("Final map: " + concurrentMap);
        
        // 4. ATOMIC OPERATIONS
        
        ConcurrentHashMap<String, Integer> atomicMap = new ConcurrentHashMap<>();
        atomicMap.put("Counter", 0);
        
        // Atomic increment using computeIfPresent
        for (int i = 0; i < 5; i++) {
            atomicMap.computeIfPresent("Counter", (key, value) -> value + 1);
        }
        System.out.println("Counter after atomic increments: " + atomicMap.get("Counter"));
        
        // Atomic increment using merge
        for (int i = 0; i < 3; i++) {
            atomicMap.merge("Counter", 1, Integer::sum);
        }
        System.out.println("Counter after merge increments: " + atomicMap.get("Counter"));
        
        // 5. COMPUTE OPERATIONS
        
        ConcurrentHashMap<String, String> computeMap = new ConcurrentHashMap<>();
        computeMap.put("name", "John");
        computeMap.put("age", "25");
        
        // Compute - always computes new value
        computeMap.compute("name", (key, value) -> value + " Doe");
        System.out.println("After compute: " + computeMap);
        
        // ComputeIfAbsent - compute only if key doesn't exist
        computeMap.computeIfAbsent("city", key -> "New York");
        System.out.println("After computeIfAbsent: " + computeMap);
        
        // ComputeIfPresent - compute only if key exists
        computeMap.computeIfPresent("age", (key, value) -> value + " years");
        System.out.println("After computeIfPresent: " + computeMap);
        
        // 6. ITERATION (WEAKLY CONSISTENT)
        
        ConcurrentHashMap<String, Integer> iterateMap = new ConcurrentHashMap<>();
        iterateMap.put("A", 1);
        iterateMap.put("B", 2);
        iterateMap.put("C", 3);
        iterateMap.put("D", 4);
        
        System.out.println("\nIteration demonstration:");
        System.out.println("Map: " + iterateMap);
        
        // Key set iteration
        System.out.println("Keys:");
        for (String key : iterateMap.keySet()) {
            System.out.println("  " + key);
        }
        
        // Entry set iteration
        System.out.println("Entries:");
        for (Map.Entry<String, Integer> entry : iterateMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }
        
        // 7. BULK OPERATIONS (Java 8+)
        
        ConcurrentHashMap<String, Integer> bulkMap = new ConcurrentHashMap<>();
        bulkMap.put("one", 1);
        bulkMap.put("two", 2);
        bulkMap.put("three", 3);
        bulkMap.put("four", 4);
        bulkMap.put("five", 5);
        
        // forEach operation
        System.out.println("\nBulk operations:");
        bulkMap.forEach((key, value) -> System.out.println(key + " = " + value));
        
        // Search operation
        String foundKey = bulkMap.search(1, (key, value) -> value > 3 ? key : null);
        System.out.println("Found key with value > 3: " + foundKey);
        
        // Reduce operation
        int sum = bulkMap.reduce(1, (key, value) -> value, Integer::sum);
        System.out.println("Sum of all values: " + sum);
        
        // 8. COLLECTION VIEWS
        
        System.out.println("\nCollection views:");
        System.out.println("Keys: " + bulkMap.keySet());
        System.out.println("Values: " + bulkMap.values());
        System.out.println("Entry set: " + bulkMap.entrySet());
        
        // Keys with mapping
        Set<String> keysWithMapping = bulkMap.keySet(3);
        System.out.println("Keys with value 3: " + keysWithMapping);
    }
}

/*
 ============================================================================
                    CONCURRENTHASHMAP TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | get(key)                     | O(1) average   | O(1)            | Hash lookup
 | put(key, value)              | O(1) average   | O(1)            | Hash insert
 | remove(key)                  | O(1) average   | O(1)            | Hash remove
 | putIfAbsent(key, value)      | O(1) average   | O(1)            | Conditional insert
 | replace(key, oldValue, newValue) | O(1) average | O(1)            | Conditional replace
 | replace(key, value)          | O(1) average   | O(1)            | Unconditional replace
 | compute(key, function)       | O(1) average   | O(1)            | Compute new value
 | computeIfAbsent(key, function) | O(1) average | O(1)            | Compute if key absent
 | computeIfPresent(key, function) | O(1) average | O(1)            | Compute if key present
 | merge(key, value, function)  | O(1) average   | O(1)            | Merge value
 | containsKey(key)             | O(1) average   | O(1)            | Key existence check
 | containsValue(value)         | O(n)           | O(1)            | Value existence check
 | size()                       | O(1) or O(n)   | O(1)            | Approximate size
 | isEmpty()                    | O(1)           | O(1)            | Empty check
 | clear()                      | O(1)           | O(1)            | Clear all entries
 | keySet()                     | O(1)           | O(1)            | Create key set view
 | values()                     | O(1)           | O(1)            | Create values view
 | entrySet()                   | O(1)           | O(1)            | Create entry set view
 | forEach(action)              | O(n)           | O(1)            | Iterate all entries
 | search(parallelism, searchFunction) | O(n/p)  | O(1)            | Parallel search
 | reduce(parallelism, transformer, reducer) | O(n/p) | O(1)       | Parallel reduce

 ============================================================================
                    WHEN TO USE CONCURRENTHASHMAP
 ============================================================================
 
 ✓ High-concurrency read-write scenarios
 ✓ Thread-safe map operations without explicit synchronization
 ✓ Better performance than Hashtable or synchronized HashMap
 ✓ When you need atomic operations on map entries
 ✓ Cache implementations with concurrent access
 ✓ Producer-consumer patterns with shared map
 ✓ Real-time systems requiring non-blocking operations
 ✓ Applications with multiple reader and writer threads

 ============================================================================
                    WHEN TO AVOID CONCURRENTHASHMAP
 ============================================================================
 
 ✗ Simple single-threaded applications
 ✗ When you don't need thread safety
 ✗ Memory-constrained environments (higher overhead than HashMap)
 ✗ When you need strong consistency guarantees
 ✗ Applications where blocking operations are acceptable
 ✗ Simple use cases where HashMap + synchronization is sufficient
 ✗ When you need ordered iteration (use ConcurrentSkipListMap)

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Thread Safety:
 - All operations are thread-safe
 - No explicit synchronization needed
 - Non-blocking operations for better performance
 - Segmented locking for high concurrency

 Atomic Operations:
 - putIfAbsent, remove, replace are atomic
 - compute, merge, computeIfAbsent, computeIfPresent are atomic
 - Bulk operations are atomic per entry

 Weakly Consistent Iterators:
 - Iterators are weakly consistent
 - Never throw ConcurrentModificationException
 - Reflect state at some point since iterator creation
 - May or may not reflect modifications during iteration

 Memory Consistency:
 - Actions in one thread before put() happen-before get() in another thread
 - Provides memory visibility guarantees
 - Happens-before relationships maintained

 ============================================================================
                    COMPARISON WITH OTHER MAP IMPLEMENTATIONS
 ============================================================================
 
 | Feature              | ConcurrentHashMap | HashMap | Hashtable | Collections.synchronizedMap()
 |----------------------|------------------|---------|-----------|----------------------------
 | Thread Safety        | Yes (lock-free)  | No      | Yes       | Yes
 | Null Keys/Values     | No               | Yes     | No        | Yes
 | Performance          | High concurrent  | High    | Low       | Low
 | Blocking             | No               | N/A     | Yes       | Yes
 | Iteration            | Weakly consistent| Fail-fast| Fail-fast | Fail-fast
 | Atomic Operations    | Yes              | No      | No        | No

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Thread-safe map implementations comparison
 2. ConcurrentHashMap vs Hashtable vs synchronized HashMap
 3. Segment-based locking mechanism
 4. Weakly consistent iterators behavior
 5. Atomic operations and their use cases
 6. Memory visibility guarantees
 7. Bulk operations in ConcurrentHashMap
 8. Cache implementation using ConcurrentHashMap
 9. Producer-consumer with shared ConcurrentHashMap
 10. Performance optimization with ConcurrentHashMap
 11. Fail-safe vs fail-fast iterators
 12. Memory consistency effects in concurrent maps

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Concurrency:
 - Segmented locking reduces contention
 - Multiple threads can access different segments simultaneously
 - Better scalability than single-lock approaches
 - Lock striping for improved throughput

 Memory:
 - Higher memory overhead than HashMap due to concurrency support
 - Segment-based structure
 - Additional metadata for concurrent operations
 - Memory-efficient for concurrent access patterns

 Throughput:
 - High throughput under concurrent access
 - Non-blocking reads improve performance
 - Reduced lock contention
 - Better than synchronized alternatives

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Use appropriate initial capacity and concurrency level
 2. Avoid null keys and values
 3. Use atomic operations for thread-safe compound actions
 4. Leverage compute methods for complex operations
 5. Use bulk operations for parallel processing
 6. Monitor performance under concurrent load
 7. Consider memory overhead for large maps
 8. Use weakly consistent iterators appropriately
 9. Handle potential race conditions in application logic
 10. Profile and tune for specific use cases

 ============================================================================
*/