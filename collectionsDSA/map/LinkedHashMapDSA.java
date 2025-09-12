package collectionsDSA.map;

import java.util.*;

public class LinkedHashMapDSA {
    public static void main(String[] args) {
        // 1. CREATION
        LinkedHashMap<String, Integer> insertionOrderMap = new LinkedHashMap<>();  // Default insertion order
        LinkedHashMap<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);  // Access order
        LinkedHashMap<String, Integer> customMap = new LinkedHashMap<>(32, 0.5f);  // Custom capacity and load factor
        
        // 2. BASIC MAP OPERATIONS WITH INSERTION ORDER
        
        // Put operations - O(1) average time
        insertionOrderMap.put("Apple", 10);
        insertionOrderMap.put("Banana", 20);
        insertionOrderMap.put("Orange", 30);
        insertionOrderMap.put("Apple", 15);  // Updates existing key (maintains position)
        System.out.println("Insertion order map: " + insertionOrderMap);
        
        // Get operations - O(1) average time
        Integer appleCount = insertionOrderMap.get("Apple");
        Integer mangoCount = insertionOrderMap.get("Mango");  // Returns null
        System.out.println("Apple count: " + appleCount);
        System.out.println("Mango count: " + mangoCount);
        
        // Add more elements to see ordering
        insertionOrderMap.put("Grape", 40);
        insertionOrderMap.put("Kiwi", 50);
        System.out.println("After adding more elements: " + insertionOrderMap);
        
        // 3. ACCESS ORDER DEMONSTRATION
        
        System.out.println("\n=== Access Order Example ===");
        accessOrderMap.put("A", 1);
        accessOrderMap.put("B", 2);
        accessOrderMap.put("C", 3);
        accessOrderMap.put("D", 4);
        
        System.out.println("Initial access order map: " + accessOrderMap);
        
        // Access elements to change their order
        accessOrderMap.get("A");  // Move A to end
        accessOrderMap.get("C");  // Move C to end
        System.out.println("After accessing A and C: " + accessOrderMap);
        
        // Add new element
        accessOrderMap.put("E", 5);
        System.out.println("After adding E: " + accessOrderMap);
        
        // 4. COLLECTION OPERATIONS
        
        LinkedHashMap<String, Integer> collectionMap = new LinkedHashMap<>();
        collectionMap.put("One", 1);
        collectionMap.put("Two", 2);
        collectionMap.put("Three", 3);
        
        // Contains operations
        boolean hasTwo = collectionMap.containsKey("Two");
        boolean hasValue3 = collectionMap.containsValue(3);
        System.out.println("\nContains 'Two' key: " + hasTwo);
        System.out.println("Contains value 3: " + hasValue3);
        
        // Size and empty check
        System.out.println("Map size: " + collectionMap.size());
        System.out.println("Is map empty: " + collectionMap.isEmpty());
        
        // 5. ITERATION (ORDERED)
        
        System.out.println("\n=== Ordered Iteration ===");
        LinkedHashMap<String, Integer> iterateMap = new LinkedHashMap<>();
        iterateMap.put("First", 1);
        iterateMap.put("Second", 2);
        iterateMap.put("Third", 3);
        iterateMap.put("Fourth", 4);
        
        System.out.println("LinkedHashMap: " + iterateMap);
        
        // Key set iteration (insertion order)
        System.out.println("Keys (insertion order):");
        for (String key : iterateMap.keySet()) {
            System.out.println("  " + key);
        }
        
        // Values iteration (insertion order)
        System.out.println("Values (insertion order):");
        for (Integer value : iterateMap.values()) {
            System.out.println("  " + value);
        }
        
        // Entry set iteration (insertion order)
        System.out.println("Entries (insertion order):");
        for (Map.Entry<String, Integer> entry : iterateMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }
        
        // 6. REMOVE AND REPLACE OPERATIONS
        
        LinkedHashMap<String, String> modifyMap = new LinkedHashMap<>();
        modifyMap.put("A", "Alpha");
        modifyMap.put("B", "Beta");
        modifyMap.put("C", "Gamma");
        
        System.out.println("\n=== Remove and Replace Operations ===");
        System.out.println("Before modifications: " + modifyMap);
        
        // Remove operations
        String removed = modifyMap.remove("B");
        System.out.println("Removed B: " + removed);
        System.out.println("After removal: " + modifyMap);
        
        // Replace operations
        boolean replaced = modifyMap.replace("A", "Alpha", "Updated");
        System.out.println("Replaced A with old value check: " + replaced);
        System.out.println("After replace: " + modifyMap);
        
        // 7. PRACTICAL USE CASE: LRU CACHE IMPLEMENTATION
        
