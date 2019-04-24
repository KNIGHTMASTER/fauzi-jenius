package com.wissensalt.rnd.fj.account.mapper;

import com.wissensalt.rnd.fj.account.dto.RequestInsertAccountDTO;
import com.wissensalt.rnd.fj.account.model.Account;
import com.wissensalt.rnd.fj.util.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 4/25/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class AccountMapper extends ADATAMapper<RequestInsertAccountDTO, Account> {

    @Override
    public Account convert(RequestInsertAccountDTO requestInsertAccountDTO) {
        Account result = new Account();
        result.setUserName(requestInsertAccountDTO.getUserName());
        result.setAccountNumber(requestInsertAccountDTO.getAccountNumber());
        result.setEmailAddress(requestInsertAccountDTO.getEmailAddress());
        result.setIdentityNumber(requestInsertAccountDTO.getIdentityNumber());
        return result;
    }
}
