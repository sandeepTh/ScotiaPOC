import java.util.List;

public class ProductResponse {

    private String productName;
    private String subProductName;
    private String language;
    private List<String> proList;
    private List<String> conList;
    private List<String> maturityList;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSubProductName() {
        return subProductName;
    }

    public void setSubProductName(String subProductName) {
        this.subProductName = subProductName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getProList() {
        return proList;
    }

    public void setProList(List<String> proList) {
        this.proList = proList;
    }

    public List<String> getConList() {
        return conList;
    }

    public void setConList(List<String> conList) {
        this.conList = conList;
    }

    public List<String> getMaturityList() {
        return maturityList;
    }

    public void setMaturityList(List<String> maturityList) {
        this.maturityList = maturityList;
    }
}
