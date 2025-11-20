public class Blooming extends Plant{
    private final double timeBluming;
    public Blooming(String title, double height, double lifetime, double timeBluming){

        super(title, height, lifetime);
        this.timeBluming=timeBluming;
    }

    @Override
    public String toString() {
        return super.toString() + " Продолжительность цветения: " + timeBluming + ", " ;
    }
}
