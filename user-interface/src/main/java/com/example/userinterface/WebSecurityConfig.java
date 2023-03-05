package com.example.userinterface;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.userinterface.account.AccountUserDetailsService;

//　WebSecurityConfigの設定をすると初回起動時のログイン画面の挙動などを変更できます。

// (参考)https://github.com/MasatoshiTada/spring-security-intro/blob/main/src/main/java/com/example/springsecurityintro/

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	AccountUserDetailsService accountUserDetailsService;

	public WebSecurityConfig(AccountUserDetailsService accountUserDetailsService) {
		this.accountUserDetailsService = accountUserDetailsService;
	}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	/*
        http.formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .permitAll()
        ).logout(logout -> logout
                .logoutSuccessUrl("/")
        ).authorizeHttpRequests(authz -> authz
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/").permitAll()
                .requestMatchers("/system_administrator").hasRole("SYSTEM_ADMINISTRATOR")
                .requestMatchers("/administrator").hasRole("ADMINISTRATOR")
                .requestMatchers("/user").hasRole("USER")
                .anyRequest().authenticated()
        );
    	 */

        return http.build();
    }

    /**
	 *　AuthenticationManagerのBean定義を行う
	 */
    @Bean
    public AuthenticationManager authenticationManager(){
        // 【このオブジェクト生成は書き方が違うかもしれない】
    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

    	// DaoAuthenticationProviderに作成したAccountUserDetailsServiceを設定する
        daoAuthenticationProvider.setUserDetailsService(accountUserDetailsService);

        // DaoAuthenticationProviderにPasswordEncoderを設定する
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(daoAuthenticationProvider);
    }

    /**
	 *　DaoAuthenticationProviderにPasswordEncoderを設定する
	 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}