import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class WordsCounter {


    protected static List<Map.Entry<String, Integer>> top5MostFrequentWord(String text) throws IOException {
//        System.out.println(text);

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
                + "\", \noccured " + maxOccurence + " times;");

        List<Map.Entry<String, Integer>> list = new LinkedList<>(occurence.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(final Map.Entry<String, Integer> o1, final Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        try {

            int top = 5;
            int counter = 1;
            for (int i = 1; i < top; i++) {
                counter++;
                System.out.println(counter + ", " + list.get(i) + " times");
            }
        }catch (Exception indexOutOfBound){

        }

        return list;
    }

}
