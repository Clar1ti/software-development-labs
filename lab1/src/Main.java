// Main.java
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrainManager manager = new TrainManager();

        while (true) {
            System.out.println("МЕНЮ: ");
            System.out.println("1. Показать все поезда");
            System.out.println("2. Поиск поездов до города");
            System.out.println("3. Поиск поездов после времени");
            System.out.println("4. Поиск поездов с общими местами");
            System.out.println("0. Выход");
            System.out.print("Выберите действие (0-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    System.out.println("\nВсе доступные поезда");
                    List<Train> allTrains = manager.getTrains();
                    if (allTrains.isEmpty()) {
                        System.out.println("Поездов не найдено");
                    } else {
                        for (int i = 0; i < allTrains.size(); i++) {
                            System.out.println((i + 1) + ". " + allTrains.get(i));
                        }
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.print("\nВведите город назначения: ");
                    String destination2 = scanner.nextLine();

                    System.out.println("\nПоезда до " + destination2.toUpperCase());
                    List<Train> trains2 = manager.getTrainsToDestination(destination2);

                    if (trains2.isEmpty()) {
                        System.out.println("Поездов до '" + destination2 + "' не найдено");
                    } else {
                        for (int i = 0; i < trains2.size(); i++) {
                            System.out.println((i + 1) + ". " + trains2.get(i));
                        }
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.print("\nВведите город назначения: ");
                    String destination3 = scanner.nextLine();

                    System.out.print("Введите время отправления (час от 0 до 23): ");
                    int hour = scanner.nextInt();
                    scanner.nextLine(); // очистка буфера

                    if (hour < 0 || hour > 23) {
                        System.out.println("Ошибка: время должно быть от 0 до 23 часов");
                        break; // return заменен на break
                    }

                    System.out.println("\nПоезда до " + destination3.toUpperCase() + " после " + hour + ":00");
                    List<Train> trains3 = manager.getTrainsToDestinationAfterHour(destination3, hour);

                    if (trains3.isEmpty()) {
                        System.out.println("Поездов до '" + destination3 + "' после " + hour + ":00 не найдено");
                    } else {
                        for (int i = 0; i < trains3.size(); i++) {
                            System.out.println((i + 1) + ". " + trains3.get(i));
                        }
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.print("\nВведите город назначения: ");
                    String destination4 = scanner.nextLine();

                    System.out.println("\nПоезда до " + destination4.toUpperCase() + " с общими местами");
                    List<Train> trains4 = manager.getTrainsWithGeneralSeats(destination4);

                    if (trains4.isEmpty()) {
                        System.out.println("Поездов до '" + destination4 + "' с общими местами не найдено");
                    } else {
                        for (int i = 0; i < trains4.size(); i++) {
                            System.out.println((i + 1) + ". " + trains4.get(i));
                        }
                    }
                    System.out.println();
                    break;

                case 0:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор! Попробуйте снова.\n");
            }

            System.out.println("Нажмите Enter для продолжения...");
            scanner.nextLine();
        }
    }
}