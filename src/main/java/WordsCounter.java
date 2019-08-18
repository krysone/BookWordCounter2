import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

 class WordsCounter {


    protected static void countWords(String text) throws IOException {
        System.out.println(text);

        String[] separateWords = TextSplitter.splittWords(text.toLowerCase());

        Map<String, Integer> occurence = new HashMap<>();
        for (String separateWord : separateWords) {
            if (occurence.containsKey(separateWord)) {
                occurence.replace(separateWord, occurence.get(separateWord) + 1);
            } else
                occurence.put(separateWord, 1);
        }
        Integer maxOccurence = Collections.max(occurence.values());
        String mostFreqKey = null;


            for (Map.Entry<String, Integer> entry : occurence.entrySet()) {
                if (maxOccurence.equals(entry.getValue())) {
                    mostFreqKey = entry.getKey();
                }
            }

        System.out.println("\nthe most frequent word: \"" + mostFreqKey
                + "\", \noccured " + maxOccurence + " times");

        LinkedHashMap<String, Integer> sorted = occurence.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
//        System.out.println(sorted.entrySet().stream().collect(Collections.reverseOrder()));

    }
}
