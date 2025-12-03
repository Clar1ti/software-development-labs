import java.util.ArrayList;
import java.util.List;

/**
 * Класс-репозиторий для управления коллекцией поездов
 * Содержит коллекцию экземпляров иерархии и методы для работы с ней
 */
public class TrainRepository {
    // КОЛЛЕКЦИЯ ЭКЗЕМПЛЯРОВ ИЕРАРХИИ: список поездов
    private final List<Train> trains = new ArrayList<>();

    // МЕТОД ДОБАВЛЕНИЯ: добавляет поезд в коллекцию
    public void addTrain(Train train) {
        if (train != null) {
            trains.add(train);
        }
    }

    // МЕТОД УДАЛЕНИЯ: удаляет поезд по индексу
    public boolean removeTrain(int index) {
        if (index >= 0 && index < trains.size()) {
            trains.remove(index);
            return true;
        }
        return false;
    }

    // МЕТОД ИЗМЕНЕНИЯ: изменяет поезд по индексу
    public boolean updateTrain(int index, Train newTrain) {
        if (index >= 0 && index < trains.size() && newTrain != null) {
            trains.set(index, newTrain);
            return true;
        }
        return false;
    }

    // Дополнительные методы для работы с коллекцией
    public List<Train> getAllTrains() {
        return new ArrayList<>(trains); // Возвращаем копию для защиты от внешних изменений
    }

    public Train getTrain(int index) {
        if (index >= 0 && index < trains.size()) {
            return trains.get(index);
        }
        return null;
    }

    public int getTrainCount() {
        return trains.size();
    }
}