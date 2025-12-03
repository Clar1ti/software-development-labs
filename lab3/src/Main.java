import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Plant> plantList = new ArrayList<>();

        // ИЗМЕНЕНО: вынес инициализацию в отдельный метод для лучшей читаемости
        initializePlants(plantList);

        // ИЗМЕНЕНО: разделил логику на методы
        showBloomingPlants(plantList);
        showPlantsWithShortLifetime(plantList);
        searchFernsByHeight(plantList, scanner);

        scanner.close();
    }

    // НОВЫЙ МЕТОД: инициализация списка растений
    private static void initializePlants(List<Plant> plantList) {
        plantList.add(new Blooming("Роза", 0.5, 5.0, 2.0));
        plantList.add(new Blooming("Тюльпан", 0.3, 2.0, 1.0));
        plantList.add(new Blooming("Орхидея", 0.4, 3.0, 4.0));
        plantList.add(new Blooming("Лилия", 0.6, 4.0, 1.5));
        plantList.add(new Succulents("Кактус", 0.2, 10.0));
        plantList.add(new Succulents("Алоэ", 0.4, 8.0));
        plantList.add(new Succulents("Эхеверия", 0.15, 6.0));
        plantList.add(new Succulents("Хавортия", 0.1, 7.0));
        plantList.add(new Fern("Папоротник обыкновенный", 0.7, 3.0));
        plantList.add(new Fern("Нефролепис", 0.5, 4.0));
        plantList.add(new Fern("Адиантум", 0.4, 5.0));
        plantList.add(new Fern("Платицериум", 0.6, 6.0));
    }

    // НОВЫЙ МЕТОД: показ цветущих растений
    private static void showBloomingPlants(List<Plant> plantList) {
        System.out.println("Информация по красиво цветущим цветам");
        for (Plant plant : plantList) {
            if (plant instanceof Blooming) {
                System.out.println(plant);
            }
        }
        System.out.println();
    }

    // НОВЫЙ МЕТОД: показ растений с короткой жизнью
    private static void showPlantsWithShortLifetime(List<Plant> plantList) {
        System.out.println("\nВывод всех растений, продолжительность жизни которых менее 5 лет");
        for (Plant plant : plantList) {
            if (plant.getLifetime() < 5) {
                System.out.println(plant);
            }
        }
        System.out.println();
    }

    // НОВЫЙ МЕТОД: поиск папоротников по высоте
    private static void searchFernsByHeight(List<Plant> plantList, Scanner scanner) {
        System.out.println("\nВывод всех папоротников, высота которых более заданной");
        System.out.println("Введите высоту:");

        double height = 0;
        boolean validInput = false;

        // ИЗМЕНЕНО: улучшено сообщение об ошибке
        while (!validInput) {
            try {
                height = scanner.nextDouble();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ошибка! Пожалуйста, введите число (например: 0.5):");
                scanner.next(); // очистка некорректного ввода
            }
        }

        boolean found = false;
        for (Plant plant : plantList) {
            if (plant instanceof Fern && plant.getHeight() > height) {
                System.out.println(plant);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Папоротников выше " + height + " не найдено.");
        }
    }
}