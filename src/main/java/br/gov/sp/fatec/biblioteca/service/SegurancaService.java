package br.gov.sp.fatec.biblioteca.service;

import java.util.List;

import br.gov.sp.fatec.biblioteca.entity.Livro;
import br.gov.sp.fatec.biblioteca.entity.Usuario;

public interface SegurancaService {

    public Livro novoLivro(String  titulo,Long isbn, String papel, String autor);

    public List<Livro> buscarTodosLivros();

    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();
    
}
