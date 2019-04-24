package com.wissensalt.rnd.fj.sec.oauth2.dao;

import com.wissensalt.rnd.fj.sec.oauth2.data.User;
import com.wissensalt.rnd.fj.util.exception.DAOException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 5/23/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IUserDAO extends JpaRepository<User, Long> {

    User findByCode(String p_Code) throws DAOException;

    List<User> findByCodeContainingAndNameContaining(String p_Code, String p_Name) throws DAOException;

    List<User> findByCodeContainingOrNameContainingAndRoles_code(String p_Code, String p_Name, String p_RoleCode) throws DAOException;

    List<User> findByCodeContaining(String p_code) throws DAOException;

    List<User> findByCodeContainingAndRoles_code(String p_code, String p_RoleCode) throws DAOException;

    List<User> findByNameContainingAndRoles_code(String p_code, String p_RoleCode) throws DAOException;

    List<User> findByRoles_code(String p_RoleCode) throws DAOException;

    User findByCodeAndRoles_code(String p_Name, String p_RoleCode) throws DAOException;

}
