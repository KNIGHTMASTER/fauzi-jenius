package com.wissensalt.rnd.fj.shared.data.dto.response;

public enum EResponseCode {
    RC_SUCCESS(200, "V-200", "Success"),
    RC_FAILURE(500, "X-VVV", "Web Service Failure");

    private int httpResponse;
    private String responseCode;
    private String responseMsg;

    private EResponseCode(int httpResponse, String responseCode, String responseMsg){
        this.httpResponse = httpResponse ;
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public int getHttpResponse() {
        return httpResponse;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    @Override
    public String toString() {
        return responseMsg;
    }
}
