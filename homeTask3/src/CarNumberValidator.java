import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNumberValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ��������������� ����� ���������� ��� 'exit' ��� ������:");

        while (true) {
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("EXIT")) {
                System.out.println("��������� ���������.");
                break;
            }

            validateCarNumber(input);
        }

        scanner.close();
    }

    // ����� ��� ��������� ���������������� ������ ����������
    private static void validateCarNumber(String carNumber) {
        // �������� �������� � ������� 'RUS'
        carNumber = carNumber.replaceAll("\\s+|RUS", "");

        // �������� ������� ������
        if (!isValidFormat(carNumber)) {
            return;
        }

        // ���������� ������� � ����� ����������
        String region = extractRegion(carNumber);

        if (!region.equals("")) {
            System.out.println("����� ��������������� � �������: " + region);
        } else {
            System.out.println("������: ������ �� ������.");
        }
    }

    // ����� ��� �������� ������������ ������ ��������� �������
    private static boolean isValidFormat(String carNumber) {
        // ���������� ��������� ��� �������� ������� ������
        String regex = "[������������]\\d{3}[������������]{2}\\d{2,3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(carNumber);

        // �������� ������� ������������ �������� � ������
        if (carNumber.matches(".*[^������������\\d].*")) {
            System.out.println("������: ������������ ����� � ������.");
            return false;
        }

        // �������� ������������ ������� ������
        if (!matcher.matches()) {
            System.out.println("������: �������� ������ ������.");
            return false;
        }

        return true;
    }

    // ����� ��� ���������� ������� �� ������
    private static String extractRegion(String carNumber) {
        // ���������� ��������� ��� ���������� �������
        Pattern pattern = Pattern.compile("[������������]\\d{3}[������������]{2}(\\d{2,3})");
        Matcher matcher = pattern.matcher(carNumber);

        // �������� ������������ ������� ������� � ������� ���������������� �������
        if (matcher.matches()) {
            String regionCode = matcher.group(1);

            // ����������� ������� �� ����
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
                    return "������";
                case "78":
                case "98":
                case "178":
                case "198":
                    return "�����-���������";
                case "50":
                case "90":
                case "150":
                case "190":
                case "750":
                case "790":
                    return "���������� �������";
                case "24":
                case "84":
                case "88":
                case "124":
                    return "������������ ����";
                case "23":
                case "93":
                case "123":
                case "193":
                    return "������������� ����";
                case "59":
                case "81":
                case "159":
                    return "�������� ����";
                case "38":
                case "85":
                case "138":
                    return "��������� �������";
                case "63":
                case "163":
                case "763":
                    return "��������� �������";
                case "66":
                case "96":
                case "196":
                    return "������������ �������";
                case "16":
                case "116":
                case "716":
                    return "���������� ���������";
                case "61":
                case "161":
                case "761":
                    return "���������� �������";
                case "02":
                case "102":
                case "702":
                    return "���������� ������������";
                case "74":
                case "174":
                case "774":
                    return "����������� �������";
                default:
            }
        }

        return "";
    }
}
