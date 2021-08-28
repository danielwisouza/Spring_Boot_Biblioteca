package br.gov.sp.fatec.frases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import br.gov.sp.fatec.frases.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

    public Livro findByTitulo(String titulo);

    public List<Livro> findByTituloContainsOrPapelContains(String titulo, String papel);
}
