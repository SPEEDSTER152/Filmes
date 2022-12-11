package br.com.gabriel.Filmes.repositories;

import br.com.gabriel.Filmes.entities.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FilmesRepository{

    private final List<Message> messages;

    public FilmesRepository(){
        this.messages = new ArrayList<>();
    }

    public List<Message> findAll() {
        return messages;
    }
    public List<Message> findAll(final String message){
        return messages.stream()
                .filter(msg -> msg.getMessage().contains(message))
                .collect(Collectors.toList());
    }
    public Message findById(Integer id){
        return this.messages.stream()
                .filter(msg -> msg.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void add(Message message) {
        this.messages.add(message);
    }

    public void update(Message message){
        this.messages.stream()
                .filter(msg -> message.getId().equals(message.getId()))
                .forEach(msg -> msg.setMessage(message.getMessage()));
    }

    public void delete(Integer id) {
        this.messages.removeIf(msg -> msg.getId().equals(id));
    }
    public int count(){
     return messages.size();
    }
}