package br.gov.sp.fatec.biblioteca.service;

import java.util.List;

import br.gov.sp.fatec.biblioteca.entity.Livro;

public interface SegurancaService {

    public Livro novoLivro(String  titulo,Long isbn, String papel, String autor);

    public List<Livro> buscarTodosLivros();
    
}
