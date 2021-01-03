package gorbats.dockerproject.controller;

import gorbats.dockerproject.model.UserAccount;
import gorbats.dockerproject.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

  private UserAccountRepository userAccountRepository;

  @Autowired
  public UserController(UserAccountRepository userAccountRepository) {
    this.userAccountRepository = userAccountRepository;
  }

  @GetMapping("/user/all")
  Iterable<UserAccount> all() {
    return userAccountRepository.findAll();
  }

  @GetMapping("/user/{id}")
  UserAccount userById(@PathVariable Long id) {
    return userAccountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND));
  }

  @PostMapping("/user/save")
  UserAccount save(@RequestBody UserAccount userAccount) {
    return userAccountRepository.save(userAccount);
  }

}
