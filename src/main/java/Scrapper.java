
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;
import java.net.*;
import java.io.*;



public class Scrapper {
    private WebClient client;
    private String dom;


    public void initScrapper(String url) {
        openBrowser(url);
    }


    public String findElemenByXPath(String xPath) {
        Document doc = Jsoup.parse(dom);
        String result = Xsoup.compile(xPath).evaluate(doc).get();
        return result;
    }

    public String getDom() {
        return dom;
    }


    private void openBrowser(String url) {
        try {
            client = new WebClient(BrowserVersion.FIREFOX_52);
            client.getOptions().setThrowExceptionOnScriptError(false);
            Page page = client.getPage(url);
            String resp = page.getWebResponse().getContentAsString();
            this.dom = resp;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}