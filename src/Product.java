public class Product {

    private String barcode;
    private String name;
    private String category;
    private String brandName;

    public Product(String barcode, String name, String category, String brandName) {
        this.barcode = barcode;
        this.name = name;
        this.category = category;
        this.brandName = brandName;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getBrandName() {
        return brandName;
    }
}
