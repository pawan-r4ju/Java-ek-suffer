package collectionsDSA.special;

import java.util.*;

public class EnumSetDSA {
    public static void main(String[] args) {
        // 1. CREATION - Different ways to create EnumSet
        
        // Create empty EnumSet
        EnumSet<Day> emptySet = EnumSet.noneOf(Day.class);
        System.out.println("Empty EnumSet: " + emptySet);
        
        // Create EnumSet with all elements
        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All days: " + allDays);
        
        // Create EnumSet with specific elements
        EnumSet<Day> weekdays = EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, 
                                          Day.THURSDAY, Day.FRIDAY);
        System.out.println("Weekdays: " + weekdays);
        
        // Create EnumSet with a range
        EnumSet<Day> weekend = EnumSet.range(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend: " + weekend);
        
        // Create EnumSet from another collection
        EnumSet<Day> workDays = EnumSet.copyOf(Arrays.asList(Day.MONDAY, Day.TUESDAY));
        System.out.println("Work days: " + workDays);
        
        // 2. BASIC SET OPERATIONS
        
        // Add operations - O(1) time
        EnumSet<Day> days = EnumSet.noneOf(Day.class);
        days.add(Day.MONDAY);
        days.add(Day.WEDNESDAY);
        days.add(Day.FRIDAY);
        System.out.println("\nDays after adds: " + days);
        
        // Add all from another collection
        days.addAll(EnumSet.of(Day.TUESDAY, Day.THURSDAY));
        System.out.println("Days after addAll: " + days);
        
        // 3. CONTAINS OPERATIONS - O(1) time
        
        boolean hasMonday = days.contains(Day.MONDAY);
        boolean hasSunday = days.contains(Day.SUNDAY);
        System.out.println("Contains Monday: " + hasMonday);
        System.out.println("Contains Sunday: " + hasSunday);
        
        // 4. REMOVE OPERATIONS - O(1) time
        
        boolean removed = days.remove(Day.WEDNESDAY);
        boolean notRemoved = days.remove(Day.SUNDAY);  // Doesn't exist
        System.out.println("Removed Wednesday: " + removed);
        System.out.println("Tried to remove Sunday: " + notRemoved);
        System.out.println("Days after removals: " + days);
        
        // Remove all elements present in another collection
        days.removeAll(EnumSet.of(Day.TUESDAY, Day.THURSDAY));
        System.out.println("After removeAll: " + days);
        
        // Retain only elements present in another collection (intersection)
        days.retainAll(EnumSet.of(Day.MONDAY, Day.SATURDAY));
        System.out.println("After retainAll: " + days);
        
        // 5. ENUM ORDER PRESERVATION
        
        System.out.println("\n=== Enum Order Preservation ===");
        EnumSet<Day> orderedSet = EnumSet.allOf(Day.class);
        System.out.println("EnumSet maintains enum declaration order: " + orderedSet);
        
        // Iteration follows enum declaration order
        System.out.println("Iteration order:");
        for (Day day : orderedSet) {
            System.out.println("  " + day);
        }
        
        // 6. SET THEORETIC OPERATIONS
        
        System.out.println("\n=== Set Theoretic Operations ===");
        
        EnumSet<Day> weekdaysSet = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        EnumSet<Day> weekendSet = EnumSet.range(Day.SATURDAY, Day.SUNDAY);
        
        System.out.println("Weekdays: " + weekdaysSet);
        System.out.println("Weekend: " + weekendSet);
        
        // Union - elements in either set
        EnumSet<Day> allDaysUnion = EnumSet.copyOf(weekdaysSet);
        allDaysUnion.addAll(weekendSet);
        System.out.println("Union (Weekdays ∪ Weekend): " + allDaysUnion);
        
        // Intersection - elements in both sets
        EnumSet<Day> workWeekend = EnumSet.copyOf(weekdaysSet);
        workWeekend.retainAll(weekendSet);
        System.out.println("Intersection (Weekdays ∩ Weekend): " + workWeekend);
        
        // Difference - elements in first set but not in second
        EnumSet<Day> mondayOnly = EnumSet.of(Day.MONDAY, Day.TUESDAY);
        mondayOnly.removeAll(EnumSet.of(Day.TUESDAY));
        System.out.println("Difference: " + mondayOnly);
        
        // Complement - elements not in the set
        EnumSet<Day> notWeekend = EnumSet.complementOf(weekendSet);
        System.out.println("Complement of Weekend: " + notWeekend);
        
        // 7. ITERATION (ORDERED BY ENUM DECLARATION)
        
        System.out.println("\n=== Ordered Iteration ===");
        EnumSet<Priority> prioritySet = EnumSet.allOf(Priority.class);
        System.out.println("Priority EnumSet: " + prioritySet);
        
        // Enhanced for loop (enum order)
        System.out.println("Enhanced for loop:");
        for (Priority priority : prioritySet) {
            System.out.println("  " + priority);
        }
        
        // Iterator (enum order)
        System.out.println("Iterator:");
        Iterator<Priority> iterator = prioritySet.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }
        
