package collectionsDSA.set;

import java.util.*;

public class HashSetDSA {
    public static void main(String[] args) {
        // 1. CREATION
        HashSet<String> hashSet = new HashSet<>();  // Default capacity 16, load factor 0.75
        HashSet<Integer> hashSet2 = new HashSet<>(32);  // Initial capacity 32
        HashSet<Integer> hashSet3 = new HashSet<>(32, 0.5f);  // Capacity 32, load factor 0.5
        
        // 2. BASIC SET OPERATIONS
        
        // Add operations - O(1) average time
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Apple");  // Duplicate - won't be added
        System.out.println("HashSet after adds: " + hashSet);
        System.out.println("Size: " + hashSet.size());  // 3, not 4
        
        // 3. CONTAINS OPERATIONS - O(1) average time
        
        boolean hasApple = hashSet.contains("Apple");
        boolean hasMango = hashSet.contains("Mango");
        System.out.println("Contains Apple: " + hasApple);
        System.out.println("Contains Mango: " + hasMango);
        
        // 4. REMOVE OPERATIONS - O(1) average time
        
        boolean removed = hashSet.remove("Banana");
        boolean notRemoved = hashSet.remove("Grape");  // Doesn't exist
        System.out.println("Removed Banana: " + removed);
        System.out.println("Tried to remove Grape: " + notRemoved);
        System.out.println("HashSet after removals: " + hashSet);
        
        // 5. COLLECTION OPERATIONS
        
        // Add all from another collection
        HashSet<String> sourceSet = new HashSet<>(Arrays.asList("Grape", "Kiwi", "Apple"));
        hashSet.addAll(sourceSet);
        System.out.println("After addAll: " + hashSet);
        
        // Remove all elements present in another collection
        HashSet<String> toRemove = new HashSet<>(Arrays.asList("Kiwi", "Orange"));
        hashSet.removeAll(toRemove);
        System.out.println("After removeAll: " + hashSet);
        
        // Retain only elements present in another collection (intersection)
        HashSet<String> toRetain = new HashSet<>(Arrays.asList("Apple", "Mango", "Pineapple"));
        hashSet.retainAll(toRetain);
        System.out.println("After retainAll: " + hashSet);
        
        // 6. SET THEORETIC OPERATIONS
        
        System.out.println("\n=== Set Theoretic Operations ===");
        
        HashSet<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);
        
        // Union - elements in either set
        HashSet<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("Union (A ∪ B): " + union);
        
        // Intersection - elements in both sets
        HashSet<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Intersection (A ∩ B): " + intersection);
        
        // Difference - elements in A but not in B
        HashSet<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Difference (A - B): " + difference);
        
        // 7. ITERATION
        
        System.out.println("\n=== Iteration Methods ===");
        HashSet<String> iterateSet = new HashSet<>();
        iterateSet.add("First");
        iterateSet.add("Second");
        iterateSet.add("Third");
        iterateSet.add("Fourth");
        
        System.out.println("HashSet: " + iterateSet);
        
        // Enhanced for loop
        System.out.println("Enhanced for loop:");
        for (String element : iterateSet) {
            System.out.println("  " + element);
        }
        
