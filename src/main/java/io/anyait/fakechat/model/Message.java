package io.anyait.fakechat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Message {

    @Id
    private String id;

    private String text;

    private LocalDateTime cteatedAt;

    private Author author;

    public Message(String text, LocalDateTime cteatedAt, Author author) {
        this.text = text;
        this.cteatedAt = cteatedAt;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCteatedAt() {
        return cteatedAt;
    }

    public void setCteatedAt(LocalDateTime cteatedAt) {
        this.cteatedAt = cteatedAt;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
