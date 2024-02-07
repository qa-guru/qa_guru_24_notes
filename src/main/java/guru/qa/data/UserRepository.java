package guru.qa.data;

import guru.qa.model.User;

import java.util.Optional;

public interface UserRepository {

  Optional<User> findByUsername(String username);

  class InMemUserRepository implements UserRepository {

    @Override
    public Optional<User> findByUsername(String username) {
      return username.equals("dima")
          ? Optional.of(new User("dima", "12345"))
          : Optional.empty();
    }
  }
}
