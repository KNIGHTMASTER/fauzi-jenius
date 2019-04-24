package com.wissensalt.rnd.fj.account.endpoint;

import com.wissensalt.rnd.fj.account.dto.RequestInsertAccountDTO;
import com.wissensalt.rnd.fj.util.exception.EndPointException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created on 4/25/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ITransactionEndPoint {

    @PostMapping("/insert")
    ResponseEntity insert(@RequestBody RequestInsertAccountDTO p_Request) throws EndPointException;

    @PutMapping("/update")
    ResponseEntity update(@RequestBody RequestInsertAccountDTO p_Request) throws EndPointException;
}
