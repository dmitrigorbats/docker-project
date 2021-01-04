package gorbats.dockerproject.repository;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

import gorbats.dockerproject.tables.pojos.UserAccount;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserAccountRepositoryTest {

  @Inject
  private UserAccountRepository userAccountRepository;

  @Test
  void save() {
    final String name = randomUUID().toString();
    final UserAccount dbUserAccount = userAccountRepository.createUserAccount(name);
    assertEquals(name, dbUserAccount.getName());
  }

}
