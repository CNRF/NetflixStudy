package com.example.admindemo.config;


/**
 * @author wmx
 * @version 1.0
 * @date 2021/5/13 11:25
 * @Description
 */
public class Message {
    private String msgtype;
    private MessageInfo text;
    public String getMsgtype() {
        return msgtype;
    }
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
    public MessageInfo getText() {
        return text;
    }
    public void setText(MessageInfo text) {
        this.text = text;
    }
}