        System.out.println("\n=== LRU Cache Example ===");
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);  // Capacity 3
        
        lruCache.put("A", 1);
        lruCache.put("B", 2);
        lruCache.put("C", 3);
        System.out.println("Cache after A, B, C: " + lruCache);
        
        // Access B (moves to end)
        lruCache.get("B");
        System.out.println("After accessing B: " + lruCache);
        
        // Add D (evicts A, which is now least recently used)
        lruCache.put("D", 4);
        System.out.println("After adding D (A evicted): " + lruCache);
        
        // Add E (evicts C, which is now least recently used)
        lruCache.put("E", 5);
        System.out.println("After adding E (C evicted): " + lruCache);
        
        // 8. COMPUTE OPERATIONS (Java 8+)
        
        LinkedHashMap<String, Integer> computeMap = new LinkedHashMap<>();
        computeMap.put("count1", 10);
        computeMap.put("count2", 20);
        
        System.out.println("\n=== Compute Operations ===");
        System.out.println("Before compute: " + computeMap);
        
        // Compute - always computes new value
        computeMap.compute("count3", (key, oldValue) -> oldValue == null ? 5 : oldValue + 5);
        computeMap.compute("count1", (key, oldValue) -> oldValue + 10);
        System.out.println("After compute: " + computeMap);
        
        // ComputeIfAbsent - compute only if key doesn't exist
        computeMap.computeIfAbsent("count4", key -> 40);
        System.out.println("After computeIfAbsent: " + computeMap);
        
        // 9. BULK OPERATIONS
        
        LinkedHashMap<String, Integer> sourceMap = new LinkedHashMap<>();
        sourceMap.put("X", 100);
        sourceMap.put("Y", 200);
        
        LinkedHashMap<String, Integer> targetMap = new LinkedHashMap<>();
        targetMap.put("A", 1);
        targetMap.put("B", 2);
        
        targetMap.putAll(sourceMap);
        System.out.println("\nAfter putAll (maintains order): " + targetMap);
        
        // 10. CUSTOM ORDERING WITH REMOVE ELDEST ENTRY
        
        System.out.println("\n=== Custom Remove Eldest Entry ===");
        CustomLinkedHashMap<String, Integer> customCache = new CustomLinkedHashMap<>(3);
        
        customCache.put("Item1", 1);
        customCache.put("Item2", 2);
        customCache.put("Item3", 3);
        System.out.println("Custom cache: " + customCache);
        
        customCache.put("Item4", 4);  // Should trigger removal
        System.out.println("After adding Item4: " + customCache);
        
        customCache.put("Item5", 5);  // Should trigger removal
        System.out.println("After adding Item5: " + customCache);
    }
    
    // LRU Cache implementation using LinkedHashMap
    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;
        
        public LRUCache(int capacity) {
            // Access order enabled (third parameter = true)
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }
        
        // Override removeEldestEntry to implement LRU eviction
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }
    
    // Custom LinkedHashMap with size-based eviction
    static class CustomLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private final int maxSize;
        
        public CustomLinkedHashMap(int maxSize) {
            super(16, 0.75f, false);  // Insertion order
            this.maxSize = maxSize;
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > maxSize;
        }
    }
}

