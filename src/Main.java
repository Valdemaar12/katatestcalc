import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String inputText = new Scanner(System.in).nextLine();
        String finish = calc(inputText);
        System.out.println(finish);
    }


    public static String check(String input) {

        String[] strArray = input.split(" ");

        String[] arabicArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romanArr = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        String status1;
        String status2;

        if (Arrays.asList(arabicArr).contains(strArray[0])) {
            status1 = "isArabic";
        } else if (Arrays.asList(romanArr).contains(strArray[0])) {
            status1 = "isRoman";
        } else {
            throw new IllegalArgumentException();
        }

        if (Arrays.asList(arabicArr).contains(strArray[2])) {
            status2 = "isArabic";
        } else if (Arrays.asList(romanArr).contains(strArray[2])) {
            status2 = "isRoman";
        } else {
            throw new IllegalArgumentException();
        }

        if (!(status1 == status2)) {
            throw new IllegalArgumentException();
        }

        return status1;
    }

    public static int result(int first, String operation, int second) {
        switch (operation) {
            case ("+"):
                return first + second;
            case ("-"):
                return first - second;
            case ("*"):
                return first * second;
            case ("/"):
                return first / second;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static String calc(String input) {
        int first;
        int second;
        String finish;
        String[] strArray = input.split(" ");
        String status = check(input);

        if (status.equals("isRoman")) {
            first = RomanNum.romanToArabic(strArray[0]);
            second = RomanNum.romanToArabic(strArray[2]);
        } else {
            first = Integer.parseInt(strArray[0]);
            second = Integer.parseInt(strArray[2]);
        }

        int output = result(first, strArray[1], second);
        if (status.equals("isRoman")) {
            finish = RomanNum.arabicToRoman(output);
        } else finish = Integer.toString(output);

        return finish;
    }


}