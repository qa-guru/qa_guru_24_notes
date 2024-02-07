package guru.qa.data;

import guru.qa.model.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface NoteRepository {

  List<Note> findAllByUsername(String username);

  void save(Note note);

  class InMemNoteRepository implements NoteRepository {

    private final List<Note> notes = new ArrayList<>(
        List.of(
            new Note("dima", "Прочитать лекцию"),
            new Note("dima", "Сходить в отпуск")
        )
    );

    @Override
    public List<Note> findAllByUsername(String username) {
      return username.equals("dima")
          ? notes
          : Collections.emptyList();
    }

    @Override
    public void save(Note note) {
      if (note.getUsername().equals("dima")) {
        notes.add(note);
      }
    }
  }
}
