package com.wissensalt.rnd.fj.account.service;

import com.wissensalt.rnd.fj.account.dto.RequestPaginationDTO;
import com.wissensalt.rnd.fj.account.model.Account;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IInquiryService {

    List<Account> findAll() throws ServiceException;

    Account findByUserName(String p_UserName) throws ServiceException;

    Account findByEmailAddress(String p_EmailAddress) throws ServiceException;

    Account findByAccountNumber(String p_AccountNumber) throws ServiceException;

    Account findByIdentityNumber(String p_IdentityNumber) throws ServiceException;

    Page<Account> findPagination(RequestPaginationDTO p_RequestPagination) throws ServiceException;
}
