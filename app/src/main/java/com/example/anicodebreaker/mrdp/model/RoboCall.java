package com.example.anicodebreaker.mrdp.model;

/**
 * Created by anicodebreaker on 20/12/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Message {

    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("speech")
    @Expose
    private String speech;

    /**
     * No args constructor for use in serialization
     */
    public Message() {
    }

    /**
     * @param speech
     * @param type
     */
    public Message(int type, String speech) {
        super();
        this.type = type;
        this.speech = speech;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

}

class Metadata {

    @SerializedName("intentId")
    @Expose
    private String intentId;
    @SerializedName("webhookUsed")
    @Expose
    private String webhookUsed;
    @SerializedName("webhookForSlotFillingUsed")
    @Expose
    private String webhookForSlotFillingUsed;
    @SerializedName("intentName")
    @Expose
    private String intentName;

    /**
     * No args constructor for use in serialization
     */
    public Metadata() {
    }

    /**
     * @param intentId
     * @param webhookUsed
     * @param intentName
     * @param webhookForSlotFillingUsed
     */
    public Metadata(String intentId, String webhookUsed, String webhookForSlotFillingUsed, String intentName) {
        super();
        this.intentId = intentId;
        this.webhookUsed = webhookUsed;
        this.webhookForSlotFillingUsed = webhookForSlotFillingUsed;
        this.intentName = intentName;
    }

    public String getIntentId() {
        return intentId;
    }

    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }

    public String getWebhookUsed() {
        return webhookUsed;
    }

    public void setWebhookUsed(String webhookUsed) {
        this.webhookUsed = webhookUsed;
    }

    public String getWebhookForSlotFillingUsed() {
        return webhookForSlotFillingUsed;
    }

    public void setWebhookForSlotFillingUsed(String webhookForSlotFillingUsed) {
        this.webhookForSlotFillingUsed = webhookForSlotFillingUsed;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

}

class Parameters {


}

public class RoboCall {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("sessionId")
    @Expose
    private String sessionId;

    /**
     * No args constructor for use in serialization
     */
    public RoboCall() {
    }

    /**
     * @param timestamp
     * @param id
     * @param result
     * @param sessionId
     * @param status
     */
    public RoboCall(String id, String timestamp, Result result, Status status, String sessionId) {
        super();
        this.id = id;
        this.timestamp = timestamp;
        this.result = result;
        this.status = status;
        this.sessionId = sessionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}


