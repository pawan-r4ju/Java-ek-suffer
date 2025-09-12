package collectionsDSA.map;

import java.util.*;

public class WeakHashMapDSA {
    public static void main(String[] args) {
        // 1. CREATION
        WeakHashMap<String, Integer> weakMap = new WeakHashMap<>();
        WeakHashMap<Object, String> objectMap = new WeakHashMap<>(32);  // Initial capacity
        
        // 2. BASIC MAP OPERATIONS - Keys are weakly referenced
        
        // Put operations - O(1) average time
        String key1 = new String("Key1");
        String key2 = new String("Key2");
        String key3 = "String Literal";  // String literals are in string pool
        
        weakMap.put(key1, 1);
        weakMap.put(key2, 2);
        weakMap.put(key3, 3);
        
        System.out.println("WeakHashMap initial: " + weakMap);
        System.out.println("Initial size: " + weakMap.size());
        
        // 3. WEAK REFERENCE BEHAVIOR DEMONSTRATION
        
        System.out.println("\n=== Weak Reference Behavior ===");
        
        // Remove strong references to key1 and key2
        key1 = null;
        key2 = null;
        
        // Suggest garbage collection
        System.gc();
        
        // Wait a bit for GC to potentially run
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Check what remains in the map
        System.out.println("After removing strong references and GC suggestion:");
        System.out.println("WeakHashMap: " + weakMap);
        System.out.println("Size after GC: " + weakMap.size());
        System.out.println("Note: String literal key3 may still exist due to string interning");
        
        // 4. STRONG VS WEAK REFERENCE COMPARISON
        
        System.out.println("\n=== Strong vs Weak Reference Comparison ===");
        
        // Regular HashMap - strong references
        HashMap<String, Integer> strongMap = new HashMap<>();
        String strongKey = new String("StrongKey");
        strongMap.put(strongKey, 100);
        
        // WeakHashMap - weak references
        WeakHashMap<String, Integer> weakRefMap = new WeakHashMap<>();
        String weakKey = new String("WeakKey");
        weakRefMap.put(weakKey, 200);
        
        System.out.println("Before removing references:");
        System.out.println("Strong HashMap: " + strongMap);
        System.out.println("Weak HashMap: " + weakRefMap);
        
        // Remove strong references
        strongKey = null;
        weakKey = null;
        
        // Force garbage collection
        System.gc();
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("After removing references and GC:");
        System.out.println("Strong HashMap: " + strongMap);  // Still contains entry
        System.out.println("Weak HashMap: " + weakRefMap);    // Entry likely removed
        
        // 5. PRACTICAL USE CASE: CACHE IMPLEMENTATION
        
        System.out.println("\n=== Cache Implementation Example ===");
        
        // Simulate a simple cache using WeakHashMap
        WeakHashMap<CacheKey, CachedData> cache = new WeakHashMap<>();
        
        // Create cache entries
        CacheKey key1Obj = new CacheKey("Document1");
        CacheKey key2Obj = new CacheKey("Document2");
        
        cache.put(key1Obj, new CachedData("Content of Document1"));
        cache.put(key2Obj, new CachedData("Content of Document2"));
        
        System.out.println("Cache initial state: " + cache.size() + " entries");
        
        // Remove strong references
        key1Obj = null;
        key2Obj = null;
        
        // Force GC to demonstrate automatic cleanup
        System.gc();
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Cache after removing references and GC: " + cache.size() + " entries");
        
        // 6. COLLECTION OPERATIONS
        
        WeakHashMap<String, Integer> collectionMap = new WeakHashMap<>();
        String a = new String("A");
        String b = new String("B");
        String c = new String("C");
        
        collectionMap.put(a, 1);
        collectionMap.put(b, 2);
        collectionMap.put(c, 3);
        
        // Contains operations
        boolean hasA = collectionMap.containsKey(a);
        boolean hasValue2 = collectionMap.containsValue(2);
        System.out.println("\nContains key A: " + hasA);
        System.out.println("Contains value 2: " + hasValue2);
        
        // Size and empty check
        System.out.println("Map size: " + collectionMap.size());
        System.out.println("Is map empty: " + collectionMap.isEmpty());
        
        // 7. ITERATION
        
        System.out.println("\n=== Iteration Example ===");
        WeakHashMap<String, Integer> iterateMap = new WeakHashMap<>();
        String x = new String("X");
        String y = new String("Y");
        String z = new String("Z");
        
        iterateMap.put(x, 10);
        iterateMap.put(y, 20);
        iterateMap.put(z, 30);
        
        System.out.println("WeakHashMap before iteration: " + iterateMap);
        
        // Entry set iteration
        System.out.println("Entries:");
        for (Map.Entry<String, Integer> entry : iterateMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }
        
        // 8. REMOVE AND REPLACE OPERATIONS
        
        WeakHashMap<Object, String> modifyMap = new WeakHashMap<>();
        Object obj1 = new Object();
        Object obj2 = new Object();
        
        modifyMap.put(obj1, "First");
        modifyMap.put(obj2, "Second");
        
        System.out.println("\n=== Remove and Replace Operations ===");
        System.out.println("Before modifications: " + modifyMap);
        
        // Remove operations
        String removed = modifyMap.remove(obj1);
        System.out.println("Removed obj1: " + removed);
        System.out.println("After removal: " + modifyMap);
        
        // Replace operations
        Object obj3 = new Object();
        modifyMap.put(obj3, "Third");
        boolean replaced = modifyMap.replace(obj3, "Third", "Updated");
        System.out.println("Replaced obj3: " + replaced);
        System.out.println("After replace: " + modifyMap);
        
        // 9. PRACTICAL USE CASE: LISTENER REGISTRATION
        
        System.out.println("\n=== Listener Registration Example ===");
        
        // WeakHashMap for automatic listener cleanup
        WeakHashMap<EventListener, String> listeners = new WeakHashMap<>();
        
        // Register listeners
        EventListener listener1 = new EventListener("Listener1");
        EventListener listener2 = new EventListener("Listener2");
        
        listeners.put(listener1, "Registered");
        listeners.put(listener2, "Registered");
        
        System.out.println("Listeners registered: " + listeners.size());
        
        // Remove strong reference to listener1
        listener1 = null;
        
        // Force GC
        System.gc();
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Listeners after GC: " + listeners.size());
        System.out.println("Note: Listener2 still exists because we hold a reference to it");
        
        // 10. COMPUTE OPERATIONS (Java 8+)
        
        WeakHashMap<String, Integer> computeMap = new WeakHashMap<>();
        String computeKey = new String("Count");
        computeMap.put(computeKey, 10);
        
        System.out.println("\n=== Compute Operations ===");
        System.out.println("Before compute: " + computeMap);
        
        // Compute - always computes new value
        computeMap.compute(computeKey, (key, oldValue) -> oldValue + 5);
        System.out.println("After compute: " + computeMap);
        
        // ComputeIfAbsent - compute only if key doesn't exist
        String newKey = new String("NewCount");
        computeMap.computeIfAbsent(newKey, key -> 40);
        System.out.println("After computeIfAbsent: " + computeMap);
        
        // 11. MEMORY LEAK PREVENTION DEMONSTRATION
        
        System.out.println("\n=== Memory Leak Prevention ===");
        
        // Demonstrate how WeakHashMap prevents memory leaks
        List<WeakHashMap<Object, String>> maps = new ArrayList<>();
        
        // Create many WeakHashMaps with temporary keys
        for (int i = 0; i < 1000; i++) {
            WeakHashMap<Object, String> tempMap = new WeakHashMap<>();
            Object tempKey = new Object();
            tempMap.put(tempKey, "Value" + i);
            maps.add(tempMap);
            
            // Remove reference to key - entry becomes eligible for GC
            tempKey = null;
        }
        
        System.out.println("Created 1000 WeakHashMaps with temporary keys");
        System.out.println("After removing references, entries can be garbage collected");
        System.out.println("This prevents memory leaks that could occur with strong references");
        
        // Force GC to clean up
        System.gc();
    }
    
