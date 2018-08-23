package io.anyait.fakechat.services;

import io.anyait.fakechat.MessageGenerator;
import io.anyait.fakechat.model.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static io.anyait.fakechat.model.AuthorType.BOT;

@Service
public class BotMessageService implements MessageService {

    private final Flux<MessageDto> messages;
    private final MessageGenerator messageGenerator;

    @Autowired
    public BotMessageService() {
        this.messageGenerator =new MessageGenerator("SuperBot", BOT);
        this.messages = Flux.interval(Duration.ofMillis(1000))
                .flatMap(next -> messageGenerator.generateMessages())
                .share()
                .onBackpressureDrop();
    }

    @Override
    public Flux<MessageDto> getMessages() {
        return messages;
    }
}
