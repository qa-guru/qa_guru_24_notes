package guru.qa.service;

import guru.qa.model.User;

public class UserSession implements Session {

  private final User user;

  public UserSession(User user) {
    this.user = user;
  }

  @Override
  public User user() {
    return user;
  }
}
