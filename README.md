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
```

 # all conditional statements in Java
  **explained clearly with syntax, examples, and best practices.**

You can save this as `JavaConditionalStatements.md`.

---

# 🧠 Java Conditional Statements

Conditional statements in Java allow programs to make decisions based on certain conditions. They control the **flow of execution** by evaluating `true` or `false` expressions.

This guide covers all types of conditional statements in Java:
- `if`
- `if-else`
- `if-else-if ladder`
- `nested if`
- `switch`

---

## ✅ 1. `if` Statement

Executes a block of code **only if** the condition is `true`.

### 🔹 Syntax
```java
if (condition) {
    // code to execute if condition is true
}
```

### 🔹 Example
```java
int age = 18;
if (age >= 18) {
    System.out.println("You are eligible to vote.");
}
```

> **Output:** `You are eligible to vote.`

---

## ✅ 2. `if-else` Statement

Executes one block if the condition is `true`, and another if it's `false`.

### 🔹 Syntax
```java
if (condition) {
    // code if true
} else {
    // code if false
}
```

### 🔹 Example
```java
int number = -5;
if (number >= 0) {
    System.out.println("Number is positive or zero.");
} else {
    System.out.println("Number is negative.");
}
```

> **Output:** `Number is negative.`

---

## ✅ 3. `if-else-if` Ladder (Multiple Conditions)

Used to check multiple conditions in sequence. The first `true` condition is executed, and the rest are skipped.

### 🔹 Syntax
```java
if (condition1) {
    // code if condition1 is true
} else if (condition2) {
    // code if condition2 is true
} else if (condition3) {
    // code if condition3 is true
} else {
    // optional default code
}
```

### 🔹 Example
```java
int marks = 75;
if (marks >= 90) {
    System.out.println("Grade: A");
} else if (marks >= 80) {
    System.out.println("Grade: B");
} else if (marks >= 70) {
    System.out.println("Grade: C");
} else if (marks >= 60) {
    System.out.println("Grade: D");
} else {
    System.out.println("Grade: F");
}
```

> **Output:** `Grade: C`

> ✅ Only the **first matching condition** is executed.

---

## ✅ 4. Nested `if` Statements

An `if` statement inside another `if` or `if-else` block.

### 🔹 Syntax
```java
if (outerCondition) {
    if (innerCondition) {
        // code
    }
}
```

### 🔹 Example
```java
int age = 25;
boolean hasLicense = true;

if (age >= 18) {
    if (hasLicense) {
        System.out.println("You can drive.");
    } else {
        System.out.println("You need a license to drive.");
    }
} else {
    System.out.println("You are too young to drive.");
}
```

> **Output:** `You can drive.`

---

## ✅ 5. `switch` Statement

Evaluates a variable and matches it against multiple `case` values. It’s ideal when comparing a variable against **multiple fixed values**.

### 🔹 Syntax
```java
switch (expression) {
    case value1:
        // code
        break;
    case value2:
        // code
        break;
    ...
    default:
        // optional default code
}
```

### 🔹 Rules
- `expression` must be `byte`, `short`, `int`, `char`, `String`, or `enum`.
- `break` stops execution and exits the switch (optional but recommended).
- `default` runs if no case matches (optional).

### 🔹 Example (with int)
```java
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    case 4:
        System.out.println("Thursday");
        break;
    case 5:
        System.out.println("Friday");
        break;
    default:
        System.out.println("Weekend");
}
```

> **Output:** `Wednesday`

### 🔹 Example (with String) – Java 7+
```java
String fruit = "Apple";
switch (fruit.toLowerCase()) {
    case "banana":
        System.out.println("It's a banana.");
        break;
    case "apple":
        System.out.println("It's an apple.");
        break;
    case "orange":
        System.out.println("It's an orange.");
        break;
    default:
        System.out.println("Unknown fruit.");
}
```

> **Output:** `It's an apple.`

---

## 🆚 `if-else` vs `switch`: When to Use?

| Use `if-else` when: | Use `switch` when: |
|---------------------|--------------------|
| Conditions are ranges (e.g., `age > 18`) | Comparing single variable to fixed values |
| Using logical operators (`&&`, `||`) | Values are known and discrete |
| Working with floating-point or complex logic | Performance matters (switch can be faster) |

