import java.util.ArrayList;

public class Employee {
    /**
     * A string containing the employee's name.
     */
    private String name;

    /**
     * Getter for name.
     */
    public String getName() { return this.name; }

    /**
     * A string containing the employee's position.
     */
    private String position;

    /**
     * A string containing the name of the employee's department.
     */
    private String department;

    /**
     * An object containing the employee's salary.
     */
    private Salary salary;

    /**
     * Getter for salary.
     * @return the employee salary
     */
    public Salary getSalary() { return this.salary; }

    /**
     * A string containing the employee's gender
     */
    private String gender;

    /**
     * A getter for gender.
     * @return the employee's gender
     */
    public String getGender() { return this.gender; }

    /**
     * A boolean determining if the employee has dependents.
     */
    private boolean dependents;

    /**
     * A getter for dependents.
     * @return
     */
    public boolean getDependents() { return this.dependents; }

    /**
     * A list of all the subemployees of this employee.
     */
    private ArrayList<Employee> manages;

    /**
     * A getter for the subemployees of this employee.
     * @return the subemployees of this employee
     */
    public ArrayList<Employee> getManages() { return this.manages; }

    /**
     * A constructor for an employee with no subemployees.
     * @param name employee name
     * @param position employee position
     * @param department employee department
     * @param salary employee salary
     * @param gender employee gender
     * @param dependents employee dependents
     */
    public Employee(String name, String position, String department, int salary, String gender, boolean dependents) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.salary = new Salary(salary);
        this.gender = gender;
        this.dependents = dependents;
        this.manages = new ArrayList<Employee>();
    }

    /**
     * A method to add a subemployee
     */
    public void addEmployee(Employee toAdd) {
        this.manages.add(toAdd);
    }

    /**
     * A toString override for Employee.
     * @return a toString for Employee
     */
    @Override
    public String toString() {
        String str = "";
        str += "Name: " + name + "\n";
        str += "Position: " + position + "\n";
        str += "Department: " + department + "\n";
        str += "Salary: " + salary.toString() + "\n";
        str += "Gender: " + gender + "\n";
        str += "Dependents: " + dependents;
        if (manages.size() > 0) {
            str += "\nManages:";
            for (Employee e : manages) {
                str += " " + e.getName();
            }
        }
        return str;
    }
}