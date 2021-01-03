package gorbats.dockerproject.repository;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import gorbats.dockerproject.model.UserAccount;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserAccountRepositoryTest {

  @Inject
  private UserAccountRepository userAccountRepository;

  @Test
  void save() {
    final UserAccount userAccount = new UserAccount();
    final String name = randomUUID().toString();
    userAccount.setName(name);
    userAccountRepository.save(userAccount);
    final UserAccount dbUserAccount = userAccountRepository.findByName(name);
    assertNotNull(dbUserAccount);
  }

}