        // forEach method (Java 8+) (enum order)
        System.out.println("forEach method:");
        prioritySet.forEach(priority -> System.out.println("  " + priority));
        
        // 8. SIZE AND EMPTY CHECK OPERATIONS
        
        EnumSet<Day> sizeSet = EnumSet.noneOf(Day.class);
        System.out.println("\n=== Size and Empty Operations ===");
        System.out.println("Initial size: " + sizeSet.size());
        System.out.println("Is empty: " + sizeSet.isEmpty());
        
        sizeSet.add(Day.MONDAY);
        sizeSet.add(Day.TUESDAY);
        System.out.println("After adding elements - Size: " + sizeSet.size());
        System.out.println("Is empty: " + sizeSet.isEmpty());
        
        sizeSet.clear();
        System.out.println("After clear - Size: " + sizeSet.size());
        System.out.println("Is empty: " + sizeSet.isEmpty());
        
        // 9. PRACTICAL USE CASE: STATE MACHINE
        
        System.out.println("\n=== State Machine Example ===");
        
        // Define valid states for a traffic light
        EnumSet<TrafficLightState> validStates = EnumSet.allOf(TrafficLightState.class);
        System.out.println("Valid traffic light states: " + validStates);
        
        // Current state
        TrafficLightState currentState = TrafficLightState.RED;
        System.out.println("Current state: " + currentState);
        
        // Check if state is valid
        boolean isValid = validStates.contains(currentState);
        System.out.println("Is current state valid: " + isValid);
        
        // 10. PRACTICAL USE CASE: PERMISSIONS SYSTEM
        
        System.out.println("\n=== Permissions System Example ===");
        
        // User permissions
        EnumSet<Permission> userPermissions = EnumSet.of(
            Permission.READ, 
            Permission.WRITE
        );
        System.out.println("User permissions: " + userPermissions);
        
        // Admin permissions
        EnumSet<Permission> adminPermissions = EnumSet.allOf(Permission.class);
        System.out.println("Admin permissions: " + adminPermissions);
        
        // Check specific permissions
        boolean canRead = userPermissions.contains(Permission.READ);
        boolean canDelete = userPermissions.contains(Permission.DELETE);
        System.out.println("User can read: " + canRead);
        System.out.println("User can delete: " + canDelete);
        
        // Add permission
        userPermissions.add(Permission.DELETE);
        System.out.println("After adding delete permission: " + userPermissions);
        
        // Check if user has all admin permissions
        boolean isAdmin = adminPermissions.containsAll(userPermissions);
        System.out.println("User has all admin permissions: " + isAdmin);
        
        // 11. PERFORMANCE DEMONSTRATION
        
        System.out.println("\n=== Performance Characteristics ===");
        
        // EnumSet is extremely fast due to bit vector implementation
        EnumSet<Day> perfSet = EnumSet.noneOf(Day.class);
        
        // Add elements
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            perfSet.add(Day.MONDAY);
            perfSet.add(Day.TUESDAY);
            perfSet.remove(Day.MONDAY);
        }
        long operationTime = System.nanoTime() - startTime;
        
        System.out.println("Time for 10000 operations: " + operationTime + " ns");
        System.out.println("EnumSet operations are extremely fast due to bit vector implementation");
        
        // 12. MEMORY EFFICIENCY
        
        System.out.println("\n=== Memory Efficiency ===");
        System.out.println("EnumSet uses bit vectors internally");
        System.out.println("Memory usage is proportional to number of enum constants, not elements");
        System.out.println("Very memory efficient compared to other Set implementations");
        
        // 13. COMPLEMENT OPERATIONS
        
        System.out.println("\n=== Complement Operations ===");
        EnumSet<Day> workDaysOnly = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        EnumSet<Day> nonWorkDays = EnumSet.complementOf(workDaysOnly);
        System.out.println("Work days: " + workDaysOnly);
        System.out.println("Non-work days: " + nonWorkDays);
    }
    
    // Enum for days
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    
    // Enum for priorities
    enum Priority {
        LOW, MEDIUM, HIGH, CRITICAL, URGENT
    }
    
    // Enum for traffic light states
    enum TrafficLightState {
        RED, YELLOW, GREEN
    }
    
    // Enum for permissions
    enum Permission {
        READ, WRITE, EXECUTE, DELETE
    }
}

