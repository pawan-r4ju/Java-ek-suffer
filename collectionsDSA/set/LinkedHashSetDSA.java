package collectionsDSA.set;

import java.util.*;

public class LinkedHashSetDSA {
    public static void main(String[] args) {
        // 1. CREATION
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();  // Default capacity
        LinkedHashSet<Integer> linkedHashSet2 = new LinkedHashSet<>(32);  // Initial capacity 32
        LinkedHashSet<Integer> linkedHashSet3 = new LinkedHashSet<>(32, 0.5f);  // Capacity 32, load factor 0.5
        
        // 2. BASIC SET OPERATIONS WITH INSERTION ORDER
        
        // Add operations - O(1) average time
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Orange");
        linkedHashSet.add("Apple");  // Duplicate - won't be added
        linkedHashSet.add("Grape");
        linkedHashSet.add("Kiwi");
        
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);
        System.out.println("Size: " + linkedHashSet.size());  // 5, not 6
        
        // 3. CONTAINS OPERATIONS - O(1) average time
        
        boolean hasApple = linkedHashSet.contains("Apple");
        boolean hasMango = linkedHashSet.contains("Mango");
        System.out.println("Contains Apple: " + hasApple);
        System.out.println("Contains Mango: " + hasMango);
        
        // 4. REMOVE OPERATIONS - O(1) average time
        
        boolean removed = linkedHashSet.remove("Banana");
        boolean notRemoved = linkedHashSet.remove("Pineapple");  // Doesn't exist
        System.out.println("Removed Banana: " + removed);
        System.out.println("Tried to remove Pineapple: " + notRemoved);
        System.out.println("LinkedHashSet after removals: " + linkedHashSet);
        
        // 5. INSERTION ORDER PRESERVATION DEMONSTRATION
        
        System.out.println("\n=== Insertion Order Preservation ===");
        LinkedHashSet<String> orderSet = new LinkedHashSet<>();
        
        // Add elements in specific order
        orderSet.add("First");
        orderSet.add("Second");
        orderSet.add("Third");
        orderSet.add("Fourth");
        orderSet.add("Fifth");
        
        System.out.println("LinkedHashSet maintains insertion order: " + orderSet);
        
        // Even after removals, order is preserved for remaining elements
        orderSet.remove("Second");
        orderSet.remove("Fourth");
        System.out.println("After removals, order preserved: " + orderSet);
        
        // 6. COLLECTION OPERATIONS
        
        // Add all from another collection
        LinkedHashSet<String> sourceSet = new LinkedHashSet<>(Arrays.asList("Sixth", "Seventh", "First"));
        orderSet.addAll(sourceSet);
        System.out.println("After addAll (insertion order): " + orderSet);
        
        // Remove all elements present in another collection
        LinkedHashSet<String> toRemove = new LinkedHashSet<>(Arrays.asList("Third", "Fifth"));
        orderSet.removeAll(toRemove);
        System.out.println("After removeAll: " + orderSet);
        
        // Retain only elements present in another collection (intersection)
        LinkedHashSet<String> toRetain = new LinkedHashSet<>(Arrays.asList("First", "Eighth", "Ninth"));
        orderSet.retainAll(toRetain);
        System.out.println("After retainAll: " + orderSet);
        
        // 7. ITERATION (ORDERED)
        
        System.out.println("\n=== Ordered Iteration ===");
        LinkedHashSet<String> iterateSet = new LinkedHashSet<>();
        iterateSet.add("Delta");
        iterateSet.add("Alpha");
        iterateSet.add("Charlie");
        iterateSet.add("Beta");
        
        System.out.println("LinkedHashSet: " + iterateSet);
        
        // Enhanced for loop (insertion order)
        System.out.println("Enhanced for loop (insertion order):");
        for (String element : iterateSet) {
            System.out.println("  " + element);
        }
        
