package com.wissensalt.rnd.fj.account.service;

import com.wissensalt.rnd.fj.account.dto.RequestInsertAccountDTO;
import com.wissensalt.rnd.fj.account.model.Account;
import com.wissensalt.rnd.fj.util.exception.ServiceException;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAccountService extends ICrudService<Account, RequestInsertAccountDTO> {

    Account findByAccountNumber(String p_AccountNumber) throws ServiceException;

    Account findByIdentityNumber(String p_IdentityNumber) throws ServiceException;
}
