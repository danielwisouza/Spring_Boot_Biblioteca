package br.gov.sp.fatec.biblioteca;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.biblioteca.entity.Autor;
import br.gov.sp.fatec.biblioteca.entity.Livro;
import br.gov.sp.fatec.biblioteca.entity.Volume;
import br.gov.sp.fatec.biblioteca.repository.AutorRepository;
import br.gov.sp.fatec.biblioteca.repository.LivroRepository;
import br.gov.sp.fatec.biblioteca.repository.VolumeRepository;

@Transactional
@Rollback
@SpringBootTest
public class BibliotecaTests {

    @Autowired
	private LivroRepository LivroRepo;

    @Autowired
	private AutorRepository AutorRepo;

	@Autowired
	private VolumeRepository VolumeRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void findbyTituloTests() {
		Livro livro= new Livro();
		livro.setTitulo("Harry Potter e A Pedra Filosofal");
		livro.setIsbn((long) 1);
		livro.setPapel("Brochura");
        LivroRepo.save(livro);
		assertNotNull(LivroRepo.findByTitulo("Harry Potter e A Pedra Filosofal"));
	}

	@Test
	void findByTituloIgnoreCaseTests() {
		Livro livro= new Livro();
		livro.setTitulo("Harry Potter e A Pedra Filosofal");
		livro.setIsbn((long) 1);
		livro.setPapel("Brochura");
        LivroRepo.save(livro);
		assertNotNull(LivroRepo.findByTituloIgnoreCase("Harry Potter e A Pedra Filosofal"));
	}


	@Test
	void findByTituloContainsOrPapelContainsTest() {
		Livro livro= new Livro();
		livro.setTitulo("Harry Potter e A Pedra Filosofal");
		livro.setIsbn((long) 1);
		livro.setPapel("Brochura");
        LivroRepo.save(livro);
		assertFalse(LivroRepo.findByTituloContainsOrPapelContains("arry", "lalala").isEmpty());
	}

	@Test
	void findByAutoresNomeTests() {
		Autor autor =  new Autor();
		autor.setNome("J. K. Rowling");
		autor.setMensagem("Aventura; ‎Fantasia");
		autor.setBiografia("Joanne Rowling");
		AutorRepo.save(autor);

		Livro livro= new Livro();
		livro.setTitulo("Harry Potter e A Pedra Filosofal");
		livro.setIsbn((long) 1);
		livro.setPapel("Brochura");
		livro.setAutores(new HashSet<Autor>());
		livro.getAutores().add(autor);
        LivroRepo.save(livro);
		assertNotNull(LivroRepo.findByAutoresNome("J. K. Rowling").isEmpty());
	}

	@Test
	void findByLivrosTituloTests() {
		Autor autor =  new Autor();
		autor.setNome("J. K. Rowling");
		autor.setMensagem("Aventura; ‎Fantasia");
		autor.setBiografia("Joanne Rowling");
		AutorRepo.save(autor);

		Livro livro= new Livro();
		livro.setTitulo("Harry Potter e A Pedra Filosofal");
		livro.setIsbn((long) 1);
		livro.setPapel("Brochura");
		livro.setAutores(new HashSet<Autor>());
		livro.getAutores().add(autor);
        LivroRepo.save(livro);
		assertNotNull(AutorRepo.findByLivrosTitulo("Harry Potter e A Pedra Filosofal").isEmpty());
	}

	@Test
	void findByLivroTituloTest(){
		Livro livro= new Livro();
		livro.setTitulo("Harry Potter e A Pedra Filosofal");
		livro.setIsbn((long) 1);
		livro.setPapel("Brochura");
        LivroRepo.save(livro);


		Volume volume = new Volume();
		volume.setAquisicao(new Date());
		volume.setObservacao("observacao");
		volume.setSituacao("Aprovado");
		volume.setLivro(livro);
		VolumeRepo.save(volume);
		assertNotNull(VolumeRepo.findByLivroTitulo("Harry Potter e A Pedra Filosofal").isEmpty());
	}


	@Test
	void findByVolumeSituacaoTest(){
		Livro livro= new Livro();
		livro.setTitulo("Harry Potter e A Pedra Filosofal");
		livro.setIsbn((long) 1);
		livro.setPapel("Brochura");
        LivroRepo.save(livro);


		Volume volume = new Volume();
		volume.setAquisicao(new Date());
		volume.setObservacao("observacao");
		volume.setSituacao("Aprovado");
		volume.setLivro(livro);
		VolumeRepo.save(volume);
		assertNotNull(LivroRepo.findByVolumesSituacao("Aprovado").isEmpty());
	}


}
