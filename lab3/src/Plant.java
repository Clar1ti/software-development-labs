// ИЗМЕНЕНО: добавлен геттер для title для лучшей инкапсуляции
public abstract class Plant {
    protected String title;
    protected double height;
    protected double lifetime;

    public Plant(String title, double height, double lifetime) {
        this.title = title;
        this.height = height;
        this.lifetime = lifetime;
    }

    // НОВЫЙ ГЕТТЕР: для доступа к названию растения
    public String getTitle() {
        return title;
    }

    public double getLifetime() {
        return lifetime;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Название: " + title + ", Высота: " + height + ", Время жизни: " + lifetime + " лет";
    }
}