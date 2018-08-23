package io.anyait.fakechat.repositories;

import io.anyait.fakechat.model.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MessageRepository extends ReactiveMongoRepository<Message, String> {
}
