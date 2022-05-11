import java.util.ArrayList;

public class WorkplaceController {
    public static void main(String[] args) {
        System.out.println("Initializing Yellow Coats Employees");
        Employee aZelaya = new Employee("Alicia Zelaya", "Office Manager", "Administration",
                75, "Female", false);
        Employee aJabbar = new Employee("Ahmad Jabbar", "Admin", "Administration",
                100, "Male", false);
        Employee jWallace = new Employee("Jennifer Wallace", "CFO", "Administration",
                172, "Female", true);
        Employee jBorg = new Employee("James Borg", "CEO", "Headquarters",
                220, "Male", false);
        Employee fWong = new Employee("Franklin Wong", "CRADO", "R&D",
                160, "Male", true);
        Employee jSmith = new Employee("John Smith", "Assistant", "R&D",
                120, "Male", true);
        Employee rNarayan = new Employee("Ramesh Narayan", "Data Scientist", "R&D",
                152, "Male", false);
        System.out.println("Implementing Employee Hierarchy");
        fWong.addEmployee(jSmith);
        fWong.addEmployee(rNarayan);
        jWallace.addEmployee(aZelaya);
        jWallace.addEmployee(aJabbar);
        jBorg.addEmployee(fWong);
        jBorg.addEmployee(jWallace);
        printReports(jBorg);
        Employee jEnglish = new Employee("Joyce English", "ML Engineer", "R&D",140,
                "Female" , false);
        rNarayan.addEmployee(jEnglish);
        printReports(jBorg);
    }

    /**
     * Generates a report with all employees.
     */
    public static String report1(Employee head) {
        String str = head.toString() + "\n\n";
        if (head.getManages().size() > 0) {
            for (Employee e : head.getManages()) {
                str += report1(e);
            }
        }
        return str;
    }

    /**
     * Generates a report with all employees that are male and have dependants.
     */
    public static String report2(Employee head) {
        String str = "";
        if (head.getDependents() == true) {
            if (head.getGender().equals("Male")) {
                str += "\n" + "\n" + head.toString();
            }
        }
        if (head.getManages().size() > 0) {
            for (Employee e : head.getManages()) {
                str += report2(e);
            }
        }
        return str;
    }

    /**
     * Generates a report with all employees that are female.
     */
    public static String report3(Employee head) {
        String str = "";
        if (head.getGender().equals("Female")) {
            str += "\n" + "\n" + head.toString();
        }
        if (head.getManages().size() > 0) {
            for (Employee e : head.getManages()) {
                str += report3(e);
            }
        }
        return str;
    }

    /**
     * Generates a report on average salary.
     */
    public static String report4(Employee head) {
        ArrayList<Salary> salaries = new ArrayList<Salary>();
        getSalaries(head, salaries);
        int numEmployees = salaries.size();
        int totalSalaries = 0;
        for (Salary s : salaries) {
            totalSalaries += s.getAmount();
        }
        Salary avg = new Salary(totalSalaries/numEmployees);
        return "Average Salary: " + avg.toString();
    }

    /**
     * A helper method for report4
     * @param head node being operated on
     * @param salaries salaries list to add to
     */
    public static void getSalaries(Employee head, ArrayList<Salary> salaries) {
        salaries.add(head.getSalary());
        if (head.getManages().size() > 0) {
            for (Employee e : head.getManages()) {
                getSalaries(e, salaries);
            }
        }
    }

    /**
     * A method to get all reports
     * @param head head employee node
     * @return all four reports
     */
    public static String allReports(Employee head) {
        return report1(head) + report2(head) + report3(head) + report4(head);
    }

    /**
     * Prints all four reports.
     * @param head head employee node
     */
    public static void printReports(Employee head) {
        System.out.println("Report 1:");
        System.out.println(report1(head));
        System.out.println("Report 2:");
        System.out.println(report2(head));
        System.out.println("Report 3:");
        System.out.println(report3(head));
        System.out.println("Report 4:");
        System.out.println(report4(head));
    }
}