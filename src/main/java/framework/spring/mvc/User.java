package framework.spring.mvc;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author zyf
 * @date 2018/1/17
 */
public class User {
    @NotNull
    private String name;
    @Range(min = 0,max = 120,message = "年龄必须在0-120之间")
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
