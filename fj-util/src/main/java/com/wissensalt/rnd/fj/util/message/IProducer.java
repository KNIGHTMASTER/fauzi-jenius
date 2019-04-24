package com.wissensalt.rnd.fj.util.message;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IProducer<DATA> {

    void produce(DATA p_DATA);
}