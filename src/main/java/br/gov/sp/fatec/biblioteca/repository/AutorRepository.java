package br.gov.sp.fatec.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.biblioteca.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
    public Autor findByNome(String nome);
 
    public List<Autor> findByNomeContainsOrMensagemContains(String nome, String mensagem);   
}


