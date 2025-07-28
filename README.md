# 📚 Java Data Types Reference

This document provides a comprehensive overview of all **data types in Java**, including **primitive** and **non-primitive (reference)** types. Data types are categorized, sorted by size, and explained with details on memory usage, range, default values, and usage examples.

---

## 🔹 1. Primitive Data Types

Primitive data types are the most basic building blocks in Java. There are **8 primitive types**, all defined by the language and named with lowercase keywords.

They are further categorized by purpose:
- **Integer types**: `byte`, `short`, `int`, `long`
- **Floating-point types**: `float`, `double`
- **Character type**: `char`
- **Boolean type**: `boolean`

### ✅ Primitive Types (Sorted by Size)

| Type      | Size (Bytes) | Size (Bits) | Range / Value | Default | Example |
|-----------|--------------|------------|---------------|---------|---------|
| `boolean` | 1 byte       | (8 bits)   | `true` or `false` | `false` | `boolean isActive = true;` |
| `byte`    | 1 byte       | (8 bits)   | -128 to 127   | `0`     | `byte b = 100;` |
| `char`    | 2 bytes      | (16 bits)  | 0 to 65,535 (Unicode) | `\u0000` | `char c = 'A';` |
| `short`   | 2 bytes      | (16 bits)  | -32,768 to 32,767 | `0`     | `short s = 5000;` |
| `int`     | 4 bytes      | (32 bits)  | -2,147,483,648 to 2,147,483,647 | `0` | `int count = 1000;` |
| `float`   | 4 bytes      | (32 bits)  | ~±3.4 × 10³⁸ (6-7 digits precision) | `0.0f` | `float f = 3.14f;` |
| `long`    | 8 bytes      | (64 bits)  | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 | `0L` | `long big = 1000000000L;` |
| `double`  | 8 bytes      | (64 bits)  | ~±1.7 × 10³⁰⁸ (15-16 digits precision) | `0.0d` | `double d = 3.14159;` |

> 💡 **Note on `boolean` size**: Although it represents 1 bit logically, the JVM typically uses **1 byte** due to memory alignment. No official bit-level size is guaranteed.

---

## 🔹 2. Non-Primitive (Reference) Data Types

Non-primitive types refer to **objects** and are called **reference types** because they store a **reference (memory address)** to the actual data.

Unlike primitives, they can be:
- `null`
- Created from classes
- Have methods and properties
- Dynamically allocated on the heap

### 📦 Common Non-Primitive Types

| Type | Description | Example |
|------|-------------|---------|
| **`String`** | Represents a sequence of characters (immutable) | `String name = "Java";` |
| **Arrays** | Holds fixed-size collections of same-type elements | `int[] nums = {1, 2, 3};` |
| **Classes** | User-defined or built-in object types | `Person p = new Person();` |
| **Interfaces** | Define behavior contracts | `List<String> list = new ArrayList<>();` |
| **Enums** | Special class for fixed set of constants | `enum Day { MON, TUE, WED }` |

### 🔍 Key Differences: Primitive vs Non-Primitive

| Feature | Primitive | Non-Primitive |
|--------|---------|----------------|
| Stored as | Value | Reference (pointer to object) |
| Memory | Stack (usually) | Heap (object), Stack (reference) |
| Default Value | e.g., `0`, `false` | `null` |
| Can be `null`? | ❌ No | ✅ Yes |
| Size | Fixed | Varies (depends on object) |
| Inheritance | ❌ No | ✅ Yes |
| Methods | ❌ No (no methods) | ✅ Yes |

---

## 🧪 Example: Complete Java Program Demonstrating All Types

```java
public class DataTypesDemo {
    // Field variables (class-level) - show default values
    static boolean flag;
    static byte b;
    static short s;
    static int i;
    static long l;
    static float f;
    static double d;
    static char ch;

    public static void main(String[] args) {
        // ✅ Primitive Types
        System.out.println("=== Primitive Types ===");
        System.out.println("boolean: " + flag); // false
        System.out.println("byte: " + b);       // 0
        System.out.println("short: " + s);      // 0
        System.out.println("int: " + i);        // 0
        System.out.println("long: " + l);       // 0
        System.out.println("float: " + f);      // 0.0
        System.out.println("double: " + d);     // 0.0
        System.out.println("char: '" + ch + "'"); // '\u0000'

        // ✅ Non-Primitive Types
        System.out.println("\n=== Non-Primitive Types ===");
        String text = "Hello, Java!";
        int[] numbers = {10, 20, 30};
        Object obj = null;

        System.out.println("String: " + text);
        System.out.print("Array: ");
        for (int num : numbers) System.out.print(num + " ");
        System.out.println("\nObject: " + obj);

        // Enum example
        Day today = Day.MON;
        System.out.println("Day: " + today);
    }

    // Example enum
    enum Day {
        MON, TUE, WED, THU, FRI, SAT, SUN
    }
}