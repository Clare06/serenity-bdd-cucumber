package starter.testsetup;

import io.cucumber.java.BeforeAll;
import io.github.cdimascio.dotenv.Dotenv;

public class GlobalTestSetUp {
    private static Dotenv dotenv;

    @BeforeAll
    public static void setup() {
        dotenv = Dotenv.load();
    }

    public static String getEnvData(String key) {
        return dotenv.get(key);
    }
}
