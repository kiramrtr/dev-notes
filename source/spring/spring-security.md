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

```java
public interface AuthenticationManager {
    Authentication authenticate(Authentication authentication) throws AuthenticationException;
}
```

`Authentication`

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

1. AuthenticationFilter
2. AuthenticationToken
3. AuthenticationManager
   1. Failure: AuthenticationFailureHandler
   2. Success: AuthenticationSuccessHandler

`ExceptionTranslationFilter` saves request when redirected to login page.
