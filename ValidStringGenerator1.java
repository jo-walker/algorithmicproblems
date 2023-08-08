package algorithmproblems;
import java.util.Random;
import java.io.IOException;
import java.io.FileWriter;

public class ValidStringGenerator1 {

    public static void main(String[] args) {
        //for (int i = 0; i < 100; i++) {
            String validString = generateValidString();
            System.out.println(validString);
            writeToFile(validString); 
        //}
    }

    public static String generateValidString() {
        char[] pool = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String result = ""; //initializeing an empty string
        Random random = new Random();

        while (result.length() < 256) { //    while loop based on the string length
            char currentChar;
            boolean validCharFound = false;

            while (!validCharFound) {
                currentChar = pool[random.nextInt(pool.length)];

                //adjacent characters within 2 indeces
                if (result.length() >= 2 && (currentChar == result.charAt(result.length() - 1)
                        || currentChar == result.charAt(result.length() - 2))) {
                    continue;
                }

                // Check for the character 3 indeces ago
                if (result.length() >= 3 && currentChar == result.charAt(result.length() - 3)) {
                    continue;
                }

                validCharFound = true;
                result+=currentChar; // appnde character to StringBuilder
            }
        }

        return result;
    }
    public static void writeToFile(String content) {
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write(content); // Write the content to the text file
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
