package us.mattgreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    //private final static FileInput indata = new FileInput("newtext.txt");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();
    Map<String, List<Main>> counts = new HashMap<String, List<Main>>();
    Map<String, Integer> frequency = new HashMap<>();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        String line;
        String[] words;
        ArrayList<Integer> wordCounts = new ArrayList<>();
        int count = 0;
        String currentWord = "the";
        while ((line = indata.fileReadLine()) != null) {
            // Remove anything that's not a letter or space
            line = line.replaceAll("[^a-zA-Z ]", "")
                    .toLowerCase().trim();

            // Don't process lines with no characters
            if (line.isEmpty()) {
                continue;
            }

            // Split string over one or more spaces
            words = line.split(" +");

            // Look for each word in the map
            for (String word : words) {
                // This word isn't yet a key, init count to 1
                if (word == null || word.trim().equals("")) {
                    continue;
                }
                String processed = word.toLowerCase();
                if (frequency.containsKey(processed)) {
                    frequency.put(processed, frequency.get(processed) + 1);
                } else {
                    frequency.put(processed, 1);
                }
            }
            // Loop over entries in the map, getting each key/value pair

        }

        //System.out.println(frequency);
        int mostFrequentlyUsed = 0;
        String theWord = null;
        int countSingles = 0;
        for (String word : frequency.keySet()) {
            Integer theVal = frequency.get(word);
            if (theVal > mostFrequentlyUsed) {
                mostFrequentlyUsed = theVal;
                theWord = word;
            }

        }
        //System.out.println("These only have 1 occurrence");
        int countSingleWords = 0;
        for (Map.Entry<String, Integer> item : frequency.entrySet()) {
            if (item.getValue() == 1) {
                //System.out.println(item.getKey());
                countSingleWords++;
            }

        }
        System.out.println(countSingleWords + " words were only used once.");
        System.out.println("The most frequently used word is \"" + theWord + "\" which had " + mostFrequentlyUsed + " occurrences.");
    }
}
