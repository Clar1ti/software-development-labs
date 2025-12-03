// ИЗМЕНЕНО: улучшена обработка ввода и структура кода
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrainManager manager = new TrainManager();

        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Показать все поезда");
            System.out.println("2. Поиск поездов до города");
            System.out.println("3. Поиск поездов после времени");
            System.out.println("4. Поиск поездов с общими местами");
            System.out.println("0. Выход");
            System.out.print("Выберите действие (0-4): ");

            // ИЗМЕНЕНО: улучшенная обработка ввода числа
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число от 0 до 4");
                continue;
            }

            // ИЗМЕНЕНО: заменен switch на switch с лямбдами для читаемости
            switch (choice) {
                case 1 -> showAllTrains(manager);
                case 2 -> searchByDestination(manager, scanner);
                case 3 -> searchAfterTime(manager, scanner);
                case 4 -> searchWithGeneralSeats(manager, scanner);
                case 0 -> {
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // НОВЫЙ МЕТОД: вынесена логика показа всех поездов
    private static void showAllTrains(TrainManager manager) {
        System.out.println("\n=== ВСЕ ПОЕЗДА ===");
        List<Train> allTrains = manager.getTrains();
        if (allTrains.isEmpty()) {
            System.out.println("Поездов не найдено");
        } else {
            for (int i = 0; i < allTrains.size(); i++) {
                System.out.println((i + 1) + ". " + allTrains.get(i));
            }
        }
    }

    // НОВЫЙ МЕТОД: вынесена логика поиска по направлению
    private static void searchByDestination(TrainManager manager, Scanner scanner) {
        System.out.print("\nВведите город назначения: ");
        String destination = scanner.nextLine();

        System.out.println("\nПоезда до " + destination.toUpperCase() + ":");
        List<Train> trains = manager.getTrainsToDestination(destination);

        printTrains(trains);
    }

    // НОВЫЙ МЕТОД: вынесена логика поиска по времени
    private static void searchAfterTime(TrainManager manager, Scanner scanner) {
        System.out.print("\nВведите город назначения: ");
        String destination = scanner.nextLine();

        System.out.print("Введите время отправления (час от 0 до 23): ");
        int hour;
        try {
            hour = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите целое число");
            return;
        }

        if (hour < 0 || hour > 23) {
            System.out.println("Ошибка: время должно быть от 0 до 23 часов");
            return;
        }

        System.out.println("\nПоезда до " + destination.toUpperCase() + " после " + hour + ":00");
        List<Train> trains = manager.getTrainsToDestinationAfterHour(destination, hour);

        printTrains(trains);
    }

    // НОВЫЙ МЕТОД: вынесена логика поиска по общим местам
    private static void searchWithGeneralSeats(TrainManager manager, Scanner scanner) {
        System.out.print("\nВведите город назначения: ");
        String destination = scanner.nextLine();

        System.out.println("\nПоезда до " + destination.toUpperCase() + " с общими местами:");
        List<Train> trains = manager.getTrainsWithGeneralSeats(destination);

        printTrains(trains);
    }

    // НОВЫЙ МЕТОД: общая функция для вывода списка поездов
    private static void printTrains(List<Train> trains) {
        if (trains.isEmpty()) {
            System.out.println("Поездов не найдено");
        } else {
            for (int i = 0; i < trains.size(); i++) {
                System.out.println((i + 1) + ". " + trains.get(i));
            }
        }
    }
}