import java.util.Scanner;

public class MainProblem {
    public static void main(String[] args) {

        User user = User.userInput();

        if (user.authenticate()) {
            System.out.println("User authenticated successfully!");
        } else {
            System.out.println("Authentication failed.");
        }

        System.out.println(user.userDetails());
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate() {
        return username.equals("admin") && password.equals("admin1234");
    }


    public String userDetails() {
        return "User: " + username + ", Password: " + password;
    }

    public static User userInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();

            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            return new User(username, password);
        } finally {
            scanner.close();
        }
    }
}
