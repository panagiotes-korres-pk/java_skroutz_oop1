// δημιουργια scanner για input
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Πινακες αποθηκευσης
        Item[] items = new Item[100];
        Eshop[] eshops = new Eshop[50];
        ItemInEshop[] listings = new ItemInEshop[200];

        // μετρητες στοιχειων
        int itemCount = 0;
        int eshopCount = 0;
        int itemInEshopCount = 0;

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
        String search = sc.nextLine();

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


        for (int i =0 ; i <itemInEshopCount; i ++){
            if (listings[i].getEshop() == selectedEshop &&
            listings[i].getItem().getBarcode().equals(code)){
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

