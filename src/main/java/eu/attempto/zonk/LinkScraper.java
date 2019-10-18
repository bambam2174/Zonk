package eu.attempto.zonk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.logging.Logger.getLogger;

public class LinkScraper {

    private LinkScraper() {

    }

    public static List<String> getLinks(String url) {
        if (!url.contains("https://") && !url.contains("http://") && !url.contains("file:/")) {
            url = "https://" + url;
        }
        ArrayList<String> links = new ArrayList<String>();
        String content = "";
        try {
            content = ContentReader.getInstance().getContent(url);
        } catch (IOException e) {
            getLogger("").warning(e.getLocalizedMessage());
            return links;
        }
        Pattern patternHref = Pattern.compile("<a\\shref=\"([^\"]+)");
        Matcher matcherHref = patternHref.matcher(content);

        while (matcherHref.find()) {
            String link = matcherHref.group(1);
            if (!link.startsWith("/")) {
                links.add(matcherHref.group(1));
            } else {
                links.add(url + link);
            }
        }
        return links;
    }
    
}
