package guru.qa;

import guru.qa.data.FileUserRepository;
import guru.qa.data.NoteRepository;
import guru.qa.service.Session;
import guru.qa.view.LoginSwingUiComponent;
import guru.qa.view.NotesSwingUiComponent;
import guru.qa.view.UiComponents;

import java.nio.file.Path;

public class NewMain {
  public static void main(String[] args) {
    new UiComponents(
        new LoginSwingUiComponent(
            new FileUserRepository(
                Path.of(
                    "users.csv"
                )
            )
        ),
        new NotesSwingUiComponent(
            new NoteRepository.InMemNoteRepository()
        )
    ).render(new Session.EmptySession());
  }
}