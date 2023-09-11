# Spring Security

`AuthenticationEntryPoint`

```java
public interface AuthenticationEntryPoint {
	void commence(
        HttpServletRequest request,
        HttpServletResponse response,
        AuthenticationException authException
    ) throws IOException, ServletException;
}
```

`AuthenticationManager`

- Processes an `Authentication` request.

```java
public interface AuthenticationManager {
    Authentication authenticate(Authentication authentication) throws AuthenticationException;
}
```

`Authentication`

- Represents the token for an authentication request or for an authenticated principal once the request has been processed by the `AuthenticationManager.authenticate(Authentication)` method.

```java
public interface Authentication extends Principal, Serializable {
    Collection<? extends GrantedAuthority> getAuthorities();
    Object getCredentials();
    Object getDetails();
    Object getPrincipal();
    boolean isAuthenticated();
    void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException;
}
```

- https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/core/Authentication.html

1. AuthenticationFilter
2. AuthenticationToken
3. AuthenticationManager
   1. Failure: AuthenticationFailureHandler
   2. Success: AuthenticationSuccessHandler

`ExceptionTranslationFilter` saves request when redirected to login page.

Ant Matcher

- `?` matches one character
- `*` matched zero or more characters
- `**` matched zero or more directories in a path

Role vs Authority