    // Cache key class for cache example
    static class CacheKey {
        private String name;
        
        public CacheKey(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() {
            return "CacheKey{" + name + "}";
        }
    }
    
    // Cached data class for cache example
    static class CachedData {
        private String content;
        
        public CachedData(String content) {
            this.content = content;
        }
        
        @Override
        public String toString() {
            return "CachedData{" + content + "}";
        }
    }
    
    // Event listener class for listener example
    static class EventListener {
        private String name;
        
        public EventListener(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() {
            return "EventListener{" + name + "}";
        }
    }
}

/*
 ============================================================================
                    WEAKHASHMAP TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | get(key)                     | O(1) average   | O(1)            | Hash lookup with weak reference
 |                              | O(n) worst     |                 | All keys collide
 | put(key, value)              | O(1) average   | O(1)            | Hash insert with weak reference
 |                              | O(n) worst     |                 | Resize + all keys collide
 | remove(key)                  | O(1) average   | O(1)            | Hash remove with weak reference
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
 | size()                       | O(1) or O(n)   | O(1)            | Count entries (may trigger cleanup)
 | isEmpty()                    | O(1) or O(n)   | O(1)            | Check if empty (may trigger cleanup)
 | clear()                      | O(1)           | O(1)            | Clear all entries
 | keySet()                     | O(1)           | O(1)            | Create key set view
 | values()                     | O(1)           | O(1)            | Create values view
 | entrySet()                   | O(1)           | O(1)            | Create entry set view
 | forEach(action)              | O(n)           | O(1)            | Iterate all entries (may trigger cleanup)

 ============================================================================
                    WHEN TO USE WEAKHASHMAP
 ============================================================================
 
 ✓ Cache implementations with automatic cleanup
 ✓ Listener registration systems
 ✓ Memory-sensitive applications
 ✓ When you want to avoid memory leaks
 ✓ Temporary data storage
 ✓ Weak reference management
 ✓ When keys may become unreachable
 ✓ Automatic resource cleanup scenarios

 ============================================================================
                    WHEN TO AVOID WEAKHASHMAP
 ============================================================================
 
 ✗ When you need guaranteed persistence of entries
 ✗ Performance-critical applications (cleanup overhead)
 ✗ When strong references are required
 ✗ Simple key-value storage applications
 ✗ When you can't afford unpredictable cleanup timing
 ✗ Applications requiring deterministic behavior
 ✗ When keys are string literals or interned strings

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Weak References:
 - Keys are stored as weak references
 - Values are stored as strong references
 - Entries are automatically removed when keys become unreachable
 - No protection against value-based memory leaks
 - Cleanup happens during map operations or garbage collection

 Memory Management:
 - Prevents memory leaks by automatic cleanup
 - Entries removed during next map operation or GC
 - Cleanup timing is not guaranteed
 - May cause temporary inconsistency during cleanup

 Internal Structure:
 - Extends AbstractMap but doesn't use standard HashMap
 - Uses ReferenceQueue for tracking cleared references
 - Cleanup performed during map operations
 - Hash table structure similar to HashMap

 ============================================================================
                    COMPARISON WITH OTHER MAP IMPLEMENTATIONS
 ============================================================================
 
 | Feature              | WeakHashMap | HashMap    | LinkedHashMap | TreeMap
 |----------------------|-------------|------------|---------------|---------
 | Key References       | Weak        | Strong     | Strong        | Strong
 | Time Complexity      | O(1) avg    | O(1) avg   | O(1) avg      | O(log n)
 | Memory Management    | Automatic   | Manual     | Manual        | Manual
 | Cleanup              | Automatic   | None       | None          | None
 | Ordering             | No          | No         | Insertion/Access | Sorted
 | Use Case             | Cache,Listeners | General | Ordered maps  | Sorted maps

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Difference between WeakHashMap and HashMap
 2. Weak reference behavior and garbage collection
 3. How WeakHashMap prevents memory leaks
 4. ReferenceQueue usage in WeakHashMap
 5. Automatic cleanup mechanism
 6. String literal behavior in WeakHashMap
 7. Use cases for weak references
 8. Performance implications of cleanup operations
 9. Thread safety of WeakHashMap
 10. Comparison with SoftReference and PhantomReference
 11. Cache implementation using WeakHashMap
 12. Listener registration patterns

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Speed:
 - Same average O(1) performance as HashMap for basic operations
 - Additional overhead during cleanup operations
 - Cleanup may cause temporary performance impact
 - Size() and isEmpty() operations may trigger cleanup
 - Iteration performance depends on cleanup state

 Memory:
 - Prevents memory leaks by automatic entry removal
 - Lower memory footprint over time due to cleanup
 - May have temporary memory overhead during cleanup
 - No memory leaks from unreachable keys
 - Values still hold strong references

 Garbage Collection:
 - Cleanup triggered by GC of weakly-referenced keys
 - Cleanup also triggered by map operations
 - Timing of cleanup is not deterministic
 - May cause slight performance variations

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Use for cache implementations with automatic cleanup
 2. Avoid for critical data that must persist
 3. Understand that only keys are weakly referenced
 4. Be aware that string literals may not be cleaned up
 5. Don't rely on deterministic cleanup timing
 6. Use for listener and callback registration
 7. Monitor performance impact of cleanup operations
 8. Consider memory leak prevention benefits
 9. Test behavior with garbage collection
 10. Document weak reference behavior for maintenance
 11. Use appropriate initial capacity for performance
 12. Profile memory usage in long-running applications

 ============================================================================
*/