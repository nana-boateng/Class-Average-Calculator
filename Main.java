import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAverage {
        Average average = new Average();
        System.out.println("################################################");
        System.out.println("\t\tWELCOME TO GRADE CALCULATOR");
        System.out.println("################################################\n");
        start(average);
    }

    private static void start(Average average) throws IllegalAverage {
        System.out.println("1. Add new mark.\n2. Remove mark\n3. View marks\n4. Calculate average\n0. Exit");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter option: ");
        int choice = keyboard.nextInt();
        System.out.println();
        switch (choice) {
            case 1:
                addMark(average);
            case 2:
                removeMark(average);
            case 3:
                viewMarks(average);
                goBack(average);
            case 4:
                calculateAvg(average);
            case 0:
                System.out.println("Thank you for using this program! Goodbye!");
                System.exit(0);
        }
    }

    private static void addMark(Average average) throws IllegalAverage {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter percentage mark: ");
        int num = keyboard.nextInt();
        average.setMarks(num);
        boolean check = true;
        while (check) {
            System.out.print("1. Enter new assignment\n2. Save and go back to the Main Menu\nEnter option: ");
            int choice = keyboard.nextInt();
            if (choice == 2) {
                check = false;
            } else if (choice == 1) {
                System.out.print("\nEnter percentage mark: ");
                int mark = keyboard.nextInt();
                average.setMarks(mark);
            } else {
                System.out.println("Enter a valid number");
            }
        }
        System.out.println();
        start(average);
    }

    private static void removeMark(Average average) throws IllegalAverage {
        Scanner keyboard = new Scanner(System.in);
        viewMarks(average);
        System.out.println("\nEnter assignment # to remove");
        int number = keyboard.nextInt();
        average.removeMark(number);
        viewMarks(average);
        goBack(average);
    }

    private static void viewMarks(Average average) {
        ArrayList<Double> marks = average.getMarks();
        ArrayList<Double> weights = average.getWeights();
        System.out.println("Assignment #\tMark\tWeight");
        for (int i = 0; i < marks.size(); i++) {
            System.out.println("Assignment " + (i + 1) + "\t" + marks.get(i) + "%\t" + weights.get(i) + "%");
        }
    }

    private static void calculateAvg(Average average) throws IllegalAverage {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What's the passing grade for this class: ");
        double desiredGrade = keyboard.nextDouble();
        double currentGrade = average.getCurrentAverage(average.getMarks(), average.getWeights());
        System.out.println("Current Grade = " + currentGrade);
        if(currentGrade > desiredGrade){
            System.out.println("Your current grade is above your desired grade!");
            System.out.println("You will pass the class even if you get 0% on the final!");
        }
        double currentWeightTotal = average.getTotalWeights(average.getWeights());
        double finalMark = (desiredGrade * 100 - currentGrade * currentWeightTotal) / (100 - currentGrade);
        if (finalMark < 0) finalMark = 0;
        System.out.println("You need " + finalMark + "% to get " + desiredGrade + "%.");
        goBack(average);
    }

    private static void goBack(Average average) throws IllegalAverage {
        System.out.print("\n1. Go to Main Menu.\n0. Exit.\nNumber: ");
        Scanner keyboard = new Scanner(System.in);
        int num = keyboard.nextInt();
        if (num == 1) {
            start(average);
        } else {
            System.out.println("Thank you for using this program! Goodbye!");
            System.exit(0);
        }
    }

}
