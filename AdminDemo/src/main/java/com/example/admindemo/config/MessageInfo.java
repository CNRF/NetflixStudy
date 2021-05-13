package com.example.admindemo.config;

/**
 * @author wmx
 * @version 1.0
 * @date 2021/5/13 11:25
 * @Description
 */
public class MessageInfo {

    private String content;
    public MessageInfo(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
