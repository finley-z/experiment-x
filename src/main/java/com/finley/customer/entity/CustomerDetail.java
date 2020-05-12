package com.finley.customer.entity;

import java.util.List;

public class CustomerDetail extends CustomerInfo{
    private Integer mobileUseTime;
    private Integer contactListNumber;
    private String jdbAccount;
    private String jdbPwd;
    private Integer sesameCreditScore;

    private String fatherName;
    private String fatherPhone;
    private Integer fatherChecked;
    private String motherName;
    private String motherPhone;
    private Integer motherChecked;
    private String mateName;
    private String matePhone;
    private Integer mateChecked;
    private String friend1Name;
    private String friend1Phone;
    private Integer friend1Checked;
    private String friend2Name;
    private String friend2Phone;
    private Integer friend2Checked;



    //图片信息
    private String idCardFronted;
    private String idCardBacked;
    private String idCardHandTake;
    private String personalLife;
    private String contactList;
    private String callHistories;

    private List<ImageInfo> others;

    private String contactListData;
    private String callHistoriesData;

    public Integer getMobileUseTime() {
        return mobileUseTime;
    }

    public void setMobileUseTime(Integer mobileUseTime) {
        this.mobileUseTime = mobileUseTime;
    }

    public Integer getContactListNumber() {
        return contactListNumber;
    }

    public void setContactListNumber(Integer contactListNumber) {
        this.contactListNumber = contactListNumber;
    }

    public String getJdbAccount() {
        return jdbAccount;
    }

    public void setJdbAccount(String jdbAccount) {
        this.jdbAccount = jdbAccount;
    }

    public String getJdbPwd() {
        return jdbPwd;
    }

    public void setJdbPwd(String jdbPwd) {
        this.jdbPwd = jdbPwd;
    }

    public Integer getSesameCreditScore() {
        return sesameCreditScore;
    }

    public void setSesameCreditScore(Integer sesameCreditScore) {
        this.sesameCreditScore = sesameCreditScore;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    public Integer getFatherChecked() {
        return fatherChecked;
    }

    public void setFatherChecked(Integer fatherChecked) {
        this.fatherChecked = fatherChecked;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherPhone() {
        return motherPhone;
    }

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone;
    }

    public Integer getMotherChecked() {
        return motherChecked;
    }

    public void setMotherChecked(Integer motherChecked) {
        this.motherChecked = motherChecked;
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }

    public String getMatePhone() {
        return matePhone;
    }

    public void setMatePhone(String matePhone) {
        this.matePhone = matePhone;
    }

    public Integer getMateChecked() {
        return mateChecked;
    }

    public void setMateChecked(Integer mateChecked) {
        this.mateChecked = mateChecked;
    }

    public String getFriend1Name() {
        return friend1Name;
    }

    public void setFriend1Name(String friend1Name) {
        this.friend1Name = friend1Name;
    }

    public String getFriend1Phone() {
        return friend1Phone;
    }

    public void setFriend1Phone(String friend1Phone) {
        this.friend1Phone = friend1Phone;
    }

    public Integer getFriend1Checked() {
        return friend1Checked;
    }

    public void setFriend1Checked(Integer friend1Checked) {
        this.friend1Checked = friend1Checked;
    }

    public String getFriend2Name() {
        return friend2Name;
    }

    public void setFriend2Name(String friend2Name) {
        this.friend2Name = friend2Name;
    }

    public String getFriend2Phone() {
        return friend2Phone;
    }

    public void setFriend2Phone(String friend2Phone) {
        this.friend2Phone = friend2Phone;
    }

    public Integer getFriend2Checked() {
        return friend2Checked;
    }

    public void setFriend2Checked(Integer friend2Checked) {
        this.friend2Checked = friend2Checked;
    }

    public String getIdCardFronted() {
        return idCardFronted;
    }

    public void setIdCardFronted(String idCardFronted) {
        this.idCardFronted = idCardFronted;
    }

    public String getIdCardBacked() {
        return idCardBacked;
    }

    public void setIdCardBacked(String idCardBacked) {
        this.idCardBacked = idCardBacked;
    }

    public String getIdCardHandTake() {
        return idCardHandTake;
    }

    public void setIdCardHandTake(String idCardHandTake) {
        this.idCardHandTake = idCardHandTake;
    }

    public String getPersonalLife() {
        return personalLife;
    }

    public void setPersonalLife(String personalLife) {
        this.personalLife = personalLife;
    }

    public String getContactList() {
        return contactList;
    }

    public void setContactList(String contactList) {
        this.contactList = contactList;
    }

    public String getCallHistories() {
        return callHistories;
    }

    public void setCallHistories(String callHistories) {
        this.callHistories = callHistories;
    }

    public List<ImageInfo> getOthers() {
        return others;
    }

    public void setOthers(List<ImageInfo> others) {
        this.others = others;
    }

    public String getContactListData() {
        return contactListData;
    }

    public void setContactListData(String contactListData) {
        this.contactListData = contactListData;
    }

    public String getCallHistoriesData() {
        return callHistoriesData;
    }

    public void setCallHistoriesData(String callHistoriesData) {
        this.callHistoriesData = callHistoriesData;
    }
}