/*
 ============================================================================
                    LINKEDHASHMAP TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | get(key)                     | O(1) average   | O(1)            | Hash lookup + list traversal
 |                              | O(n) worst     |                 | All keys collide
 | put(key, value)              | O(1) average   | O(1)            | Hash insert + list update
 |                              | O(n) worst     |                 | Resize + all keys collide
 | remove(key)                  | O(1) average   | O(1)            | Hash remove + list update
 |                              | O(n) worst     |                 | All keys collide
 | putIfAbsent(key, value)      | O(1) average   | O(1)            | Conditional insert
 |                              | O(n) worst     |                 | Resize + all keys collide
 | replace(key, oldValue, newValue) | O(1) average | O(1)            | Conditional replace
 |                              | O(n) worst     |                 | All keys collide
 | replace(key, value)          | O(1) average   | O(1)            | Unconditional replace
 |                              | O(n) worst     |                 | All keys collide
 | containsKey(key)             | O(1) average   | O(1)            | Key existence check
 |                              | O(n) worst     |                 | All keys collide
 | containsValue(value)         | O(n)           | O(1)            | Value existence check
 | size()                       | O(1)           | O(1)            | Return size field
 | isEmpty()                    | O(1)           | O(1)            | Check size
 | clear()                      | O(1)           | O(1)            | Clear all entries
 | keySet()                     | O(1)           | O(1)            | Create key set view
 | values()                     | O(1)           | O(1)            | Create values view
 | entrySet()                   | O(1)           | O(1)            | Create entry set view
 | forEach(action)              | O(n)           | O(1)            | Iterate all entries
 | compute(key, function)       | O(1) average   | O(1)            | Compute new value
 |                              | O(n) worst     |                 | Resize + all keys collide
 | computeIfAbsent(key, function) | O(1) average | O(1)            | Compute if key absent
 |                              | O(n) worst     |                 | Resize + all keys collide
 | computeIfPresent(key, function) | O(1) average | O(1)            | Compute if key present
 |                              | O(n) worst     |                 | All keys collide

 ============================================================================
                    WHEN TO USE LINKEDHASHMAP
 ============================================================================
 
 ✓ When you need predictable iteration order
 ✓ LRU (Least Recently Used) cache implementations
 ✓ Access-order tracking for cache eviction
 ✓ Insertion-order preservation for display purposes
 ✓ When HashMap performance is needed with ordering guarantees
 ✓ Configuration maps where order matters
 ✓ History tracking applications
 ✓ FIFO/LIFO queue implementations with Map interface

 ============================================================================
                    WHEN TO AVOID LINKEDHASHMAP
 ============================================================================
 
 ✗ When order doesn't matter (use HashMap for better performance)
 ✗ Memory-constrained environments (higher overhead than HashMap)
 ✗ When you need sorted order (use TreeMap)
 ✗ Performance-critical applications where ordering isn't needed
 ✗ Simple key-value storage without iteration requirements
 ✗ When thread safety is required without synchronization

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Internal Structure:
 - Combines hash table with doubly-linked list
 - Each entry maintains links to previous and next entries
 - Separate structures for hashing and ordering
 - Doubly-linked list maintains insertion or access order
 - Hash table provides O(1) lookups

 Ordering:
 - Insertion order by default (accessOrder = false)
 - Access order when accessOrder = true
 - Iteration follows the linked list order
 - Maintains order through put, get, and remove operations
 - Order is preserved during resizing

 Memory:
 - Higher memory overhead than HashMap
 - Additional pointers for doubly-linked list
 - Each entry stores prev and next references
 - Memory usage proportional to number of entries

 ============================================================================
                    COMPARISON WITH OTHER MAP IMPLEMENTATIONS
 ============================================================================
 
 | Feature              | LinkedHashMap | HashMap    | TreeMap    | IdentityHashMap
 |----------------------|---------------|------------|------------|----------------
 | Time Complexity      | O(1) avg      | O(1) avg   | O(log n)   | O(1) avg
 | Ordering             | Insertion/Access | No      | Sorted     | No
 | Memory Overhead      | High          | Medium     | High       | Medium
 | Null Keys/Values     | Yes           | Yes        | Keys: No*  | Yes
 | Use Case             | Ordered maps  | General    | Sorted     | Identity-based
 | * = Comparable keys required

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Internal implementation of LinkedHashMap
 2. Difference between insertion order and access order
 3. LRU cache implementation using LinkedHashMap
 4. removeEldestEntry() method and its use cases
 5. Performance comparison with HashMap and TreeMap
 6. Memory overhead of doubly-linked list structure
 7. Thread safety of LinkedHashMap operations
 8. Custom ordering implementations
 9. Iterator behavior and fail-fast guarantees
 10. Use cases for access-order vs insertion-order
 11. Cache eviction policies with LinkedHashMap
 12. Integration with Collections.synchronizedMap()

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Speed:
 - Same O(1) average time complexity as HashMap for basic operations
 - Slight overhead due to linked list maintenance
 - Access order requires updating list positions on get()
 - Insertion order has minimal overhead on get()
 - Resizing behavior identical to HashMap

 Memory:
 - Higher memory usage than HashMap due to linked list nodes
 - Each entry requires prev and next pointers
 - Memory overhead proportional to number of entries
 - No additional hash table overhead beyond HashMap

 Ordering Overhead:
 - Insertion order: Minimal overhead (list append only)
 - Access order: Moderate overhead (list repositioning on get)
 - removeEldestEntry(): Conditional overhead on put operations
 - Iterator performance: O(1) creation, O(n) traversal

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Use for LRU cache implementations with removeEldestEntry()
 2. Choose insertion order vs access order based on requirements
 3. Specify appropriate initial capacity to avoid resizing
 4. Override removeEldestEntry() for custom eviction policies
 5. Consider memory overhead for large datasets
 6. Use access order for cache-like behavior
 7. Use insertion order for display and processing order
 8. Profile performance impact of ordering maintenance
 9. Monitor memory usage due to linked list overhead
 10. Consider HashMap + separate ordering structure for complex scenarios
 11. Use appropriate load factor for performance tuning
 12. Document ordering requirements for maintenance

 ============================================================================
*/