package br.com.gabriel.Filmes.services;

import br.com.gabriel.Filmes.IFilmesService;
import br.com.gabriel.Filmes.entities.Message;
import br.com.gabriel.Filmes.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService implements IFilmesService {

    @Autowired
    private FilmesRepository filmesRepository;

    public FilmesService(FilmesRepository filmesRepository) {
        this.filmesRepository = filmesRepository;
    }

    public List<Message> findAll(String message) {
        if (message != null) {

            return filmesRepository.findAll(message);
        }
        return filmesRepository.findAll();
    }

    public Message findById(Integer id) {
        return filmesRepository.findById(id);
    }

    public Integer add(final Message message) {
        if (message.getId() == null) {
            message.setId(filmesRepository.count() + 1);
        }
        filmesRepository.add(message);
        return message.getId();
    }

    public void update(final Message message) {
        filmesRepository.update(message);
    }
        public void delete(Integer id){
        filmesRepository.delete(id);
        }
    }
