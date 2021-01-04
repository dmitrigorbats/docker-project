package gorbats.dockerproject.repository;


import static gorbats.dockerproject.Tables.USER_ACCOUNT;
import static java.util.Objects.isNull;

import gorbats.dockerproject.tables.pojos.UserAccount;
import gorbats.dockerproject.tables.records.UserAccountRecord;
import org.springframework.stereotype.Service;

@Service
public class UserAccountRepository extends AbstractRepository<UserAccountRecord, UserAccount> {

  public UserAccount createUserAccount(final String name) {
    UserAccountRecord userAccountRecord = dsl.fetchOne(
        USER_ACCOUNT, USER_ACCOUNT.NAME.eq(name));
    if (isNull(userAccountRecord)) {
      userAccountRecord = dsl.insertInto(
          USER_ACCOUNT,
          USER_ACCOUNT.NAME)
          .values(
              name)
          .returning()
          .fetchOne();
    }
    return new UserAccount(userAccountRecord.getId(), name);
  }

  public UserAccount insert(final UserAccount userAccount) {
    return super.insert(userAccount, UserAccount.class);
  }

  @Override
  protected UserAccountRecord newRecord() {
    return new UserAccountRecord();
  }

}
