public abstract class Plant {
protected String title;
protected double height;
protected double lifetime;

public Plant(String title, double height, double lifetime){
    this.title=title;
    this.height=height;
    this.lifetime=lifetime;
}
public double getLifetime(){return lifetime;}
public double getHeight(){return height;}
    @Override
    public String toString() {
        return "Название: " + title + ", Высота: " + height + ", Время жизни: " + lifetime+ " лет";
    }

}
