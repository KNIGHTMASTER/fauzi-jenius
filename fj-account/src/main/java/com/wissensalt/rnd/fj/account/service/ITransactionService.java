package com.wissensalt.rnd.fj.account.service;

import com.wissensalt.rnd.fj.account.dto.RequestInsertAccountDTO;
import com.wissensalt.rnd.fj.account.model.Account;
import com.wissensalt.rnd.fj.util.exception.ServiceException;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ITransactionService {

    Account insert(RequestInsertAccountDTO p_Request) throws ServiceException;

    Account update(RequestInsertAccountDTO p_Request) throws ServiceException;

    Boolean deleteByUserName(String p_UserName) throws ServiceException;
}
