package com.wissensalt.rnd.fj.util.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <SOURCE> Data to Convert
 * @param <TARGET> Result of Convert
 */
public interface IDATAMapper<SOURCE, TARGET> extends Converter<SOURCE, TARGET> {

    List<TARGET> mapEntitiesIntoDTOs(Iterable<SOURCE> entities);

    Page<TARGET> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<SOURCE> source);
    
    SOURCE convertReverse(TARGET p_TARGET);
}
