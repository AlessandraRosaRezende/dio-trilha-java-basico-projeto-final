package one.digitalinnovation.projetofinalspring.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.projetofinalspring.model.Posts;
import one.digitalinnovation.projetofinalspring.model.PostsRepository;
import one.digitalinnovation.projetofinalspring.service.JSONPlaceHolderPostsService;
import one.digitalinnovation.projetofinalspring.service.PostsService;

@Service
public class PostsServiceImpl implements PostsService{
    // Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private PostsRepository postsRepository;
	@Autowired
	private JSONPlaceHolderPostsService jsonPlaceHolderPostsService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Posts> buscarTodos() {
		// Buscar todos os Clientes.
		return postsRepository.findAll();
	}

	@Override
	public Posts buscarPorId(String id) {
		// Buscar Post por ID.
		Optional<Posts> post = postsRepository.findById(id);
		return post.get();
	}

	@Override
	public void inserir(Posts post) {
        // Verificar se o Post já existe (pelo ID).
        String id = post.getPostId();

        postsRepository.findById(id).orElseGet(() -> {
            // Caso não exista, integrar com a API e persistir o retorno.
            Posts novoPost = jsonPlaceHolderPostsService.consultarPosts(id);
            postsRepository.save(novoPost);
            return novoPost;
        });
	}

	@Override
	public void atualizar(String id, Posts post) {
		// Buscar Post por ID, caso exista:
        Optional<Posts> postBd = postsRepository.findById(id);
        if (postBd.isPresent()) {
            // Atualizar Post
            post.setPostId(id);
            postsRepository.save(post);
        }
	}

	@Override
	public void deletar(String id) {
		// Deletar User por ID.
		postsRepository.deleteById(id);
	}
}
