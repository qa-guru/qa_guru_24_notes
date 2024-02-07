package guru.qa.view;

import guru.qa.data.UserRepository;
import guru.qa.model.User;
import guru.qa.service.Session;
import guru.qa.service.UserSession;

import javax.swing.*;
import java.util.Optional;

public class LoginSwingUiComponent implements UiComponent {

  private final UserRepository userRepository;

  public LoginSwingUiComponent(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Session render(Session session) {
    String username = JOptionPane.showInputDialog("Username:");
    String password = JOptionPane.showInputDialog("Password:");

    Optional<User> user = userRepository.findByUsername(username);
    if (user.isEmpty()) {
      showErrorMessage("Bad credentials :(");
      throw new IllegalStateException();
    } else {
      User unwrappesUser = user.get();
      if (!unwrappesUser.getPassword().equals(password)) {
        showErrorMessage("Bad credentials :(");
        throw new IllegalStateException();
      } else {
        return new UserSession(unwrappesUser);
      }
    }
  }

  private void showErrorMessage(String msg) {
    JOptionPane.showMessageDialog(
        null,
        msg,
        "error",
        JOptionPane.ERROR_MESSAGE
    );
  }
}
