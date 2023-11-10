package se.folkuniversitetet.mu23.telefonbok;

public class PrintHandler {

    public static void showGuestMenu(){
        System.out.println("==========================");
        System.out.println(" – Choose one of these options: \n" +
                "        1. Find by surname\n" +
                "        2. Search by name\n" +
                "        3. Search by address\n" +
                "        4. Search by any field\n" +
                "        5. Login as admin\n" +
                "        6. Exit\n");
    }
    public static void showAdminMenu(){
        System.out.println("==========================");
        System.out.println(" – Choose one of these options: \n" +
                "        1. Create contact\n" +
                "        2. Read contact\n" +
                "        3. Update contact\n" +
                "        4. Delete contact\n" +
                "        5. Exit\n");
    }

    public static void showUserInput(int userInput) {
        System.out.println("==========================");
        System.out.println("You have chosen: " + userInput);
    }

}