/*
 ============================================================================
                    ENUMSET TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | add(element)                 | O(1)           | O(1)            | Set bit
 | remove(element)              | O(1)           | O(1)            | Clear bit
 | contains(element)            | O(1)           | O(1)            | Check bit
 | size()                       | O(1) or O(n)   | O(1)            | Count bits
 | isEmpty()                    | O(1)           | O(1)            | Check if empty
 | clear()                      | O(1)           | O(1)            | Clear all bits
 | iterator()                   | O(1)           | O(1)            | Create iterator
 | addAll(collection)           | O(m)           | O(m)            | Set m bits
 | removeAll(collection)        | O(m)           | O(1)            | Clear m bits
 | retainAll(collection)        | O(m)           | O(1)            | Retain m bits
 | containsAll(collection)      | O(m)           | O(1)            | Check m bits
 | toArray()                    | O(n)           | O(n)            | Copy to array
 | forEach(action)              | O(n)           | O(1)            | Iterate all elements
 | complementOf(set)            | O(1)           | O(1)            | Bitwise complement

 ============================================================================
                    WHEN TO USE ENUMSET
 ============================================================================
 
 ✓ When working exclusively with enum types
 ✓ Performance-critical applications with enum elements
 ✓ Memory-efficient set operations for enums
 ✓ When you need ordered iteration by enum declaration
 ✓ State machines with enum states
 ✓ Permission systems with enum permissions
 ✓ Configuration flags with enum options
 ✓ Any scenario where all elements are from a single enum type

 ============================================================================
                    WHEN TO AVOID ENUMSET
 ============================================================================
 
 ✗ When elements are not enum types
 ✗ When you need null elements (EnumSet doesn't allow null)
 ✗ Simple single-threaded applications with few elements
 ✗ When you don't need the performance benefits
 ✗ Applications where enum order doesn't matter
 ✗ When you need more flexible element types

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Internal Structure:
 - Uses bit vectors internally (one bit per enum constant)
 - Extremely memory efficient
 - No object overhead per element
 - Bit operations for all set operations
 - Memory usage proportional to enum size, not set size

 Performance:
 - O(1) time complexity for all basic operations
 - Fastest Set implementation for enum types
 - No hash computation or tree traversal overhead
 - Direct bit manipulation operations

 Memory Efficiency:
 - Extremely memory efficient
 - Single long or array of longs for storage
 - No per-element object overhead
 - Memory usage predictable based on enum size

 ============================================================================
                    COMPARISON WITH OTHER SET IMPLEMENTATIONS
 ============================================================================
 
 | Feature              | EnumSet    | HashSet    | TreeSet    | LinkedHashSet
 |----------------------|------------|------------|------------|---------------
 | Time Complexity      | O(1)       | O(1) avg   | O(log n)   | O(1) avg
 | Space Complexity     | O(enum)    | O(n)       | O(n)       | O(n)
 | Null Elements        | No         | Yes        | No*        | Yes
 | Ordering             | Enum order | No         | Sorted     | Insertion
 | Memory Efficiency    | Excellent  | Good       | Fair       | Fair
 | * = Comparable elements required

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Why EnumSet is more efficient than HashSet for enum elements
 2. Internal implementation of EnumSet (bit vectors)
 3. Memory usage comparison with other Set implementations
 4. Enum ordering preservation in EnumSet
 5. Thread safety of EnumSet operations
 6. Use cases for EnumSet in state machines
 7. Performance characteristics of EnumSet vs HashSet
 8. Bit vector usage in EnumSet implementation
 9. Null element restrictions in EnumSet
 10. EnumSet iteration order guarantees
 11. Bulk operations support in EnumSet
 12. EnumSet vs EnumMap for different use cases

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Speed:
 - Fastest Set implementation for enum keys
 - No hash computation required
 - Direct bit operations
 - No collision handling overhead
 - Consistent O(1) performance

 Memory:
 - Extremely memory efficient
 - Bit vector storage
 - No per-element overhead
 - Predictable memory usage based on enum size

 Scalability:
 - Performance independent of set size
 - Only depends on enum size
 - No resizing operations
 - No load factor considerations

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Always use EnumSet for enum elements
 2. Leverage enum ordering for predictable iteration
 3. Use complementOf() for inverse set operations
 4. Consider memory efficiency for large enum types
 5. Use bulk operations for multiple elements
 6. Avoid null elements (not supported)
 7. Use range() for consecutive enum elements
 8. Profile performance for enum-heavy applications
 9. Consider EnumMap for key-value mappings with enums
 10. Document enum-based set usage for maintenance

 ============================================================================
*/