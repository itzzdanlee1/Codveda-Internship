package level2;
import java.util.ArrayList;


public class EmployeeManagement {
    private ArrayList<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
    }
    //CREATE
    // Check if an employee ID already exists
    public boolean employeeExists(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return true;
            }
        }

        return false;
    }
    public void addEmployee(Employee employee) {

        if (employeeExists(employee.getId())) {
            System.out.println("Employee ID already exists!");
            return;
        }

        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

   //READ
   public void viewEmployee(){
        if(employees.isEmpty()){
            System.out.println("No employees found.");
            return;
        }
        System.out.println("\n--------Employee List--------");

        for(Employee employee : employees){
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("------------------------");
        }
   }

   //UPDATE
    public void updateEmployee(int id, String name, double salary, String position, String department){

        for (Employee employee : employees){
            if(employee.getId() == id){

                employee.setName(name);
                employee.setSalary(salary);
                employee.setPosition(position);
                employee.setDepartment(department);

                System.out.println("Successfully updated Employee!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    //DELETE
    public void deleteEmployee(int id){
        for (int i = 0; i < employees.size(); i++){
            if (employees.get(i).getId() == id){
                employees.remove(i);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}

