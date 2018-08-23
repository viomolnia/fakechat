package io.anyait.fakechat.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Author {

    private AuthorType type;

    private String nickName;

    private int age;

    public Author(AuthorType type, String nickName, int age) {
        this.type = type;
        this.nickName = nickName;
        this.age = age;
    }

    public AuthorType getType() {
        return type;
    }

    public void setType(AuthorType type) {
        this.type = type;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
