package com.wissensalt.rnd.fj.account.service;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <REQUEST>
 */
public interface ICrudService<DATA, REQUEST> extends IInquiryService<DATA>, ITransactionService<DATA, REQUEST> {
}
