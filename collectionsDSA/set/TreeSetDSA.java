package collectionsDSA.set;

import java.util.*;

public class TreeSetDSA {
    public static void main(String[] args) {
        // 1. CREATION
        TreeSet<String> treeSet = new TreeSet<>();  // Natural ordering
        TreeSet<Integer> reverseSet = new TreeSet<>(Collections.reverseOrder());  // Reverse ordering
        TreeSet<Person> customSet = new TreeSet<>();  // Custom ordering with Comparable
        
        // 2. BASIC SET OPERATIONS WITH SORTED ORDER
        
        // Add operations - O(log n) time
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Orange");
        treeSet.add("Apple");  // Duplicate - won't be added
        treeSet.add("Grape");
        treeSet.add("Kiwi");
        
        System.out.println("TreeSet (sorted order): " + treeSet);
        System.out.println("Size: " + treeSet.size());  // 5, not 6
        
        // 3. CONTAINS OPERATIONS - O(log n) time
        
        boolean hasApple = treeSet.contains("Apple");
        boolean hasMango = treeSet.contains("Mango");
        System.out.println("Contains Apple: " + hasApple);
        System.out.println("Contains Mango: " + hasMango);
        
        // 4. REMOVE OPERATIONS - O(log n) time
        
        boolean removed = treeSet.remove("Banana");
        boolean notRemoved = treeSet.remove("Pineapple");  // Doesn't exist
        System.out.println("Removed Banana: " + removed);
        System.out.println("Tried to remove Pineapple: " + notRemoved);
        System.out.println("TreeSet after removals: " + treeSet);
        
        // 5. SORTED ORDER DEMONSTRATION
        
        System.out.println("\n=== Sorted Order Example ===");
        TreeSet<Integer> numberSet = new TreeSet<>();
        numberSet.add(5);
        numberSet.add(2);
        numberSet.add(8);
        numberSet.add(1);
        numberSet.add(3);
        
        System.out.println("TreeSet with numbers (sorted): " + numberSet);
        
        // 6. NAVIGATIONAL OPERATIONS (KEY FEATURES OF TREESET)
        
        System.out.println("\n=== Navigational Operations ===");
        
        // First and last elements
        Integer firstElement = numberSet.first();
        Integer lastElement = numberSet.last();
        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);
        
        // Lower, floor, ceiling, higher operations
        Integer lowerElement = numberSet.lower(3);    // Greatest element < 3
        Integer floorElement = numberSet.floor(3);    // Greatest element <= 3
        Integer ceilingElement = numberSet.ceiling(3); // Smallest element >= 3
        Integer higherElement = numberSet.higher(3);   // Smallest element > 3
        
        System.out.println("Lower element of 3: " + lowerElement);
        System.out.println("Floor element of 3: " + floorElement);
        System.out.println("Ceiling element of 3: " + ceilingElement);
        System.out.println("Higher element of 3: " + higherElement);
        
        // 7. SUBSET OPERATIONS
        
        System.out.println("\n=== Subset Operations ===");
        
        // SubSet - range view
        SortedSet<Integer> subSet = numberSet.subSet(2, 5);  // [2, 5)
        System.out.println("SubSet [2, 5): " + subSet);
        
        // HeadSet - elements less than specified element
        SortedSet<Integer> headSet = numberSet.headSet(5);  // < 5
        System.out.println("HeadSet < 5: " + headSet);
        
        // TailSet - elements greater than or equal to specified element
        SortedSet<Integer> tailSet = numberSet.tailSet(3);  // >= 3
        System.out.println("TailSet >= 3: " + tailSet);
        
        // Java 8+ versions with inclusive/exclusive bounds
        NavigableSet<Integer> subSetInclusive = numberSet.subSet(2, true, 5, true);
        System.out.println("SubSet [2, 5] inclusive: " + subSetInclusive);
        
        // 8. REMOVE OPERATIONS
        
        System.out.println("\n=== Remove Operations ===");
        TreeSet<Integer> removeSet = new TreeSet<>(numberSet);
        System.out.println("Before removals: " + removeSet);
        
        // Remove first and last elements
        Integer removedFirst = removeSet.pollFirst();
        Integer removedLast = removeSet.pollLast();
        System.out.println("Removed first element: " + removedFirst);
        System.out.println("Removed last element: " + removedLast);
        System.out.println("After removals: " + removeSet);
        
        // 9. REVERSE ORDER OPERATIONS
        
        System.out.println("\n=== Reverse Order Operations ===");
        NavigableSet<Integer> descendingSet = numberSet.descendingSet();
        System.out.println("Descending set: " + descendingSet);
        
