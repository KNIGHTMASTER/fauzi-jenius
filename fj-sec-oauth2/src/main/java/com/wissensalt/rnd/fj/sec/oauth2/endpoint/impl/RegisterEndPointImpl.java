package com.wissensalt.rnd.fj.sec.oauth2.endpoint.impl;

import com.wissensalt.rnd.fj.sec.oauth2.data.dto.RequestRegisterDTO;
import com.wissensalt.rnd.fj.sec.oauth2.endpoint.IRegisterEndPoint;
import com.wissensalt.rnd.fj.sec.oauth2.service.IRegistrationService;
import com.wissensalt.rnd.fj.shared.data.dto.response.APIErrorBuilder;
import com.wissensalt.rnd.fj.shared.data.dto.response.EResponseCode;
import com.wissensalt.rnd.fj.shared.data.dto.response.ResponseData;
import com.wissensalt.rnd.fj.util.apilogger.RequestLogger;
import com.wissensalt.rnd.fj.util.exception.EndPointException;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 4/25/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class RegisterEndPointImpl implements IRegisterEndPoint {

    @Autowired private IRegistrationService registrationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterEndPointImpl.class);

    @RequestLogger(name = "|security|register")
    @Override
    public ResponseEntity register(@RequestBody RequestRegisterDTO p_Request) throws EndPointException {
        try {
            registrationService.register(p_Request);
            return ResponseEntity.ok(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
        } catch (ServiceException e) {
            LOGGER.error("Error registering user : {}", e.toString());
            return new ResponseEntity<>(APIErrorBuilder.internalServerError(RegisterEndPointImpl.class, "Error Registering User", "/security/register"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
