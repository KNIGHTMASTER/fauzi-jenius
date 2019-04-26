package com.wissensalt.rnd.fj.account.endpoint;

import com.wissensalt.rnd.fj.account.dto.RequestPaginationDTO;
import com.wissensalt.rnd.fj.util.exception.EndPointException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created on 4/25/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IInquiryEndPoint {

    @GetMapping("/")
    ResponseEntity findAll() throws EndPointException;

    @GetMapping("/pagination")
    ResponseEntity findPagination(@RequestBody RequestPaginationDTO p_RequestPagination) throws EndPointException;
}
