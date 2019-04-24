package com.wissensalt.rnd.fj.account.endpoint.impl;

import com.wissensalt.rnd.fj.account.dto.RequestInsertAccountDTO;
import com.wissensalt.rnd.fj.account.dto.RequestPaginationDTO;
import com.wissensalt.rnd.fj.account.endpoint.IAccountEndPoint;
import com.wissensalt.rnd.fj.account.service.IAccountService;
import com.wissensalt.rnd.fj.shared.data.dto.response.APIErrorBuilder;
import com.wissensalt.rnd.fj.shared.data.dto.response.EResponseCode;
import com.wissensalt.rnd.fj.shared.data.dto.response.ResponseData;
import com.wissensalt.rnd.fj.util.exception.EndPointException;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 4/25/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class AccountEndPointImpl implements IAccountEndPoint {

    @Autowired private IAccountService  accountService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountEndPointImpl.class);

    @Override
    public ResponseEntity deleteByUserName(@RequestParam("userName") String p_UserName) throws EndPointException {
        ResponseEntity result = ResponseEntity.ok(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));;
        try {
            if (!accountService.deleteByUserName(p_UserName)) {
                result = ResponseEntity.ok(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));
            }else {
                result = new ResponseEntity<>(
                        APIErrorBuilder.internalServerError(
                                AccountEndPointImpl.class,
                                "Error Delete Account By User Name", "/account/delete"
                        ),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ServiceException e) {
            LOGGER.error("Error Delete Account By User Name {}", e.toString());
            result = new ResponseEntity<>(
                    APIErrorBuilder.internalServerError(
                            AccountEndPointImpl.class,
                            "Error Delete Account By User Name", "/account/delete"
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @Override
    public ResponseEntity findAll() throws EndPointException {
        ResponseEntity result = ResponseEntity.ok(new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg()));;
        return null;
    }

    @Override
    public ResponseEntity findByUserName(@RequestParam("userName") String p_UserName) throws EndPointException {
        return null;
    }

    @Override
    public ResponseEntity findByEmailAddress(@RequestParam("emailAddress") String p_EmailAddress) throws EndPointException {
        return null;
    }

    @Override
    public ResponseEntity findByAccountNumber(@RequestParam("accountNumber") String p_AccountNumber) throws EndPointException {
        return null;
    }

    @Override
    public ResponseEntity findByIdentityNumber(@RequestParam("identityNumber") String p_IdentityNumber) throws EndPointException {
        return null;
    }

    @Override
    public ResponseEntity findPagination(@RequestBody RequestPaginationDTO p_RequestPagination) throws EndPointException {
        return null;
    }

    @Override
    public ResponseEntity insert(@RequestBody RequestInsertAccountDTO p_Request) throws EndPointException {
        return null;
    }

    @Override
    public ResponseEntity update(@RequestBody RequestInsertAccountDTO p_Request) throws EndPointException {
        return null;
    }
}
