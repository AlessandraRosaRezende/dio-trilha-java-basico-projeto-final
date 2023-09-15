package one.digitalinnovation.projetofinalspring.service;

import one.digitalinnovation.projetofinalspring.model.Posts;

public interface PostsService {
    
    Iterable<Posts> buscarTodos();

	Posts buscarPorId(Long id);

	Posts inserir(Posts post);

	Posts atualizar(Long id, Posts post);

	void deletar(Long id);
}
