package one.digitalinnovation.projetofinalspring.service;

import one.digitalinnovation.projetofinalspring.model.Users;

public interface UsersService {
    Iterable<Users> buscarTodos();

	Users buscarPorId(String id);

	void inserir(Users user);

	void atualizar(String id, Users user);

	void deletar(String id);
}
