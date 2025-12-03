// ИСПРАВЛЕНО: переменная timeBluming переименована в bloomingDuration
public class Blooming extends Plant {
    private final double bloomingDuration; // ИСПРАВЛЕНО: было timeBluming

    public Blooming(String title, double height, double lifetime, double bloomingDuration) {
        super(title, height, lifetime);
        this.bloomingDuration = bloomingDuration;
    }

    @Override
    public String toString() {
        // ИСПРАВЛЕНО: убрана лишняя запятая в конце строки
        return super.toString() + " Продолжительность цветения: " + bloomingDuration;
    }
}