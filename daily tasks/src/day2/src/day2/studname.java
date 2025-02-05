package day2;

import java.util.*;

public class studname {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();  

        List<String> studentNames = new ArrayList<>();
        List<int[]> studentMarks = new ArrayList<>();
        List<Integer> totalMarks = new ArrayList<>();
        List<Double> averageMarks = new ArrayList<>();

        
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            studentNames.add(name);

            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();
            int[] marks = new int[numSubjects];

            
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter marks for subject " + (j + 1) + ": ");
                marks[j] = scanner.nextInt();
            }
            scanner.nextLine();  

            
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }
            double average = (double) total / marks.length;

            studentMarks.add(marks);
            totalMarks.add(total);
            averageMarks.add(average);
        }

       
        for (int i = 0; i < numberOfStudents - 1; i++) {
            for (int j = i + 1; j < numberOfStudents; j++) {
                if (totalMarks.get(i) < totalMarks.get(j)) {
                    
                    String tempName = studentNames.get(i);
                    studentNames.set(i, studentNames.get(j));
                    studentNames.set(j, tempName);

                   
                    int tempTotal = totalMarks.get(i);
                    totalMarks.set(i, totalMarks.get(j));
                    totalMarks.set(j, tempTotal);

                    
                    double tempAverage = averageMarks.get(i);
                    averageMarks.set(i, averageMarks.get(j));
                    averageMarks.set(j, tempAverage);
                }
            }
        }

        
        System.out.println("\nSorted list of students based on total marks:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println(studentNames.get(i) + " | Total Marks: " + totalMarks.get(i) + " | Average: " + averageMarks.get(i));
        }

        scanner.close();
    }
}

