package one.digitalinnovation.projetofinalspring.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.projetofinalspring.model.Users;
import one.digitalinnovation.projetofinalspring.model.UsersRepository;
import one.digitalinnovation.projetofinalspring.service.JSONPlaceHolderUsersService;
import one.digitalinnovation.projetofinalspring.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
    // Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private JSONPlaceHolderUsersService jsonPlaceHolderUsersService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Users> buscarTodos() {
		// Buscar todos os Clientes.
		return usersRepository.findAll();
	}

	@Override
	public Users buscarPorId(String id) {
		// Buscar User por ID.
		Optional<Users> user = usersRepository.findById(id);
		return user.get();
	}

	@Override
	public void inserir(Users user) {
        // Verificar se o User já existe (pelo ID).
        String id = user.getUserId();

		usersRepository.findById(id).orElseGet(() -> {
			// Caso não exista, integrar com a API e persistir o retorno.
            Users novoUser = jsonPlaceHolderUsersService.consultarUsers(id);
			usersRepository.save(novoUser);
			return novoUser;
		});
	}

	@Override
	public void atualizar(String id, Users user) {
		// Buscar User por ID, caso exista:
		Optional<Users> userBd = usersRepository.findById(id);
		if (userBd.isPresent()) {
			// Atualizar User
            user.setUserId(id);
            usersRepository.save(user);
		}
	}

	@Override
	public void deletar(String id) {
		// Deletar User por ID.
		usersRepository.deleteById(id);
	}
}
