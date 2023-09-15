package one.digitalinnovation.projetofinalspring.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.projetofinalspring.model.Users;
import one.digitalinnovation.projetofinalspring.model.UsersRepository;
import one.digitalinnovation.projetofinalspring.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
    // Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private UsersRepository usersRepository;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Users> buscarTodos() {
		// Buscar todos os Clientes.
		return usersRepository.findAll();
	}

	@Override
	public Users buscarPorId(Long id) {
		// Buscar User por ID.
		Optional<Users> user = usersRepository.findById(id);
		return user.get();
	}

	@Override
	public Users inserir(Users user) {
		usersRepository.save(user);
		return user;
	}

	@Override
	public Users atualizar(Long id, Users user) {
		// Buscar User por ID, caso exista:
		Optional<Users> userBd = usersRepository.findById(id);
		if (userBd.isPresent()) {
			// Atualizar User
            user.setUserId(id);
            usersRepository.save(user);
		}
		return user;
	}

	@Override
	public void deletar(Long id) {
		// Deletar User por ID.
		usersRepository.deleteById(id);
	}
}