        // Iterator (insertion order)
        System.out.println("Iterator (insertion order):");
        Iterator<String> iterator = iterateSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }
        
        // forEach method (Java 8+) (insertion order)
        System.out.println("forEach method (insertion order):");
        iterateSet.forEach(element -> System.out.println("  " + element));
        
        // 8. COMPARISON WITH HASHSET ORDERING
        
        System.out.println("\n=== HashSet vs LinkedHashSet Ordering ===");
        
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedSet = new LinkedHashSet<>();
        
        String[] elements = {"E", "A", "C", "B", "D"};
        for (String element : elements) {
            hashSet.add(element);
            linkedSet.add(element);
        }
        
        System.out.println("HashSet (no order guarantee): " + hashSet);
        System.out.println("LinkedHashSet (insertion order): " + linkedSet);
        
        // 9. SIZE AND EMPTY CHECK OPERATIONS
        
        LinkedHashSet<Integer> sizeSet = new LinkedHashSet<>();
        System.out.println("\n=== Size and Empty Operations ===");
        System.out.println("Initial size: " + sizeSet.size());
        System.out.println("Is empty: " + sizeSet.isEmpty());
        
        sizeSet.add(1);
        sizeSet.add(2);
        sizeSet.add(3);
        System.out.println("After adding elements - Size: " + sizeSet.size());
        System.out.println("Is empty: " + sizeSet.isEmpty());
        
        sizeSet.clear();
        System.out.println("After clear - Size: " + sizeSet.size());
        System.out.println("Is empty: " + sizeSet.isEmpty());
        
        // 10. PRACTICAL USE CASE: LRU CACHE IMPLEMENTATION
        
        System.out.println("\n=== LRU Cache Example ===");
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);
        
        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");
        System.out.println("Cache after 1, 2, 3: " + lruCache.keySet());
        
        // Access element 1 (moves to end)
        lruCache.get(1);
        System.out.println("After accessing 1: " + lruCache.keySet());
        
        // Add element 4 (evicts 2, which is now least recently used)
        lruCache.put(4, "Four");
        System.out.println("After adding 4 (2 evicted): " + lruCache.keySet());
        
        // Add element 5 (evicts 3, which is now least recently used)
        lruCache.put(5, "Five");
        System.out.println("After adding 5 (3 evicted): " + lruCache.keySet());
        
        // 11. PRACTICAL USE CASE: FREQUENCY COUNTING WITH ORDER
        
        System.out.println("\n=== Frequency Counting with Order Preservation ===");
        String text = "the quick brown fox jumps over the lazy dog the dog was really lazy";
        String[] words = text.split(" ");
        
        LinkedHashSet<String> uniqueWords = new LinkedHashSet<>(Arrays.asList(words));
        System.out.println("Text: " + text);
        System.out.println("Unique words (order preserved): " + uniqueWords);
        
        // 12. PERFORMANCE COMPARISON
        
        System.out.println("\n=== Performance Characteristics ===");
        
        // Compare HashSet vs LinkedHashSet performance
        HashSet<Integer> hashSetPerf = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSetPerf = new LinkedHashSet<>();
        
        int iterations = 10000;
        
        // HashSet performance
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            hashSetPerf.add(i);
        }
        long hashSetAddTime = System.nanoTime() - startTime;
        
        // LinkedHashSet performance
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            linkedHashSetPerf.add(i);
        }
        long linkedHashSetAddTime = System.nanoTime() - startTime;
        
        System.out.println("HashSet add time for " + iterations + " elements: " + hashSetAddTime + " ns");
        System.out.println("LinkedHashSet add time for " + iterations + " elements: " + linkedHashSetAddTime + " ns");
        System.out.println("LinkedHashSet has slight overhead due to linked list maintenance");
        
        // Iteration performance
        startTime = System.nanoTime();
        for (Integer i : hashSetPerf) {
            // Just iterate
        }
        long hashSetIterateTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        for (Integer i : linkedHashSetPerf) {
            // Just iterate
        }
        long linkedHashSetIterateTime = System.nanoTime() - startTime;
        
        System.out.println("HashSet iteration time: " + hashSetIterateTime + " ns");
        System.out.println("LinkedHashSet iteration time: " + linkedHashSetIterateTime + " ns");
    }
    
    // Simple LRU Cache implementation using LinkedHashSet for order tracking
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
}

