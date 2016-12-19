package com.example.anicodebreaker.mrdp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("errorType")
    @Expose
    private String errorType;
    @SerializedName("errorDetails")
    @Expose
    private String errorDetails;

    /**
     * No args constructor for use in serialization
     */
    public Status() {
    }

    /**
     * @param errorType
     * @param code
     * @param errorDetails
     */
    public Status(int code, String errorType, String errorDetails) {
        super();
        this.code = code;
        this.errorType = errorType;
        this.errorDetails = errorDetails;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

}
