package br.com.gabriel.Filmes;

import br.com.gabriel.Filmes.entities.Message;

import java.util.List;

public interface IFilmesService {

    List<Message> findAll(String message);
    Message findById(Integer id);
    void update(final Message message);
    void delete(Integer Id);
    Integer add(final Message message);
}