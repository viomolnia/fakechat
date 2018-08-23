package io.anyait.fakechat.services;

import io.anyait.fakechat.model.MessageDto;
import reactor.core.publisher.Flux;

public interface MessageService {

    Flux<MessageDto> getMessages();
}
