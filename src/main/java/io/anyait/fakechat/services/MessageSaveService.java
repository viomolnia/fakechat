package io.anyait.fakechat.services;

import io.anyait.fakechat.model.Message;
import io.anyait.fakechat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.util.Logger;
import reactor.util.Loggers;

@Service
public class MessageSaveService {
    private static final Logger log = Loggers.getLogger(MessageSaveService.class);

    @Autowired
    public MessageSaveService(MessageService messageService, MessageRepository repo) {
        messageService.getMessages()
                .map(message -> new Message(message.getText(), message.getCreatedAt(), message.getAuthor()))
                .flatMap(repo::save)
                .subscribe(saved -> log.info("{} : {}", saved.getAuthor().getNickName(), saved.getText()));

    }

}
