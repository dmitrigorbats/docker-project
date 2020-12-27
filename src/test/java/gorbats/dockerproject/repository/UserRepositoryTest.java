package gorbats.dockerproject.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import gorbats.dockerproject.model.UserModel;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

  @Inject
  private UserRepository userRepository;

  @Test
  void save() {
    final UserModel model = new UserModel();
    model.setName("Dmitri");
    userRepository.save(model);
    final UserModel dbModel = userRepository.findById(model.getId()).get();
    assertEquals(model.getName(), dbModel.getName());
  }

}