package com.wissensalt.fj.api.logger.message;

import com.wissensalt.fj.api.logger.exception.APILoggerServiceException;
import com.wissensalt.fj.api.logger.mapper.APILogMapper;
import com.wissensalt.fj.api.logger.service.ILogService;
import com.wissensalt.rnd.fj.util.apilogger.request.RequestAPILogDTO;
import com.wissensalt.rnd.fj.util.message.ISubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class FanoutApiLogListener implements ISubscriber<RequestAPILogDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutApiLogListener.class);

    @Autowired
    @Qualifier(value = "apiLogService")
    private ILogService logService;

    @Autowired
    private APILogMapper apiLogMapper;

    @RabbitListener(queues = "${rabbitmq.queue.api-logger}")
    @Override
    public void receive(RequestAPILogDTO p_DATA) {
        try {
            logService.insert(apiLogMapper.convert(p_DATA));
        } catch (APILoggerServiceException e) {
            LOGGER.error("Error insert API Log : {}", e.toString());
        }
    }
}
