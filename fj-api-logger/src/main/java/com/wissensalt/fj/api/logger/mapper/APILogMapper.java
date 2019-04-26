package com.wissensalt.fj.api.logger.mapper;

import com.wissensalt.fj.api.logger.data.APILog;
import com.wissensalt.fj.api.logger.data.APIRequestData;
import com.wissensalt.fj.api.logger.data.APIResponseData;
import com.wissensalt.rnd.fj.util.apilogger.request.RequestAPILogDTO;
import com.wissensalt.rnd.fj.util.mapper.ADATAMapper;
import org.springframework.stereotype.Service;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class APILogMapper extends ADATAMapper<RequestAPILogDTO, APILog> {
    @Override
    public APILog convert(RequestAPILogDTO requestAPILogDTO) {
        APILog result = new APILog();
        result.setTimeStamp(requestAPILogDTO.getTimeStamp());
        result.setServiceName(requestAPILogDTO.getServiceName());

        APIRequestData requestData = new APIRequestData();
        if (requestAPILogDTO.getRequestData() != null) {
            requestData.setRemoteAddress(requestAPILogDTO.getRequestData().getRemoteAddress());
            requestData.setRemotePort(requestAPILogDTO.getRequestData().getRemotePort());
            requestData.setRemoteUser(requestAPILogDTO.getRequestData().getRemoteUser());
            requestData.setMethod(requestAPILogDTO.getRequestData().getMethod());
            requestData.setRequestUrl(requestAPILogDTO.getRequestData().getRequestUrl());
            requestData.setHeaders(requestAPILogDTO.getRequestData().getHeaders());
            requestData.setCookies(requestAPILogDTO.getRequestData().getCookies());
            requestData.setPayload(requestAPILogDTO.getRequestData().getPayload());

            result.setRequestData(requestData);
        }

        APIResponseData responseData = new APIResponseData();
        if (requestAPILogDTO.getResponseData() != null) {
            responseData.setHost(requestAPILogDTO.getResponseData().getHost());
            responseData.setBody(requestAPILogDTO.getResponseData().getBody());

            result.setResponseData(responseData);
        }

        return result;
    }
}
