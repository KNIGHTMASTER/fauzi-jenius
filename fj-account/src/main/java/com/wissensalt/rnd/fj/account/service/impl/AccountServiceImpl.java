package com.wissensalt.rnd.fj.account.service.impl;

import com.wissensalt.rnd.fj.account.dao.IAccountDAO;
import com.wissensalt.rnd.fj.account.dto.RequestInsertAccountDTO;
import com.wissensalt.rnd.fj.account.dto.RequestPaginationDTO;
import com.wissensalt.rnd.fj.account.mapper.AccountMapper;
import com.wissensalt.rnd.fj.account.model.Account;
import com.wissensalt.rnd.fj.account.service.IAccountService;
import com.wissensalt.rnd.fj.util.exception.DAOException;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired private IAccountDAO accountDAO;
    @Autowired private AccountMapper accountMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Override
    public List<Account> findAll() throws ServiceException {
        return accountDAO.findAll();
    }


    @Override
    public Account findByAccountNumber(String p_AccountNumber) throws ServiceException {
        try {
            return accountDAO.findByAccountNumber(p_AccountNumber);
        } catch (DAOException e) {
            LOGGER.error("Error find account by account number {} : {}", p_AccountNumber, e.toString());
            return null;
        }
    }

    @Override
    public Account findByIdentityNumber(String p_IdentityNumber) throws ServiceException {
        try {
            return accountDAO.findByIdentityNumber(p_IdentityNumber);
        } catch (DAOException e) {
            LOGGER.error("Error find account by identity number {} : {}", p_IdentityNumber, e.toString());
            return null;
        }
    }

    @Override
    public Page<Account> findPagination(RequestPaginationDTO p_RequestPagination) throws ServiceException {
        PageRequest pageRequest = PageRequest.of(
                p_RequestPagination.getOffset(),
                p_RequestPagination.getLimit(),
                Sort.Direction.fromString(p_RequestPagination.getOrder()),
                p_RequestPagination.getSort()
        );
        try {
            return accountDAO.findPagination(pageRequest);
        } catch (DAOException e) {
            LOGGER.error("Error find pagination account : {}", e.toString());
            return null;
        }
    }

    @Transactional
    @Override
    public Account insert(RequestInsertAccountDTO p_Request) throws ServiceException {
        return accountDAO.insert(accountMapper.convert(p_Request));
    }

    @Transactional
    @Override
    public Account update(RequestInsertAccountDTO p_Request) throws ServiceException {
        Account account = null;
        try {
            account = accountDAO.findByUserName(p_Request.getUserName());
        } catch (DAOException e) {
            LOGGER.error("Error find Account by User Name {} : {}", p_Request.getUserName(), e.toString());
        }
        if (account != null) {
            accountDAO.insert(accountMapper.convert(p_Request));
        }
        return null;
    }

    @Override
    public Boolean deleteByUserName(String p_UserName) throws ServiceException {
        Account account;
        try {
            account = accountDAO.findByUserName(p_UserName);
        } catch (DAOException e) {
            LOGGER.error("Error find Account By User Name");
            return false;
        }

        if (account != null) {
            accountDAO.deleteById(account.getId());
        }else {
            return false;
        }

        return true;
    }
}
