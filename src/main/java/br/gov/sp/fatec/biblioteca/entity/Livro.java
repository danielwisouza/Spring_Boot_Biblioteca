package br.gov.sp.fatec.biblioteca.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="liv_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "liv_id")
    private long id;

    @Column(name= "liv_titulo")
    private String  titulo;

    @Column(name= "liv_isbn")
    private Long isbn;

    @Column(name= "liv_tipo_papel")
    private String papel;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "lau_livro_autor",
        joinColumns = { @JoinColumn(name="liv_id")},
        inverseJoinColumns = { @JoinColumn(name = "aur_id")})
        
    private Set<Autor> autores;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "livro")
    private Set<Volume> volumes;
    

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }



}