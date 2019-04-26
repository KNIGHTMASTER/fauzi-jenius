package com.wissensalt.rnd.fj.account.endpoint.impl;

import com.wissensalt.rnd.fj.account.dto.RequestInsertAccountDTO;
import com.wissensalt.rnd.fj.account.dto.RequestPaginationDTO;
import com.wissensalt.rnd.fj.account.endpoint.IAccountEndPoint;
import com.wissensalt.rnd.fj.account.service.IAccountService;
import com.wissensalt.rnd.fj.shared.data.dto.response.APIErrorBuilder;
import com.wissensalt.rnd.fj.shared.data.dto.response.EResponseCode;
import com.wissensalt.rnd.fj.shared.data.dto.response.ResponseData;
import com.wissensalt.rnd.fj.util.apilogger.RequestLogger;
import com.wissensalt.rnd.fj.util.exception.EndPointException;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    @RequestLogger(name = "account|delete")
    @Override
    public ResponseEntity deleteByUserName(@RequestParam("userName") String p_UserName) throws EndPointException {
        ResponseEntity result;
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

    @Cacheable(value = "accounts")
    @RequestLogger(name = "account|find-all")
    @Override
    public ResponseEntity findAll() throws EndPointException {
        ResponseEntity result;
        try {
            result = ResponseEntity.ok(accountService.findAll());
        } catch (ServiceException e) {
            LOGGER.error("Error Find All Account : {}", e.toString());
            result = new ResponseEntity<>(
                    APIErrorBuilder.internalServerError(
                            AccountEndPointImpl.class,
                            "Error Find All Account", "/account/find-all"
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @Cacheable(value = "account-by-number")
    @RequestLogger(name = "account|find-by-account-number")
    @Override
    public ResponseEntity findByAccountNumber(@RequestParam("accountNumber") String p_AccountNumber) throws EndPointException {
        ResponseEntity result;
        try {
            result = ResponseEntity.ok(accountService.findByAccountNumber(p_AccountNumber));
        } catch (ServiceException e) {
            LOGGER.error("Error Find Account By Account Number {} : {}", p_AccountNumber, e.toString());
            result = new ResponseEntity<>(
                    APIErrorBuilder.internalServerError(
                            AccountEndPointImpl.class,
                            "Error Find By Account Number", "/account/find/by-account-number"
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @Cacheable(value = "account-by-identity-number")
    @RequestLogger(name = "account|find-by-identity-number")
    @Override
    public ResponseEntity findByIdentityNumber(@RequestParam("identityNumber") String p_IdentityNumber) throws EndPointException {
        ResponseEntity result;
        try {
            result = ResponseEntity.ok(accountService.findByIdentityNumber(p_IdentityNumber));
        } catch (ServiceException e) {
            LOGGER.error("Error Find Account By Identity Number {} : {}", p_IdentityNumber, e.toString());
            result = new ResponseEntity<>(
                    APIErrorBuilder.internalServerError(
                            AccountEndPointImpl.class,
                            "Error Find By Identity Number", "/account/find/by-identity-number"
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @Cacheable(value = "account-pagination")
    @RequestLogger(name = "account|find-pagination")
    @Override
    public ResponseEntity findPagination(@RequestBody RequestPaginationDTO p_RequestPagination) throws EndPointException {
        ResponseEntity result;
        try {
            result = ResponseEntity.ok(accountService.findPagination(p_RequestPagination));
        } catch (ServiceException e) {
            LOGGER.error("Error Find Pagination Account", e.toString());
            result = new ResponseEntity<>(
                    APIErrorBuilder.internalServerError(
                            AccountEndPointImpl.class,
                            "Error Find Pagination Account", "/account/find/pagination"
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @RequestLogger(name = "account|insert")
    @Override
    public ResponseEntity insert(@RequestBody RequestInsertAccountDTO p_Request) throws EndPointException {
        ResponseEntity result;
        try {
            result = ResponseEntity.ok(accountService.insert(p_Request));
        } catch (ServiceException e) {
            LOGGER.error("Error Insert Account", e.toString());
            result = new ResponseEntity<>(
                    APIErrorBuilder.internalServerError(
                            AccountEndPointImpl.class,
                            "Error Update Account", "/account/insert"
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @RequestLogger(name = "account|update")
    @Override
    public ResponseEntity update(@RequestBody RequestInsertAccountDTO p_Request) throws EndPointException {
        ResponseEntity result;
        try {
            result = ResponseEntity.ok(accountService.update(p_Request));
        } catch (ServiceException e) {
            LOGGER.error("Error Update Account", e.toString());
            result = new ResponseEntity<>(
                    APIErrorBuilder.internalServerError(
                            AccountEndPointImpl.class,
                            "Error Update Account", "/account/update"
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }
}
