public class Clothes extends Item {
    private int size;
    private String color;

    public Clothes(String barcode, String name, String category, String brandName, int size, String color) {
        super(barcode, name, category, brandName);
        this.size = size;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}
