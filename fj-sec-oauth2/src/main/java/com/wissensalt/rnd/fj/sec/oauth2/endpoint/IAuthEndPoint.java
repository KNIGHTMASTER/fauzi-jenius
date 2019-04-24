package com.wissensalt.rnd.fj.sec.oauth2.endpoint;

import com.wissensalt.rnd.fj.shared.data.dto.response.ResponseData;
import com.wissensalt.rnd.fj.util.exception.EndPointException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 6/3/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(tags = "API Authentication", value = "API Authentication", description = "API for Authentication Login / Logout")
@RequestMapping("/auth")
public interface IAuthEndPoint<LOGIN_DATA, RESPONSE_DTO> {

    @PostMapping("/logout")
    ResponseData logout(HttpServletRequest p_Request, HttpServletResponse p_Response) throws EndPointException;

    @PostMapping("/login")
    RESPONSE_DTO login(@RequestBody LOGIN_DATA login_data, HttpServletResponse p_Response, HttpServletRequest p_Request) throws EndPointException;
}
