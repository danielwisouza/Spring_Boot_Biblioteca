package br.gov.sp.fatec.biblioteca.controller;

public class View {

    public static class LivroSimplificado {};

    public static class LivroCompleto extends LivroSimplificado {};

    public static class UsuarioSimplificado {};

    public static class UsuarioCompleto extends UsuarioSimplificado {};
    
}
/* Exemplo de Post

{"titulo": "O Hobbit", "isbn": "1", "papel": "Folhas de mandrágora"}

{"titulo": "Narnia 2", "isbn": "6", "papel": "Folhas de mandrágora"}

*/