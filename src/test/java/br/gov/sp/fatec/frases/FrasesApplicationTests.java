package br.gov.sp.fatec.frases;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.frases.entity.Livro;
import br.gov.sp.fatec.frases.repository.LivroRepository;

@Transactional
@Rollback
@SpringBootTest
class FrasesApplicationTests {

	@Autowired
	private LivroRepository lRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void findbyTituloTests() {
		Livro livro= new Livro();
		livro.setTitulo("Harry Potter e A Pedra Filosofal");
		livro.setIsbn((long) 1);
		livro.setPapel("Brochura");

		assertNotNull(lRepository.findByTitulo("Harry Potter e A Pedra Filosofal"));
	}

/*
	@Test
	void findByTituloContainsOrPapelContainsTest() {
		Livro livro= new Livro();
		livro.setTitulo("Harry Potter e A Pedra Filosofal");
		livro.setIsbn((long) 1);
		livro.setPapel("Brochura");

		assertFalse(livroRepo.findByTituloContainsOrPapelContains("arry", "lalala").isEmpty());
	}*/
}
