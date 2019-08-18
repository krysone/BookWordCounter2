import java.io.IOException;

 class TextSplitter {

    protected static String[] splittWords(String text) throws IOException {

        String separators = "[^\\p{L}0-9']+";
        String[] separateWords = text.split(separators);

        return separateWords;
    }
}
