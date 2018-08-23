package io.anyait.fakechat.services;

import io.anyait.fakechat.model.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Primary
public class MainMessageService implements MessageService {

    private final Flux<MessageDto> messages;

    @Autowired
    public MainMessageService(Set<MessageService> messageServices) {
        List<Flux<MessageDto>> fluxes = messageServices
                .stream()
                .map(MessageService::getMessages)
                .collect(Collectors.toList());

        this.messages = Flux.merge(fluxes)
                .share()
                .onBackpressureDrop();
    }

    @Override
    public Flux<MessageDto> getMessages() {
        return messages;
    }
}
