public class Time {
    private int hours;
    private int minutes;


    public Time(int hours, int minutes) {
        setHours(hours);
        setMinutes(minutes);
    }
    public int getHours(){
        return hours;
    }
    public int getMinutes(){
        return minutes;
    }
    public void setHours(int hours){
    if (hours<0 || hours>23){
        throw new IllegalArgumentException("Часы длолжны быть от 0 до 23 ");
    }
    this.hours=hours;
    }
    public void setMinutes(int minutes){
        if (minutes<0 || minutes>60){
            throw new IllegalArgumentException("Минуть должно быть от 0 до 59");
        }
        this.minutes=minutes;
    }
    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

}