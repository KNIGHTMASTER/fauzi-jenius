package com.wissensalt.rnd.fj.sec.oauth2.endpoint.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wissensalt.rnd.fj.sec.oauth2.endpoint.IAuthEndPoint;
import com.wissensalt.rnd.fj.sec.oauth2.service.IAuthenticationService;
import com.wissensalt.rnd.fj.shared.data.dto.request.RequestLoginDTO;
import com.wissensalt.rnd.fj.shared.data.dto.response.ResponseData;
import com.wissensalt.rnd.fj.shared.data.dto.response.ResponseTokenDTO;
import com.wissensalt.rnd.fj.util.apilogger.RequestLogger;
import com.wissensalt.rnd.fj.util.exception.EndPointException;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 8/10/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class OAuth2EndPointImpl implements IAuthEndPoint<RequestLoginDTO, ResponseTokenDTO> {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private ObjectMapper mapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(OAuth2EndPointImpl.class);

    @RequestLogger(name = "oauth2|logout")
    @Override
    public ResponseData logout(HttpServletRequest p_Request, HttpServletResponse p_Response) throws EndPointException {
        ResponseData result = new ResponseData(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            authenticationService.logout(p_Request, p_Response, auth);
            try {
                authenticationService.updateStatusLoggedOut(auth.getName());
            } catch (ServiceException e) {
                LOGGER.error("Update Status Logged Out Failed");
            }
            LOGGER.info("Logout Successful");
            try {
                authenticationService.updateStatusLoggedOut(auth.getName());
            } catch (ServiceException e) {
                LOGGER.error("Error Update Status Logged Out {}", e.toString());
            }
            result = new ResponseData(String.valueOf(HttpStatus.OK.value()), HttpStatus.OK.getReasonPhrase());
        }else {
            LOGGER.error("Logout Failed");
        }
        return result;
    }

    @Override
    public ResponseTokenDTO login(@RequestBody RequestLoginDTO requestLoginDTO, HttpServletResponse p_Response, HttpServletRequest p_Request) throws EndPointException {
        return null;
    }
}
