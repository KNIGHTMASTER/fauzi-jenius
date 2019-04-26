package com.wissensalt.fj.api.logger.dao;

import com.wissensalt.fj.api.logger.data.APILog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAPILogDAO extends MongoRepository<APILog, String> {
}
