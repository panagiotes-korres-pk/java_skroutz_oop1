// δημιουργια scanner για input
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class it2024134 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Πινακες αποθηκευσης
        Item[] items = new Item[100];
        Eshop[] eshops = new Eshop[50];
        ItemInEshop[] listings = new ItemInEshop[200];
        CartItem [] cart = new CartItem[100];
        Customer [] customers = new Customer[100];
        Order [] orders = new Order[100];

        // μετρητες στοιχειων
        int itemCount = 0;
        int eshopCount = 0;
        int itemInEshopCount = 0;
        int cartCount = 0;
        int customerCount = 0;
        int orderCount = 0;

        // καταχωριση αρχικων δεδομενων
        items[itemCount++] = new Item("16363", "chair", "epipla", "ikea");
        eshops[eshopCount++] = new Eshop("pinterest", "188016985", "pinterest@gmail.com");

        // εμφανιση διαθεσιμων eshops
        for (int i = 0; i < eshopCount; i++) {
            System.out.println(eshops[i].getAfm() + " " + eshops[i].getWebshiteName());
        }

        // επιλογη ενοσ προιοντος και ενος eshop
        Item item = items[0];
        Eshop eshop = eshops[0];

        // Δοκιμαστικός χρήστη
        customers[customerCount++] =
                new Customer("Panos",
                        "panos@gmail.com",
                        "panos",
                        "1234");
        int quantity = 50;
        int price = 20;
        boolean found = false;

        // ελεγχος αν το προιον υπαρχει ηδη στο συγκεκριμενο eshop
        for (int i = 0; i < itemInEshopCount; i++) {
            if (listings[i].getItem() == item && listings[i].getEshop() == eshop) {
                listings[i].setQuantity(quantity);
                listings[i].setPrice(price);
                found = true;
                break;
            }
        }
        int count = 0;

        for (int i = 0; i < itemInEshopCount; i++) {
            if (listings[i].getItem() == item) {
                count++;
            }
        }

        // Περιορισμος max 4 eshops ανα προϊον
        if (count >= 4) {
            System.out.println("To proion yparxei idi se 4 eshops");
            return;
        }
        if (!found) {
            listings[itemInEshopCount] = new ItemInEshop(items[0], eshops[0], 49, 25);
            itemInEshopCount++;
        }
        // εμφανιση στοιχειων καταχωρισης
        System.out.println(eshop.getWebshiteName());
        System.out.println(item.getName());
        System.out.println(quantity);
        System.out.println(price);


        //  Αναζητηση eshop με ΑΦΜ ή website
        System.out.println("Dose AFM i website:");
        String search = sc.nextLine().trim();

        Eshop selectedEshop = null;

        for (int i = 0; i < eshopCount; i++) {
            if (eshops[i].getAfm().equals(search) || eshops[i].getWebshiteName().equals(search)) {
                selectedEshop = eshops[i];
                break;
            }
        }
        // ελεγχος αν βρεθηκε το eshop
        if (selectedEshop == null) {
            System.out.println("not found");
            return;
        } else {
            System.out.println(selectedEshop.getWebshiteName());
        }
        // εμφανιση προιοντων του eshop
        showProducts(listings, itemInEshopCount, selectedEshop);
        // ενημερωση αποθεματος προιοντος
        System.out.println("give me a barcode");
        String code = sc.nextLine();
        boolean foundItem = false;


        for (int i = 0; i < itemInEshopCount; i++) {
            if (listings[i].getEshop() == selectedEshop &&
                    listings[i].getItem().getBarcode().equals(code)) {
                System.out.println("dose apothema");

                System.out.println("dose neo apothema");

                if (!sc.hasNextInt()) {
                    System.out.println("Prepei na doseis arithmo");
                    return;
                }

                int newQuantity = sc.nextInt();
                sc.nextLine();

                if (newQuantity < 0) {
                    System.out.println("Mi egkyro apothema");
                    return;
                }
                //ενημερωση ποσοτητας
                listings[i].setQuantity(newQuantity);
                foundItem = true;
                break;

            }
        }
        // ελεγχος αν βρεθηκε το προιον
        if (!foundItem) {
            System.out.println("den vrethike to proion");
        }

        // 3η λειτουργια

        System.out.println("dose onoma i katigoria");
        String SearchProducts = sc.nextLine();

        for (int i = 0; i < itemCount; i++) {
            Item currentItem = items[i];
            if (currentItem.getName().equalsIgnoreCase(SearchProducts)
                    || currentItem.getCategory().equalsIgnoreCase(SearchProducts)) {
                int shopCount = 0;
                double minPrice = Double.MAX_VALUE;

                for (int j = 0; j < itemInEshopCount; j++) {
                    if (listings[j].getItem() == currentItem) {
                        shopCount++;
                        if (listings[j].getPrice() < minPrice) {
                            minPrice = listings[j].getPrice();
                        }
                    }
                }

                System.out.println("Barcode: " + currentItem.getBarcode());
                System.out.println("Name: " + currentItem.getName());
                System.out.println("Shops: " + shopCount);
                System.out.println("Lowest Price: " + minPrice);
                System.out.println("-------------------");
            }
        }

        System.out.println("Dose barcode");
        String selectBarcode = sc.nextLine();
        Item selectedItem = null;
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getBarcode().equals(selectBarcode)){
                selectedItem = items[i];
                break;
            }
        }

        if (selectedItem == null){
            System.out.println("item not found");
            return;
        }

        System.out.println("available eshops ");
        for (int i = 0; i < itemInEshopCount; i++) {
            if (listings[i].getItem() == selectedItem) {
                System.out.println("Website: "
                        + listings[i].getEshop().getWebshiteName());

                System.out.println("Product: "
                        + listings[i].getItem().getName());

                System.out.println("Price: "
                        + listings[i].getPrice());

                System.out.println("Stock: "
                        + listings[i].getQuantity());

                System.out.println("----------------");
            }
        }

        System.out.println("dose website apo opou thes na agoraseis");
        String selectedWebsite = sc.nextLine().trim();

        System.out.println("dose posotia");
        int  buyQuantity = sc.nextInt();
        sc.nextLine();

        ItemInEshop selectedListing = null;

        for (int i = 0; i < itemInEshopCount; i++) {
            if (listings[i].getItem() == selectedItem &&
            listings[i].getEshop().getWebshiteName().equalsIgnoreCase(selectedWebsite)){
                selectedListing =  listings[i];
                break;
            }
        }

        if(selectedListing == null){
            System.out.println("den vrethike proin sto eshop auto");
            return;
        }if ( buyQuantity <= 0){
            System.out.println("Mi egkyro apothema");
            return;
        }

        if (buyQuantity > selectedListing.getQuantity()){
            System.out.println("den yoarxei arketo apothema");
            return ;
        }

        cart[cartCount] = new CartItem(selectedListing , buyQuantity);
        cartCount++;

        System.out.println("To proion mpike sto kalathi");


        for (int i = 0; i < cartCount; i++) {
            System.out.println("Product: " + cart[i].getItemInEshop().getItem().getName());
            System.out.println("Website: " + cart[i].getItemInEshop().getEshop().getWebshiteName());
            System.out.println("Price: " + cart[i].getItemInEshop().getPrice());
            System.out.println("Quantity: " + cart[i].getQuantity());
            System.out.println("----------------");
        }



        System.out.println("kalathi");
        System.out.println("Product: " + selectedListing.getItem().getName());
        System.out.println("Website: " + selectedListing.getEshop().getWebshiteName());
        System.out.println("Price: " + selectedListing.getPrice());
        System.out.println("Quantity: " + buyQuantity);

        System.out.println("Login");
        System.out.println("Username:");
        String username = sc.nextLine();

        System.out.println("Password:");
        String password = sc.nextLine();

        Customer loggedCustomer = null;

        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getUsername().equals(username)
                    && customers[i].getPassword().equals(password)) {

                loggedCustomer = customers[i];
                break;
            }
        }

        if (loggedCustomer == null) {
            System.out.println("Lathos username i password");
            return;
        }

        System.out.println("Kalos irthes " + loggedCustomer.getName());

        System.out.println("theleies na epivevaioseiw paraggelia yes/no");
        String confirm = sc.nextLine();

        if (!confirm.equalsIgnoreCase("Yes")){
            System.out.println("i paraggelia akirothike");
            return;
        }

        // meiosi apothematos

        for (int i = 0; i < cartCount; i++) {
            ItemInEshop listing = cart[i].getItemInEshop();
            int newstock = listing.getQuantity() - cart[i].getQuantity();
            listing.setQuantity(newstock);
        }

        System.out.println("I paraggelia oloklirothike");

        Order order = new Order(
                orderCount + 1,
                loggedCustomer,
                selectedListing.getItem(),
                selectedListing.getEshop(),
                buyQuantity,
                (int) selectedListing.getPrice()
        );

        orders[orderCount] = order;
        orderCount++;

        order.printOrder();


        System.out.println("Neo apothema:");

        for (int i = 0; i < cartCount; i++) {
            System.out.println("Product: " + cart[i].getItemInEshop().getItem().getName());
            System.out.println("Website: " + cart[i].getItemInEshop().getEshop().getWebshiteName());
            System.out.println("New stock: " + cart[i].getItemInEshop().getQuantity());
            System.out.println("----------------");
        }

    // 4η λειτουργια

        System.out.println("Dose username gia istoriko paraggelion:");
        String searchUsername = sc.nextLine();

        boolean foundOrder = false;

        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getCustomer().getUsername().equals(searchUsername)) {
                orders[i].printOrder();
                foundOrder = true;
            }
        }

        if (!foundOrder) {
            System.out.println("Den vrethikan paraggelies gia auton ton pelati");
        }

        System.out.println("Synoliki anaφορά e-shops:");

        for (int i = 0; i < itemInEshopCount; i++) {
            System.out.println("Website: " + listings[i].getEshop().getWebshiteName());
            System.out.println("Product: " + listings[i].getItem().getName());
            System.out.println("Stock: " + listings[i].getQuantity());
            System.out.println("Price: " + listings[i].getPrice());
            System.out.println("----------------");
        }

        System.out.println("Synoliki anaφορά proionton:");

        for (int i = 0; i < itemCount; i++) {
            Item currentItem = items[i];

            int shopCount = 0;
            double minPrice = Double.MAX_VALUE;
            int orderTimes = 0;

            for (int j = 0; j < itemInEshopCount; j++) {
                if (listings[j].getItem() == currentItem) {
                    shopCount++;

                    if (listings[j].getPrice() < minPrice) {
                        minPrice = listings[j].getPrice();
                    }
                }
            }

            for (int j = 0; j < orderCount; j++) {
                if (orders[j].getProduct() == currentItem) {
                    orderTimes++;
                }
            }

            System.out.println("Barcode: " + currentItem.getBarcode());
            System.out.println("Name: " + currentItem.getName());
            System.out.println("Eshops: " + shopCount);
            System.out.println("Lowest price: " + minPrice);
            System.out.println("Orders: " + orderTimes);
            System.out.println("----------------");
        }



        try {
            FileWriter writer = new FileWriter("eshops_report.txt");

            for (int i = 0; i < eshopCount; i++) {
                Eshop currentEshop = eshops[i];

                int differentProducts = 0;
                int totalOrders = 0;
                double totalIncome = 0;

                for (int j = 0; j < itemInEshopCount; j++) {
                    if (listings[j].getEshop() == currentEshop) {
                        differentProducts++;
                    }
                }

                for (int j = 0; j < orderCount; j++) {
                    if (orders[j].getEshop() == currentEshop) {
                        totalOrders++;
                        totalIncome += orders[j].getQuantity() * orders[j].getPrice();
                    }
                }

                writer.write(
                        currentEshop.getWebshiteName() + ", " +
                                currentEshop.getAfm() + ", " +
                                differentProducts + ", " +
                                totalOrders + ", " +
                                totalIncome + " euro\n"
                );
            }

            writer.close();
            System.out.println("To arxeio eshops_report.txt dimiourgithike");

        } catch (IOException e) {
            System.out.println("Sfalma kata tin apothikeusi sto arxeio");
        }


    }


   // μεθοδοσ εμφανισης προιοντος ενος eshop
    public static void showProducts(ItemInEshop[] listings, int count, Eshop eshop) {
        for (int i = 0; i < count; i++) {
            if (listings[i].getEshop() == eshop) {

                Item item = listings[i].getItem();
                // εμφανιση βασικων στοιχειων προιοντος
                System.out.println(item.getBarcode());
                System.out.println(item.getName());
                System.out.println(item.getCategory());
                System.out.println(listings[i].getQuantity());

                // ελεγχος αν ειααι ρουχο
                if (item instanceof Clothes) {
                    Clothes c = (Clothes) item;
                    System.out.println(c.getSize());
                    System.out.println(c.getColor());
                }
               // ελεγχος αν ειναι υποδημα
                if (item instanceof Shoe) {
                    Shoe s = (Shoe) item;
                    System.out.println(s.getSize());
                    System.out.println(s.getColor());
                    System.out.println("---------------");
                }
            }
        }

        }


}

