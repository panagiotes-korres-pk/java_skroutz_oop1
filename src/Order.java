public class Order {

        private int id;
        private Customer customer;
        private Item product;
        private Eshop eshop;
        private int quantity;
        private  int price;

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Item getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public Eshop getEshop() {
        return eshop;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProduct(Item product) {
        this.product = product;
    }

    public void setEshop(Eshop eshop) {
        this.eshop = eshop;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order(int id, Customer customer, Item product, Eshop eshop, int quantity , int price) {
            this.id = id;
            this.customer = customer;
            this.product = product;
            this.eshop = eshop;
            this.quantity = quantity;
            this.price = price;
        }

        public void printOrder() {
            System.out.println("Order ID: " + id);
            System.out.println("Customer: " + customer.getUsername());
            System.out.println("Product: " + product.getName());
            System.out.println("Eshop: " + eshop.getWebshiteName());
            System.out.println("Quantity: " + quantity);
        }
    }

