package com.javasampleapproach.springrest.mysql.repo;

import java.util.List;

import com.javasampleapproach.springrest.mysql.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, String> {
    List<Message> findByUseridAndVisitorid(String userid, String visitorid);
}