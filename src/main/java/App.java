import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by Rustem on 09.08.17.
 */
public class App {

    public static void main(String[] arg0) {
        Scrapper scrapper = new Scrapper();
        scrapper.initScrapper("https://krisha.kz/arenda/kvartiry/astana/?das[live.rooms]=1&das[rent.period]=2");

        Document doc = Jsoup.parse(scrapper.getDom());
        Element rs = doc.getElementsByClass("page-title").get(0);
        System.out.println(rs.text());


    }
}
