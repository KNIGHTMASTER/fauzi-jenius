package com.wissensalt.rnd.fj.sec.oauth2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wissensalt.rnd.fj.sec.oauth2.service.IAuthenticationService;
import com.wissensalt.rnd.fj.shared.data.dto.response.EResponseCode;
import com.wissensalt.rnd.fj.shared.data.dto.response.ResponseData;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 7/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class OAuthLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements LogoutSuccessHandler {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IAuthenticationService authenticationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OAuthLogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        ResponseData responseData;
        String token = httpServletRequest.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer")) {
            OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token.split(" ")[1]);

            LOGGER.info("TOKEN {}", oAuth2AccessToken.getValue());

            tokenStore.removeAccessToken(oAuth2AccessToken);
            responseData = new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg());
            LOGGER.info("token has been removed / invalidated");

            if (authentication != null) {
                if (authentication.getName() != null) {
                    try {
                        authenticationService.updateStatusLoggedOut(authentication.getName());
                    } catch (ServiceException e) {
                        LOGGER.error("Failed Logout {}" , e.toString());
                        responseData = new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg());
                    }
                }
            }else {
                LOGGER.info("Authentication is Empty");
            }
        }else {
            responseData = new ResponseData("403", "Un Authorized");
        }

        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.getWriter().println(objectMapper.writeValueAsString(responseData));
    }
}
