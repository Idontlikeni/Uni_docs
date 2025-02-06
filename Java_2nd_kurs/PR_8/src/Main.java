import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] months = {"январь", "февраль", "март", "апрель", "май",
                "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};

        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число от 1 до 12");
        int month_number = 1;
/*        while(true) {
            boolean f = true;

            if(f)break;
        }*/
        try {
            month_number = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введен не int, значение месяца задан 1");
            //f = false;
        }

        int pl = 0;
        if (month_number == 2){
            System.out.println("Введите год:");
            int year = scan.nextInt();
            if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)pl = 1;
        }
        try {
            System.out.println("Месяц: " + months[month_number - 1] + " Количество дней в нем: " + (dom[month_number - 1] + pl));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Недопустимое");
        }

    }
}