package eu.attempto.zonk;

        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;

        import java.io.IOException;
        import java.net.URL;
        import java.util.logging.Logger;

        import static org.junit.Assert.*;

public class LinkScraperTest {

    URL url;
    @Before
    public void setUp() throws Exception {
        url =this.getClass().getClassLoader().getResource("fbcontent.html");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getContentForValidUrl() {
        String content = "";
        try {
            content = ContentReader.getInstance().getContent(url.toString());
        } catch (IOException e) {
            Logger.getLogger(e.getLocalizedMessage());
        }
        assertTrue("Couldn't load HTML", content.length() > 0);
    }

    @Test
    public void getContentForInvalidUrl() {
        String content = "";
        try {
            content = ContentReader.getInstance().getContent("notexisting.com");
        } catch (IOException e) {
            Logger.getLogger(e.getLocalizedMessage());
        }
        assertFalse("There shouldn't be any HTML content", content.length() > 0);
    }
}