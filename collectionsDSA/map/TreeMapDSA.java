package collectionsDSA.map;

import java.util.*;

public class TreeMapDSA {
    public static void main(String[] args) {
        // 1. CREATION
        TreeMap<String, Integer> treeMap = new TreeMap<>();  // Natural ordering
        TreeMap<Integer, String> reverseMap = new TreeMap<>(Collections.reverseOrder());  // Reverse ordering
        TreeMap<Person, String> customMap = new TreeMap<>();  // Custom ordering with Comparable
        
        // 2. BASIC MAP OPERATIONS WITH SORTED ORDER
        
        // Put operations - O(log n) time
        treeMap.put("Apple", 10);
        treeMap.put("Banana", 20);
        treeMap.put("Orange", 30);
        treeMap.put("Grape", 40);
        treeMap.put("Apple", 15);  // Updates existing key
        System.out.println("TreeMap (sorted by keys): " + treeMap);
        
        // Get operations - O(log n) time
        Integer appleCount = treeMap.get("Apple");
        Integer mangoCount = treeMap.get("Mango");  // Returns null
        System.out.println("Apple count: " + appleCount);
        System.out.println("Mango count: " + mangoCount);
        
        // 3. SORTED ORDER DEMONSTRATION
        
        System.out.println("\n=== Sorted Order Example ===");
        TreeMap<Integer, String> numberMap = new TreeMap<>();
        numberMap.put(5, "Five");
        numberMap.put(2, "Two");
        numberMap.put(8, "Eight");
        numberMap.put(1, "One");
        numberMap.put(3, "Three");
        
        System.out.println("TreeMap with numbers (sorted): " + numberMap);
        
        // 4. NAVIGATIONAL OPERATIONS (KEY FEATURES OF TREEMAP)
        
        System.out.println("\n=== Navigational Operations ===");
        
        // First and last entries
        Map.Entry<Integer, String> firstEntry = numberMap.firstEntry();
        Map.Entry<Integer, String> lastEntry = numberMap.lastEntry();
        System.out.println("First entry: " + firstEntry);
        System.out.println("Last entry: " + lastEntry);
        
        // First and last keys
        Integer firstKey = numberMap.firstKey();
        Integer lastKey = numberMap.lastKey();
        System.out.println("First key: " + firstKey);
        System.out.println("Last key: " + lastKey);
        
        // Lower, floor, ceiling, higher operations
        Integer lowerKey = numberMap.lowerKey(3);    // Greatest key < 3
        Integer floorKey = numberMap.floorKey(3);    // Greatest key <= 3
        Integer ceilingKey = numberMap.ceilingKey(3); // Smallest key >= 3
        Integer higherKey = numberMap.higherKey(3);   // Smallest key > 3
        
        System.out.println("Lower key of 3: " + lowerKey);
        System.out.println("Floor key of 3: " + floorKey);
        System.out.println("Ceiling key of 3: " + ceilingKey);
        System.out.println("Higher key of 3: " + higherKey);
        
        // Entry versions
        Map.Entry<Integer, String> lowerEntry = numberMap.lowerEntry(3);
        Map.Entry<Integer, String> floorEntry = numberMap.floorEntry(3);
        Map.Entry<Integer, String> ceilingEntry = numberMap.ceilingEntry(3);
        Map.Entry<Integer, String> higherEntry = numberMap.higherEntry(3);
        
        System.out.println("Lower entry of 3: " + lowerEntry);
        System.out.println("Floor entry of 3: " + floorEntry);
        System.out.println("Ceiling entry of 3: " + ceilingEntry);
        System.out.println("Higher entry of 3: " + higherEntry);
        
        // 5. SUBMAP OPERATIONS
        
        System.out.println("\n=== SubMap Operations ===");
        
        // SubMap - range view
        SortedMap<Integer, String> subMap = numberMap.subMap(2, 5);  // [2, 5)
        System.out.println("SubMap [2, 5): " + subMap);
        
        // HeadMap - keys less than specified key
        SortedMap<Integer, String> headMap = numberMap.headMap(5);  // < 5
        System.out.println("HeadMap < 5: " + headMap);
        
        // TailMap - keys greater than or equal to specified key
        SortedMap<Integer, String> tailMap = numberMap.tailMap(3);  // >= 3
        System.out.println("TailMap >= 3: " + tailMap);
        
        // Java 8+ versions with inclusive/exclusive bounds
        NavigableMap<Integer, String> subMapInclusive = numberMap.subMap(2, true, 5, true);
        System.out.println("SubMap [2, 5] inclusive: " + subMapInclusive);
        
        // 6. REMOVE OPERATIONS
        
        System.out.println("\n=== Remove Operations ===");
        TreeMap<Integer, String> removeMap = new TreeMap<>(numberMap);
        System.out.println("Before removals: " + removeMap);
        
        // Remove first and last entries
        Map.Entry<Integer, String> removedFirst = removeMap.pollFirstEntry();
        Map.Entry<Integer, String> removedLast = removeMap.pollLastEntry();
        System.out.println("Removed first entry: " + removedFirst);
        System.out.println("Removed last entry: " + removedLast);
        System.out.println("After removals: " + removeMap);
        
        // Regular remove
        String removedValue = removeMap.remove(3);
        System.out.println("Removed value for key 3: " + removedValue);
        System.out.println("After removing key 3: " + removeMap);
        
        // 7. REVERSE ORDER OPERATIONS
        
        System.out.println("\n=== Reverse Order Operations ===");
        NavigableMap<Integer, String> descendingMap = numberMap.descendingMap();
        System.out.println("Descending map: " + descendingMap);
        
        NavigableSet<Integer> descendingKeySet = numberMap.descendingKeySet();
        System.out.println("Descending key set: " + descendingKeySet);
        
        // 8. CUSTOM COMPARATOR EXAMPLE
        
        System.out.println("\n=== Custom Comparator Example ===");
        TreeMap<String, Integer> lengthMap = new TreeMap<>(
            (s1, s2) -> Integer.compare(s1.length(), s2.length())
        );
        
        lengthMap.put("A", 1);
        lengthMap.put("BB", 2);
        lengthMap.put("CCC", 3);
        lengthMap.put("DD", 4);
        lengthMap.put("E", 5);
        
        System.out.println("TreeMap sorted by string length: " + lengthMap);
        
        // 9. CUSTOM OBJECT WITH COMPARABLE
        
        System.out.println("\n=== Custom Object Example ===");
        customMap.put(new Person("Alice", 25), "Developer");
        customMap.put(new Person("Bob", 30), "Manager");
        customMap.put(new Person("Charlie", 22), "Designer");
        customMap.put(new Person("Alice", 25), "Updated");  // Duplicate based on equals
        
        System.out.println("TreeMap with Person objects: " + customMap);
        
        // 10. COLLECTION OPERATIONS
        
        TreeMap<String, Integer> collectionMap = new TreeMap<>();
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
        
        // 11. ITERATION (SORTED ORDER)
        
        System.out.println("\n=== Sorted Iteration ===");
        TreeMap<String, Integer> iterateMap = new TreeMap<>();
        iterateMap.put("Delta", 4);
        iterateMap.put("Alpha", 1);
        iterateMap.put("Charlie", 3);
        iterateMap.put("Beta", 2);
        
        System.out.println("TreeMap (sorted): " + iterateMap);
        
        // Key set iteration (sorted order)
        System.out.println("Keys (sorted order):");
        for (String key : iterateMap.keySet()) {
            System.out.println("  " + key);
        }
        
        // Values iteration (sorted by keys)
        System.out.println("Values (sorted by keys):");
        for (Integer value : iterateMap.values()) {
            System.out.println("  " + value);
        }
        
        // Entry set iteration (sorted order)
        System.out.println("Entries (sorted order):");
        for (Map.Entry<String, Integer> entry : iterateMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }
        
        // 12. PRACTICAL USE CASE: RANGE QUERIES
        
        System.out.println("\n=== Range Query Example ===");
        TreeMap<Integer, String> scoreMap = new TreeMap<>();
        scoreMap.put(60, "D");
        scoreMap.put(70, "C");
        scoreMap.put(80, "B");
        scoreMap.put(90, "A");
        scoreMap.put(100, "A+");
        
        System.out.println("Score mapping: " + scoreMap);
        
        // Find grade for score 85
        Map.Entry<Integer, String> gradeEntry = scoreMap.floorEntry(85);
        System.out.println("Grade for score 85: " + gradeEntry);
        
        // Find all scores in range [70, 90]
        SortedMap<Integer, String> rangeScores = scoreMap.subMap(70, 91);
        System.out.println("Scores in range [70, 90]: " + rangeScores);
        
        // 13. COMPUTE OPERATIONS (Java 8+)
        
        TreeMap<String, Integer> computeMap = new TreeMap<>();
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
    }
    
