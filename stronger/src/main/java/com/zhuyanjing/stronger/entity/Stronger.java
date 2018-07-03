package com.zhuyanjing.stronger.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity//表示对应数据库的表
public class Stronger {

    @Id
    @GeneratedValue
    private Integer id;
    private String  beauty;

    @Override
    public String toString() {
        return "Stronger{" +
                "id=" + id +
                ", beauty='" + beauty + '\'' +
                ", age=" + age +
                '}';
    }

    @Min(value = 18,message = "年龄不够")/*加限制最低为18年龄*/
    private Integer age;

    public Stronger() {
    }//必须有一个无参的；全选getset方法！

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeauty() {
        return beauty;
    }

    public void setBeauty(String beauty) {
        this.beauty = beauty;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
