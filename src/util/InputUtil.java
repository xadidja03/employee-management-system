package util;

import java.util.Scanner;

public class   InputUtil {
    public static String inputRequiredString(String title){
        Scanner input=new Scanner(System.in);
        System.out.println(title);
        return input.nextLine();
    }
    public static Double inputRequiredDouble(String title){
        Scanner input=new Scanner(System.in);
        System.out.println(title);
        return input.nextDouble();
    }
    public static long inputRequiredLong(String title){
        Scanner input = new Scanner(System.in);
        System.out.println(title);
        return input.nextLong();
    }

    public static int inputRequiredInteger(String title) {
        Scanner input = new Scanner(System.in);
        System.out.println(title);
        return input.nextInt();
    }
}
