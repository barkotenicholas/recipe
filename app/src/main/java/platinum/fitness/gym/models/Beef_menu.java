package platinum.fitness.gym.models;

public class Beef_menu {
    public int image;
    public String menu_item;
    public String type;
    public int price;

    public Beef_menu(int image, String menu_item, String type, int price) {
        this.image = image;
        this.menu_item = menu_item;
        this.type = type;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMenu_item() {
        return menu_item;
    }

    public void setMenu_item(String menu_item) {
        this.menu_item = menu_item;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
