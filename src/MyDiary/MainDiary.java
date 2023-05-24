package MyDiary;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class MainDiary {
    private static final LocalDateTime localDateTime = LocalDateTime.now();
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy      hh:mm a");
    private static final Diary entries = new Diary();

    public static void main(String[] args) {
        goToMainMenu();
    }

    public static void goToMainMenu() {
        String mainMenu = "           " + dateTimeFormatter.format(localDateTime) + "\n" +
                """
                              =========================
                                 Welcome to My EBook
                                     -------------------------
                               1 -> Create Entry
                               2 -> View Entry
                               3 -> Count Entry
                               4 -> Edit Entry
                               5 -> Delete Entry
                               6 -> Exit
                              =========================
                        """;
        String userInput = input(mainMenu);
        if (Objects.equals(userInput, "")) goToMainMenu();
        switch (userInput.charAt(0)) {
            case '1' -> createEntry();
            case '2' -> viewEntry();
            case '3' -> countEntry();
            case '4' -> {
                userInput = input("""
                        1.  Edit the title.
                        2.  Edit the body.
                        3.  Back.
                        """);
                switch (userInput.charAt(0)) {
                    case '1' -> editTitle();
                    case '2' -> editBody();
                    case '3' -> goToMainMenu();
                    default -> goToMainMenu();
                }
            }
            case '5' -> deleteEntry();
            case '6' -> exitApplication();
            default -> goToMainMenu();

        }
    }

    public static void createEntry() {
        String title = input("Enter the title");
        String body = input("Enter the note");
        entries.createEntry(title, body);
        display(dateTimeFormatter.format(localDateTime) + "\nNote " + entries.countEntries() + " successfully saved");
        goToMainMenu();
    }

    public static void exitApplication() {
        display("Thank you for using the eBook application");
        System.exit(1);
    }

    public static void viewEntry() {
        try {
            int id = Integer.parseInt(input("Enter id number"));
            String noteBook = String.format("%s ", entries.findEntry(id).toString());
            display(noteBook);
            goToMainMenu();
        } catch (IllegalArgumentException e) {
            display(e.getMessage());
        }
        goToMainMenu();
    }

    public static void countEntry() {
        display(String.format("""
                You have %s entry(ies) on your eBook so far
                """, entries.countEntries()));
        goToMainMenu();
    }

    public static void editBody() {
        try {
            int id = Integer.parseInt(input("Enter the id number of the note you want to edit: "));
            String noteBook = String.format("%s ", entries.findEntry(id).toString());
            display(noteBook);
            String body = input("Edit the body: ");
            entries.editEntryBody(id, body);
            display(dateTimeFormatter.format(localDateTime) + "\nNote body successfully updated");
            noteBook = String.format("%s ", entries.findEntry(id).toString());
            display(noteBook);
            goToMainMenu();
        } catch (IllegalArgumentException e) {
            display(e.getMessage());
        }
        goToMainMenu();
    }

    public static void editTitle() {
        try {
            int id = Integer.parseInt(input("Enter the id number of the title you wish to edit: "));
            String myNoteBook = String.format("%s ", entries.findEntry(id).toString());
            display(myNoteBook);
            String title = input("Edit the title: ");
            entries.editEntryTitle(id, title);
            display(dateTimeFormatter.format(localDateTime) + "\nNote title successfully edited");
            myNoteBook = String.format("%s ", entries.findEntry(id).toString());
            display(myNoteBook);
            goToMainMenu();
        } catch (IllegalArgumentException e) {
            display(e.getMessage());
        }
        goToMainMenu();
    }

    public static void deleteEntry() {
        try {
            int id = Integer.parseInt(input("Enter the Id number of the note that you wish to delete"));
            String noteBook = String.format("%s ", entries.findEntry(id).toString());
            display(noteBook);
            entries.entryDelete(id);
            display(dateTimeFormatter.format(localDateTime) + "\nNote " + id + " successfully deleted !!!\n");
            goToMainMenu();

        } catch (IllegalArgumentException e) {
            display(e.getMessage());
        }
        goToMainMenu();

    }

    public static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    public static void display(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }

}
