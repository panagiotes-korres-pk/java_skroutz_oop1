public class Eshop {

    private String webshiteName;
    private String afm;
    private  String email;

    public Eshop(String webshiteName, String afm, String email) {
        this.webshiteName = webshiteName;
        this.afm = afm;
        this.email = email;

    }

    public String getWebshiteName() {
        return webshiteName;
    }

    public String getAfm() {
        return afm;
    }

    public String getEmail() {
        return email;
    }
}
