package ma.youcode.lineperm.ui;

import ma.youcode.lineperm.model.User;
import ma.youcode.lineperm.service.UserService;

import java.util.Scanner;

public class ConsoleApp {

    private final Scanner scanner;
    private final UserService userService;

    private User currentUser ;

    public ConsoleApp() {
        scanner = new Scanner(System.in);
        userService = new UserService();
        currentUser = null;
    }

    public void start() {

        System.out.println("============================================");
        System.out.println("        Bienvenue dans LinePermission");
        System.out.println("============================================");
        System.out.println("Commandes : signup | login | help | exit" + "\n");


        while (true) {

            if (currentUser == null) {
                System.out.print("linperm> ");
            } else {
                System.out.print(currentUser.getLogin() + "@linperm> ");
            }

            String line = scanner.nextLine().trim();

            String[] mots = line.split("\\s+");

            String command = mots[0].toLowerCase();

            switch (command) {

                case "signup":
                    signup();
                    break;

                case "login":
                    login();
                    break;

                case "logout":
                    logout();
                    break;

                case "help":
                    help();
                    break;

                case "exit":
                    System.out.println("Au revoir.");
                    return;

                default:
                    System.out.println("Commande inconnue.");
            }
        }
    }

    private void signup() {

        System.out.print("Login : ");
        String login = scanner.nextLine();

        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();

        userService.signUp(login, password);
    }

    private void login() {

        System.out.print("Login : ");
        String login = scanner.nextLine();

        System.out.print("Mot de passe : ");
        String password = scanner.nextLine();

        try {
            User user = userService.login(login, password);
            currentUser = user;
            
        } catch (Exception e) {
            System.out.println("Erreur lors de la connexion : " + e.getMessage());
        }

        if (currentUser != null) {
            System.out.println("Bienvenue " + currentUser.getLogin());
        }
    }

    private void logout() {
        System.out.println("Deconnecte");
        currentUser = null;
    }

    private void help() {

        if (currentUser == null) {
            System.out.println("Commandes : signup | login | help | exit");
        } else {
            System.out.println("Commandes : logout | help | exit");
        }
    }
}
