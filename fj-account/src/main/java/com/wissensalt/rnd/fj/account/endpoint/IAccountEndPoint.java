package com.wissensalt.rnd.fj.account.endpoint;

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
public interface IAccountEndPoint extends IInquiryEndPoint, ITransactionEndPoint {

    @GetMapping("/delete")
    ResponseEntity deleteByUserName(@RequestParam("userName") String p_UserName) throws EndPointException;
}
