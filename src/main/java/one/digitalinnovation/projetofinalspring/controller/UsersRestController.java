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

import one.digitalinnovation.projetofinalspring.model.Users;
import one.digitalinnovation.projetofinalspring.service.UsersService;

@RestController
@RequestMapping("users")
public class UsersRestController {
    @Autowired
	private UsersService usersService;

	@GetMapping
	public ResponseEntity<Iterable<Users>> buscarTodos() {
		return ResponseEntity.ok(usersService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Users> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(usersService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Users> inserir(@RequestBody Users user) {
		usersService.inserir(user);
		return ResponseEntity.ok(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Users> atualizar(@PathVariable Long id, @RequestBody Users user) {
		usersService.atualizar(id, user);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		usersService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
