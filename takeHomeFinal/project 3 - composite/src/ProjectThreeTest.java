import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;

/**
 * @author Saatvik Agrawal
 * @version 1
 */

public class ProjectThreeTest {


    /**
     * Prevent tests from running infinitely
     */
    @Rule
    public Timeout globalTimeout = Timeout.seconds(20);

    /**
     * Setup necessary components before start
     */
    @Before
    public void setup() throws IOException {

    }

    /**
     * Test that report one is successfully generated
     */
    @Test
    public void testReportOne() {
        WorkplaceController workplaceController = new WorkplaceController();
        Employee fWong = new Employee("Franklin Wong", "CRADO", "R&D",
                160, "Male", true);
        Employee jSmith = new Employee("John Smith", "Assistant", "R&D",
                120, "Male", true);
        Employee rNarayan = new Employee("Jennifer Wallace", "Data Scientist", "R&D",
                152, "Male", false);
        fWong.addEmployee(jSmith);
        fWong.addEmployee(rNarayan);
        String report = WorkplaceController.report1(fWong);
        int expected = 342;
        assert(report.length() == expected);
    }

    /**
     * Test that report two is successfully generated
     */
    @Test
    public void testReportTwo() {
        WorkplaceController workplaceController = new WorkplaceController();
        Employee fWong = new Employee("Franklin Wong", "CRADO", "R&D",
                160, "Male", true);
        Employee jSmith = new Employee("John Smith", "Assistant", "R&D",
                120, "Female", true);
        Employee rNarayan = new Employee("Jennifer Wallace", "Data Scientist", "R&D",
                152, "Male", false);
        fWong.addEmployee(jSmith);
        fWong.addEmployee(rNarayan);
        String report = WorkplaceController.report2(fWong);
        System.out.println(report.length());
        int expected = 134;
        assert(report.length() == expected);
    }

    /**
     * Test that report three is successfully generated
     */
    @Test
    public void testReportThree() {
        WorkplaceController workplaceController = new WorkplaceController();
        Employee fWong = new Employee("Franklin Wong", "CRADO", "R&D",
                160, "Male", true);
        Employee jSmith = new Employee("John Smith", "Assistant", "R&D",
                120, "Female", true);
        Employee rNarayan = new Employee("Jennifer Wallace", "Data Scientist", "R&D",
                152, "Male", false);
        fWong.addEmployee(jSmith);
        fWong.addEmployee(rNarayan);
        String report = WorkplaceController.report3(fWong);
        int expected = 100;
        assert(report.length() == expected);
    }

    /**
     * Test that report four is successfully generated
     */
    @Test
    public void testReportFour() {
        WorkplaceController workplaceController = new WorkplaceController();
        Employee fWong = new Employee("Franklin Wong", "CRADO", "R&D",
                160, "Male", true);
        Employee jSmith = new Employee("John Smith", "Assistant", "R&D",
                120, "Male", true);
        Employee rNarayan = new Employee("Jennifer Wallace", "Data Scientist", "R&D",
                152, "Male", false);
        fWong.addEmployee(jSmith);
        fWong.addEmployee(rNarayan);
        String report = WorkplaceController.report4(fWong);
        String expected = "Average Salary: $144k";
        assert(expected.equals(report));
    }


    @Test
    public void testEmployeeClass() {
        Employee employee = new Employee("Franklin Wong", "CRADO", "R&D",
                160, "Male", true);
        assert(employee.getName().equals("Franklin Wong"));
        assert(employee.getGender().equals("Male"));
        assert(employee.getSalary().getAmount() == 160);

    }


}