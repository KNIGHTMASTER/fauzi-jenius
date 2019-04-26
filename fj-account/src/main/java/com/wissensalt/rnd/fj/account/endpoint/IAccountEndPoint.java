package com.wissensalt.rnd.fj.account.endpoint;

import com.wissensalt.rnd.fj.account.dto.RequestInsertAccountDTO;
import com.wissensalt.rnd.fj.util.exception.EndPointException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created on 4/25/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RequestMapping("/account")
public interface IAccountEndPoint extends IInquiryEndPoint, ITransactionEndPoint<RequestInsertAccountDTO> {

    @GetMapping("/delete")
    ResponseEntity deleteByUserName(@RequestParam("userName") String p_UserName) throws EndPointException;

    @GetMapping("find/by-account-number")
    ResponseEntity findByAccountNumber(@RequestParam("accountNumber") String p_AccountNumber) throws EndPointException;

    @GetMapping("find/by-identity-number")
    ResponseEntity findByIdentityNumber(@RequestParam("identityNumber") String p_IdentityNumber) throws EndPointException;
}
