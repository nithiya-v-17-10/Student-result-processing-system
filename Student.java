import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private int rollNo;
    private String name;
    private int[] marks;
    private int total;
    private double average;
    private String grade;

    public Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        calculateResult();
    }

    private void calculateResult() {
        total = 0;

        for (int i = 0; i < marks.length; i++) {
            total += marks[i];
        }

        average = total / 5.0;

        if (average >= 90)
            grade = "O";
        else if (average >= 80)
            grade = "A+";
        else if (average >= 70)
            grade = "A";
        else if (average >= 60)
            grade = "B";
        else if (average >= 50)
            grade = "C";
        else
            grade = "Fail";
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
    }

    public void display(boolean fullDetails) {
        display();
        if (fullDetails) {
            System.out.println("Total score: " + total);
            System.out.println("Average marks: " + average);
            System.out.println("Grade result: " + grade);
        }
        System.out.println("----------------------");
    }

    public boolean isFailed() {
        return grade.equals("Fail");
    }
}