/*
 ============================================================================
                    LINKEDHASHSET TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | add(element)                 | O(1) average   | O(1)            | Hash insert + list update
 |                              | O(n) worst     |                 | Resize + all keys collide
 | remove(element)              | O(1) average   | O(1)            | Hash remove + list update
 |                              | O(n) worst     |                 | All keys collide
 | contains(element)            | O(1) average   | O(1)            | Hash lookup
 |                              | O(n) worst     |                 | All keys collide
 | size()                       | O(1)           | O(1)            | Return size field
 | isEmpty()                    | O(1)           | O(1)            | Check size
 | clear()                      | O(1)           | O(1)            | Clear all elements
 | iterator()                   | O(1)           | O(1)            | Create iterator
 | addAll(collection)           | O(m) average   | O(m)            | Add m elements
 |                              | O(m*n) worst   |                 | Resize + all keys collide
 | removeAll(collection)        | O(m) average   | O(1)            | Remove m elements
 |                              | O(m*n) worst   |                 | All keys collide
 | retainAll(collection)        | O(m) average   | O(1)            | Retain m elements
 |                              | O(m*n) worst   |                 | All keys collide
 | toArray()                    | O(n)           | O(n)            | Copy to array
 | forEach(action)              | O(n)           | O(1)            | Iterate all elements

 ============================================================================
                    WHEN TO USE LINKEDHASHSET
 ============================================================================
 
 ✓ When you need unique elements with insertion order preservation
 ✓ LRU (Least Recently Used) cache implementations
 ✓ When HashSet performance is needed with ordering guarantees
 ✓ Configuration sets where order matters
 ✓ History tracking applications
 ✓ When you need predictable iteration order
 ✓ Duplicate removal with order preservation
 ✓ FIFO queue implementations with uniqueness

 ============================================================================
                    WHEN TO AVOID LINKEDHASHSET
 ============================================================================
 
 ✗ When order doesn't matter (use HashSet for better performance)
 ✗ Memory-constrained environments (higher overhead than HashSet)
 ✗ When you need sorted order (use TreeSet)
 ✗ Performance-critical applications where ordering isn't needed
 ✗ Simple uniqueness checking without iteration requirements
 ✗ When thread safety is required without synchronization

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Internal Structure:
 - Combines hash table with doubly-linked list
 - Each element maintains links to previous and next elements
 - Separate structures for hashing and ordering
 - Doubly-linked list maintains insertion order
 - Hash table provides O(1) lookups

 Ordering:
 - Insertion order preserved
 - Iteration follows the linked list order
 - Maintains order through add and remove operations
 - Order is preserved during resizing

 Memory:
 - Higher memory overhead than HashSet
 - Additional pointers for doubly-linked list
 - Each element stores prev and next references
 - Memory usage proportional to number of elements

 ============================================================================
                    COMPARISON WITH OTHER SET IMPLEMENTATIONS
 ============================================================================
 
 | Feature              | LinkedHashSet | HashSet    | TreeSet    | EnumSet
 |----------------------|---------------|------------|------------|---------
 | Time Complexity      | O(1) avg      | O(1) avg   | O(log n)   | O(1)
 | Ordering             | Insertion     | No         | Sorted     | Enum order
 | Memory Overhead      | High          | Medium     | High       | Low
 | Null Elements        | Yes           | Yes        | No*        | No
 | Thread Safety        | No            | No         | No         | No
 | * = Comparable elements required

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Internal implementation of LinkedHashSet
 2. Difference between HashSet and LinkedHashSet
 3. Insertion order preservation mechanism
 4. Memory overhead of doubly-linked list structure
 5. Performance comparison with HashSet and TreeSet
 6. LRU cache implementation using LinkedHashSet
 7. Iterator behavior and fail-fast guarantees
 8. Use cases for order-preserving unique collections
 9. Thread safety of LinkedHashSet operations
 10. Custom ordering implementations
 11. Integration with Collections.synchronizedSet()
 12. Hash collision handling with ordering

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Speed:
 - Same O(1) average time complexity as HashSet for basic operations
 - Slight overhead due to linked list maintenance
 - Insertion order has minimal overhead
 - Resizing behavior identical to HashSet

 Memory:
 - Higher memory usage than HashSet due to linked list nodes
 - Each element requires prev and next pointers
 - Memory overhead proportional to number of elements
 - No additional hash table overhead beyond HashSet

 Ordering Overhead:
 - Insertion order: Minimal overhead (list append only)
 - Remove operations: Moderate overhead (list repositioning)
 - Iterator performance: O(1) creation, O(n) traversal
 - Order preservation during resizing

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Use for unique elements with order preservation requirements
 2. Choose appropriate initial capacity to avoid resizing
 3. Specify appropriate load factor for performance tuning
 4. Consider memory overhead for large datasets
 5. Use for LRU cache implementations
 6. Profile performance impact of ordering maintenance
 7. Monitor memory usage due to linked list overhead
 8. Use for duplicate removal with order preservation
 9. Consider HashSet + separate ordering structure for complex scenarios
 10. Document ordering requirements for maintenance
 11. Use appropriate initial capacity for performance
 12. Test with large datasets for memory implications

 ============================================================================
*/