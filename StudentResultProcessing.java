import java.io.*;
import java.util.*;

public class StudentResultProcessing {

    static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Roll No: ");
            int roll = sc.nextInt();
            sc.nextLine(); // clear buffer

            System.out.print("Name: ");
            String name = sc.nextLine();

            int[] marks = new int[5];
            System.out.println("Enter marks for 5 subjects:");
            for (int j = 0; j < 5; j++) {
                System.out.print("Mark " + (j + 1) + ": ");
                marks[j] = sc.nextInt();
            }

            Student s = new Student(roll, name, marks);
            studentList.add(s);
        }

        // Write to file
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(FILE_NAME))) {

            oos.writeObject(studentList);
            System.out.println("\nRecords saved successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read from file
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(FILE_NAME))) {

            List<Student> list = (List<Student>) ois.readObject();

            System.out.println("\n--- All Students ---");
            for (Student s : list) {
                s.display(true);
            }

            System.out.println("\n--- Failed Students list ---");
            for (Student s : list) {
                if (s.isFailed()) {
                    s.display(true);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
