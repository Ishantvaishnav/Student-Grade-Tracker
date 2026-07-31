import java.util.ArrayList;
import java.util.Scanner;


// Defining the missing Student class
class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getname() {
        return name;
    }

    public double getgrade() {
        return grade;
    }
}

class Grademanagement{
    public static void main(String[] args) {
        ArrayList<Student> studentlist = new ArrayList<>();
        Scanner sc = new Scanner(System.in);


    while(true){
        System.out.println("Enter A Name (or type 'exit' to finish):-");
        String name = sc.nextLine();

       if (name.equalsIgnoreCase("exit")){
            break;
        }

        System.out.println("Enter Grade:-");
        double grade = sc.nextDouble();
        sc.nextLine();// Clear the scanner buffer after reading a number

        Student newstudent = new Student(name , grade);
        studentlist.add(newstudent);
       
    }

    // Check if the user exited without entering any students to prevent crashes
    if(studentlist.isEmpty()){
        System.out.println("No student data entered. Exiting program.");
        return;
    }

    // --- STEP 2: CONVERT TO ARRAY ---
    double[] gradesArray = new double[studentlist.size()];
    
      for(int i=0;i<studentlist.size();i++){
          gradesArray[i] =  studentlist.get(i).getgrade();
 }

    // --- STEP 3: CALCULATE STATISTICS USING THE ARRAY ---
    double sum =0;
    double highest = gradesArray[0];
    double lowest = gradesArray[0];

    for(int i=0; i<gradesArray.length; i++){
     sum += gradesArray[i];

    if(gradesArray[i] > highest){
        highest = gradesArray[i];
    }

    if(gradesArray[i] < lowest){
        lowest = gradesArray[i];
    }
    }

    double average = sum / gradesArray.length;

    System.out.println("\n===== Student Summary =====");
    for(int j=0; j<studentlist.size(); j++){
          System.out.println("Student:" + studentlist.get(j).getname() + "| Grade:" + studentlist.get(j).getgrade());
    }

     System.out.println("===========================");
     System.out.printf("Average Score: %.2f\n", average);
     System.out.println("Highest Score: " + highest);
     System.out.println("Lowest Score:  " + lowest);
     System.out.println("===========================");

     sc.close();
    }
}