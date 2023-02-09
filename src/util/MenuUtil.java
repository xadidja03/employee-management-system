package util;

import static util.InputUtil.inputRequiredInteger;

public class MenuUtil {
    public static int entryApp() {
        System.out.println("\n------ Employee Management System ------\n" +
                "\n[0] Exit System" +
                "\n[1] Register" +
                "\n[2] Show Employee" +
                "\n[3] Update" +
                "\n[4] Delete" +
                "\n[5] Total Employee" +
                "\n[6] Find by Name\n"
        );
        return inputRequiredInteger("Chose option: ");
    }
}
