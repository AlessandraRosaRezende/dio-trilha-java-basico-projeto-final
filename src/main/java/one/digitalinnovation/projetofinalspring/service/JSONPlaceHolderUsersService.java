package one.digitalinnovation.projetofinalspring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.digitalinnovation.projetofinalspring.model.Users;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, para o consumo da API do
 * <b>JSONPlaceHolder</b>.
 * 
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://jsonplaceholder.typicode.com/users">JSONPlaceHolder</a>
 * 
 * @author AlessandraRosaRezende
 */
@FeignClient(name = "users", url = "https://jsonplaceholder.typicode.com/users")
public interface JSONPlaceHolderUsersService {
    @GetMapping("/{users}")
	Users consultarUsersById(@PathVariable("users") Long id);
}