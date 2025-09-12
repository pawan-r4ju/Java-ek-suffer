package collectionsDSA.map;

import java.util.*;

public class IdentityHashMapDSA {
    public static void main(String[] args) {
        // 1. CREATION
        IdentityHashMap<String, Integer> identityMap = new IdentityHashMap<>();
        IdentityHashMap<Object, String> objectMap = new IdentityHashMap<>(32);  // Initial capacity
        
        // 2. BASIC MAP OPERATIONS - Uses == instead of equals() for key comparison
        
        // Put operations - O(1) average time
        String key1 = new String("Hello");
        String key2 = new String("Hello");  // Different object, same content
        String key3 = "Hello";              // String literal
        
        identityMap.put(key1, 1);
        identityMap.put(key2, 2);
        identityMap.put(key3, 3);
        
        System.out.println("IdentityHashMap: " + identityMap);
        System.out.println("Size: " + identityMap.size());  // Will be 3, not 1!
        
        // Get operations - O(1) average time
        Integer value1 = identityMap.get(key1);  // Found
        Integer value2 = identityMap.get(key2);  // Found
        Integer value3 = identityMap.get("Hello");  // Not found (different object)
        
        System.out.println("Value for key1: " + value1);
        System.out.println("Value for key2: " + value2);
        System.out.println("Value for string literal 'Hello': " + value3);  // null!
        
        // 3. IDENTITY VS EQUALITY DEMONSTRATION
        
        System.out.println("\n=== Identity vs Equality ===");
        
        // Regular HashMap - uses equals()
        HashMap<String, Integer> regularMap = new HashMap<>();
        regularMap.put(key1, 10);
        regularMap.put(key2, 20);
        regularMap.put(key3, 30);
        
        System.out.println("Regular HashMap size: " + regularMap.size());  // 1
        System.out.println("Regular HashMap: " + regularMap);
        
        // IdentityHashMap - uses ==
        System.out.println("IdentityHashMap size: " + identityMap.size());  // 3
        System.out.println("IdentityHashMap: " + identityMap);
        
        // Check identity
        System.out.println("key1 == key2: " + (key1 == key2));  // false
        System.out.println("key1.equals(key2): " + key1.equals(key2));  // true
        System.out.println("key3 == \"Hello\": " + (key3 == "Hello"));  // true (string interning)
        
        // 4. COLLECTION OPERATIONS
        
        // Contains operations
        boolean hasKey1 = identityMap.containsKey(key1);
        boolean hasStringValue = identityMap.containsValue(1);
        System.out.println("Contains key1: " + hasKey1);
        System.out.println("Contains value 1: " + hasStringValue);
        
        // Size and empty check
        System.out.println("Map size: " + identityMap.size());
        System.out.println("Is map empty: " + identityMap.isEmpty());
        
        // 5. ITERATION
        
        IdentityHashMap<String, Integer> iterateMap = new IdentityHashMap<>();
        String a1 = new String("A");
        String a2 = new String("A");
        String b = new String("B");
        
        iterateMap.put(a1, 1);
        iterateMap.put(a2, 2);
        iterateMap.put(b, 3);
        
        System.out.println("\n=== Iteration Methods ===");
        System.out.println("IdentityHashMap: " + iterateMap);
        
        // Key set iteration
        System.out.println("Keys:");
        for (String key : iterateMap.keySet()) {
            System.out.println("  " + key + " (hash: " + System.identityHashCode(key) + ")");
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
        
        // 6. REMOVE AND REPLACE OPERATIONS
        
        IdentityHashMap<Object, String> modifyMap = new IdentityHashMap<>();
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = obj1;  // Same reference
        
        modifyMap.put(obj1, "First");
        modifyMap.put(obj2, "Second");
        modifyMap.put(obj3, "Third");  // Replaces obj1 entry
        
        System.out.println("\n=== Remove and Replace ===");
        System.out.println("Before modifications: " + modifyMap);
        System.out.println("Size: " + modifyMap.size());  // 2, not 3!
        
        // Remove operations
        String removed = modifyMap.remove(obj2);
        System.out.println("Removed obj2: " + removed);
        System.out.println("After removal: " + modifyMap);
        
        // Replace operations
        boolean replaced = modifyMap.replace(obj1, "Third", "Updated");
        System.out.println("Replaced with old value check: " + replaced);
        
        boolean replaced2 = modifyMap.replace(obj1, "Updated", "Final");
        System.out.println("Replaced again: " + replaced2);
        System.out.println("After replace: " + modifyMap);
        
        // 7. PRACTICAL USE CASE: GRAPH ALGORITHMS
        
        System.out.println("\n=== Graph Algorithm Example ===");
        
        // Node class for graph
        class GraphNode {
            String name;
            List<GraphNode> neighbors;
            
            GraphNode(String name) {
                this.name = name;
                this.neighbors = new ArrayList<>();
            }
            
            @Override
            public String toString() {
                return name;
            }
        }
        
        // Create graph nodes
        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        GraphNode nodeC = new GraphNode("C");
        
        // Add edges
        nodeA.neighbors.add(nodeB);
        nodeB.neighbors.add(nodeC);
        nodeC.neighbors.add(nodeA);
        
        // Use IdentityHashMap to track visited nodes during traversal
        IdentityHashMap<GraphNode, Boolean> visited = new IdentityHashMap<>();
        visited.put(nodeA, true);
        visited.put(nodeB, true);
        
        System.out.println("Visited nodes: " + visited);
        System.out.println("Contains nodeA: " + visited.containsKey(nodeA));
        System.out.println("Contains new GraphNode(\"A\"): " + 
                         visited.containsKey(new GraphNode("A")));  // false!
        
        // 8. PRACTICAL USE CASE: OBJECT COPYING/CLONING TRACKING
        
        System.out.println("\n=== Object Copying Tracking ===");
        
        IdentityHashMap<Object, Object> copyTracking = new IdentityHashMap<>();
        List<String> originalList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> copiedList = new ArrayList<>(originalList);
        
        // Track original vs copied objects
        copyTracking.put(originalList, "Original");
        copyTracking.put(copiedList, "Copy");
        
        System.out.println("Copy tracking map: " + copyTracking);
        System.out.println("Original list == Copied list: " + (originalList == copiedList));  // false
        System.out.println("Original list.equals(Copied list): " + originalList.equals(copiedList));  // true
        
        // 9. COMPUTE OPERATIONS (Java 8+)
        
        IdentityHashMap<String, Integer> computeMap = new IdentityHashMap<>();
        String computeKey = new String("Count");
        computeMap.put(computeKey, 10);
        
        System.out.println("\n=== Compute Operations ===");
        System.out.println("Before compute: " + computeMap);
        
        // Compute - always computes new value
        computeMap.compute(computeKey, (key, oldValue) -> oldValue + 5);
        System.out.println("After compute: " + computeMap);
        
        // ComputeIfAbsent - compute only if key doesn't exist
        String newKey = new String("Count");  // Different object!
        computeMap.computeIfAbsent(newKey, key -> 40);
        System.out.println("After computeIfAbsent: " + computeMap);  // Size becomes 2!
        
        // 10. PERFORMANCE COMPARISON DEMONSTRATION
        
        System.out.println("\n=== Performance Characteristics ===");
        
        // Identity check is faster than equals() check
        String[] testKeys = new String[1000];
        for (int i = 0; i < testKeys.length; i++) {
            testKeys[i] = new String("Key" + i);  // Different objects
        }
        
        IdentityHashMap<String, Integer> identityPerfMap = new IdentityHashMap<>();
        HashMap<String, Integer> regularPerfMap = new HashMap<>();
        
        // Populate both maps
        for (int i = 0; i < testKeys.length; i++) {
            identityPerfMap.put(testKeys[i], i);
            regularPerfMap.put(testKeys[i], i);
        }
        
        // Lookup performance (identity check vs equals check)
        long startTime = System.nanoTime();
        for (String key : testKeys) {
            identityPerfMap.get(key);  // Identity check
        }
        long identityTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        for (String key : testKeys) {
            regularPerfMap.get(key);  // Equals check
        }
        long equalsTime = System.nanoTime() - startTime;
        
        System.out.println("IdentityHashMap lookup time: " + identityTime + " ns");
        System.out.println("HashMap lookup time: " + equalsTime + " ns");
        System.out.println("Identity check is typically faster than equals() check");
    }
}

/*
 ============================================================================
                    IDENTITYHASHMAP TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | get(key)                     | O(1) average   | O(1)            | Identity lookup
 |                              | O(n) worst     |                 | All keys collide
 | put(key, value)              | O(1) average   | O(1)            | Identity insert
 |                              | O(n) worst     |                 | Resize + all keys collide
 | remove(key)                  | O(1) average   | O(1)            | Identity remove
 |                              | O(n) worst     |                 | All keys collide
 | putIfAbsent(key, value)      | O(1) average   | O(1)            | Conditional insert
 |                              | O(n) worst     |                 | Resize + all keys collide
 | replace(key, oldValue, newValue) | O(1) average | O(1)            | Conditional replace
 |                              | O(n) worst     |                 | All keys collide
 | replace(key, value)          | O(1) average   | O(1)            | Unconditional replace
 |                              | O(n) worst     |                 | All keys collide
 | containsKey(key)             | O(1) average   | O(1)            | Identity existence check
 |                              | O(n) worst     |                 | All keys collide
 | containsValue(value)         | O(n)           | O(1)            | Value existence check
 | size()                       | O(1)           | O(1)            | Return size field
 | isEmpty()                    | O(1)           | O(1)            | Check size
 | clear()                      | O(1)           | O(1)            | Clear all entries
 | keySet()                     | O(1)           | O(1)            | Create key set view
 | values()                     | O(1)           | O(1)            | Create values view
 | entrySet()                   | O(1)           | O(1)            | Create entry set view
 | forEach(action)              | O(n)           | O(1)            | Iterate all entries

 ============================================================================
                    WHEN TO USE IDENTITYHASHMAP
 ============================================================================
 
 ✓ When object identity (==) matters more than object equality (.equals())
 ✓ Graph algorithms where node identity is crucial
 ✓ Object copying/cloning tracking
 ✓ Weak reference management
 ✓ Debugging and profiling tools
 ✓ Serialization frameworks
 ✓ When you want to avoid custom equals() behavior
 ✓ Performance-critical applications where == is faster than equals()

 ============================================================================
                    WHEN TO AVOID IDENTITYHASHMAP
 ============================================================================
 
 ✗ When you need logical equality comparison
 ✗ Most general-purpose mapping scenarios
 ✗ When working with String literals primarily
 ✗ When you expect content-based equality
 ✗ Simple key-value storage applications
 ✗ When interoperability with standard Map implementations is needed

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Identity-Based Comparison:
 - Uses == operator for key comparison instead of equals()
 - Keys are considered equal only if they are the same object reference
 - Different objects with same content are treated as different keys
 - String interning can cause unexpected behavior

 Internal Structure:
 - Hash table similar to HashMap
 - Uses System.identityHashCode() instead of hashCode()
 - No collision resolution through equals() comparison
 - Performance characteristics similar to HashMap

 Memory Behavior:
 - Objects are not considered equal even if content is identical
 - String literals may be interned and behave unexpectedly
 - Reference-based storage prevents automatic deduplication

 ============================================================================
                    COMPARISON WITH OTHER MAP IMPLEMENTATIONS
 ============================================================================
 
 | Feature              | IdentityHashMap | HashMap    | TreeMap    | EnumMap
 |----------------------|-----------------|------------|------------|---------
 | Key Comparison       | == (identity)   | equals()   | compareTo()| ordinal
 | Time Complexity      | O(1) average    | O(1) avg   | O(log n)   | O(1)
 | Null Keys/Values     | Yes             | Yes        | Keys: No*  | Keys: No
 | Ordering             | No              | No         | Sorted     | Enum order
 | Memory Overhead      | Medium          | Medium     | High       | Low
 | Use Case             | Identity-based  | General    | Sorted     | Enum keys
 | * = Comparable keys required

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Difference between IdentityHashMap and HashMap
 2. When to use == vs equals() for object comparison
 3. IdentityHashMap internal implementation
 4. System.identityHashCode() vs hashCode()
 5. String interning effects on IdentityHashMap
 6. Graph algorithms using IdentityHashMap
 7. Object copying tracking with IdentityHashMap
 8. Performance comparison: == vs equals()
 9. Memory implications of identity-based storage
 10. Use cases for reference-based mapping
 11. IdentityHashMap vs WeakHashMap
 12. Thread safety of IdentityHashMap operations

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Speed:
 - Identity comparison (==) is faster than equals() comparison
 - System.identityHashCode() may be faster than custom hashCode()
 - No equals() method calls for collision resolution
 - Consistent performance characteristics

 Memory:
 - Similar memory overhead to HashMap
 - No additional overhead for equals() method calls
 - Reference-based storage may use more memory for duplicate content
 - No automatic deduplication of logically equal objects

 Scalability:
 - Same scalability as HashMap
 - Performance depends on hash distribution
 - Identity-based hashing may have different collision patterns
 - Resizing behavior identical to HashMap

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Use only when identity comparison is explicitly required
 2. Be aware of String interning behavior
 3. Understand the difference between == and equals()
 4. Consider memory implications of duplicate content
 5. Use for graph algorithms and object tracking
 6. Avoid for general-purpose key-value storage
 7. Profile performance for identity vs equality comparisons
 8. Document the use of identity-based comparison
 9. Test with String literals and new String objects
 10. Consider WeakHashMap for reference-based weak mappings
 11. Use appropriate initial capacity for performance
 12. Monitor memory usage in object-heavy applications

 ============================================================================
*/