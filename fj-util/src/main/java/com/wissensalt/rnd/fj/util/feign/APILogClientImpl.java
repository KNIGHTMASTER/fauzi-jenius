package com.wissensalt.rnd.fj.util.feign;

import com.wissensalt.rnd.fj.shared.data.dto.response.ResponseData;
import com.wissensalt.rnd.fj.util.apilogger.request.RequestAPILogDTO;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class APILogClientImpl {

    @Value("${logging.api.base-path}")
    private String loggingApiBasePath;

    public ResponseData conductPost(RequestAPILogDTO p_RequestAPILogDTO) throws ServiceException {
        IAPILogClient apiLogClient = FeignBuilderFactory.createClient(IAPILogClient.class, loggingApiBasePath);
        return apiLogClient.sendAPILog(p_RequestAPILogDTO);
    }
}
