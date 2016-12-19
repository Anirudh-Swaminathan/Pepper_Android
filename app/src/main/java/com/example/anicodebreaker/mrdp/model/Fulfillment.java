package com.example.anicodebreaker.mrdp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Fulfillment {

    @SerializedName("speech")
    @Expose
    private String speech;
    @SerializedName("messages")
    @Expose
    private List<Message> messages = null;

    /**
     * No args constructor for use in serialization
     */
    public Fulfillment() {
    }

    /**
     * @param speech
     * @param messages
     */
    public Fulfillment(String speech, List<Message> messages) {
        super();
        this.speech = speech;
        this.messages = messages;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}
