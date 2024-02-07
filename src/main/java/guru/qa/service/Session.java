package guru.qa.service;

import guru.qa.model.User;

public interface Session {

  User user();

  class EmptySession implements Session {

    @Override
    public User user() {
      throw new UnsupportedOperationException("This is an empty session");
    }
  }
}
