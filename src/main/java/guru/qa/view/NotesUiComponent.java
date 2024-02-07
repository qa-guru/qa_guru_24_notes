package guru.qa.view;

import guru.qa.data.NoteRepository;
import guru.qa.model.Note;
import guru.qa.model.User;
import guru.qa.service.Session;

import java.util.List;
import java.util.Scanner;

public class NotesUiComponent implements UiComponent {

  private final NoteRepository noteRepository;

  public NotesUiComponent(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  @Override
  public Session render(Session session) {
    Scanner scanner = new Scanner(System.in);

    User user = session.user();
    List<Note> userNotes = noteRepository.findAllByUsername(user.getUsername());
    System.out.println("Our notes: ");
    System.out.println(
        userNotes
    );
    System.out.println("Would you like to continue? y/n");
    String key = scanner.nextLine();
    if (key.equals("y")) {
      System.out.println("Here is your new notes: ");
      String note = scanner.nextLine();
      userNotes.add(
          new Note(user.getUsername(), note)
      );

      System.out.println("Our notes: ");
      System.out.println(userNotes);
    } else {
      System.exit(0);
    }
    return session;
  }
}
