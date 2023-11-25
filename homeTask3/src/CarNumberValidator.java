import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNumberValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите регистрационный номер автомобиля или 'exit' для выхода:");

        while (true) {
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("EXIT")) {
                System.out.println("Программа завершена.");
                break;
            }

            validateCarNumber(input);
        }

        scanner.close();
    }

    // Метод для валидации регистрационного номера автомобиля
    private static void validateCarNumber(String carNumber) {
        // Удаление пробелов и символа 'RUS'
        carNumber = carNumber.replaceAll("\\s+|RUS", "");

        // Проверка формата номера
        if (!isValidFormat(carNumber)) {
            return;
        }

        // Извлечение региона и вывод результата
        String region = extractRegion(carNumber);

        if (!region.equals("")) {
            System.out.println("Номер зарегистрирован в регионе: " + region);
        } else {
            System.out.println("Ошибка: Регион не найден.");
        }
    }

    // Метод для проверки соответствия номера заданному формату
    private static boolean isValidFormat(String carNumber) {
        // Регулярное выражение для проверки формата номера
        String regex = "[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(carNumber);

        // Проверка наличия недопустимых символов в номере
        if (carNumber.matches(".*[^АВЕКМНОРСТУХ\\d].*")) {
            System.out.println("Ошибка: Недопустимая буква в номере.");
            return false;
        }

        // Проверка соответствия формату номера
        if (!matcher.matches()) {
            System.out.println("Ошибка: Неверный формат номера.");
            return false;
        }

        return true;
    }

    // Метод для извлечения региона из номера
    private static String extractRegion(String carNumber) {
        // Регулярное выражение для извлечения региона
        Pattern pattern = Pattern.compile("[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}(\\d{2,3})");
        Matcher matcher = pattern.matcher(carNumber);

        // Проверка соответствия региона шаблону и возврат соответствующего региона
        if (matcher.matches()) {
            String regionCode = matcher.group(1);

            // Определение региона по коду
            switch (regionCode) {
                case "77":
                case "99":
                case "97":
                case "177":
                case "199":
                case "197":
                case "777":
                case "799":
                case "797":
                case "977":
                    return "Москва";
                case "78":
                case "98":
                case "178":
                case "198":
                    return "Санкт-Петербург";
                case "50":
                case "90":
                case "150":
                case "190":
                case "750":
                case "790":
                    return "Московская область";
                case "24":
                case "84":
                case "88":
                case "124":
                    return "Красноярский край";
                case "23":
                case "93":
                case "123":
                case "193":
                    return "Краснодарский край";
                case "59":
                case "81":
                case "159":
                    return "Пермский край";
                case "38":
                case "85":
                case "138":
                    return "Иркутская область";
                case "63":
                case "163":
                case "763":
                    return "Самарская область";
                case "66":
                case "96":
                case "196":
                    return "Свердловская область";
                case "16":
                case "116":
                case "716":
                    return "Республика Татарстан";
                case "61":
                case "161":
                case "761":
                    return "Ростовская область";
                case "02":
                case "102":
                case "702":
                    return "Республика Башкортостан";
                case "74":
                case "174":
                case "774":
                    return "Челябинская область";
                default:
            }
        }

        return "";
    }
}
