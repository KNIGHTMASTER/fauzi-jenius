package com.wissensalt.rnd.fj.sec.oauth2.dao;

import com.wissensalt.rnd.fj.sec.oauth2.data.Role;
import com.wissensalt.rnd.fj.util.exception.DAOException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 5/23/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IRoleDAO extends JpaRepository<Role, Long> {

    List<Role> findRoleByUsers_Code(String p_UserName) throws DAOException;

    Role findByCode(String p_Code) throws DAOException;
}
