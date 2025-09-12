package collectionsDSA.map;

import java.util.*;

public class HashMapDSA {
    public static void main(String[] args) {
        // 1. CREATION
        HashMap<String, Integer> map = new HashMap<>();  // Default capacity 16, load factor 0.75
        HashMap<String, Integer> map2 = new HashMap<>(32);  // Initial capacity 32
        HashMap<String, Integer> map3 = new HashMap<>(32, 0.5f);  // Capacity 32, load factor 0.5
        
        // 2. BASIC MAP OPERATIONS
        
        // Put operations - O(1) average time
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);
        map.put("Apple", 15);  // Updates existing key
        System.out.println("Map after puts: " + map);
        
        // Get operations - O(1) average time
        Integer appleCount = map.get("Apple");
        Integer mangoCount = map.get("Mango");  // Returns null
        System.out.println("Apple count: " + appleCount);
        System.out.println("Mango count: " + mangoCount);
        
        // PutIfAbsent - O(1) average time
        Integer oldValue = map.putIfAbsent("Apple", 50);  // Won't replace since Apple exists
        System.out.println("Old value for Apple: " + oldValue);
        Integer newValue = map.putIfAbsent("Grape", 40);  // Will add since Grape doesn't exist
        System.out.println("New value for Grape: " + newValue);
        System.out.println("Map after putIfAbsent: " + map);
        
        // Remove operations - O(1) average time
        Integer removed = map.remove("Banana");
        boolean removed2 = map.remove("Orange", 30);  // Remove only if value matches
        System.out.println("Removed Banana: " + removed);
        System.out.println("Removed Orange with value 30: " + removed2);
        System.out.println("Map after removals: " + map);
        
        // Replace operations
        boolean replaced = map.replace("Apple", 15, 25);  // Replace only if current value is 15
        System.out.println("Replaced Apple: " + replaced);
        System.out.println("Map after replace: " + map);
        
        // 3. COLLECTION OPERATIONS
        
        // Contains operations
        boolean hasApple = map.containsKey("Apple");
        boolean hasValue25 = map.containsValue(25);
        System.out.println("Contains Apple key: " + hasApple);
        System.out.println("Contains value 25: " + hasValue25);
        
        // Size and empty check
        System.out.println("Map size: " + map.size());
        System.out.println("Is map empty: " + map.isEmpty());
        
        // 4. ITERATION
        
        HashMap<String, Integer> iterateMap = new HashMap<>();
        iterateMap.put("A", 1);
        iterateMap.put("B", 2);
        iterateMap.put("C", 3);
        iterateMap.put("D", 4);
        
        System.out.println("\n=== Iteration Methods ===");
        
        // Key set iteration
        System.out.println("Keys:");
        for (String key : iterateMap.keySet()) {
            System.out.println("  " + key);
        }
        
        // Values iteration
        System.out.println("Values:");
        for (Integer value : iterateMap.values()) {
            System.out.println("  " + value);
        }
        
        // Entry set iteration
        System.out.println("Entries:");
        for (Map.Entry<String, Integer> entry : iterateMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }
        
        // forEach method (Java 8+)
        System.out.println("Using forEach:");
        iterateMap.forEach((key, value) -> System.out.println("  " + key + " = " + value));
        
        // 5. COMPUTE OPERATIONS (Java 8+)
        
        HashMap<String, Integer> computeMap = new HashMap<>();
        computeMap.put("count1", 10);
        computeMap.put("count2", 20);
        
        System.out.println("\n=== Compute Operations ===");
        System.out.println("Before compute: " + computeMap);
        
        // Compute - always computes new value
        computeMap.compute("count3", (k, v) -> v == null ? 5 : v + 5);
        computeMap.compute("count1", (k, v) -> v + 10);
        System.out.println("After compute: " + computeMap);
        
        // ComputeIfAbsent - compute only if key doesn't exist
        computeMap.computeIfAbsent("count4", k -> 40);
        System.out.println("After computeIfAbsent: " + computeMap);
        
        // ComputeIfPresent - compute only if key exists
        computeMap.computeIfPresent("count2", (k, v) -> v * 2);
        System.out.println("After computeIfPresent: " + computeMap);
        
        // 6. MERGE OPERATIONS
        
        HashMap<String, String> mergeMap = new HashMap<>();
        mergeMap.put("name", "John");
        mergeMap.put("city", "New York");
        
        System.out.println("\n=== Merge Operations ===");
        System.out.println("Before merge: " + mergeMap);
        
        // Merge - combine values
        mergeMap.merge("name", " Doe", (oldVal, newVal) -> oldVal + newVal);
        mergeMap.merge("country", "USA", (oldVal, newVal) -> oldVal + newVal);
        System.out.println("After merge: " + mergeMap);
        
        // 7. GET OR DEFAULT
        
        HashMap<String, Integer> defaultMap = new HashMap<>();
        defaultMap.put("existing", 100);
        
        Integer existing = defaultMap.getOrDefault("existing", 0);
        Integer missing = defaultMap.getOrDefault("missing", 0);
        System.out.println("\nGet or default:");
        System.out.println("Existing key: " + existing);
        System.out.println("Missing key: " + missing);
        
        // 8. PUT ALL OPERATION
        
        HashMap<String, Integer> sourceMap = new HashMap<>();
        sourceMap.put("X", 100);
        sourceMap.put("Y", 200);
        
        HashMap<String, Integer> targetMap = new HashMap<>();
        targetMap.put("A", 1);
        targetMap.put("B", 2);
        
        targetMap.putAll(sourceMap);
        System.out.println("\nAfter putAll: " + targetMap);
        
        // 9. PRACTICAL USE CASE: WORD COUNT
        