        // Iterator
        System.out.println("Iterator:");
        Iterator<String> iterator = iterateSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }
        
        // forEach method (Java 8+)
        System.out.println("forEach method:");
        iterateSet.forEach(element -> System.out.println("  " + element));
        
        // 8. SIZE AND EMPTY CHECK OPERATIONS
        
        HashSet<Integer> sizeSet = new HashSet<>();
        System.out.println("\n=== Size and Empty Operations ===");
        System.out.println("Initial size: " + sizeSet.size());
        System.out.println("Is empty: " + sizeSet.isEmpty());
        
        sizeSet.add(1);
        sizeSet.add(2);
        System.out.println("After adding elements - Size: " + sizeSet.size());
        System.out.println("Is empty: " + sizeSet.isEmpty());
        
        sizeSet.clear();
        System.out.println("After clear - Size: " + sizeSet.size());
        System.out.println("Is empty: " + sizeSet.isEmpty());
        
        // 9. PRACTICAL USE CASE: DUPLICATE REMOVAL
        
        System.out.println("\n=== Duplicate Removal Example ===");
        List<String> withDuplicates = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Banana", "Grape");
        System.out.println("List with duplicates: " + withDuplicates);
        
        HashSet<String> uniqueElements = new HashSet<>(withDuplicates);
        List<String> withoutDuplicates = new ArrayList<>(uniqueElements);
        System.out.println("List without duplicates: " + withoutDuplicates);
        
        // 10. PRACTICAL USE CASE: FREQUENCY COUNTING
        
        System.out.println("\n=== Frequency Counting Example ===");
        String text = "the quick brown fox jumps over the lazy dog the dog was really lazy";
        String[] words = text.split(" ");
        
        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Text: " + text);
        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Number of unique words: " + uniqueWords.size());
        
        // 11. HASH COLLISION DEMONSTRATION
        
        System.out.println("\n=== Hash Collision Handling ===");
        HashSet<BadHashKey> collisionSet = new HashSet<>();
        
        // These keys will have the same hash code due to poor hash implementation
        BadHashKey key1 = new BadHashKey("key1");
        BadHashKey key2 = new BadHashKey("key2");
        BadHashKey key3 = new BadHashKey("key3");
        
        collisionSet.add(key1);
        collisionSet.add(key2);
        collisionSet.add(key3);
        
        System.out.println("Set with hash collisions: " + collisionSet);
        System.out.println("Size: " + collisionSet.size());
        
        // Even with same hash, different keys are stored separately
        System.out.println("Contains key1: " + collisionSet.contains(key1));
        System.out.println("Contains key2: " + collisionSet.contains(key2));
        
        // 12. PERFORMANCE DEMONSTRATION
        
        System.out.println("\n=== Performance Characteristics ===");
        HashSet<Integer> perfSet = new HashSet<>();
        
        // Add elements
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            perfSet.add(i);
        }
        long addTime = System.nanoTime() - startTime;
        
        // Contains operations
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            perfSet.contains(i);
        }
        long containsTime = System.nanoTime() - startTime;
        
        // Remove operations
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            perfSet.remove(i);
        }
        long removeTime = System.nanoTime() - startTime;
        
        System.out.println("Time to add 10000 elements: " + addTime + " ns");
        System.out.println("Time to check 10000 elements: " + containsTime + " ns");
        System.out.println("Time to remove 10000 elements: " + removeTime + " ns");
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
                    HASHSET TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | add(element)                 | O(1) average   | O(1)            | Hash insert
 |                              | O(n) worst     |                 | Resize + all keys collide
 | remove(element)              | O(1) average   | O(1)            | Hash remove
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
                    WHEN TO USE HASHSET
 ============================================================================
 
 ✓ When you need to store unique elements
 ✓ Fast membership testing (contains operation)
 ✓ Removing duplicates from collections
 ✓ Set theoretic operations (union, intersection, difference)
 ✓ When order doesn't matter
 ✓ When you need O(1) average time complexity for basic operations
 ✓ Cache implementations for quick lookups
 ✓ Tracking visited nodes in graph algorithms

 ============================================================================
                    WHEN TO AVOID HASHSET
 ============================================================================
 
 ✗ When you need ordered iteration
 ✗ When you need sorted elements
 ✗ When you need indexed access to elements
 ✗ When thread safety is required without synchronization
 ✗ When memory overhead of hash table is unacceptable
 ✗ When you can't afford worst-case O(n) performance
 ✗ When you need predictable iteration order

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Internal Structure:
 - Hash table implementation (similar to HashMap)
 - Each element is both key and value
 - No duplicate elements allowed
 - Uses equals() and hashCode() for element comparison
 - Resizing when load factor threshold exceeded

 Performance:
 - O(1) average case for basic operations
 - O(n) worst case when all elements collide
 - Load factor controls resizing behavior
 - Default load factor of 0.75 provides good trade-off

 Memory:
 - Memory overhead for hash table structure
 - Array of buckets regardless of actual elements
 - No value storage (elements are keys)
 - Resizing doubles capacity when needed

 ============================================================================
                    COMPARISON WITH OTHER SET IMPLEMENTATIONS
 ============================================================================
 
 | Feature              | HashSet    | TreeSet    | LinkedHashSet | EnumSet
 |----------------------|------------|------------|---------------|---------
 | Time Complexity      | O(1) avg   | O(log n)   | O(1) avg      | O(1)
 | Ordering             | No         | Sorted     | Insertion     | Enum order
 | Memory Overhead      | Medium     | High       | High          | Low
 | Null Elements        | Yes        | No*        | Yes           | No
 | Thread Safety        | No         | No         | No            | No
 | * = Comparable elements required

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Internal working of HashSet
 2. Hash collision handling mechanisms
 3. Load factor and resizing behavior
 4. Difference between HashSet and TreeSet
 5. equals() and hashCode() contract importance
 6. Fail-fast iterator behavior
 7. Memory usage and optimization
 8. Performance characteristics and trade-offs
 9. Custom object as element in HashSet
 10. ConcurrentModificationException scenarios
 11. Set theoretic operations implementation
 12. HashSet vs LinkedHashSet vs EnumSet

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Best Case:
 - All elements have unique hash codes
 - No collisions occur
 - O(1) for all operations
 - Optimal load factor maintained

 Average Case:
 - Some collisions handled by chaining
 - Load factor around 0.75
 - O(1) average time complexity
 - Good distribution of elements

 Worst Case:
 - All elements hash to same bucket
 - Degenerates to linked list performance
 - O(n) for all operations
 - Poor hash function or adversarial input

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Override equals() and hashCode() properly for custom elements
 2. Choose appropriate initial capacity to avoid resizing
 3. Understand load factor implications
 4. Handle null elements appropriately
 5. Use for duplicate removal and membership testing
 6. Consider LinkedHashSet for insertion order
 7. Use TreeSet for sorted elements
 8. Profile performance for hash-heavy operations
 9. Avoid modifying elements after insertion
 10. Consider EnumSet for enum elements
 11. Use appropriate initial capacity for large datasets
 12. Monitor memory usage in large applications

 ============================================================================
*/