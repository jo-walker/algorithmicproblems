import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileToJSON {

    public static void main(String[] args) {
        ArrayList<String> strings = readStringsFromFile("D:\Ideabytes_Projects\algorithmproblems\100Strings.txt");
        String jsonArrayString = convertToJSONArrayString(strings);
        System.out.println(jsonArrayString);
    }

    public static ArrayList<String> readStringsFromFile(String filePath) {
        ArrayList<String> strings = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings;
    }

    public static String convertToJSONArrayString(ArrayList<String> strings) {
        Gson gson = new Gson();
        JsonArray jsonArray = new JsonArray();

        for (String str : strings) {
            jsonArray.add(str);
        }

        return gson.toJson(jsonArray);
    }
}