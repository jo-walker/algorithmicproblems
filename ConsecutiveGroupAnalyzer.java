package algorithmproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * A class for analyzing consecutive groups of characters in a written file.
 */
public class ConsecutiveGroupAnalyzer {

	public static void main(String[] args) {
	        String filePath = algorithmproblems.Character.FILEPATH ;
	        List<String> consecutiveGroups = findConsecutiveGroupsFromFile(filePath, 4); //groupSize=4

	        // Print the list of consecutive groups
	        System.out.println("Consecutive Groups:");
	        if (consecutiveGroups.isEmpty()) {
	            System.out.println("No consecutive groups of size 4-char found.");
	        } else {
	            for (String group : consecutiveGroups) {
	                System.out.println(group);
	            }
	        }

	        // Find and print max, min, and median groups
	        if (!consecutiveGroups.isEmpty()) {
	            String maxGroup = findMaxGroup(consecutiveGroups);
	            String minGroup = findMinGroup(consecutiveGroups);
	            String medianGroup = findMedianGroup(consecutiveGroups);
	            System.out.println("Max Group: " + maxGroup);
	            System.out.println("Min Group: " + minGroup);
	            System.out.println("Median Group: " + medianGroup);
	        }
	    }
    /**
     * Reads the written file and finds consecutive groups of the given size (4) in the file.
     *
     * @param filePath   The path of the file to read.
     * @param groupSize  The size of the consecutive groups to find.
     * @return           A list of consecutive groups.
     */
	    public static List<String> findConsecutiveGroupsFromFile(String filePath, int groupSize) {
	        List<String> groups = new ArrayList<>();
	        try {
	            FileReader fileReader = new FileReader(filePath);
	            BufferedReader br = new BufferedReader(fileReader);
	            String line;

	            while ((line = br.readLine()) != null) {
	                List<String> lineGroups = findConsecutiveGroupsInLine(line, groupSize);
	                groups.addAll(lineGroups);
	            }
	   	            br.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return groups;
	    }
    /**
     * Finds consecutive groups of a given size in a single line.
     *
     * @param line       The line to search for consecutive groups.
     * @param groupSize  The size of the consecutive groups to find.
     * @return           A list of consecutive groups in the line.
     */
	public static List<String> findConsecutiveGroupsInLine(String line, int groupSize) {
	        List<String> groups = new ArrayList<>();
	        int lineLength = line.length();

	        for (int i = 0; i <= lineLength - groupSize; i++) {
	            String group = line.substring(i, i + groupSize);
	            if (areConsecutiveGroup(group)) {
	                groups.add(group);
	            }
	        }

	        return groups;
	    }
	/**
     * Checks if a substring of a specified size is consecutive based on ASCII values.
     *
     * @param group  The substring to check.
     * @return       True if the substring is consecutive, false otherwise.
     */
	    public static boolean areConsecutiveGroup(String group) {
	        for (int i = 0; i < group.length()-1; i++) {
	            int ascii1 = (int) group.charAt(i);
	            int ascii2 = (int) group.charAt(i + 1);
	            if (ascii2 - ascii1 != 1) {
	                return false;
	            }
	        }
	        return true;
	    }
/**
 * Finds the maximum group (with the most occurrences) in a list of groups.
 *
 * @param groups  The list of groups to analyze.
 * @return        The maximum group.
 */
	    public static String findMaxGroup(List<String> groups) {
	        String maxGroup = groups.get(0);
	        int maxOccur = 1;

	        for (int i = 0; i < groups.size() - 1; i++) {
	            String currentGroup = groups.get(i);
	            int occurrences = 1;

	            for (int j = i + 1; j < groups.size(); j++) {
	                if (currentGroup.equals(groups.get(j))) {
	                    occurrences++;
	                }
	            }

	            if (occurrences > maxOccur) {
	                maxOccur = occurrences;
	                maxGroup = currentGroup;
	            }
	        }

	        return maxGroup;
	    }
/**
 * Finds the minimum group (with the fewest occurrences) in a list of groups.
 *
 * @param groups  The list of groups to analyze.
 * @return        The minimum group.
 */
	    public static String findMinGroup(List<String> groups) {
	        String minGroup = groups.get(0);
	        int minOccur = 1;

	        for (int i = 0; i < groups.size() - 1; i++) {
	            String currentGroup = groups.get(i);
	            int occurrences = 1;

	            for (int j = i + 1; j < groups.size(); j++) {
	                if (currentGroup.equals(groups.get(j))) {
	                    occurrences++;
	                }
	            }

	            if (occurrences < minOccur) {
	                minOccur = occurrences;
	                minGroup = currentGroup;
	            }
	        }

	        return minGroup;
	    }


/**
 * Finds the median group based on the occurrences in a list of groups.
 *
 * @param groups  The list of groups to analyze.
 * @return        The median group.
 * @throws IllegalArgumentException if the list is empty.
 */
	public static String findMedianGroup(List<String> groups) {
        int size = groups.size();
        if (size == 0) {
            throw new IllegalArgumentException("List is empty. Cannot find median.");
        }

        int medianIndex = size / 2;
        return groups.get(medianIndex);
    }


/**
 * Counts the occurrences of a target group in a list of groups.
 *
 * @param groups  The list of groups to analyze.
 * @param target  The target group to count occurrences of.
 * @return        The count of occurrences of the target group.
 */
	public static int groupOccurrences(List<String> groups, String target) {
        int count = 0;
        for (String group : groups) {
            if (group.equals(target)) {
                count++;
            }
        }
        return count;
    }

/**
 * Checks if four characters are consecutive based on ASCII values.
 *
 * @param char1  The first character.
 * @param char2  The second character.
 * @param char3  The third character.
 * @param char4  The fourth character.
 * @return       True if the characters are consecutive, false otherwise.
 */
	public static boolean areConsecutive(char char1, char char2, char char3, char char4) {
        int ascii1 = (int) char1;
        int ascii2 = (int) char2;
        int ascii3 = (int) char3;
        int ascii4 = (int) char4;
        return (ascii2 - ascii1 == 1) && (ascii3 - ascii2 == 1) && (ascii4 - ascii3 == 1);
    }
}
