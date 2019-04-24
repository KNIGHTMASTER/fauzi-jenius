package com.wissensalt.rnd.fj.shared.data.mapping;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

/**
 * Created on 4/24/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface MappingConfig {
}