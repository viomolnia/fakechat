package io.anyait.fakechat.model;

import java.time.LocalDateTime;

public class MessageDto {

    private String text;

    private LocalDateTime createdAt;

    private Author author;

    public MessageDto() {
    }

    public MessageDto(String text, Author author) {
        this.text = text;
        this.createdAt = LocalDateTime.now();
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
