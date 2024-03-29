package exercise;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.web.servlet.function.RequestPredicates.POST;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    // Переопределяет схему аутентификации
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // BEGIN
        http

                // По умолчанию spring boot даёт доступ к любому url любому аутентифицированному пользователю
                // Мы должны переопределить это поведение
                // Определяем доступы к url
                .authorizeRequests()
                // Доступ к корню сайта доступен всем пользователям
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                // Доступ ко всем остальным url даётся только аутентифицированным пользователям
                .anyRequest().authenticated()
                // Используем базовую аутентификацию
                // Имя пользователя и пароль передаются в заголовке в зашифрованном виде
                .and().httpBasic();
        // END
    }

    // Указываем, что для сравнения хешей паролей
    // будет использоваться кодировщик BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Указываем, что будем использовать созданный нами диспетчер аутентификации
    // вместо дефолтного
    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService);
    }
}
