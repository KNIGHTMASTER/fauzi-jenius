package com.wissensalt.fj.api.logger.service;

import com.wissensalt.fj.api.logger.exception.APILoggerServiceException;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface ILogService<DATA> {

    void insert(DATA p_DATA) throws APILoggerServiceException;
}
