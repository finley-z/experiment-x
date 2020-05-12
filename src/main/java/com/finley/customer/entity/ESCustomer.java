package com.finley.customer.entity;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @description
 * @auth panmingshuai
 * @time 2017年12月7日  下午12:31:50
 * @Document注解里面的几个属性，类比mysql的话是这样： indexName –> DB 		索引库的名称
 * type –> Table 		类型
 * shards  				分片数         		拥有更多的碎片可以提升索引执行能力，并允许通过机器分发一个大型的索引；
 * replicas  			每个分区的备份数        拥有更多的副本能够提升搜索执行能力以及集群能力。
 * refreshInterval   	刷新时间        单位秒
 * indexStoreType		索引文件存储类型
 */
@Document(indexName = "loans2", type = "customer_es2")
public class ESCustomer {
    @Field(type = FieldType.Integer, store = true,fielddata = true)
    private Integer id;

    /**
     * type  	类型，可以是boolean,long,double,date,string
     * index 	是否进行索引，analyzed表示索引，并且对数据进行拆词，not_analyzed表示索引，但是不进行拆词，no表示不索引。也就没法对该字段进行搜索。
     * analyzer	是字段文本的分词器。默认standard分词器，另外还有whitespace, simple, or english等。
     * search_analyzer是搜索词的分词器
     * 设置store为true，可以把字段原始值保存，但是索引会更大，需要根据需求使用
     * String[] ignoreFields() default {};#如果某个字段需要被忽略
     */
    @Field(type = FieldType.Integer, store = true)
    private Integer customerId;

    //	@Field(type = FieldType.text, analyzer = "ik_smart", searchAnalyzer = "ik_smart", store = true)
    @Field(type = FieldType.text, store = true)
    private String customerName;


    //	@Field(type = FieldType.text, analyzer = "ik_smart", searchAnalyzer = "ik_smart", store = true)
    @Field(type = FieldType.text, store = true)
    private String nickName;

    //	@Field(type = FieldType.text, analyzer = "ik_smart", searchAnalyzer = "ik_smart", store = true)
    @Field(type = FieldType.text, store = true)

    private String mobile;

    //	@Field(type = FieldType.text, analyzer = "ik_smart", searchAnalyzer = "ik_smart", store = true)
    @Field(type = FieldType.text, store = true)

    private String email;

    //	@Field(type = FieldType.text, analyzer = "ik_smart", searchAnalyzer = "ik_smart", store = true)
    @Field(type = FieldType.text, store = true)

    private String major;

    //	@Field(type = FieldType.text, analyzer = "ik_smart", searchAnalyzer = "ik_smart", store = true)
    @Field(type = FieldType.text, store = true)

    private String address;

    public ESCustomer() {
    }

    public ESCustomer(Integer id, Integer customerId, String customerName, String nickName, String mobile, String email, String major, String address) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.nickName = nickName;
        this.mobile = mobile;
        this.email = email;
        this.major = major;
        this.address = address;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ESCustomer{" +
                "id='" + id + '\'' +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
