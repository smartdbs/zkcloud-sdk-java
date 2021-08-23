package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class ReaderUpdateRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 读头编号
     */
    @Expose
    private Integer readerNum;

    /**
     * 读头名称
     */
    @Expose
    private String readerName;

    /**
     * 出入类型, 0:入, 1:出
     */
    @Expose
    private Integer inOutType;

    /**
     * 读头总线类型(0:不使用, 1:使用RS-485读头, 2:使用韦根读头, 3:使用RS-485读头或者韦根读头）, 4:使用TCP/IP读头)
     */
    @Expose
    private Integer busType;

    /**
     * 启用状态，0:停用，1:启用
     */
    @Expose
    private Integer enable;

    /**
     * 是否离线通行, 0:正常通行, 1:拒绝通行
     */
    @Expose
    private Integer offlineRefuse;

    /**
     * 读头接在控制器上对应逻辑地址, 针对韦根读头; 读头拨码地址, 针对RS-485读头
     */
    @Expose
    private Integer address;

    /**
     * 读头连接控制器的串口(对应控制器串口丝印:RS-485 PORT1/RS-485 PORT2/RS-485 PORT3, 值分别为1/2/3)进行通信, 针对RS-485读头
     */
    @Expose
    private Integer serialPort;

    /**
     * 读头IP, 针对TCP/IP读头
     */
    @Expose
    private String ip;

    /**
     * 读头端口, 针对TCP/IP读头
     */
    @Expose
    private String port;

    /**
     * 读头MAC地址
     */
    @Expose
    private String mac;

    /**
     * 组播地址
     */
    @Expose
    private String multicast;


    public ReaderUpdateRequest(String sn, Integer readerNum) {
        this.sn = sn;
        this.readerNum = readerNum;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getReaderNum() {
        return readerNum;
    }

    public void setReaderNum(Integer readerNum) {
        this.readerNum = readerNum;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public Integer getInOutType() {
        return inOutType;
    }

    public void setInOutType(Integer inOutType) {
        this.inOutType = inOutType;
    }

    public Integer getBusType() {
        return busType;
    }

    public void setBusType(Integer busType) {
        this.busType = busType;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getOfflineRefuse() {
        return offlineRefuse;
    }

    public void setOfflineRefuse(Integer offlineRefuse) {
        this.offlineRefuse = offlineRefuse;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Integer getSerialPort() {
        return serialPort;
    }

    public void setSerialPort(Integer serialPort) {
        this.serialPort = serialPort;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getMulticast() {
        return multicast;
    }

    public void setMulticast(String multicast) {
        this.multicast = multicast;
    }
}
