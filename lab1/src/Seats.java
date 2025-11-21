public class Seats {
    private final SeatType type;
    private int number;

    public Seats(SeatType type, int number) {
        this.type = type;
        this.number = number;
    }

    public SeatType getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}