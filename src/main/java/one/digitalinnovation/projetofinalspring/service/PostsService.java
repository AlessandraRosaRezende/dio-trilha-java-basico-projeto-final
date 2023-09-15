package one.digitalinnovation.projetofinalspring.service;

import one.digitalinnovation.projetofinalspring.model.Posts;

public interface PostsService {
    
    Iterable<Posts> buscarTodos();

	Posts buscarPorId(String id);

	void inserir(Posts post);

	void atualizar(String id, Posts post);

	void deletar(String id);
}
