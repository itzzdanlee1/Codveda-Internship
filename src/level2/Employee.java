package level2;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String position;
    private String department;


    //a constructor to initialize the variables
    public Employee(int id,String name, double salary, String position, String department){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.position = position;
    }
    //getters for private fields
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public String getPosition(){
        return position;
    }

    public String getDepartment(){
        return department;
    }

    //Setters for private fields
    public void setName(String name){
        this.name = name;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setDepartment(String department){
        this.department = department;
    }
}
