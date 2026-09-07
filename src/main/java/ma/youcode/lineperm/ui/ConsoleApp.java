package ma.youcode.lineperm.ui;
import ma.youcode.lineperm.service.UserService;

import java.util.Scanner;

public class ConsoleApp {

    private final Scanner scanner;
    private final UserService userService;

    public ConsoleApp() {
        scanner = new Scanner(System.in);
        userService = new UserService();
    }

    public void start() {

        while (true) {

            System.out.print("linperm> ");

            String line = scanner.nextLine();

            switch (line) {

                case "signup":
                    signup();
                    break;

                case "login":
                    login();
                    break;

                case "exit":
                    return;

                default:
                    System.out.println("Commande inconnue");
            }
        }
    }

    private void signup() {

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        userService.signUp(login, password);
    }

    private void login() {

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        userService.login(login, password);
    }
}