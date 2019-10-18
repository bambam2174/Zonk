package eu.attempto.zonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ContentReader {
    private static ContentReader single_instance = null;

    // variable of type String
    public String s;

    // private constructor restricted to this class itself
    private ContentReader()
    {
        s = "Hello I am a string part of Singleton class";
    }

    // static method to create instance of Singleton class
    public static ContentReader getInstance()
    {
        if (single_instance == null)
            single_instance = new ContentReader();

        return single_instance;
    }

    public String getContent(String szUrl) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        URL url = new URL(szUrl);
        InputStreamReader reader = new InputStreamReader(url.openStream());
        BufferedReader bufferedReader = new BufferedReader(reader);
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null) {
            stringBuilder.append(inputLine);
        }
        return stringBuilder.toString();
    }
}
