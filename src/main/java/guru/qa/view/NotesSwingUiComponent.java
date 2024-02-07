package guru.qa.view;

import guru.qa.data.NoteRepository;
import guru.qa.model.Note;
import guru.qa.model.User;
import guru.qa.service.Session;

import javax.swing.*;
import java.util.List;

public class NotesSwingUiComponent implements UiComponent {

  private final NoteRepository noteRepository;

  public NotesSwingUiComponent(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  @Override
  public Session render(Session session) {
    User user = session.user();
    List<Note> userNotes = noteRepository.findAllByUsername(user.getUsername());

    showNotes(userNotes);
    int key = getConfirmation();
    if (key == 0) {
      String note = JOptionPane.showInputDialog("Here is your new notes: ");
      userNotes.add(
          new Note(user.getUsername(), note)
      );

      showNotes(userNotes);
    } else {
      System.exit(0);
    }
    return session;
  }

  private void showNotes(List<Note> notes) {
    JOptionPane.showMessageDialog(
        null,
        "Our notes: " + notes,
        "Notes",
        JOptionPane.INFORMATION_MESSAGE
    );
  }

  private int getConfirmation() {
    return JOptionPane.showConfirmDialog(
        null,
        "Would you like to continue? y/n",
        "Confirmation",
        JOptionPane.YES_NO_OPTION
    );
  }
}
