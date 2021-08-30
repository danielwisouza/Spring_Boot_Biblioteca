/*package br.gov.sp.fatec.frases;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.frases.entity.Autor;
import br.gov.sp.fatec.frases.repository.AutorRepository;

@Transactional
@Rollback
@SpringBootTest
class FrasesApplicationTests {

	@Autowired
	private AutorRepository AutorRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void findByNomeTests() {
		Autor autor =  new Autor();
		autor.setNome("J. K. Rowling");
		autor.setMensagem("Aventura; ‎Fantasia");
		autor.setBiografia("Joanne Rowling");
		AutorRepo.save(autor);
		assertNotNull(AutorRepo.findByNome("J. K. Rowling"));
	}
	

	@Test
	void findByNomeContainsOrMensagemContainsTest() {
		Autor autor =  new Autor();
		autor.setNome("J. K. Rowling");
		autor.setMensagem("Aventura; ‎Fantasia");
		autor.setBiografia("Joanne Rowling");
		AutorRepo.save(autor);
		assertFalse(AutorRepo.findByNomeContainsOrMensagemContains("Rowling", "lalala").isEmpty());
	}
}
*/