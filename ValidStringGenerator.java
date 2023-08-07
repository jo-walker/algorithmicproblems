package algorithmproblems;
import java.util.Random;

public class ValidStringGenerator {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String validString = generateValidString();
            System.out.println(validString);
        }
    }

    public static String generateValidString() {
        char[] pool = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] result = new char[256];
        Random random = new Random();

        for (int i = 0; i < 256; i++) {
            char currentChar;
            boolean validCharFound = false;

            while (!validCharFound) {
                currentChar = pool[random.nextInt(pool.length)];

                if (i >= 2 && (currentChar == result[i - 1] || currentChar == result[i - 2])) {
                    continue;
                }

                if (i >= 3 && currentChar == result[i - 3]) {
                    continue;
                }

                validCharFound = true;
                result[i] = currentChar;
            }
        }

        return new String(result);
    }
}
