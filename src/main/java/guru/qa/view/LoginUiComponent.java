package guru.qa.view;

import guru.qa.data.UserRepository;
import guru.qa.model.User;
import guru.qa.service.Session;
import guru.qa.service.UserSession;

import java.util.Optional;
import java.util.Scanner;

public class LoginUiComponent implements UiComponent {

  private final UserRepository userRepository;

  public LoginUiComponent(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Session render(Session session) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Username:");
    String username = scanner.nextLine();
    System.out.println("Password:");
    String password = scanner.nextLine();

    Optional<User> user = userRepository.findByUsername(username);
    if (user.isEmpty()) {
      System.out.println("Bad credentials :(");
      throw new IllegalStateException();
    } else {
      User unwrappesUser = user.get();
      if (!unwrappesUser.getPassword().equals(password)) {
        System.out.println("Bad credentials :(");
        throw new IllegalStateException();
      } else {
        return new UserSession(unwrappesUser);
      }
    }
  }
}
