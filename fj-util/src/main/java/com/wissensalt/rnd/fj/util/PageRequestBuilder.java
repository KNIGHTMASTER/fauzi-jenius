package com.wissensalt.rnd.fj.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Created on 12/26/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class PageRequestBuilder {

    /**
     *
     * Build custom page request
     * @param p_Page
     * @param p_Size
     * @param p_Direction
     * @param p_Order
     * @return
     */
    public static PageRequest build(Integer p_Page, Integer p_Size, String p_Direction, String p_Order) {
        PageRequest pageRequest;
        if (p_Direction.equals("asc")) {
            pageRequest = PageRequest.of(p_Page, p_Size, Sort.Direction.ASC, p_Order);
        }else {
            pageRequest = PageRequest.of(p_Page, p_Size, Sort.Direction.DESC, p_Order);
        }

        return pageRequest;
    }
}
