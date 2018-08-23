package io.anyait.fakechat;

import io.anyait.fakechat.model.Author;
import io.anyait.fakechat.model.AuthorType;
import io.anyait.fakechat.model.MessageDto;
import org.apache.commons.lang3.RandomStringUtils;
import reactor.core.publisher.Flux;

import java.util.Random;

public class MessageGenerator {


    private final String nickname;
    private final AuthorType type;
    private final Random random;

    public MessageGenerator(String nickname, AuthorType type) {
        this.nickname = nickname;
        this.type = type;
        this.random = new Random();
    }


    //TODO: replace generator with controllers
    public Flux<MessageDto> generateMessages() {
        return Flux.range(0, 1)
                .map(this::generateAuthor)
                .map(author -> new MessageDto(RandomStringUtils.randomAlphabetic(10), author));
    }

    private Author generateAuthor(int i) {
        return new Author(type, nickname, random.nextInt(60) + i);
    }
}
