package one.digitalinnovation.projetofinalspring.service;

import one.digitalinnovation.projetofinalspring.model.Users;

public interface UsersService {
    Iterable<Users> buscarTodos();

	Users buscarPorId(Long id);

	Users inserir(Users user);

	Users atualizar(Long id, Users user);

	void deletar(Long id);
}