    // Person class implementing Comparable for natural ordering
    static class Person implements Comparable<Person> {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public int compareTo(Person other) {
            int nameCompare = this.name.compareTo(other.name);
            if (nameCompare != 0) {
                return nameCompare;
            }
            return Integer.compare(this.age, other.age);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return age == person.age && Objects.equals(name, person.name);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
        
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
}

/*
 ============================================================================
                    TREEMAP TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | get(key)                     | O(log n)       | O(1)            | Tree traversal
 | put(key, value)              | O(log n)       | O(1)            | Tree insertion + rebalancing
 | remove(key)                  | O(log n)       | O(1)            | Tree removal + rebalancing
 | putIfAbsent(key, value)      | O(log n)       | O(1)            | Conditional insert
 | replace(key, oldValue, newValue) | O(log n)    | O(1)            | Conditional replace
 | replace(key, value)          | O(log n)       | O(1)            | Unconditional replace
 | containsKey(key)             | O(log n)       | O(1)            | Tree search
 | containsValue(value)         | O(n)           | O(1)            | Linear search through values
 | size()                       | O(1)           | O(1)            | Return size field
 | isEmpty()                    | O(1)           | O(1)            | Check size
 | clear()                      | O(1)           | O(1)            | Clear all entries
 | firstKey()                   | O(log n)       | O(1)            | Leftmost node
 | lastKey()                    | O(log n)       | O(1)            | Rightmost node
 | lowerKey(key)                | O(log n)       | O(1)            | Predecessor search
 | higherKey(key)               | O(log n)       | O(1)            | Successor search
 | floorKey(key)                | O(log n)       | O(1)            | Floor search
 | ceilingKey(key)              | O(log n)       | O(1)            | Ceiling search
 | firstEntry()                 | O(log n)       | O(1)            | Leftmost entry
 | lastEntry()                  | O(log n)       | O(1)            | Rightmost entry
 | pollFirstEntry()             | O(log n)       | O(1)            | Remove leftmost entry
 | pollLastEntry()              | O(log n)       | O(1)            | Remove rightmost entry
 | subMap(from, to)             | O(1)           | O(1)            | Create submap view
 | headMap(toKey)               | O(1)           | O(1)            | Create headmap view
 | tailMap(fromKey)             | O(1)           | O(1)            | Create tailmap view
 | keySet()                     | O(1)           | O(1)            | Create key set view
 | values()                     | O(1)           | O(1)            | Create values view
 | entrySet()                   | O(1)           | O(1)            | Create entry set view
 | forEach(action)              | O(n)           | O(1)            | Iterate all entries

 ============================================================================
                    WHEN TO USE TREEMAP
 ============================================================================
 
 ✓ When you need sorted keys
 ✓ Range queries and submap operations
 ✓ Navigational operations (first, last, lower, higher)
 ✓ Ordered iteration is required
 ✓ When you need to find closest matches
 ✓ Priority queue-like behavior with map interface
 ✓ Database-like range searches
 ✓ When natural ordering or custom ordering is important

 ============================================================================
                    WHEN TO AVOID TREEMAP
 ============================================================================
 
 ✗ When order doesn't matter (use HashMap for better performance)
 ✗ Performance-critical applications where O(log n) is too slow
 ✗ Simple key-value storage without ordering requirements
 ✗ Memory-constrained environments (higher overhead than HashMap)
 ✗ When you only need insertion order (use LinkedHashMap)
 ✗ High-frequency insert/delete operations where performance matters

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Internal Structure:
 - Red-Black tree implementation (self-balancing binary search tree)
 - Guaranteed O(log n) time complexity for basic operations
 - Maintains sorted order automatically
 - No hash collisions since it's tree-based
 - Complex rebalancing operations during insertions/deletions

 Ordering:
 - Natural ordering by default (keys must implement Comparable)
 - Custom ordering with Comparator
 - Consistent ordering guaranteed
 - Iteration follows in-order traversal
 - Range operations supported efficiently

 Memory:
 - Higher memory overhead than HashMap due to tree nodes
 - Each node stores left, right, parent pointers
 - Color information for Red-Black tree balancing
 - Memory usage proportional to number of entries

 ============================================================================
                    COMPARISON WITH OTHER MAP IMPLEMENTATIONS
 ============================================================================
 
 | Feature              | TreeMap    | HashMap    | LinkedHashMap | ConcurrentHashMap
 |----------------------|------------|------------|---------------|------------------
 | Time Complexity      | O(log n)   | O(1) avg   | O(1) avg      | O(1) avg
 | Ordering             | Sorted     | No         | Insertion/Access | No
 | Memory Overhead      | High       | Medium     | High          | Medium-High
 | Null Keys            | Keys: No   | Yes        | Yes           | No
 | Thread Safety        | No         | No         | No            | Yes
 | Range Operations     | Yes        | No         | No            | No
 | Navigational Ops     | Yes        | No         | Limited       | No

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Internal implementation of TreeMap (Red-Black tree)
 2. Time complexity analysis of TreeMap operations
 3. Difference between TreeMap, HashMap, and LinkedHashMap
 4. Red-Black tree properties and balancing operations
 5. Range query implementation and performance
 6. Navigational operations (first, last, lower, higher)
 7. SubMap, HeadMap, TailMap operations
 8. Custom Comparator vs Comparable implementation
 9. Memory usage comparison with other Map implementations
 10. Iterator behavior and fail-fast guarantees
 11. Use cases for sorted maps in real applications
 12. Performance trade-offs in ordered collections

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Speed:
 - Consistent O(log n) time complexity for all operations
 - No best/worst case variations like HashMap
 - Slower than HashMap for basic operations
 - Faster than linear search for large datasets
 - Range operations are efficient

 Memory:
 - Higher memory usage than HashMap due to tree structure
 - Each node requires parent, left, right pointers
 - Additional color information for balancing
 - No array resizing overhead like HashMap

 Scalability:
 - Predictable performance regardless of data size
 - No hash collision issues
 - Self-balancing ensures consistent performance
 - Range operations scale well with data size

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Use when sorted order is explicitly required
 2. Implement Comparable properly for custom keys
 3. Provide appropriate Comparator for custom ordering
 4. Use navigational operations for efficient key searches
 5. Leverage subMap operations for range queries
 6. Consider memory overhead for large datasets
 7. Profile performance for high-frequency operations
 8. Use entrySet() for efficient iteration with keys and values
 9. Consider HashMap + sorting for batch operations
 10. Use pollFirstEntry()/pollLastEntry() for priority queue behavior
 11. Understand the difference between floor/ceiling and lower/higher
 12. Document ordering requirements for maintenance

 ============================================================================
*/