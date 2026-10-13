package oit.is.z2608.kaizi.janken.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class JankenAuthConfiguration {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin(login -> login
        .permitAll())
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")) // ログアウト後に / にリダイレクト
        .authorizeHttpRequests(authz -> authz
            .requestMatchers("/janken/**").authenticated() // /janken/以下は認証済みであること
            .anyRequest().permitAll()); // 上記以外は全員アクセス可能
    return http.build();
  }
  
@Bean
  public InMemoryUserDetailsManager userDetailsService() {

    // ユーザ名，パスワード，ロールを指定してbuildする
    // このときパスワードはBCryptでハッシュ化されているため，{bcrypt}とつける
    // ハッシュ化せずに平文でパスワードを指定する場合は{noop}をつける

    UserDetails user1 = User.withUsername("user1")
        .password("{bcrypt}$2y$05$dKCp4CPQN86sAPQuXQ6Ckuc/bfgM9SzAeEzEO1QBL3oZLGiIUkQIG").roles("USER").build();
    UserDetails admin = User.withUsername("user2")
        .password("{bcrypt}$2y$05$5DAtO5oSAZrdEPUQ8zRXy.zs2FxQlvVHvDMO3JDZeI8gBoZv4TKna").roles("ADMIN").build();

    // 生成したユーザをImMemoryUserDetailsManagerに渡す（いくつでも良い）
    return new InMemoryUserDetailsManager(user1, admin);
  }
}
