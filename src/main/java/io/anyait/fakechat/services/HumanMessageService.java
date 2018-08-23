package io.anyait.fakechat.services;


import io.anyait.fakechat.MessageGenerator;
import io.anyait.fakechat.model.AuthorType;
import io.anyait.fakechat.model.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class HumanMessageService implements MessageService{

    private final MessageGenerator messageGenerator;

    private final Flux<MessageDto> messages;

    @Autowired
    public HumanMessageService() {
        this.messageGenerator =  new MessageGenerator("Human", AuthorType.PERSON);
        this.messages = Flux.interval(Duration.ofMillis(500))
                .flatMap(next -> messageGenerator.generateMessages())
                .share()
                .onBackpressureDrop();
    }

    @Override
    public Flux<MessageDto> getMessages() {
        return messages;
    }
}
