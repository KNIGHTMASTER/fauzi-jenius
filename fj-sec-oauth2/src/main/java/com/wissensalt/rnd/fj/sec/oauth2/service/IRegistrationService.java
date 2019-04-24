package com.wissensalt.rnd.fj.sec.oauth2.service;

import com.wissensalt.rnd.fj.sec.oauth2.data.dto.RequestRegisterDTO;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 4/25/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IRegistrationService {

    @Transactional
    void register(RequestRegisterDTO p_Request) throws ServiceException;
}
