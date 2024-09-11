import java.util.Scanner;

public class MainRefactoring {
    public static void main(String[] args) {
        User user = UserInputHandler.userInput();

        UserAuthentication auth = new UserAuthentication();
        if (auth.authenticate(user)) {
            System.out.println("User authenticated successfully!");
        } else {
            System.out.println("Authentication failed.");
        }

        UserReport report = new UserReport();
        System.out.println(report.userDetails(user));
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class UserInputHandler {
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

class UserAuthentication {
    public boolean authenticate(User user) {
        return user.getUsername().equals("admin") && user.getPassword().equals("admin1234");
    }
}

class UserReport {
    public String userDetails(User user) {
        return "User: " + user.getUsername() + ", Password: " + user.getPassword();
    }
}
