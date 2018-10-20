package com.sky.hrpro.util;

import io.grpc.Metadata;

/**
 * @Author: CarryJey
 * @Date: 2018/10/2 11:26:38
 */
public abstract class Constants {
    private Constants(){}

    public static final String HEADER_NAME_REQUEST_ID = "X-Request-Id";
    public static final String HEADER_NAME_REQUEST_IP = "X-Real-IP";

    public static final Metadata.Key<String> HEADER_KEY_REQUEST_ID =
            Metadata.Key.of(HEADER_NAME_REQUEST_ID, Metadata.ASCII_STRING_MARSHALLER);

    public static final String MAIL_FROM_IP = "***@163.com";   //发件邮箱地址
    public static final String MAIL_FROM_NAME = "***@163.com";   //发件邮箱称号，同邮箱地址
    public static final String MAIL_FROM_PASSWORD = "******";   //发件邮箱授权码


}
