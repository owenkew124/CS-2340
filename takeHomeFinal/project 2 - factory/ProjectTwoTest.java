import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;

/**
 * @author Saatvik Agrawal
 * @version 1
 */

public class ProjectTwoTest {


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
     * Test that the computer factory successfully creates a laptop
     */
    @Test
    public void testComputerFactoryCreatesLaptop() {
        ComputerFactory computerFactory = new ComputerFactory();
        Computer newComputer = computerFactory.makeComputer("Dell", "LAPTOP");
        assert(newComputer.getClass() == Laptop.class);
    }

    /**
     * Test that the computer factory creates a server
     */
    @Test
    public void testComputerFactoryCreatesServer() {
        ComputerFactory computerFactory = new ComputerFactory();
        Computer newComputer = computerFactory.makeComputer("Dell", "SERVER");
        assert(newComputer.getClass() == Server.class);
    }

    /**
     * Test that the computer factory creates a workstation
     */
    @Test
    public void testComputerFactoryCreatesWorkstation() {
        ComputerFactory computerFactory = new ComputerFactory();
        Computer newComputer = computerFactory.makeComputer("Dell", "WORKSTATION");
        assert(newComputer.getClass() == Workstation.class);
    }

    /**
     * Test that the computer factory creates a workstation with correct brand
     */
    @Test
    public void testComputerFactoryCreatesCorrectBrand() {
        ComputerFactory computerFactory = new ComputerFactory();
        Computer newComputer = computerFactory.makeComputer("Dell", "WORKSTATION");
        String expected = "Dell";
        assert(expected.equals(newComputer.getBrand()));
    }

    /**
     * Test that the computer factory creates a workstation
     */
    @Test
    public void testComputerModifiableBrand() {
        ComputerFactory computerFactory = new ComputerFactory();
        Computer newComputer = computerFactory.makeComputer("Dell", "WORKSTATION");
        String expected = "Dell";
        assert(expected.equals(newComputer.getBrand()));
        newComputer.setBrand("HP");
        String newExpected = "HP";
        assert(expected.equals(newComputer.getBrand()));
    }
}