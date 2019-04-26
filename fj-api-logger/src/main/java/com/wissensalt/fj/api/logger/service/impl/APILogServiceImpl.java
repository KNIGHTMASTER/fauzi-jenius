package com.wissensalt.fj.api.logger.service.impl;

import com.wissensalt.fj.api.logger.dao.IAPILogDAO;
import com.wissensalt.fj.api.logger.data.APILog;
import com.wissensalt.fj.api.logger.exception.APILoggerServiceException;
import com.wissensalt.fj.api.logger.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service(value = "apiLogService")
public class APILogServiceImpl implements ILogService<APILog> {

    @Autowired
    private IAPILogDAO apiLogDAO;

    @Async
    @Override
    public void insert(APILog p_DATA) throws APILoggerServiceException {
        apiLogDAO.save(p_DATA);
    }
}
