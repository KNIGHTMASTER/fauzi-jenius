package com.wissensalt.rnd.fj.util.apilogger.base;

import com.wissensalt.rnd.fj.util.apilogger.RequestLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.web.util.ContentCachingRequestWrapper;

/**
 * Created on 10/31/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IRequestLoggerAspect {

    @Around("execution(@RequestLogger * *(..)) && @annotation(requestLogger)")
    Object logRequest(ProceedingJoinPoint joinPoint, RequestLogger requestLogger) throws Throwable;

    String getRequestBody(final ContentCachingRequestWrapper wrapper);

    ContentCachingRequestWrapper getWrapper(ProceedingJoinPoint joinPoint);
}
