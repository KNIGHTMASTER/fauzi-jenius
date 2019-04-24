package com.wissensalt.rnd.fj.util.apilogger.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wissensalt.rnd.fj.util.apilogger.RequestLogger;
import com.wissensalt.rnd.fj.util.apilogger.request.ContentAPIRequestData;
import com.wissensalt.rnd.fj.util.apilogger.request.ContentAPIResponseData;
import com.wissensalt.rnd.fj.util.apilogger.request.RequestAPILogDTO;
import com.wissensalt.rnd.fj.util.feign.APILogClientImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public abstract class ARequestLoggerAspect implements IRequestLoggerAspect {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private APILogClientImpl apiLogClientImpl;

    private static final Logger LOGGER = LoggerFactory.getLogger(ARequestLoggerAspect.class);

    @Override
    public Object logRequest(ProceedingJoinPoint joinPoint, RequestLogger requestLogger) throws Throwable {
        RequestAPILogDTO requestAPILogDTO = new RequestAPILogDTO();
        StringBuilder apiLog = new StringBuilder();
        apiLog.append(requestLogger.name()).append("\n");

        requestAPILogDTO.setServiceName(requestLogger.name());
        requestAPILogDTO.setTimeStamp(new Date());

        ContentCachingRequestWrapper request = getWrapper(joinPoint);

        ContentAPIRequestData apiRequestData = new ContentAPIRequestData();

        List<String> cookieRequest = new ArrayList<>();

        Object retVal = null;
        retVal = joinPoint.proceed();

        if (request != null) {
            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies() ) {
                    String cookieContent = cookie.getName().concat(":").concat(cookie.getValue());
                    cookieRequest.add(cookieContent);
                    apiLog.append(cookieContent).append("\n");
                }
            }
            apiRequestData.setCookies(cookieRequest);

            List<String> headerRequest = new ArrayList<>();

            for (String header : Collections.list(request.getHeaderNames())) {
                String headerContent = header.concat(":").concat(request.getHeader(header));
                headerRequest.add(headerContent);
                apiLog.append(headerContent).append("\n");
            }
            apiRequestData.setHeaders(headerRequest);
            apiRequestData.setRemoteAddress(request.getRemoteAddr());
            apiRequestData.setRemotePort(request.getRemotePort());
            apiRequestData.setRemoteUser(request.getRemoteUser());
            apiRequestData.setMethod(request.getMethod());
            apiRequestData.setRequestUrl(request.getRequestURI());

            String requestBody = getRequestBody(request);

            apiRequestData.setPayload(requestBody);
            requestAPILogDTO.setRequestData(apiRequestData);

            apiLog.append("method ").append(request.getMethod()).append("\n");
            apiLog.append("auth type ").append(request.getAuthType()).append("\n");
            apiLog.append("remote Address ").append(request.getRemoteAddr()).append("\n");
            apiLog.append("Remote user ").append(request.getRemoteUser()).append("\n");
            apiLog.append("remote host ").append(request.getRemoteHost()).append("\n");
            apiLog.append("remote port ").append(request.getRemotePort()).append("\n");
            apiLog.append("Request API: ").append(request.getRequestURL().toString()).append("\n");
            apiLog.append("Payload :").append(getRequestBody(request)).append("\n");

            ContentAPIResponseData responseData = new ContentAPIResponseData();
            try {
                responseData.setBody(objectMapper.writeValueAsString(retVal));
            } catch (JsonProcessingException e) {
                LOGGER.debug("Error Parsing Response Data {}", e.toString());
            }
            responseData.setHost(request.getRemoteHost());
            requestAPILogDTO.setResponseData(responseData);
        }


        apiLog.append("Response:").append(objectMapper.writeValueAsString(retVal));
        LOGGER.debug(apiLog.toString());

        apiLogClientImpl.conductPost(requestAPILogDTO);
        return retVal;
    }


    @Override
    public String getRequestBody(ContentCachingRequestWrapper wrapper) {
        String payload = null;
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                try {
                    int maxLength = buf.length > 500 ? 500 : buf.length;

                    payload = new String(buf, 0, maxLength, wrapper.getCharacterEncoding());
                } catch (UnsupportedEncodingException e) {
                    LOGGER.error("UnsupportedEncoding : {}", e);
                }
            }
        }
        return payload;
    }

    @Override
    public ContentCachingRequestWrapper getWrapper(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        ContentCachingRequestWrapper request = null;

        for (Object arg : args) {
            if (arg instanceof ContentCachingRequestWrapper) {
                request = (ContentCachingRequestWrapper) arg;
                break;
            }
        }
        return request;
    }

}
