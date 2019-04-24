package com.wissensalt.rnd.fj.util.feign;

import com.wissensalt.rnd.fj.shared.data.dto.response.ResponseData;
import com.wissensalt.rnd.fj.util.apilogger.request.RequestAPILogDTO;
import feign.Headers;
import feign.RequestLine;

/**
 * Created on 6/4/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface IAPILogClient {

   @RequestLine("POST /api/apiLog/insert")
   ResponseData sendAPILog(RequestAPILogDTO p_RequestAPILogDTO);

}
