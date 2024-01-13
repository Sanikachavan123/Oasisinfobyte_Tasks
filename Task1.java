import java.util.ArrayList;
import java.util.Scanner;

// User class to manage user profilesg
class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to update profile
    public void updateProfile(String newPassword) {
        this.password = newPassword;
        System.out.println("Profile updated successfully!");
    }

    // Method to change password
    public void changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Incorrect old password. Unable to change password.");
        }
    }

    // Getter method for username
    public String getUsername() {
        return username;
    }

    // Getter method for password
    public String getPassword() {
        return password;
    }

    // Method to log out
    public void logout() {
        System.out.println("Logged out successfully!");
    }
}

// Class to manage MCQs
class MCQs {
    private ArrayList<String> questions;
    private ArrayList<String> options;
    private ArrayList<String> answers;

    public MCQs() {
        questions = new ArrayList<>();
        options = new ArrayList<>();
        answers = new ArrayList<>();
    }

    // Method to add MCQ
    public void addQuestion(String question, String optionA, String optionB, String optionC, String optionD, String answer) {
        questions.add(question);
        options.add("A. " + optionA + "\nB. " + optionB + "\nC. " + optionC + "\nD. " + optionD);
        answers.add(answer);
    }

    // Method to display questions
    public void displayQuestions() {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1) + ": " + questions.get(i));
            System.out.println("Options:\n" + options.get(i));
        }
    }

    // Method to select answer
    public void selectAnswer(int questionNumber, String selectedAnswer) {
        if (questionNumber >= 1 && questionNumber <= questions.size()) {
            if (selectedAnswer.equalsIgnoreCase(answers.get(questionNumber - 1))) {
                System.out.println("Correct answer!");
            } else {
                System.out.println("Incorrect answer.");
            }
        } else {
            System.out.println("Invalid question number.");
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        // Sample usage
        User currentUser = new User("username", "password");
        MCQs mcqs = new MCQs();

        mcqs.addQuestion("What is the capital of France?", "Paris", "Rome", "Berlin", "Madrid", "A");
        mcqs.addQuestion("What is the largest planet in our solar system?", "Jupiter", "Saturn", "Mars", "Earth", "A");

        // Login
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getPassword())) {
            System.out.println("Login successful!");

            // Selecting answers for MCQs
            mcqs.displayQuestions();
            System.out.print("Enter the question number to answer: ");
            int questionNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter your answer (A/B/C/D): ");
            String selectedAnswer = scanner.nextLine().toUpperCase();

            mcqs.selectAnswer(questionNumber, selectedAnswer);

            // Update Profile and Password
            System.out.print("Do you want to update your profile? (yes/no): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                currentUser.updateProfile(newPassword);
            }

            // Timer and auto-submit logic can be implemented here

            // Closing session and Logout
            currentUser.logout();
        } else {
            System.out.println("Invalid username or password. Login failed.");
        }
    }
}