> ✅ Prefer `switch` for menu systems, state machines, or fixed options.

---

## 🧪 Complete Example: All Conditionals in One Program

```java
public class ConditionalDemo {
    public static void main(String[] args) {
        int score = 85;
        char grade;
        boolean passed = false;

        // if-else-if ladder
        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else {
            grade = 'F';
        }

        // nested if
        if (grade != 'F') {
            passed = true;
            if (score >= 95) {
                System.out.println("Excellent! Awarded Honors.");
            }
        }

        // switch
        switch (grade) {
            case 'A':
                System.out.println("Outstanding performance!");
                break;
            case 'B':
                System.out.println("Good job!");
                break;
            case 'C':
                System.out.println("Average, keep improving.");
                break;
            default:
                System.out.println("Need to work harder.");
        }

        System.out.println("Grade: " + grade);
        System.out.println("Passed: " + passed);
    }
}
```

> **Output:**
```
Good job!
Grade: B
Passed: true
```

---

## 📌 Best Practices

- Always use **braces `{}`** even for single-line `if` blocks (prevents bugs).
- Avoid deep nesting — refactor using methods or `return` early.
- Use `switch` with `enum` or `String` for cleaner code.
- Prefer `else if` ladder over multiple `if` when mutually exclusive.
- Use meaningful condition names (e.g., `if (isEligible)` instead of complex logic inline).

---

## 🚫 Common Mistakes

| Mistake | Fix |
|-------|-----|
| Missing `break` in `switch` → fall-through | Add `break;` after each case |
| Using `=` instead of `==` | Use `==` for comparison, `=` for assignment |
| Forgetting `default` in `switch` | Include `default` for safety |
| Complex conditions without parentheses | Use `()` to group: `(age > 18 && hasLicense)` |

---

## ✅ Summary Table

| Statement | Purpose | Use Case |
|---------|--------|---------|
| `if` | Run code if condition true | Simple check |
| `if-else` | Two outcomes | Binary decisions |
| `if-else-if` | Multiple outcomes | Grading, tiers |
| `nested if` | Conditional inside conditional | Multi-level logic |
| `switch` | Match value to cases | Menu selection, enums |

---
# 🔁 Java Loops: Complete Guide

Loops in Java allow you to **execute a block of code repeatedly** based on a condition. They are essential for tasks like iterating over arrays, processing data, or repeating actions until a condition is met.

Java supports **four types of loops**:
1. `for` loop
2. `while` loop
3. `do-while` loop
4. Enhanced `for-each` loop

---

## ✅ 1. `for` Loop

Used when you **know in advance** how many times the loop should run.

### 🔹 Syntax
```java
for (initialization; condition; update) {
    // code to repeat
}
```

- **Initialization**: Runs once at the start.
- **Condition**: Checked before each iteration. If `true`, loop continues.
- **Update**: Runs after each iteration (e.g., increment/decrement).

### 🔹 Example: Print Numbers 1 to 5
```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

> **Output:**
```
1
2
3
4
5
```

### 🔹 Real-World Use
- Iterating a known number of times.
- Traversing arrays or lists with index.

---

## ✅ 2. `while` Loop

Executes a block **as long as** the condition is `true`. Ideal when the number of iterations is **not known** in advance.

### 🔹 Syntax
```java
while (condition) {
    // code to repeat
}
```

> 🔁 The condition is checked **before** each iteration.

### 🔹 Example: Countdown
```java
int count = 3;
while (count > 0) {
    System.out.println(count);
    count--;
}
System.out.println("Blast off!");
```

> **Output:**
```
3
2
1
Blast off!
```

### 🔹 Real-World Use
- Reading input until user types "quit".
- Polling or waiting for a condition.

---

## ✅ 3. `do-while` Loop

Similar to `while`, but the code runs **at least once** because the condition is checked **after** execution.

### 🔹 Syntax
```java
do {
    // code to repeat
} while (condition);
```

> 🔁 Loop body executes **first**, then condition is checked.

### 🔹 Example: Menu with Retry
```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
int choice;

do {
    System.out.println("Menu: 1. Play  2. Settings  3. Exit");
    System.out.print("Choose an option: ");
    choice = sc.nextInt();
} while (choice != 3);

