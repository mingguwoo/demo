package com.sh.demo.domain;

import java.util.Map;

/**
 * Created by wuminggu on 2018/4/19.
 */
public class Author {

    private Long id;
    private String pin;
    private String encryptPin;
    private String assignmentCenter;
    private String investmentCenter;
    private String userName;
    private Long discoveryId;
    private String discoveryName;
    private String wechatId;
    private String wechatName;
    private String userPic;
    private String phoneNumber;
    private String unionId;
    private String parentPin;
    private String parentUnionId;
    private Map<String, Long> privileges;
    private Integer source;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getEncryptPin() {
        return encryptPin;
    }

    public void setEncryptPin(String encryptPin) {
        this.encryptPin = encryptPin;
    }

    public String getAssignmentCenter() {
        return assignmentCenter;
    }

    public void setAssignmentCenter(String assignmentCenter) {
        this.assignmentCenter = assignmentCenter;
    }

    public String getInvestmentCenter() {
        return investmentCenter;
    }

    public void setInvestmentCenter(String investmentCenter) {
        this.investmentCenter = investmentCenter;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getDiscoveryId() {
        return discoveryId;
    }

    public void setDiscoveryId(Long discoveryId) {
        this.discoveryId = discoveryId;
    }

    public String getDiscoveryName() {
        return discoveryName;
    }

    public void setDiscoveryName(String discoveryName) {
        this.discoveryName = discoveryName;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getParentPin() {
        return parentPin;
    }

    public void setParentPin(String parentPin) {
        this.parentPin = parentPin;
    }

    public String getParentUnionId() {
        return parentUnionId;
    }

    public void setParentUnionId(String parentUnionId) {
        this.parentUnionId = parentUnionId;
    }

    public Map<String, Long> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Map<String, Long> privileges) {
        this.privileges = privileges;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", pin='" + pin + '\'' +
                ", encryptPin='" + encryptPin + '\'' +
                ", assignmentCenter='" + assignmentCenter + '\'' +
                ", investmentCenter='" + investmentCenter + '\'' +
                ", userName='" + userName + '\'' +
                ", discoveryId=" + discoveryId +
                ", discoveryName='" + discoveryName + '\'' +
                ", wechatId='" + wechatId + '\'' +
                ", wechatName='" + wechatName + '\'' +
                ", userPic='" + userPic + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", unionId='" + unionId + '\'' +
                ", parentPin='" + parentPin + '\'' +
                ", parentUnionId='" + parentUnionId + '\'' +
                ", privileges=" + privileges +
                ", source=" + source +
                '}';
    }
}
