public class Order {

        private int id;
        private Customer customer;
        private Product product;
        private Eshop eshop;
        private int quantity;

        public Order(int id, Customer customer, Product product, Eshop eshop, int quantity) {
            this.id = id;
            this.customer = customer;
            this.product = product;
            this.eshop = eshop;
            this.quantity = quantity;
        }

        public void printOrder() {
            System.out.println("Order ID: " + id);
            System.out.println("Customer: " + customer.getUsername());
            System.out.println("Product: " + product.getName());
            System.out.println("Eshop: " + eshop.getWebshiteName());
            System.out.println("Quantity: " + quantity);
        }
    }

