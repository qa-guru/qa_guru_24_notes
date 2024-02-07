package guru.qa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentMain {
  public static void main(String[] args) {
    Map<String, String> users = Map.of(
        "dima", "12345",
        "cat", "54321"
    );

    Map<String, List<String>> notes = Map.of(
        "dima", new ArrayList<>(List.of("Прочитать лекцию", "Сходить в отпуск")),
        "cat", new ArrayList<>(List.of("Поспать", "Поесть"))
    );

    Scanner scanner = new Scanner(System.in);
    System.out.println("Username:");
    String username = scanner.nextLine();
    System.out.println("Password:");
    String password = scanner.nextLine();

    String user = users.get(username);
    if (user == null) {
      System.out.println("Bad credentials :(");
      System.exit(0);
    } else {
      if (!user.equals(password)) {
        System.out.println("Bad credentials :(");
        System.exit(0);
      } else {
        System.out.println("Our notes: ");
        System.out.println(notes.get(username));

        System.out.println("Would you like to continue? y/n");
        String key = scanner.nextLine();
        if (key.equals("y")) {
          System.out.println("Here is your new notes: ");
          String note = scanner.nextLine();
          notes.get(username).add(note);

          System.out.println("Our notes: ");
          System.out.println(notes.get(username));
        } else {
          System.exit(0);
        }
      }
    }
  }
}