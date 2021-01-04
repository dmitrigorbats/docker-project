package gorbats.dockerproject.config;

import static org.jooq.SQLDialect.POSTGRES;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.inject.Inject;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.jooq.ConnectionProvider;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class DataSourceConfig {

  @Inject
  private Environment environment;

  @Bean
  HikariConfig hikariConfig() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(environment.getRequiredProperty("spring.datasource.url"));
    config.setUsername(environment.getRequiredProperty("spring.datasource.username"));
    config.setPassword(environment.getRequiredProperty("spring.datasource.password"));
    return config;
  }

  @Bean
  public DataSource dataSource() {
    return new HikariDataSource(hikariConfig());
  }

  @Bean
  ConnectionProvider connectionProvider() {
    return new DataSourceConnectionProvider(dataSource());
  }

  @Bean
  public DefaultDSLContext dsl() {
    return new DefaultDSLContext(configuration());
  }

  @Bean
  public DefaultConfiguration configuration() {
    DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
    jooqConfiguration.set(connectionProvider());
    jooqConfiguration.set(POSTGRES);
    return jooqConfiguration;
  }
}
