package com.jiyun.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

@Repository
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sno")
    private Integer sno;

    @Column(name = "name")
    private String name;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "sex")
    private char sex;

    @Column(name = "birthday")
    private Date birthday;

    @Transient
    private Date startBirth;

    @Transient
    private Date endBirth;

    public Students(Integer sno, String name, char sex, Date birthday) {
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public Students() {
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getStartBirth() {
        return startBirth;
    }

    public void setStartBirth(Date startBirth) {
        this.startBirth = startBirth;
    }

    public Date getEndBirth() {
        return endBirth;
    }

    public void setEndBirth(Date endBirth) {
        this.endBirth = endBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", sno=" + sno +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", startBirth=" + startBirth +
                ", endBirth=" + endBirth +
                '}';
    }
}
