package collectionsDSA.map;

import java.util.*;

public class EnumMapDSA {
    public static void main(String[] args) {
        // 1. CREATION
        EnumMap<Day, String> dayMap = new EnumMap<>(Day.class);
        EnumMap<Priority, Integer> priorityMap = new EnumMap<>(Priority.class);
        
        // 2. BASIC MAP OPERATIONS
        
        // Put operations - O(1) time
        dayMap.put(Day.MONDAY, "Start of work week");
        dayMap.put(Day.FRIDAY, "End of work week");
        dayMap.put(Day.SUNDAY, "Weekend");
        dayMap.put(Day.SATURDAY, "Weekend");
        System.out.println("Day map: " + dayMap);
        
        // Get operations - O(1) time
        String mondayDescription = dayMap.get(Day.MONDAY);
        System.out.println("Monday description: " + mondayDescription);
        
        // PutIfAbsent - O(1) time
        String oldValue = dayMap.putIfAbsent(Day.TUESDAY, "Second work day");
        System.out.println("Old value for Tuesday: " + oldValue);
        
        String existingValue = dayMap.putIfAbsent(Day.MONDAY, "New Monday");  // Won't replace
        System.out.println("Existing value for Monday: " + existingValue);
        System.out.println("Map after putIfAbsent: " + dayMap);
        
        // Remove operations - O(1) time
        String removed = dayMap.remove(Day.FRIDAY);
        System.out.println("Removed Friday: " + removed);
        System.out.println("Map after removal: " + dayMap);
        
        // Replace operations
        boolean replaced = dayMap.replace(Day.SUNDAY, "Weekend", "Relaxing day");
        System.out.println("Replaced Sunday: " + replaced);
        System.out.println("Map after replace: " + dayMap);
        
        // 3. ENUM ORDER PRESERVATION
        
        System.out.println("\n=== Enum Order Preservation ===");
        System.out.println("EnumMap maintains enum declaration order:");
        for (Map.Entry<Day, String> entry : dayMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }
        
        // 4. COLLECTION OPERATIONS
        
        priorityMap.put(Priority.LOW, 1);
        priorityMap.put(Priority.MEDIUM, 5);
        priorityMap.put(Priority.HIGH, 10);
        priorityMap.put(Priority.CRITICAL, 20);
        
        System.out.println("\nPriority map: " + priorityMap);
        
        // Contains operations
        boolean hasHigh = priorityMap.containsKey(Priority.HIGH);
        boolean hasValue10 = priorityMap.containsValue(10);
        System.out.println("Contains HIGH priority: " + hasHigh);
        System.out.println("Contains value 10: " + hasValue10);
        
        // Size and empty check
        System.out.println("Priority map size: " + priorityMap.size());
        System.out.println("Is priority map empty: " + priorityMap.isEmpty());
        
        // 5. ITERATION (ORDERED BY ENUM DECLARATION)
        
        System.out.println("\n=== Ordered Iteration ===");
        System.out.println("Keys (enum order): " + priorityMap.keySet());
        System.out.println("Values (enum order): " + priorityMap.values());
        System.out.println("Entries (enum order): " + priorityMap.entrySet());
        
        // Iterate through entries
        System.out.println("Iterating through entries:");
        for (Map.Entry<Priority, Integer> entry : priorityMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        
        // 6. BULK OPERATIONS
        
        // Put all from another map
        EnumMap<Priority, Integer> anotherMap = new EnumMap<>(Priority.class);
        anotherMap.put(Priority.LOW, 2);
        anotherMap.put(Priority.URGENT, 50);
        
        priorityMap.putAll(anotherMap);
        System.out.println("\nAfter putAll: " + priorityMap);
        
        // 7. COMPUTE OPERATIONS (Java 8+)
        
        EnumMap<Day, Integer> workHours = new EnumMap<>(Day.class);
        workHours.put(Day.MONDAY, 8);
        workHours.put(Day.TUESDAY, 7);
        workHours.put(Day.WEDNESDAY, 8);
        
        System.out.println("\nWork hours before compute: " + workHours);
        
        // Compute - always computes new value
        workHours.compute(Day.THURSDAY, (key, oldVal) -> oldVal == null ? 8 : oldVal + 1);
        workHours.compute(Day.MONDAY, (key, oldVal) -> oldVal + 1);
        System.out.println("Work hours after compute: " + workHours);
        
        // ComputeIfAbsent - compute only if key doesn't exist
        workHours.computeIfAbsent(Day.FRIDAY, key -> 6);
        System.out.println("Work hours after computeIfAbsent: " + workHours);
        
        // ComputeIfPresent - compute only if key exists
        workHours.computeIfPresent(Day.TUESDAY, (key, oldVal) -> oldVal - 1);
        System.out.println("Work hours after computeIfPresent: " + workHours);
        
        // 8. MERGE OPERATIONS
        
        EnumMap<Day, String> activities = new EnumMap<>(Day.class);
        activities.put(Day.MONDAY, "Meeting");
        activities.put(Day.TUESDAY, "Review");
        
        System.out.println("\nActivities before merge: " + activities);
        
        // Merge - combine values
        activities.merge(Day.MONDAY, " & Planning", (oldVal, newVal) -> oldVal + newVal);
        activities.merge(Day.WEDNESDAY, "Training", (oldVal, newVal) -> oldVal + newVal);
        System.out.println("Activities after merge: " + activities);
        
        // 9. PRACTICAL USE CASE: STATE MACHINE
        
        EnumMap<State, Set<State>> stateTransitions = new EnumMap<>(State.class);
        
        // Define valid transitions
        stateTransitions.put(State.CREATED, EnumSet.of(State.RUNNING, State.CANCELLED));
        stateTransitions.put(State.RUNNING, EnumSet.of(State.PAUSED, State.COMPLETED, State.ERROR));
        stateTransitions.put(State.PAUSED, EnumSet.of(State.RUNNING, State.CANCELLED));
        stateTransitions.put(State.COMPLETED, Collections.emptySet());
        stateTransitions.put(State.ERROR, EnumSet.of(State.RUNNING, State.CANCELLED));
        stateTransitions.put(State.CANCELLED, Collections.emptySet());
        
        System.out.println("\n=== State Machine Example ===");
        System.out.println("Valid transitions: " + stateTransitions);
        
        // Check if transition is valid
        boolean canTransition = canTransition(stateTransitions, State.CREATED, State.RUNNING);
        System.out.println("Can transition from CREATED to RUNNING: " + canTransition);
        
        boolean invalidTransition = canTransition(stateTransitions, State.COMPLETED, State.RUNNING);
        System.out.println("Can transition from COMPLETED to RUNNING: " + invalidTransition);
        
        // 10. MEMORY EFFICIENCY DEMONSTRATION
        
        System.out.println("\n=== Memory Efficiency ===");
        // EnumMap uses bit vectors internally for better memory usage
        // Size is proportional to number of enum constants, not actual entries
        
        EnumMap<Day, Boolean> booleanMap = new EnumMap<>(Day.class);
        booleanMap.put(Day.MONDAY, true);
        booleanMap.put(Day.FRIDAY, false);
        
        System.out.println("Boolean map size: " + booleanMap.size());
        System.out.println("Boolean map: " + booleanMap);
    }
    
    // Helper method for state machine example
    private static boolean canTransition(EnumMap<State, Set<State>> transitions, 
                                      State from, State to) {
        Set<State> validTransitions = transitions.get(from);
        return validTransitions != null && validTransitions.contains(to);
    }
    
    // Enum for days
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    
    // Enum for priorities
    enum Priority {
        LOW, MEDIUM, HIGH, CRITICAL, URGENT
    }
    
    // Enum for states
    enum State {
        CREATED, RUNNING, PAUSED, COMPLETED, ERROR, CANCELLED
    }
}

/*
 ============================================================================
                    ENUMMAP TIME COMPLEXITY ANALYSIS
 ============================================================================
 
 | Operation                    | Time Complexity | Space Complexity | Description
 |------------------------------|-----------------|------------------|------------
 | get(key)                     | O(1)           | O(1)            | Array index lookup
 | put(key, value)              | O(1)           | O(1)            | Array index assignment
 | remove(key)                  | O(1)           | O(1)            | Array index clear
 | putIfAbsent(key, value)      | O(1)           | O(1)            | Conditional put
 | replace(key, oldValue, newValue) | O(1)       | O(1)            | Conditional replace
 | replace(key, value)          | O(1)           | O(1)            | Unconditional replace
 | containsKey(key)             | O(1)           | O(1)            | Bit vector check
 | containsValue(value)         | O(n)           | O(1)            | Linear search
 | size()                       | O(1) or O(n)   | O(1)            | Count bits or entries
 | isEmpty()                    | O(1)           | O(1)            | Check if empty
 | clear()                      | O(1) or O(n)   | O(1)            | Clear all entries
 | keySet()                     | O(1)           | O(1)            | Create key set view
 | values()                     | O(1)           | O(1)            | Create values view
 | entrySet()                   | O(1)           | O(1)            | Create entry set view
 | forEach(action)              | O(n)           | O(1)            | Iterate all entries
 | compute(key, function)       | O(1)           | O(1)            | Compute new value
 | computeIfAbsent(key, function) | O(1)         | O(1)            | Compute if key absent
 | computeIfPresent(key, function) | O(1)        | O(1)            | Compute if key present
 | merge(key, value, function)  | O(1)           | O(1)            | Merge value

 ============================================================================
                    WHEN TO USE ENUMMAP
 ============================================================================
 
 ✓ Map with enum keys exclusively
 ✓ Performance-critical applications with enum keys
 ✓ Memory-efficient mapping for enum types
 ✓ When you need ordered iteration by enum declaration order
 ✓ State machines with enum states
 ✓ Configuration mappings with enum keys
 ✓ Any scenario where all keys are from a single enum type

 ============================================================================
                    WHEN TO AVOID ENUMMAP
 ============================================================================
 
 ✗ When keys are not enum types
 ✗ When you need null keys (EnumMap doesn't allow null keys)
 ✗ Simple single-threaded applications with few entries
 ✗ When you don't need the performance benefits
 ✗ Applications where enum order doesn't matter
 ✗ When you need more flexible key types

 ============================================================================
                    KEY CHARACTERISTICS
 ============================================================================
 
 Internal Structure:
 - Uses array internally with enum ordinals as indices
 - Bit vectors for tracking which keys are present
 - Memory-efficient storage proportional to enum size
 - No hash collisions since enum ordinals are unique

 Performance:
 - O(1) time complexity for all basic operations
 - Faster than HashMap for enum keys
 - No hash computation overhead
 - Direct array access by ordinal

 Memory Efficiency:
 - Compact representation using arrays
 - No node overhead like HashMap
 - Bit vectors for presence tracking
 - Memory usage predictable based on enum size

 Ordering:
 - Maintains enum declaration order
 - Iteration follows enum constant order
 - Consistent ordering guaranteed
 - No need for TreeMap for ordering

 ============================================================================
                    COMPARISON WITH OTHER MAP IMPLEMENTATIONS
 ============================================================================
 
 | Feature              | EnumMap    | HashMap    | TreeMap    | LinkedHashMap
 |----------------------|------------|------------|------------|---------------
 | Time Complexity      | O(1)       | O(1) avg   | O(log n)   | O(1) avg
 | Space Complexity     | O(enum)    | O(n)       | O(n)       | O(n)
 | Null Keys            | No         | Yes        | No*        | Yes
 | Ordering             | Enum order | No         | Sorted     | Insertion
 | Memory Efficiency    | High       | Medium     | Low        | Medium
 | Performance          | Excellent  | Good       | Fair       | Good
 | * = null keys not allowed for Comparable implementations

 ============================================================================
                    COMMON DSA INTERVIEW QUESTIONS
 ============================================================================
 
 1. Why EnumMap is more efficient than HashMap for enum keys
 2. Internal implementation of EnumMap
 3. Memory usage comparison with other Map implementations
 4. Enum ordering preservation in EnumMap
 5. Thread safety of EnumMap operations
 6. Use cases for EnumMap in state machines
 7. Performance characteristics of EnumMap vs HashMap
 8. Bit vector usage in EnumMap implementation
 9. Null key restrictions in EnumMap
 10. EnumMap iteration order guarantees
 11. Bulk operations support in EnumMap
 12. EnumMap vs EnumSet for different use cases

 ============================================================================
                    PERFORMANCE CHARACTERISTICS
 ============================================================================
 
 Speed:
 - Fastest Map implementation for enum keys
 - No hash computation required
 - Direct array access by ordinal
 - No collision handling overhead
 - Consistent O(1) performance

 Memory:
 - Extremely memory efficient
 - Array size = number of enum constants
 - Bit vectors for presence tracking
 - No per-entry overhead
 - Predictable memory usage

 Scalability:
 - Performance independent of map size
 - Only depends on enum size
 - No resizing operations
 - No load factor considerations
 - Constant time operations regardless of entries

 ============================================================================
                    BEST PRACTICES
 ============================================================================
 
 1. Always use EnumMap for enum keys
 2. Specify enum class in constructor for type safety
 3. Leverage enum ordering for predictable iteration
 4. Use compute methods for atomic operations
 5. Consider memory efficiency for large enum types
 6. Use bulk operations for multiple entries
 7. Avoid null keys and values
 8. Use EnumMap.EntrySet for efficient iteration
 9. Consider EnumSet for key-only collections
 10. Profile performance for enum-heavy applications

 ============================================================================
*/