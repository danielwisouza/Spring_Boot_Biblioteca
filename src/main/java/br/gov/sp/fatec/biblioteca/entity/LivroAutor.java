package br.gov.sp.fatec.biblioteca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="lau_livro_autor")
public class LivroAutor {
    
    @Column(name= "liv_id")
    private long liv_id;

    @Column(name= "aur_id")
    private long aur_id;

}
