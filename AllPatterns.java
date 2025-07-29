import java.util.*;

// public class Log {
//     public static void main(String[] args) {
//         System.out.println(" enter a and b for sum");
        
//         Scanner sc = new Scanner(System.in);
//         int a = sc.nextInt();
//         int b=sc.nextInt();
//         for (int i = 0; i < a; i++) {
//             for (int j = 0; j < i; j++) {
//                 System.out.print('*');
                
//             }
//             System.out.println("");
//         }

//     }
// }

public class AllPatterns {
    private static Scanner sc = new Scanner(System.in);

    public static void solidRectangle() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        System.out.print("Enter columns: ");
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void hollowRectangle() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        System.out.print("Enter columns: ");
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void halfPyramid() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void invertedHalfPyramid() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void invertedPyramidWithSpaces() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void numberHalfPyramid() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void invertedNumberPyramid() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void filledNumberPyramid() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        int number = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void binaryTriangle() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void solidRhombus() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void numberPyramid() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void palindromicNumberPyramid() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printEvenNumbers() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        System.out.println();
    }

    public static void menuDrivenMarks() {
        int input;
        do {
            System.out.print("Enter marks (0-100): ");
            int marks = sc.nextInt();
            if (marks >= 90 && marks <= 100) {
                System.out.println("This is Good");
            } else if (marks >= 60 && marks <= 89) {
                System.out.println("This is also Good");
            } else if (marks >= 0 && marks <= 59) {
                System.out.println("This is Good as well");
            } else {
                System.out.println("Invalid");
            }
            System.out.print("Want to continue? (1 for Yes, 0 for No): ");
            input = sc.nextInt();
        } while (input == 1);
        System.out.println();
    }

    public static void checkPrime() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        boolean isPrime = true;
        if (n == 1) {
            System.out.println("This is neither prime nor composite");
            return;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("This is a prime number");
        } else {
            System.out.println("This is not a prime number");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Solid Rectangle");
            System.out.println("2. Hollow Rectangle");
            System.out.println("3. Half Pyramid");
            System.out.println("4. Inverted Half Pyramid");
            System.out.println("5. Inverted Half Pyramid with Spaces");
            System.out.println("6. Number Half Pyramid");
            System.out.println("7. Inverted Number Half Pyramid");
            System.out.println("8. Filled Number Pyramid");
            System.out.println("9. Binary Triangle");
            System.out.println("10. Solid Rhombus");
            System.out.println("11. Number Pyramid");
            System.out.println("12. Palindromic Number Pyramid");
            System.out.println("13. Print Even Numbers");
            System.out.println("14. Menu-Driven Marks");
            System.out.println("15. Check Prime");
            System.out.println("16. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 16) break;

            switch (choice) {
                case 1: solidRectangle(); break;
                case 2: hollowRectangle(); break;
                case 3: halfPyramid(); break;
                case 4: invertedHalfPyramid(); break;
                case 5: invertedPyramidWithSpaces(); break;
                case 6: numberHalfPyramid(); break;
                case 7: invertedNumberPyramid(); break;
                case 8: filledNumberPyramid(); break;
                case 9: binaryTriangle(); break;
                case 10: solidRhombus(); break;
                case 11: numberPyramid(); break;
                case 12: palindromicNumberPyramid(); break;
                case 13: printEvenNumbers(); break;
                case 14: menuDrivenMarks(); break;
                case 15: checkPrime(); break;
                default: System.out.println("Invalid choice\n");
            }
        }
        sc.close();
    }
}