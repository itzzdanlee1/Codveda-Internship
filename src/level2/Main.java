package level2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    EmployeeManagement management = new EmployeeManagement();

    int choice;

    do {
        System.out.println("\n---------Employee Management System--------");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");

        choice = input.nextInt();
        input.nextLine();

        switch (choice){
            case 1:
                System.out.print("Enter employee ID: ");
                int id = input.nextInt();
                input.nextLine();

                System.out.print("Enter employee name: ");
                String name = input.nextLine();

                System.out.print("Enter employee salary: ");
                double salary = input.nextDouble();
                input.nextLine();

                System.out.print("Enter position: ");
                String position = input.nextLine();

                System.out.print("Enter department: ");
                String department = input.nextLine();

                Employee employee =
                        new Employee(id, name, salary, position, department);
                management.addEmployee(employee);
                break;

            case 2:
                management.viewEmployee();
                break;

            case 3:
                System.out.print("Enter employee ID to update: ");
                int updateId = input.nextInt();
                input.nextLine();

                System.out.print("Enter new name: ");
                String newName = input.nextLine();

                System.out.print("Enter new salary: ");
                double newSalary = input.nextDouble();
                input.nextLine();

                System.out.print("Enter new position: ");
                String newPosition = input.nextLine();

                System.out.print("Enter new department: ");
                String newDepartment = input.nextLine();

                management.updateEmployee(
                        updateId,
                        newName,
                        newSalary,
                        newPosition,
                        newDepartment
                );
                break;

            case 4:
                System.out.print("Enter employee ID to delete: ");
                int deleteId = input.nextInt();

                management.deleteEmployee(deleteId);
                break;

            case 5:
                System.out.println("Thank you for using this system!!");
                break;

            default:
                System.out.println("Invalid choice! please try again.");
        }

      } while (choice != 5);
         input.close();
    }

}