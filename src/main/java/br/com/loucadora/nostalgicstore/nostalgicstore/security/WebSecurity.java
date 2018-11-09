package br.com.loucadora.nostalgicstore.nostalgicstore.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.loucadora.nostalgicstore.nostalgicstore.services.ResearchersService;

import org.springframework.context.annotation.Bean;


@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private ResearchersService researchersService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(ResearchersService researchersService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.researchersService = researchersService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //Todas as rotas são liberadas, bloquear apenas a rota de cadastro e edição de pesquisa
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
        		.antMatchers("/*").permitAll()
        		//aqui bloqueia as rotas de cadastro e edição de pesquisa
        		//.antMatchers(HttpMethod.POST, "/researches").authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(researchersService).passwordEncoder(bCryptPasswordEncoder);
    }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    return source;
  }
}
