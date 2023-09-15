package one.digitalinnovation.projetofinalspring.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.projetofinalspring.model.Posts;
import one.digitalinnovation.projetofinalspring.model.PostsRepository;
import one.digitalinnovation.projetofinalspring.service.PostsService;

@Service
public class PostsServiceImpl implements PostsService{
    // Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private PostsRepository postsRepository;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Posts> buscarTodos() {
		// Buscar todos os Clientes.
		return postsRepository.findAll();
	}

	@Override
	public Posts buscarPorId(Long id) {
		// Buscar Post por ID.
		Optional<Posts> post = postsRepository.findById(id);
		return post.get();
	}

	@Override
	public Posts inserir(Posts post) {
		postsRepository.save(post);
        return post;
	}

	@Override
	public Posts atualizar(Long id, Posts post) {
		// Buscar Post por ID, caso exista:
        Optional<Posts> postBd = postsRepository.findById(id);
        if (postBd.isPresent()) {
            // Atualizar Post
            post.setPostId(id);
            postsRepository.save(post);
        }
		return post;
	}

	@Override
	public void deletar(Long id) {
		// Deletar User por ID.
		postsRepository.deleteById(id);
	}
}
