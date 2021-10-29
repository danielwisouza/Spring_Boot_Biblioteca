package br.gov.sp.fatec.biblioteca.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.biblioteca.entity.Autor;
import br.gov.sp.fatec.biblioteca.entity.Autorizacao;
import br.gov.sp.fatec.biblioteca.entity.Livro;
import br.gov.sp.fatec.biblioteca.entity.Usuario;
import br.gov.sp.fatec.biblioteca.repository.AutorRepository;
import br.gov.sp.fatec.biblioteca.repository.AutorizacaoRepository;
import br.gov.sp.fatec.biblioteca.repository.LivroRepository;
import br.gov.sp.fatec.biblioteca.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService{
    
    @Autowired
    LivroRepository livroRepo;

    @Autowired
    AutorRepository autorRepo;

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    AutorizacaoRepository autorizacaoRepo;

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

    @Transactional
    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao) {
        
        Autorizacao aut = autorizacaoRepo.findByNome(autorizacao);
        if(aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autorizacaoRepo.save(aut);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);

        return usuario;
    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepo.findAll();
    }


}
