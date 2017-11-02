package exjobb.cache.mongo;

import exjobb.cache.mongo.util.CorsFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;


/**
 * Created by Jimmie on 10/26/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                //.antMatchers("/controller").permitAll()
                //.antMatchers(HttpMethod.POST, "/api/token").permitAll()
                .anyRequest().permitAll()
                .and()
                // We filter the controller/login requests
                //.addFilterBefore(new JWTLoginFilter("/api/token", authenticationManager()),
                 //       UsernamePasswordAuthenticationFilter.class)
                // And filter other requests to check the presence of JWT in header
                //.addFilterBefore(new JWTAuthenticationFilter(),
                 //       UsernamePasswordAuthenticationFilter.class)
                //Add CORS Preflight
                .addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
    }

   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Create a default account
        auth.inMemoryAuthentication()
                .withUser("jimmie")
                .password("Katat0nia")
                .roles("ADMIN");
    }*/
}
