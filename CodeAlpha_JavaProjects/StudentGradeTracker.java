import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.size();
    }

    int getHighest() {
        int max = grades.get(0);
        for (int g : grades) {
            if (g > max) {
                max = g;
            }
        }
        return max;
    }

    int getLowest() {
        int min = grades.get(0);
        for (int g : grades) {
            if (g < min) {
                min = g;
            }
        }
        return min;
    }

    void displayReport() {
        System.out.println("\nStudent Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + getAverage());
        System.out.println("Highest: " + getHighest());
        System.out.println("Lowest: " + getLowest());
    }
}

// Main class (file name must match this)
public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();

            Student s = new Student(name);

            System.out.print("Enter number of subjects: ");
            int m = sc.nextInt();

            for (int j = 0; j < m; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = sc.nextInt();
                s.addGrade(grade);
            }

            sc.nextLine();
            students.add(s);
        }

        System.out.println("\n===== STUDENT REPORT =====");
        for (Student s : students) {
            s.displayReport();
        }

        sc.close();
    }
}