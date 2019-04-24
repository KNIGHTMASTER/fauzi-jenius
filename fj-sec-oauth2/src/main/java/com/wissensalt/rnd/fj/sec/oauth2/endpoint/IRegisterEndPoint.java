package com.wissensalt.rnd.fj.sec.oauth2.endpoint;

import com.wissensalt.rnd.fj.sec.oauth2.data.dto.RequestRegisterDTO;
import com.wissensalt.rnd.fj.util.exception.EndPointException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 4/25/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RequestMapping("/security")
public interface IRegisterEndPoint {

    @PostMapping("/register")
    ResponseEntity register(@RequestBody RequestRegisterDTO p_Request) throws EndPointException;
}
