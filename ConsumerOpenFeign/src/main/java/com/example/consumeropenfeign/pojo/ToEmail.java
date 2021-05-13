package com.example.consumeropenfeign.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wmx
 * @version 1.0
 * @date 2021/5/13 10:46
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToEmail implements Serializable {

    /**
     * 邮件接收方，可多人
     */
    private String[] tos;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String content;
}