System.out.println("Goodbye!");
```

> ✅ User sees the menu at least once, even if `choice == 3` initially.

### 🔹 Real-World Use
- Input validation.
- Game loops.
- Menus that must show at least once.

---

## ✅ 4. Enhanced `for` Loop (For-Each)

Used to **iterate through arrays or collections** without using an index. Clean and readable.

### 🔹 Syntax
```java
for (Type variable : arrayOrCollection) {
    // code to execute
}
```

### 🔹 Example: Loop Through Array
```java
int[] numbers = {10, 20, 30, 40};

for (int num : numbers) {
    System.out.println(num);
}
```

> **Output:**
```
10
20
30
40
```

### 🔹 Example: Loop Through String Array
```java
String[] fruits = {"Apple", "Banana", "Orange"};

for (String fruit : fruits) {
    System.out.println("Fruit: " + fruit);
}
```

> ✅ No need to manage index or bounds.

### 🔹 Real-World Use
- Iterating over `ArrayList`, arrays, or any `Iterable`.
- When you only need **read access**, not modification by index.

---

## 🆚 Loop Comparison Table

| Loop Type       | Condition Check | Minimum Executions | Best For |
|-----------------|------------------|--------------------|---------|
| `for`           | Before each     | 0                  | Known iterations, index-based access |
| `while`         | Before each     | 0                  | Unknown iterations, condition-controlled |
| `do-while`      | After each      | 1                  | Must run at least once (e.g., menus) |
| `for-each`      | Before each     | 0                  | Traversing arrays/collections (clean syntax) |

---

## 🧪 Complete Example: All Loops in One Program

```java
public class LoopsDemo {
    public static void main(String[] args) {

        int[] nums = {5, 10, 15};

        // 1. for loop
        System.out.println("=== for loop ===");
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Index " + i + ": " + nums[i]);
        }

        // 2. while loop
        System.out.println("\n=== while loop ===");
        int i = 0;
        while (i < nums.length) {
            System.out.println(nums[i]);
            i++;
        }

        // 3. do-while loop
        System.out.println("\n=== do-while loop ===");
        int j = 0;
        do {
            System.out.println(nums[j]);
            j++;
        } while (j < nums.length);

        // 4. for-each loop
        System.out.println("\n=== for-each loop ===");
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
```

> ✅ All four loops produce the same output:
```
5
10
15
```

---

## ⚠️ Infinite Loops (Common Mistake)

An infinite loop runs forever — useful only in specific cases (e.g., servers), but usually a bug.

### ❌ Bad Example
```java
while (true) {
    System.out.println("This never stops!");
}
```

```java
for (int i = 0; i > -1; i++) {  // i will always be increasing
    System.out.println(i);
}
```

### ✅ How to Avoid
- Ensure the loop variable is **updated**.
- Make sure the **condition eventually becomes false**.
- Use `break` when needed.

---

## 🔧 Loop Control Statements

You can control loop flow using:

| Keyword | Purpose |
|--------|--------|
| `break` | Exits the loop immediately |
| `continue` | Skips the current iteration and continues to the next |

### 🔹 Example with `break` and `continue`
```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue; // skip 3
    }
    if (i == 5) {
        break; // stop before printing 5
    }
    System.out.println(i);
}
```

> **Output:**
```
1
2
4
```

---

## 📌 Best Practices

- Use `for-each` whenever possible for collections/arrays — it's safer and cleaner.
- Prefer `while` over `do-while` unless you **need** at least one execution.
- Avoid modifying loop variables inside the loop body.
- Declare loop variables in the smallest scope (e.g., `for (int i = 0; ...)`).
- Use meaningful variable names: `for (String name : names)`.

---

## 🚫 Common Mistakes

| Mistake | Fix |
|-------|-----|
| Missing update → infinite loop | Add increment/decrement |
| Semicolon after `for()` or `while()` → empty loop | Remove extra `;` |
| Off-by-one error (e.g., `i <= arr.length`) | Use `< arr.length` |
| Modifying collection during for-each | Use `Iterator` or regular `for` loop |

---

## ✅ Summary

| Loop | When to Use |
|------|-------------|
| `for` | Known number of iterations |
| `while` | Unknown iterations, pre-check |
| `do-while` | At least one execution needed |
| `for-each` | Traversing arrays/collections (read-only) |

Loops are foundational in programming — mastering them helps you handle repetition efficiently and write cleaner, more dynamic code.

---