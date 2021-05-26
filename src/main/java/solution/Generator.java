package solution;

import java.security.SecureRandom;

public class Generator {

    public static int generate() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SecureRandom().nextInt(1000000);
    }
}
