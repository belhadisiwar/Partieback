package com.example.demo.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	

@Autowired
private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
// configure AuthenticationManager so that it knows from where to load
// user for matching credentials
// Use BCryptPasswordEncoder
 //auth.userDetailsService(this.userDetailservice).passwordEncoder(passwordEncoder());
}

@Bean
@Override
public AuthenticationManager authenticationManagerBean() throws Exception {
return super.authenticationManagerBean();
}
@Autowired
JwtRequestFilter jwtRequestFilter;

@Override
protected void configure(HttpSecurity httpSecurity) throws Exception {
// We don't need CSRF for this example
httpSecurity.csrf().disable()
// dont authenticate this particular request
//.authorizeRequests().antMatchers("/user/add","/user/decrypt","/user/addouv", "/user/login","/service/updateservices/{id}","/service/deleteservices/{id}","/user/pwdCheck").permitAll().
.authorizeRequests().antMatchers("/ouvrier/login","/ouvrier/add/{idServices}","/service/add","/user/addadmin","/ouvrier/allclient","/client/allclient","/client/oneclient/{id}","/client/add","/ouvrier/allouvrier","/user/add","/user/addouv", "/user/login","/service/updateservices/{id}","/service/deleteservices/{id}", "/service/allservice","/ouvrier/deleteouvrier/{id}","/client/deleteclient/{id}","/service/addservice/{idclient}","/contact/add","/contact/allcontact").permitAll().
// all other requests need to be authenticated
anyRequest().authenticated().and().
// make sure we use stateless session; session won't be used to
// store user's state.
exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// Add a filter to validate the tokens with every request
httpSecurity.cors();
httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
}

}
