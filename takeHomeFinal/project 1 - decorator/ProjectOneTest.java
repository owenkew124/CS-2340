
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * @author Saatvik Agrawal
 * @version 1
 */

public class ProjectOneTest {


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
     * Test that the Cone class creates a correct description.
     */
    @Test
    public void testConeDescription() {
        Cone cone = new Cone(1, "Chocolate");
        String expected = "A single scoop of chocolate ice cream";
        assert(expected.equals(cone.getDescription()));
    }

    /**
     * Test that the Cone class has the right number of scoops
     */
    @Test
    public void testConeScoops() {
        Cone cone = new Cone(1, "Chocolate");
        assert(cone.getScoops() == 1);
    }

    /**
     * Test that the Cone class accurately calculates price
     */
    @Test
    public void testConeFlavor() {
        Cone coneOneScoop = new Cone(1, "Chocolate");
        String expected = "Chocolate";
        assert(expected.equals(coneOneScoop.getFlavor()));
    }

    /**
     * Test that the ice cream maker produces the expected ice cream
     */
    @Test
    public void testIceCreamMakerOne() {
        IceCream iceCream = new Sprinkles(new HotFudge(new Cone(2, "Vanilla")));
        String expectedDescription = "A double scoop of vanilla ice cream, hot fudge, sprinkles";
        double expectedPrice = 5.77;
        assert(expectedDescription.equals(iceCream.getDescription()));
        assert(expectedPrice == iceCream.getPrice());
    }

    @Test
    public void testIceCreamMakerTwo() {
        IceCream iceCream = new HotFudge(new Cone(2, "Vanilla"));
        String expectedDescription = "A double scoop of vanilla ice cream, hot fudge";
        double expectedPrice = 4.98;
        assert(expectedDescription.equals(iceCream.getDescription()));
        assert(expectedPrice == iceCream.getPrice());
    }




}