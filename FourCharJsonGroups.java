package algorithmproblems;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class FourCharJsonGroups {
    public static void main(String[] args) throws JSONException {
        // The input string
        String myData = "akljeuqohncfjsuiplodurhgdq1h492j3k0akiamhj";
        int j = myData.length(); 

        // Create a JSON object for storing counts
        JSONObject jsonObject = new JSONObject();

        // Loop through the input data to find and count 4-character substrings
        for (int i = 0; i <= j - 4; i++) {
            // Extract a 4-character substring from the input
            String targetKey = myData.substring(i, i + 4);

            if (jsonObject.has(targetKey)) {
                // If the substring is already in the JSON object, increment its count
                int value = jsonObject.getInt(targetKey) + 1;
                jsonObject.put(targetKey, value);
            } else {
                // If the substring is not in the JSON object, add it with a count of 1
                try {
                    jsonObject.put(targetKey, 1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        
        // Get an iterator for the keys and put them in a list
        Iterator<String> keyIterator = jsonObject.keys();
        List<String> keyList = new ArrayList<>();
        while (keyIterator.hasNext()) {
        	keyList.add(keyIterator.next());
        }
        // Insertion sort algorithm
        for (int i = 1; i < keyList.size(); ++i) {
        	String key = keyList.get(i);
        	j = i - 1;
        	
        	// Compare key with the elements before it and move greater elements forward
        	while (j >= 0 && key.compareTo(keyList.get(j)) < 0) {
        		keyList.set(j + 1, keyList.get(j));
        		j = j - 1;
        	}
        	
        	keyList.set(j + 1, key);
        }

        // max, min, and median
        // Minimum (Min)
        String min = keyList.get(0);
        System.out.println("Minimum: " + min);

        // Maximum (Max)
        String max = keyList.get(keyList.size() - 1);
        System.out.println("Maximum: " + max);

        // Median
        int middleIndex = keyList.size() / 2;
        if (keyList.size() % 2 == 0) {
            // Even number of elements, take the average of the two middle elements
            String middle1 = keyList.get(middleIndex - 1);
            String middle2 = keyList.get(middleIndex);
            int median = (Integer.parseInt(middle1) + Integer.parseInt(middle2)) / 2;

            System.out.println("Median: " + median);
        } else {
            // Odd number of elements, the median is the middle element
            String median = keyList.get(middleIndex);
            System.out.println("Median: " + median);
        }
        
        // Iterate over the sorted keys and print them with their counts
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get(i);
            int value = jsonObject.getInt(key);
            System.out.println(key + ": " + value);
        }

    }
}
