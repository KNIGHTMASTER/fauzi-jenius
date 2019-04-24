package com.wissensalt.rnd.fj.sec.oauth2.data.base;

import java.io.Serializable;

/**
 * Created on 2/27/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISingleKeyDATA<KEY extends Serializable> {

    public KEY getId();

}
