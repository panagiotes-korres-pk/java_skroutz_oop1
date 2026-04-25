//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Item [] items  = new Item[100];
        Eshop [] eshops = new Eshop[50];
        ItemInEshop[] listings = new ItemInEshop[200];

        int itemCount = 0;
        int eshopCount = 0;
        int itemInEshopCount = 0;

        items[itemCount] = new Item("16363" , "chair" , "epipla" , "ikea");
        itemCount++;

        eshops[eshopCount] = new Eshop("pinterest" , "188016985" , "pinterest@gmail.com");
        eshopCount++;


    }
}