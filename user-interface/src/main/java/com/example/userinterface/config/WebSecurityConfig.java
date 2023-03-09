package com.example.userinterface.config;

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

// import com.example.userinterface.account.AccountUserDetailsService;

/**
 * WebSecurityのConfig
 *
 * 'Spring徹底入門'を引用
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	// AccountUserDetailsService accountUserDetailsService;

    /**
	 * constructor
	 */
	/*
	public WebSecurityConfig(AccountUserDetailsService accountUserDetailsService) {
		this.accountUserDetailsService = accountUserDetailsService;
	}
     */

    /**
	 * SecurityFilterChainのBean定義を行う
	 */
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
	 *　AuthenticationManagerのBean定義を行う ※Spring徹底入門の手順は古いので使用できない
	 */
    /*
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
     */

    /**
	 *　DaoAuthenticationProviderにPasswordEncoderを設定する
	 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}