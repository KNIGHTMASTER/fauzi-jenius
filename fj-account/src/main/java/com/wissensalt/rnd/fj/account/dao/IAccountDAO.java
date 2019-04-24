package com.wissensalt.rnd.fj.account.dao;

import com.wissensalt.rnd.fj.account.model.Account;
import com.wissensalt.rnd.fj.util.exception.DAOException;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAccountDAO extends MongoRepository<Account, ObjectId> {

    Account findByUserName(String p_UserName) throws DAOException;

    Account findByEmailAddress(String p_EmailAddress) throws DAOException;

    Account findByAccountNumber(String p_AccountNumber) throws DAOException;

    Account findByIdentityNumber(String p_IdentityNumber) throws DAOException;

    Page<Account> findPagination(PageRequest p_PageRequest) throws DAOException;
}
