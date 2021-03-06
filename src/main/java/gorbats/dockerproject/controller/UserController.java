package gorbats.dockerproject.controller;

import gorbats.docker_project.api.AccountsApi;
import gorbats.docker_project.model.UserAccountRequest;
import gorbats.docker_project.model.UserAccountResponse;
import gorbats.dockerproject.repository.UserAccountRepository;
import gorbats.dockerproject.tables.daos.UserAccountDao;
import gorbats.dockerproject.tables.pojos.UserAccount;
import javax.inject.Inject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements AccountsApi {

  @Inject
  private UserAccountDao userAccountDao;
  @Inject
  private UserAccountRepository userAccountRepository;

  @GetMapping("/user/all")
  Iterable<UserAccount> all() {
    return userAccountDao.findAll();
  }

  @GetMapping("/user/{id}")
  UserAccount userById(@PathVariable Long id) {
    return userAccountDao.findById(id);
  }

  @PostMapping("/user/save")
  UserAccount save(@RequestBody UserAccount userAccount) {
    return userAccountRepository.insert(userAccount);
  }

  @Override
  public ResponseEntity<UserAccountResponse> accountsPost(UserAccountRequest userAccountRequest) {
    return ResponseEntity.ok(new UserAccountResponse());
  }
}
