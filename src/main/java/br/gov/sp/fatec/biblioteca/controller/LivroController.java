package br.gov.sp.fatec.biblioteca.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.biblioteca.entity.Livro;
import br.gov.sp.fatec.biblioteca.service.SegurancaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/livro")
public class LivroController {

    @Autowired
    private SegurancaService segurancaService;
    
    @GetMapping
    @JsonView(ViewLivro.LivroSimplificado.class)
    public List<Livro> buscarTodosLivros(){
        return segurancaService.buscarTodosLivros();
    }

    @PostMapping
    @JsonView(ViewLivro.LivroCompleto.class)
    public Livro novoLivro(@RequestBody Livro livro){
        return segurancaService.novoLivro(livro.getTitulo(), livro.getIsbn(), livro.getPapel(), "AUTOR_LIVRO");
    }


}
