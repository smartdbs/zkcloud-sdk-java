package com.zkteco.dbs.client.processor.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class DbsConfig {

    /**
     * 接收DBS推送的token，作为签名认证使用
     */
    @Value("${dbs.push.token}")
    private String pushToken;

    /**
     * 接收DBS推送的数据密钥，当开启数据加密时使用
     */
    @Value("${dbs.push.secret}")
    private String pushSecret;

    /**
     * 数据推送加密开关
     */
    @Value("${dbs.push.switch.encrypt:false}")
    private boolean encrypt;

    /**
     * 数据推送打卡记录开关
     */
    @Value("${dbs.push.switch.punchRecord:false}")
    private boolean punchRecord;

    /**
     * 数据推送打卡照片开关
     */
    @Value("${dbs.push.switch.punchPhoto:false}")
    private boolean punchPhoto;

    /**
     * 设备初始化推送开关
     */
    @Value("${dbs.push.switch.deviceInit:false}")
    private boolean deviceInit;

    /**
     * 设备状态变化推送开关
     */
    @Value("${dbs.push.switch.deviceStatus:false}")
    private boolean deviceStatus;

    /**
     * 指纹登记进度通知推送开关
     */
    @Value("${dbs.push.switch.registerFpTip:false}")
    private boolean registerFpTip;

    /**
     * 数据推送请求有效性验证之 时间戳有效性范围，单位：秒
     */
    @Value("${dbs.push.valid.rangTime:300}")
    private int validRangTime;

    /**
     * appKey
     */
    @Value("${dbs.api.appKey}")
    private String appKey;

    /**
     * appSecret
     */
    @Value("${dbs.api.appSecret}")
    private String appSecret;

    /**
     * DBS API节点服务器地址
     */
    @Value("${dbs.api.endpoint}")
    private String endpoint;

    /**
     * DBS API节点服务器是否支持ssl，即https
     */
    @Value("${dbs.api.ssl:true}")
    private boolean ssl;

}
