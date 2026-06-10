public class CartItem {

    private  ItemInEshop itemInEshop;
    private int quantity;

    public CartItem(ItemInEshop itemInEshop, int quantity) {
        this.itemInEshop = itemInEshop;
        this.quantity = quantity;
    }

    public ItemInEshop getItemInEshop() {
        return itemInEshop;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemInEshop(ItemInEshop itemInEshop) {
        this.itemInEshop = itemInEshop;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
