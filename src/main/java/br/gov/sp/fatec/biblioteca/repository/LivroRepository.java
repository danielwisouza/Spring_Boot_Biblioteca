package br.gov.sp.fatec.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.biblioteca.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

   public Livro findByTitulo(String titulo);

   public List<Livro> findByTituloContainsOrPapelContains(String titulo, String papel);

   public Livro findByTituloIgnoreCase(String titulo);

}