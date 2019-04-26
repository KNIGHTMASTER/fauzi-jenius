package com.wissensalt.rnd.fj.account.service;

import com.wissensalt.rnd.fj.util.exception.ServiceException;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <REQUEST>
 */
public interface ITransactionService<DATA, REQUEST> {

    DATA insert(REQUEST p_Request) throws ServiceException;

    DATA update(REQUEST p_Request) throws ServiceException;

    Boolean deleteByUserName(String p_UserName) throws ServiceException;
}
