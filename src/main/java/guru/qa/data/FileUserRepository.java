package guru.qa.data;

import com.opencsv.CSVReader;
import guru.qa.model.User;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class FileUserRepository implements UserRepository {

  private final Path path;

  public FileUserRepository(Path path) {
    this.path = path;
  }

  @Override
  public Optional<User> findByUsername(String username) {
    try (InputStream is = Files.newInputStream(path);
         CSVReader csvReader = new CSVReader(
             new InputStreamReader(is)
         )) {

      List<String[]> users = csvReader.readAll();
      Optional<String[]> firstUser = users.stream()
          .filter(u -> u[0].equals(username))
          .findFirst();

      return firstUser.isPresent()
          ? Optional.of(new User(firstUser.get()[0], firstUser.get()[1]))
          : Optional.empty();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
