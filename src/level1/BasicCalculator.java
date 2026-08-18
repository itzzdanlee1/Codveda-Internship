package level1;
import java.util.Scanner;
 public class BasicCalculator{
     double num1, num2;

     //A constructor to initialize variables
     public BasicCalculator(double n1, double n2){
         num1 = n1;
         num2 = n2;
     }

     //Addition Method
     public double add(){
         return num1 + num2;
     }

     //Subtraction Method
     public double subtract(){
         return num1 - num2;
     }

     //Multiplication Method
     public double multiply(){
         return num1 * num2;
     }

     //Division Method
     public double divide(){
         if(num2 != 0){
             return num1/num2;
         }else {
             System.out.println("Error: Division by Zero!!");
             return 0;
         }
     }

 }

  class Main {
     public static void main(String[] args){
         Scanner input = new Scanner(System.in);
         double n1, n2;
         int choice;


         //Taking User input
         System.out.println("Enter the first number: ");
         n1 = input.nextDouble();
         System.out.println("Enter the second number: ");
         n2 = input.nextDouble();

         //The calculator object
         BasicCalculator calc = new BasicCalculator(n1, n2);

         System.out.println("Choose the operation: ");
         System.out.println("1.Addition");
         System.out.println("2.Subtraction");
         System.out.println("3.Multiplication");
         System.out.println("4.Division");

         choice = input.nextInt();

         //Decided to play with Switch
            switch (choice) {
                case 1:
                    System.out.println("Result: " + calc.add());
                    break;
                case 2:
                    System.out.println("Result: " + calc.subtract());
                    break;
                case 3:
                    System.out.println("Result: " + calc.multiply());
                    break;
                case 4:
                    System.out.println("Result: " + calc.divide());
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
         input.close();
     }
 }