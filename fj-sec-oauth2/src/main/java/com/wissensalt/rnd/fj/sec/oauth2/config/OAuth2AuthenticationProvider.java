package com.wissensalt.rnd.fj.sec.oauth2.config;

import com.wissensalt.rnd.fj.sec.oauth2.data.User;
import com.wissensalt.rnd.fj.sec.oauth2.service.IAuthenticationService;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.BadClientCredentialsException;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.stereotype.Component;

/**
 * Created on 5/17/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class OAuth2AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${oauth.token-validity-in-seconds}")
    private Integer tokenValidity;

    private static final Logger LOGGER = LoggerFactory.getLogger(OAuth2AuthenticationProvider.class);

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        User user = null;
        try {
            user = authenticationService.login(s);
        } catch (ServiceException e) {
            LOGGER.error("Error Login {}", e.toString());
        }
        if (user != null) {
            if (user.getPassword() == null || user.getPassword().trim().length() <= 0) {
                user.setPassword("");
            }
            return user;
        }else {
            LOGGER.error("User is not found");
            throw new UsernameNotFoundException("User is not found");
        }
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = null;
        try {
            user = authenticationService.login(authentication.getName());
        } catch (ServiceException e) {
            LOGGER.error("Error Login {}", e.toString());
        }
        if (user != null) {
            if (user.getPassword() == null || user.getPassword().trim().length() <= 0) {
                user.setPassword("");
            }
            if (passwordEncoder.matches(String.valueOf(authentication.getCredentials()), user.getPassword())) {
                LOGGER.info("{} - Successfully Login", user.getUsername());
                try {
                    authenticationService.updateStatusLoggedIn(user);
                } catch (ServiceException e) {
                    LOGGER.error("Error Update Login Status {}", e.toString());
                }
                return super.authenticate(authentication);
            }else {
                LOGGER.warn("Password User {} does not match", authentication.getName());
                throw new BadClientCredentialsException();
            }
        }else {
            LOGGER.error("User {} is not found", authentication.getName());
            throw new UnauthorizedUserException("User Is Not Found");
        }
    }
}
