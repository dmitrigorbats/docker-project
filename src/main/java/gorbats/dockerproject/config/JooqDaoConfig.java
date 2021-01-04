package gorbats.dockerproject.config;

import gorbats.dockerproject.tables.daos.UserAccountDao;
import javax.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JooqDaoConfig {

  @Inject
  private DSLContext dsl;

  @Bean
  public UserAccountDao userAccountDao() {
    return new UserAccountDao(dsl.configuration());
  }
}
