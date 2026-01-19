// // src/main/java/com/amwell/faqsupport/security/SecurityConfig.java
// package com.amwell.faqsupport.security;

// import javax.swing.Spring;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// // @Configuration: This is a standard Spring annotation that marks a class as a source of bean definitions.
// // It tells the Spring container that it can process the class to configure beans.
// @EnableWebSecurity
// // @EnableWebSecurity: This annotation is the main entry point for Spring Security.
// //  It enables the web security features in your application, including filters and the security context.

// public class SecurityConfig {

//     @Bean
//     // @Bean: This annotation marks the method to be managed by the Spring container. 
//     // The method creates and configures an object that can be used by other parts of the application.
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
//    // public PasswordEncoder passwordEncoder(): This method defines a PasswordEncoder bean.
//    //return new BCryptPasswordEncoder(): It returns an instance of BCryptPasswordEncoder.
//     //This is the standard, secure way to hash and verify passwords in modern applications. 
//     //You use this to:
//             //  ->   Encode passwords when a user registers or changes their password.
//             // -> Verify passwords during the login process by comparing a stored hash with a newly 
//             //         generated hash from the user's input.





//     //3. filterChain() method
//     /*
//      This is the core of your security configuration. It defines a SecurityFilterChain bean, which is a chain of filters that Spring Security will apply to incoming HTTP requests.


// •	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception: This method takes an HttpSecurity object, which is used to configure HTTP-related security settings.

// •	.csrf(AbstractHttpConfigurer::disable): This line disables Cross-Site Request Forgery (CSRF) protection. For a stateless, token-based API (like the one your React frontend will talk to), CSRF protection is not needed. CSRF protection is more relevant for stateful, session-based applications.


// •	.authorizeHttpRequests(auth -> auth ...): This is where you define authorization rules for your application's URLs.
// o	.requestMatchers("/api/auth/**").permitAll(): This rule specifies that any requests starting with /api/auth/ (e.g., login, registration) are accessible to all users (permitAll()) and do not require authentication.
// o	.anyRequest().authenticated(): This is the default rule. It states that all other requests (anyRequest()) must be authenticated (authenticated()). If a user tries to access any other endpoint without a valid token, they will be rejected.


// •	.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class): This adds a custom filter (jwtAuthenticationFilter()) to the security filter chain.
// o	jwtAuthenticationFilter(): This is a placeholder for a bean that you would need to define to create your JWT filter.
// o	UsernamePasswordAuthenticationFilter.class: The custom JWT filter is added before Spring Security's default username/password filter. This means your JWT-based authentication logic will run before the standard form-based login.



// •	return http.build(): This finalizes and builds the security configuration.


//      */
//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(AbstractHttpConfigurer::disable)
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/api/auth/**").permitAll()
//                 .anyRequest().authenticated()
//             )
//             .addFilterBefore(
//                 jwtAuthenticationFilter(),
//                 UsernamePasswordAuthenticationFilter.class
//             );
//         return http.build();
//     }
// }
