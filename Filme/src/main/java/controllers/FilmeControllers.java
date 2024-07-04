package controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import repositories.FilmeRepository;

@RestController
public class FilmeControllers {
     @Autowired
    FilmeRepository filmeRepository;
    @RequestMapping(value="/filmes", 
            method = RequestMethod.GET)
    
    public List<Filme> helloWorld(){   
      return  filmeRepository.findAll();
    }
    
    public Filme post(@Valid @RequestBody Filme filme){
        return filmeRepository.save(filme);
    }
    
    @RequestMapping(value="/filme/{id}",
            method=RequestMethod.PUT)
    
    public ResponseEntity<Filme> put(
    @PathVariable(value="id") long id,
    @Valid @RequestBody Filme novoFilme){
        Optional<Filme> filmeVelho = 
                filmeRepository.findById(id);
        if(filmeVelho.isPresent()){
            Filme filme = filmeVelho.get();
            filme.setAutor(novoFilme.getAutor());
            filme.setTitulo(novoFilme.getTitulo());
            filme.setAno(novoFilme.getAno());
            filmeRepository.save(filme);
            return new ResponseEntity<>(filme,
                    HttpStatus.OK);        
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/filme/{id}",
            method=RequestMethod.DELETE)
    public ResponseEntity<Object> delete(
    @PathVariable(value="id") long id) {
        Optional<Filme> filme
                = filmeRepository.findById(id);
        if(filme.isPresent()){
            filmeRepository.delete(filme.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value="/filme/{id}", method = 
            RequestMethod.GET)
    public ResponseEntity<Filme> getById(
    @PathVariable(value="id") long id){
    Optional<Filme> filme =
            filmeRepository.findById(id);
    if(filme.isPresent()){
        return new ResponseEntity<>(filme.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(filme.get(), HttpStatus.NOT_FOUND);
    }
}
