import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProuductDef {


    public static void main(String[] args) throws IOException {

        ProductResponse productResponse = new ProductResponse();

        System.out.println("Hi Sandeep");
        String url_test1=
                "https://scotiabank.com/content/experience-fragments/scotiabank/ca/en/conduct/conduct_2_0/test-2/master.html";
        Document document = Jsoup.connect(url_test1).timeout(10*1000).get();


        String title = document.title();
        System.out.println(title);
        Elements elements = document.getAllElements();
        String language = elements.get(1).getAllElements().attr("lang");


        HashMap<String, String> productNames = new HashMap<>();
        HashMap<String, Elements> productElementList = new HashMap<>();
        List<String> proArrayList = new ArrayList<>();
        List<String> conArrayList = new ArrayList<>();



        Elements pageTitle = document.getElementsByClass("bns--title title--h2 text-left");
         pageTitle.stream()
                .forEach(element ->
                {
                // System.out.println(element.getElementsByClass("text-none text-black").select("h2").toString());
                    if(element.getElementsByClass("text-none text-black").select("h2").text().equals("Maturity instructions")){
                      //  productNames.put("Maturity instructions",element.getElementsByClass("text-none text-black").select("h2").text());
                        productElementList.put("Maturity instructions",element.getElementsByClass("text-none text-black").nextAll());
                    }else
                   // productNames.put("productName:",element.getElementsByClass("text-none text-black").select("h2").text());
                    productElementList.put("productName",element.getElementsByClass("text-none text-black"));
                });

         //Fetch the ProList

        Elements proConElements = document.getElementsByClass("cmp-contentfragment");
                  proConElements.stream().
        forEach(element -> {
                   // productNames.put(element.getAllElements().select("p").text(),element.toString());
                   // String proListString = productNames.get("Right for you if:");
                   productElementList.put(element.getAllElements().select("p").text(),element.getAllElements());
                  //  System.out.println(element.getAllElements().select("p").select("ul"));
        });

         //Fetch Maturity List
        Elements elements1 = productElementList.get("Maturity instructions").next();



        Elements proListElement = productElementList.get("Right for you if:");
        Elements conListElement = productElementList.get("Might not be right for you if:");
        //Elements matListElement = productElementList.get("Might not be right for you if:");

       Elements proElementUlList =  proListElement.select("li");
       Elements conElementUlList =  conListElement.select("li");
        //Elements matElementUlList =  matListElement.select("li");



        proElementUlList.stream().forEach(element -> proArrayList.add(element.text()));
        conElementUlList.stream().forEach(element -> conArrayList.add(element.text()));

        productResponse.setProductName(productNames.get("productName"));
        productResponse.setProList(proArrayList);
        productResponse.setConList(conArrayList);
        productResponse.setLanguage(language);
        productResponse.setSubProductName("");

    }




}
