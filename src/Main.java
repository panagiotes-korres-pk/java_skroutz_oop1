import java.util. Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Item[] items = new Item[100];
        Eshop[] eshops = new Eshop[50];
        ItemInEshop[] listings = new ItemInEshop[200];

        int itemCount = 0;
        int eshopCount = 0;
        int itemInEshopCount = 0;

        items[itemCount] = new Item("16363", "chair", "epipla", "ikea");
        itemCount++;

        eshops[eshopCount] = new Eshop("pinterest", "188016985", "pinterest@gmail.com");
        eshopCount++;

        for (int i = 0; i < eshopCount; i++) {
            System.out.println(eshops[i].getAfm() + " " + eshops[i].getWebshiteName());
        }

        Item item = items[0];
        Eshop eshop = eshops[0];

        int quantity = 50;
        int price = 20;
        boolean found = false;

        for (int i = 0; i < itemInEshopCount; i++) {
            if (listings[i].getItem() == item && listings[i].getEshop() == eshop) {
                listings[i].setQuantity(quantity);
                listings[i].setPrice(price);
                found = true;
                break;
            }
        }

        if (!found) {
            listings[itemInEshopCount] = new ItemInEshop(items[0], eshops[0], 49, 25);
            itemInEshopCount++;
        }
        System.out.println(eshop.getWebshiteName());
        System.out.println(item.getName());
        System.out.println(quantity);
        System.out.println(price);


        Eshop selectedEshop = null;
        String search = sc.nextLine();

        for (int i = 0; i < eshopCount; i++) {
            if (eshops[i].getAfm().equals(search) || eshops[i].getWebshiteName().equals(search)) {
                selectedEshop = eshops[i];
                break;
            }
        }

        if (selectedEshop == null) {
            System.out.println("not found");
        } else {
            System.out.println(selectedEshop.getWebshiteName());
        }

        for (int i = 0; i < itemInEshopCount; i++) {
            if (listings[i].getEshop() == selectedEshop) {

                Item item1 = listings[i].getItem();

                System.out.println(item1.getBarcode());
                System.out.println(item1.getName());
                System.out.println(item1.getCategory());
                System.out.println(listings[i].getQuantity());

                if (item1 instanceof Clothes) {
                    Clothes c = (Clothes) item1;
                    System.out.println(c.getSize());
                    System.out.println(c.getColor());
                }
                if (item1 instanceof Shoe) {
                    Shoe  sh = (Shoe) item1;
                    System.out.println(sh.getSize());
                    System.out.println(sh.getColor());
                }
            }
        }
    }
}