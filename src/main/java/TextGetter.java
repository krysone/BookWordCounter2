import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.*;

 class TextGetter {

    protected static String getText(String urlPath) throws IOException {

        URL url = new URL(urlPath);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        System.out.println("Connecting to: " + urlPath);
        System.out.println("Response Code: " + connection.getResponseCode());

        Map<Integer, String> mapHttpErrors = new HashMap<>();

        mapHttpErrors.put(200, "OK - The connection has been established");
        mapHttpErrors.put(303, "See Other");
        mapHttpErrors.put(404, "Not Found");
        mapHttpErrors.put(500, "Internal Server Error");

        if (mapHttpErrors.containsKey(connection.getResponseCode())) {
            System.out.println(mapHttpErrors.get(connection.getResponseCode()) + "\n");
        } else {
            System.out.println("Ooops something went wrong" + "\n");
        }

        List<String> bookTextLineSeparated = new ArrayList<String>();

        Scanner scanner = new Scanner(connection.getInputStream());
        while (scanner.hasNextLine()) {
            bookTextLineSeparated.add(scanner.nextLine());
        }
        scanner.close();
        //solving the end of line and next line lack of space issue here
        StringBuffer stringBuffer = new StringBuffer();
        for (String line : bookTextLineSeparated) {
            String separateLine = line + " ";
            stringBuffer.append(separateLine);
        }
        return stringBuffer.toString();
    }
}
