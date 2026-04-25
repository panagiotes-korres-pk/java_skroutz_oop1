public class ItemInEshop  {
     Item item;
     Eshop eshop;
     private int quantity;
     private  int price;

    public ItemInEshop(Item item, Eshop eshop, int quantity, int price) {
        this.item = item;
        this.eshop = eshop;
        this.quantity = quantity;
        this.price = price;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Eshop getEshop() {
        return eshop;
    }

    public void setEshop(Eshop eshop) {
        this.eshop = eshop;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
