import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password to check its strength:");
        String password = scanner.nextLine();
        if (isStrongPassword(password)) {
            System.out.println("This is a strong password.");
        } else {
            System.out.println("This is not a strong password.");
        }
        scanner.close();
    }

    public static boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                String specialChars = "!@#$%^&*()_+-=[]{};:'\"|<,>.?/";
                if (specialChars.contains(String.valueOf(ch))) {
                    hasSpecial = true;
                }
            }
        }
        return hasUppercase && hasLowercase && hasDigit && hasSpecial;
    }
}
