package com.company.solidusEx1.repositories;

import com.company.solidusEx1.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    Optional<Message> findByHash256(String hash);
}
