package platinum.fitness.gym.models;

public class Meal {
    public String Meal;
    private int image;

    public Meal(String meal, int image) {
        Meal = meal;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMeal() {
        return Meal;
    }

    public void setMeal(String meal) {
        Meal = meal;
    }
}
