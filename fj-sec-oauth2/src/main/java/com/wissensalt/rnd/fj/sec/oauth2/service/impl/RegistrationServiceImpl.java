package com.wissensalt.rnd.fj.sec.oauth2.service.impl;

import com.wissensalt.rnd.fj.sec.oauth2.dao.IRoleDAO;
import com.wissensalt.rnd.fj.sec.oauth2.dao.IUserDAO;
import com.wissensalt.rnd.fj.sec.oauth2.data.Role;
import com.wissensalt.rnd.fj.sec.oauth2.data.User;
import com.wissensalt.rnd.fj.sec.oauth2.data.dto.RequestRegisterDTO;
import com.wissensalt.rnd.fj.sec.oauth2.service.IRegistrationService;
import com.wissensalt.rnd.fj.util.exception.DAOException;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 4/25/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class RegistrationServiceImpl implements IRegistrationService {

    @Autowired private IUserDAO userDAO;
    @Autowired private IRoleDAO roleDAO;
    @Autowired private PasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    @Override
    public void register(RequestRegisterDTO p_Request) throws ServiceException {
        User user = new User();
        user.setCode(p_Request.getUserName());
        user.setLoginStatus(false);
        user.setNonLocked(true);
        user.setEnabled(true);

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, 1);
        Date expiredDate = c.getTime();

        user.setCredentialsExpiredDate(expiredDate);
        user.setExpiredDate(expiredDate);
        user.setPassword(passwordEncoder.encode(p_Request.getPassword()));

        Role role = null;
        try {
            role = roleDAO.findByCode("ROLE_USER");
        } catch (DAOException e) {
            LOGGER.error("Error find role by code {} : {}", "ROLE_USER", e.toString());
        }

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        userDAO.save(user);
    }
}