        // Using descendingIterator
        System.out.println("Descending iteration:");
        Iterator<Integer> descendingIterator = numberSet.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println("  " + descendingIterator.next());
        }
        
        // 10. CUSTOM COMPARATOR EXAMPLE
        
        System.out.println("\n=== Custom Comparator Example ===");
        TreeSet<String> lengthSet = new TreeSet<>(
            (s1, s2) -> {
                int lengthCompare = Integer.compare(s1.length(), s2.length());
                if (lengthCompare != 0) {
                    return lengthCompare;
                }
                return s1.compareTo(s2);  // Lexicographic for same length
            }
        );
        
        lengthSet.add("A");
        lengthSet.add("BB");
        lengthSet.add("CCC");
        lengthSet.add("DD");
        lengthSet.add("E");
        lengthSet.add("BB");  // Duplicate
        
        System.out.println("TreeSet sorted by string length: " + lengthSet);
        
        // 11. CUSTOM OBJECT WITH COMPARABLE
        
        System.out.println("\n=== Custom Object Example ===");
        customSet.add(new Person("Alice", 25));
        customSet.add(new Person("Bob", 30));
        customSet.add(new Person("Charlie", 22));
        customSet.add(new Person("Alice", 25));  // Duplicate based on equals
        
        System.out.println("TreeSet with Person objects: " + customSet);
        
        // 12. ITERATION (SORTED ORDER)
        
        System.out.println("\n=== Sorted Iteration ===");
        TreeSet<String> iterateSet = new TreeSet<>();
        iterateSet.add("Delta");
        iterateSet.add("Alpha");
        iterateSet.add("Charlie");
        iterateSet.add("Beta");
        
        System.out.println("TreeSet (sorted): " + iterateSet);
        
        // Enhanced for loop (sorted order)
        System.out.println("Enhanced for loop (sorted order):");
        for (String element : iterateSet) {
            System.out.println("  " + element);
        }
        
        // Iterator (sorted order)
        System.out.println("Iterator (sorted order):");
        Iterator<String> iterator = iterateSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }
        
        // Descending iterator
        System.out.println("Descending iterator:");
        Iterator<String> descIterator = iterateSet.descendingIterator();
        while (descIterator.hasNext()) {
            System.out.println("  " + descIterator.next());
        }
        
        // 13. SET THEORETIC OPERATIONS
        
        System.out.println("\n=== Set Theoretic Operations ===");
        
        TreeSet<Integer> setA = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        TreeSet<Integer> setB = new TreeSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);
        
        // Union - elements in either set
        TreeSet<Integer> union = new TreeSet<>(setA);
        union.addAll(setB);
        System.out.println("Union (A ∪ B): " + union);
        
        // Intersection - elements in both sets
        TreeSet<Integer> intersection = new TreeSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Intersection (A ∩ B): " + intersection);
        
        // Difference - elements in A but not in B
        TreeSet<Integer> difference = new TreeSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Difference (A - B): " + difference);
        
        // 14. RANGE QUERIES
        
        System.out.println("\n=== Range Query Example ===");
        TreeSet<Integer> scoreSet = new TreeSet<>();
        scoreSet.addAll(Arrays.asList(60, 70, 80, 90, 100));
        
        System.out.println("Score set: " + scoreSet);
        
        // Find scores in range [70, 90]
        SortedSet<Integer> rangeScores = scoreSet.subSet(70, 91);
        System.out.println("Scores in range [70, 90]: " + rangeScores);
        
        // Find scores less than 85
        SortedSet<Integer> lessThan85 = scoreSet.headSet(85);
        System.out.println("Scores less than 85: " + lessThan85);
        
        // Find scores greater than or equal to 75
        SortedSet<Integer> greaterEqual75 = scoreSet.tailSet(75);
        System.out.println("Scores >= 75: " + greaterEqual75);
        
        // 15. PERFORMANCE DEMONSTRATION
        
        System.out.println("\n=== Performance Characteristics ===");
        TreeSet<Integer> perfSet = new TreeSet<>();
        
        // Add elements
        long startTime = System.nanoTime();
        for (int i = 1000; i >= 1; i--) {
            perfSet.add(i);
        }
        long addTime = System.nanoTime() - startTime;
        
        // Contains operations
        startTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            perfSet.contains(i);
        }
        long containsTime = System.nanoTime() - startTime;
        
        // Remove operations
        startTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            perfSet.remove(i);
        }
        long removeTime = System.nanoTime() - startTime;
        
        System.out.println("Time to add 1000 elements: " + addTime + " ns");
        System.out.println("Time to check 1000 elements: " + containsTime + " ns");
        System.out.println("Time to remove 1000 elements: " + removeTime + " ns");
        System.out.println("Consistent O(log n) performance regardless of data order");
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
                    TREESET TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | add(element)                 | O(log n)       | O(1)            | Tree insertion + rebalancing
 | remove(element)              | O(log n)       | O(1)            | Tree removal + rebalancing
 | contains(element)            | O(log n)       | O(1)            | Tree search
 | size()                       | O(1)           | O(1)            | Return size field
 | isEmpty()                    | O(1)           | O(1)            | Check size
 | clear()                      | O(1)           | O(1)            | Clear all elements
 | first()                      | O(log n)       | O(1)            | Leftmost node
 | last()                       | O(log n)       | O(1)            | Rightmost node
 | lower(element)               | O(log n)       | O(1)            | Predecessor search
 | higher(element)              | O(log n)       | O(1)            | Successor search
 | floor(element)               | O(log n)       | O(1)            | Floor search
 | ceiling(element)             | O(log n)       | O(1)            | Ceiling search
 | pollFirst()                  | O(log n)       | O(1)            | Remove leftmost element
 | pollLast()                   | O(log n)       | O(1)            | Remove rightmost element
 | subSet(from, to)             | O(1)           | O(1)            | Create subset view
 | headSet(toElement)           | O(1)           | O(1)            | Create headset view
 | tailSet(fromElement)         | O(1)           | O(1)            | Create tailset view
 | iterator()                   | O(1)           | O(1)            | Create iterator
 | descendingIterator()         | O(1)           | O(1)            | Create reverse iterator
 | addAll(collection)           | O(m log n)     | O(m)            | Add m elements
 | removeAll(collection)        | O(m log n)     | O(1)            | Remove m elements
 | retainAll(collection)        | O(m log n)     | O(1)            | Retain m elements
 | toArray()                    | O(n)           | O(n)            | Copy to array
 | forEach(action)              | O(n)           | O(1)            | Iterate all elements

 ============================================================================
                    WHEN TO USE TREESET
 ============================================================================
 
 ✓ When you need sorted unique elements
 ✓ Range queries and subset operations
 ✓ Navigational operations (first, last, lower, higher)
 ✓ Ordered iteration is required
 ✓ When you need to find closest matches
 ✓ Priority queue-like behavior with set interface
 ✓ When natural ordering or custom ordering is important
 ✓ Database-like range searches

 ============================================================================
                    WHEN TO AVOID TREESET
 ============================================================================
 
 ✗ When order doesn't matter (use HashSet for better performance)
 ✗ Performance-critical applications where O(log n) is too slow
 ✗ Simple uniqueness checking without ordering requirements
 ✗ Memory-constrained environments (higher overhead than HashSet)
 ✗ High-frequency insert/delete operations where performance matters
 ✗ When you only need insertion order (use LinkedHashSet)
 ✗ Applications where hash-based performance is sufficient

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
 - Natural ordering by default (elements must implement Comparable)
 - Custom ordering with Comparator
 - Consistent ordering guaranteed
 - Iteration follows in-order traversal
 - Range operations supported efficiently

 Memory:
 - Higher memory overhead than HashSet due to tree nodes
 - Each node stores left, right, parent pointers
 - Color information for Red-Black tree balancing
 - Memory usage proportional to number of elements

 ============================================================================
                    COMPARISON WITH OTHER SET IMPLEMENTATIONS
 ============================================================================
 
 | Feature              | TreeSet    | HashSet    | LinkedHashSet | EnumSet
 |----------------------|------------|------------|---------------|---------
 | Time Complexity      | O(log n)   | O(1) avg   | O(1) avg      | O(1)
 | Ordering             | Sorted     | No         | Insertion     | Enum order
 | Memory Overhead      | High       | Medium     | High          | Low
 | Null Elements        | No*        | Yes        | Yes           | No
 | Range Operations     | Yes        | No         | No            | No
 | Navigational Ops     | Yes        | No         | Limited       | No
 | * = Comparable elements required

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Internal implementation of TreeSet (Red-Black tree)
 2. Time complexity analysis of TreeSet operations
 3. Difference between TreeSet, HashSet, and LinkedHashSet
 4. Red-Black tree properties and balancing operations
 5. Range query implementation and performance
 6. Navigational operations (first, last, lower, higher)
 7. SubSet, HeadSet, TailSet operations
 8. Custom Comparator vs Comparable implementation
 9. Memory usage comparison with other Set implementations
 10. Iterator behavior and fail-fast guarantees
 11. Use cases for sorted sets in real applications
 12. Performance trade-offs in ordered collections

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Speed:
 - Consistent O(log n) time complexity for all operations
 - No best/worst case variations like HashSet
 - Slower than HashSet for basic operations
 - Faster than linear search for large datasets
 - Range operations are efficient

 Memory:
 - Higher memory usage than HashSet due to tree structure
 - Each node requires parent, left, right pointers
 - Additional color information for balancing
 - No array resizing overhead like HashSet

 Scalability:
 - Predictable performance regardless of data size
 - No hash collision issues
 - Self-balancing ensures consistent performance
 - Range operations scale well with data size

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Use when sorted order is explicitly required
 2. Implement Comparable properly for custom elements
 3. Provide appropriate Comparator for custom ordering
 4. Use navigational operations for efficient element searches
 5. Leverage subSet operations for range queries
 6. Consider memory overhead for large datasets
 7. Profile performance for high-frequency operations
 8. Use iterator() for sorted traversal, descendingIterator() for reverse
 9. Consider HashSet + sorting for batch operations
 10. Use pollFirst()/pollLast() for priority queue behavior
 11. Understand the difference between floor/ceiling and lower/higher
 12. Document ordering requirements for maintenance

 ============================================================================
*/