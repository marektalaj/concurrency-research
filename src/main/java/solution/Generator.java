package solution;

import java.security.SecureRandom;

public class Generator {

    public static int generate() {
        try {
            Thread.sleep(2000);
//            System.out.println((Thread.currentThread().getName()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SecureRandom().nextInt(1000000);
    }
}
