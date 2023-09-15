package one.digitalinnovation.projetofinalspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.projetofinalspring.model.Posts;
import one.digitalinnovation.projetofinalspring.service.PostsService;

@RestController
@RequestMapping("posts")
public class PostsRestController {
    @Autowired
	private PostsService postsService;

	@GetMapping
	public ResponseEntity<Iterable<Posts>> buscarTodos() {
		return ResponseEntity.ok(postsService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Posts> buscarPorId(@PathVariable String id) {
		return ResponseEntity.ok(postsService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Posts> inserir(@RequestBody Posts post) {
		postsService.inserir(post);
		return ResponseEntity.ok(post);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Posts> atualizar(@PathVariable String id, @RequestBody Posts post) {
		postsService.atualizar(id, post);
		return ResponseEntity.ok(post);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable String id) {
		postsService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
