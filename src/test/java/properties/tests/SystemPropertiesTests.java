package properties.tests;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void systemPropertiesTest() {
        String browser = System.getProperty("browser");
        System.out.println(browser); //null


    }

    @Test
    void systemProperties1Test() {
        System.getProperty("browser", "chrome");
        String browser = System.getProperty("browser");
        System.out.println(browser);

    }
}
