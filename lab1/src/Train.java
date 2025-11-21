
import java.util.List;

public class Train {
    private final String destination;
    private final int trainNumber;
    private final Time departureTime;
    private final List<Seats> seats;

    public Train(String destination, int trainNumber, Time departureTime, List<Seats> seats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.seats = seats;
    }

    public String getDestination() {
        return destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }


    public Time getDepartureTime() {
        return departureTime;
    }

    public List<Seats> getSeats() {
        return seats;
    }

    // Проверка наличия общих мест
    public boolean hasGeneralSeats() {
        for (Seats seat : seats) {
            if (seat.getType() == SeatType.GENERAL && seat.getNumber() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override//переопределить
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Поезд №").append(trainNumber)
                .append(" до ").append(destination)
                .append(", отправление: ").append(departureTime)
                .append(", места: ");

        for (Seats seat : seats) {
            sb.append(seat.getType()).append(": ").append(seat.getNumber()).append("; ");
        }

        return sb.toString();
    }
}