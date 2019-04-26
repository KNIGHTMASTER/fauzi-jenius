package com.wissensalt.rnd.fj.account.service;

import com.wissensalt.rnd.fj.account.dto.RequestPaginationDTO;
import com.wissensalt.rnd.fj.util.exception.ServiceException;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 */
public interface IInquiryService<DATA> {

    List<DATA> findAll() throws ServiceException;

    Page<DATA> findPagination(RequestPaginationDTO p_RequestPagination) throws ServiceException;
}
