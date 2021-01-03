package gorbats.dockerproject.repository;


import gorbats.dockerproject.model.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

  UserAccount findByName(final String name);

}