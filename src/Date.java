import java.util.Scanner;

public class Date {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите день");
        int day = scanner.nextInt();
        System.out.println("Введите месяц");
        int month = scanner.nextInt();
        System.out.println("Введите год");
        int year = scanner.nextInt();

        if (isDateRight(day, month, year)) {
            nextDay(day, month, year);
        } else {
            System.out.println("Дата указака неверно");
        }
    };

    static void nextDay(int day, int month, int year){
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day == 31) {
                    day = 1;
                    month++;
                    break;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 30) {
                    day = 1;
                    month++;
                    break;
                }
            case 2:
                if((isLeapYear(year) && day == 29) || (!isLeapYear(year) && day == 28)){
                    day = 1;
                    month++;
                    break;}
            default:
                day++;
                break;
        }

        if (month == 13) {
            month = 1;
            year++;
        }

        System.out.println("Дата следующего дня: " + day + "." + month + "." + year);
    }

    static boolean isLeapYear(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    };

    static boolean isDayRight(int day, int month, int year){
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day>31){
                    return false;
                };
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day>30){
                    return false;
                };
                break;
            case 2:
                if((isLeapYear(year) && day > 29) || (!isLeapYear(year) && day > 28)){
                    return false;
                };
                break;
            default:
                return false;
        }
        return true;
    };

    static boolean isDateRight(int day, int month, int year){
        return isDayRight(day, month, year) && month > 0 && month < 13;
    }
}

