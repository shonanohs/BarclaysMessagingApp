package com.barclays.repository;

import com.barclays.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository <Message, Integer> {
    List<Message> findByContentContains(String filter);

}