        String text = "the quick brown fox jumps over the lazy dog the dog was really lazy";
        HashMap<String, Integer> wordCount = new HashMap<>();
        
        String[] words = text.split(" ");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("\n=== Word Count Example ===");
        System.out.println("Text: " + text);
        System.out.println("Word counts: " + wordCount);
        
        // 10. HASH COLLISION DEMONSTRATION
        
        System.out.println("\n=== Hash Collision Handling ===");
        HashMap<BadHashKey, String> collisionMap = new HashMap<>();
        
        // These keys will have the same hash code due to poor hash implementation
        BadHashKey key1 = new BadHashKey("key1");
        BadHashKey key2 = new BadHashKey("key2");
        BadHashKey key3 = new BadHashKey("key3");
        
        collisionMap.put(key1, "value1");
        collisionMap.put(key2, "value2");
        collisionMap.put(key3, "value3");
        
        System.out.println("Map with hash collisions: " + collisionMap);
        System.out.println("Size: " + collisionMap.size());
        
        // Even with same hash, different keys are stored separately
        System.out.println("Get key1: " + collisionMap.get(key1));
        System.out.println("Get key2: " + collisionMap.get(key2));
    }
    
    // Helper class to demonstrate hash collisions
    static class BadHashKey {
        private String value;
        
        public BadHashKey(String value) {
            this.value = value;
        }
        
        @Override
        public int hashCode() {
            // Poor hash function that returns same value for all instances
            return 42;  // Always returns same hash code
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            BadHashKey that = (BadHashKey) obj;
            return Objects.equals(value, that.value);
        }
        
        @Override
        public String toString() {
            return "BadHashKey{" + value + "}";
        }
    }
}

/*
 ============================================================================
                    HASHMAP TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | get(key)                     | O(1) average   | O(1)            | Hash lookup
 |                              | O(n) worst     |                 | All keys collide
 | put(key, value)              | O(1) average   | O(1)            | Hash insert
 |                              | O(n) worst     |                 | Resize + all keys collide
 | remove(key)                  | O(1) average   | O(1)            | Hash remove
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
 | merge(key, value, function)  | O(1) average   | O(1)            | Merge value
 |                              | O(n) worst     |                 | Resize + all keys collide

 ============================================================================
                    WHEN TO USE HASHMAP
 ============================================================================
 
 ✓ Fast key-value storage and retrieval
 ✓ When you need O(1) average time complexity for operations
 ✓ Unordered collections (order doesn't matter)
 ✓ When null keys and values are acceptable
 ✓ General-purpose map implementation
 ✓ Caching and memoization scenarios
 ✓ Configuration storage
 ✓ Counting and frequency analysis

 ============================================================================
                    WHEN TO AVOID HASHMAP
 ============================================================================
 
 ✗ When you need ordered iteration
 ✗ When you need sorted keys
 ✗ When thread safety is required without synchronization
 ✗ When you can't afford worst-case O(n) performance
 ✗ When memory overhead of hash table is unacceptable
 ✗ When you need predictable iteration order

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Internal Structure:
 - Hash table with array of buckets
 - Each bucket contains linked list or tree nodes
 - Resizing when load factor threshold exceeded
 - Separate chaining for collision resolution
 - Tree nodes used when chain length exceeds threshold (Java 8+)

 Performance:
 - O(1) average case for basic operations
 - O(n) worst case when all keys collide
 - Load factor controls resizing behavior
 - Default load factor of 0.75 provides good trade-off

 Memory:
 - Memory overhead for hash table structure
 - Array of buckets regardless of actual entries
 - Node objects for each entry
 - Resizing doubles capacity when needed

 ============================================================================
                    COMPARISON WITH OTHER MAP IMPLEMENTATIONS
 ============================================================================
 
 | Feature              | HashMap    | TreeMap    | LinkedHashMap | Hashtable
 |----------------------|------------|------------|---------------|----------
 | Time Complexity      | O(1) avg   | O(log n)   | O(1) avg      | O(1) avg
 | Ordering             | No         | Sorted     | Insertion     | No
 | Null Keys/Values     | Yes        | Keys: No*  | Yes           | No
 | Thread Safety        | No         | No         | No            | Yes
 | Memory Overhead      | Medium     | High       | High          | Medium
 | * = Comparable keys required

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Internal working of HashMap
 2. Hash collision handling mechanisms
 3. Load factor and resizing behavior
 4. Difference between HashMap and Hashtable
 5. Java 8 improvements in HashMap (tree nodes)
 6. equals() and hashCode() contract importance
 7. Fail-fast iterator behavior
 8. Memory usage and optimization
 9. Performance characteristics and trade-offs
 10. Custom object as key in HashMap
 11. ConcurrentModificationException scenarios
 12. HashMap vs ConcurrentHashMap

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Best Case:
 - All keys have unique hash codes
 - No collisions occur
 - O(1) for all operations
 - Optimal load factor maintained

 Average Case:
 - Some collisions handled by chaining
 - Load factor around 0.75
 - O(1) average time complexity
 - Good distribution of keys

 Worst Case:
 - All keys hash to same bucket
 - Degenerates to linked list performance
 - O(n) for all operations
 - Poor hash function or adversarial input

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Override equals() and hashCode() properly for custom keys
 2. Choose appropriate initial capacity to avoid resizing
 3. Understand load factor implications
 4. Handle null keys and values appropriately
 5. Use compute methods for atomic operations
 6. Consider LinkedHashMap for insertion order
 7. Use TreeMap for sorted keys
 8. Profile performance for hash-heavy operations
 9. Avoid modifying keys after insertion
 10. Use getOrDefault() for cleaner code
 11. Consider EnumMap for enum keys
 12. Monitor memory usage in large applications

 ============================================================================
*/