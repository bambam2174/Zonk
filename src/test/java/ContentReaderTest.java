package eu.attempto.zonk;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.List;
import static org.junit.Assert.*;

import static java.util.logging.Logger.getLogger;

public class ContentReaderTest {
    URL url;
    @Before
    public void setUp() throws Exception {
        ClassLoader x = this.getClass().getClassLoader();
        System.out.println("HERE->Classloader " + x.toString());
        getLogger("xHERE->Classloader " + x.toString());
        url =this.getClass().getClassLoader().getResource("fbcontent.html");
        if (url == null) {
            throw new Exception("Can't get the content of the test html content");
        } else {
            System.out.println("HERE->URL = " + url.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        url = null;
    }

    @Test
    public void getLinksForValidUrl() {
        List<String> links;
        links = LinkScraper.getLinks(url.toString());
        assertTrue("There are no links", links.size() > 0);
    }

    @Test
    public void getLinksForInvalidUrl() {
        List<String> links;
        links = LinkScraper.getLinks("notexisting.com");
        assertFalse("There are no links", links.size() > 0);
    }
}
