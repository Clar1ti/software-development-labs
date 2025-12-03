// ИЗМЕНЕНО: заменяем прямую работу с коллекцией на использование репозитория
import java.util.ArrayList;
import java.util.List;

public class TrainManager {
    // ЗАМЕНЕНО: вместо List<Train> trains используем TrainRepository
    private final TrainRepository repository = new TrainRepository();

    public TrainManager() {
        initializeTrains();
    }

    private void initializeTrains() {
        // Поезд 1
        List<Seats> seats1 = new ArrayList<>();
        seats1.add(new Seats(SeatType.GENERAL, 50));
        seats1.add(new Seats(SeatType.COUPE, 20));
        seats1.add(new Seats(SeatType.PLATZKART, 30));
        // ИЗМЕНЕНО: используем метод репозитория вместо прямого добавления
        repository.addTrain(new Train("Москва", 101, new Time(14, 30), seats1));

        // Поезд 2
        List<Seats> seats2 = new ArrayList<>();
        seats2.add(new Seats(SeatType.GENERAL, 40));
        seats2.add(new Seats(SeatType.LUXURY, 10));
        repository.addTrain(new Train("Санкт-Петербург", 202, new Time(18, 45), seats2));

        // Поезд 3
        List<Seats> seats3 = new ArrayList<>();
        seats3.add(new Seats(SeatType.COUPE, 25));
        seats3.add(new Seats(SeatType.PLATZKART, 35));
        repository.addTrain(new Train("Москва", 103, new Time(9, 15), seats3));

        // Поезд 4
        List<Seats> seats4 = new ArrayList<>();
        seats4.add(new Seats(SeatType.GENERAL, 60));
        seats4.add(new Seats(SeatType.LUXURY, 5));
        repository.addTrain(new Train("Казань", 304, new Time(22, 0), seats4));
    }

    // ИЗМЕНЕНО: методы теперь работают через репозиторий
    public List<Train> getTrainsToDestination(String destination) {
        List<Train> result = new ArrayList<>();
        // ЗАМЕНЕНО: trains → repository.getAllTrains()
        for (Train train : repository.getAllTrains()) {
            if (train.getDestination().equalsIgnoreCase(destination)) {
                result.add(train);
            }
        }
        return result;
    }

    public List<Train> getTrainsToDestinationAfterHour(String destination, int hour) {
        List<Train> result = new ArrayList<>();
        for (Train train : repository.getAllTrains()) {
            if (train.getDestination().equalsIgnoreCase(destination) &&
                    train.getDepartureTime().getHours() > hour) {
                result.add(train);
            }
        }
        return result;
    }

    public List<Train> getTrainsWithGeneralSeats(String destination) {
        List<Train> result = new ArrayList<>();
        for (Train train : repository.getAllTrains()) {
            if (train.getDestination().equalsIgnoreCase(destination) &&
                    train.hasGeneralSeats()) {
                result.add(train);
            }
        }
        return result;
    }

    public List<Train> getTrains() {
        // ИСПРАВЛЕНО: возвращаем через репозиторий
        return repository.getAllTrains();
    }

    // НОВЫЕ МЕТОДЫ: для работы с репозиторием (добавление, удаление, изменение)
    public void addTrain(Train train) {
        repository.addTrain(train);
    }

    public boolean removeTrain(int index) {
        return repository.removeTrain(index);
    }

    public boolean updateTrain(int index, Train newTrain) {
        return repository.updateTrain(index, newTrain);
    }

    public int getTrainCount() {
        return repository.getTrainCount();
    }
}