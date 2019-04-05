

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileWriter data = new FileWriter();

        ContactsManager program = new ContactsManager(sc, data);
        program.start();
    }
}