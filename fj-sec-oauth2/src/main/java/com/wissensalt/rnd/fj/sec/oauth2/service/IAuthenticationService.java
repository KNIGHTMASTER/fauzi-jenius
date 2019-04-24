package com.wissensalt.rnd.fj.sec.oauth2.service;

import com.wissensalt.rnd.fj.sec.oauth2.data.User;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * Created on 5/17/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAuthenticationService extends LogoutHandler {

    User login(String p_UserName) throws ServiceException;

    void updateStatusLoggedIn(User p_User) throws ServiceException;

    void updateStatusLoggedOut(String p_UserName) throws ServiceException;

    void logoutJwt(HttpServletResponse httpServletResponse, String p_CookieName) throws ServiceException;
}
