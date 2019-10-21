package com.imooc.studyluckymoney.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Girl {
    @Id
    @SequenceGenerator(name = "girl_id", sequenceName = "girl_id", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "girl_id")
    private Integer id;
    @NotNull(message = "姓名必输!")
    private String name;
    @Min(value = 18, message = "未成年禁止入内!")
    @NotNull(message = "年龄必传!")
    private Integer age;
    private String cup_size;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getCup_size() {
        return cup_size;
    }

    public void setCup_size(String cup_size) {
        this.cup_size = cup_size;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cup_size='" + cup_size + '\'' +
                '}';
    }
}
