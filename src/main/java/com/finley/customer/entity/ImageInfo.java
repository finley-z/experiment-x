package com.finley.customer.entity;

import java.util.Date;

/**
 * Created by ֣Զ�� on 2017/6/18.
 */
public class ImageInfo {
    private Integer imageId;
    private Integer customerId;
    private Integer typeId;         //图片类型
    private String  imagePath;
    private String  imageSuffix;
    private Long    imageSize;
    private Date    uploadTime;
    private Short   isMain;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageSuffix() {
        return imageSuffix;
    }

    public void setImageSuffix(String imageSuffix) {
        this.imageSuffix = imageSuffix;
    }

    public Long getImageSize() {
        return imageSize;
    }

    public void setImageSize(Long imageSize) {
        this.imageSize = imageSize;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }



    public Short getIsMain() {
        return isMain;
    }

    public void setIsMain(Short isMain) {
        this.isMain = isMain;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
