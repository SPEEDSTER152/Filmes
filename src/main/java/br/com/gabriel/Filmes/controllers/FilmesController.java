package br.com.gabriel.Filmes.controllers;

import br.com.gabriel.Filmes.IFilmesService;
import br.com.gabriel.Filmes.entities.Message;
import br.com.gabriel.Filmes.services.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Filmes")
public class FilmesController {

    private final List<Message> messages;

   
    private IFilmesService filmesService;


    public FilmesController(FilmesService filmesService){
        this.filmesService = filmesService;
        this.messages = new ArrayList<>();
    }

    @GetMapping
    public List<Message> findAll(@RequestParam(required = false) String message){
        return filmesService.findAll(message);
    }

    @GetMapping("/{id}")
    public Message findById(@PathVariable("id") Integer id) {
        return filmesService.findById(id);
    }
        @PostMapping
                public ResponseEntity<Integer> add(@RequestBody final Message message){
              Integer id = filmesService.add(message);
              return new ResponseEntity<>(id, HttpStatus.CREATED);
        }
        @PutMapping
        public ResponseEntity update(@RequestBody final Message message){
        filmesService.update(message);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity delete(@PathVariable("id") Integer id){
        filmesService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
 }