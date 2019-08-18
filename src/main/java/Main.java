import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String urlPath = "https://wolnelektury.pl/media/book/txt/pan-tadeusz.txt";


        String text = TextGetter.getText(urlPath);

//        TextSplitter.splittWords(urlPath);

        String text2 = "lorem ipsum, lorem lorem ipsum lorem hey";
        WordsCounter.countWords(text);
    }
}
