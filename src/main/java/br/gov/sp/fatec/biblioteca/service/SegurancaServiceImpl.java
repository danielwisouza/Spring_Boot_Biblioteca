package br.gov.sp.fatec.biblioteca.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.biblioteca.entity.Autor;
import br.gov.sp.fatec.biblioteca.entity.Livro;
import br.gov.sp.fatec.biblioteca.repository.AutorRepository;
import br.gov.sp.fatec.biblioteca.repository.LivroRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService{
    
    @Autowired
    LivroRepository livroRepo;

    @Autowired
    AutorRepository autorRepo;

    @Transactional
    public Livro novoLivro(String  titulo,Long isbn, String papel, String autor){
        Autor aut = autorRepo.findByNome(autor);
        if(aut ==null){
            aut = new Autor(); 
            aut.setNome(autor);
            autorRepo.save(aut);
        }

        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setIsbn(isbn);
        livro.setPapel(papel);
        livro.setAutores(new HashSet<Autor>());
        livro.getAutores().add(aut);
        livroRepo.save(livro);

        return livro;
    }

    public List<Livro> buscarTodosLivros(){
       return livroRepo.findAll();

    }


}
