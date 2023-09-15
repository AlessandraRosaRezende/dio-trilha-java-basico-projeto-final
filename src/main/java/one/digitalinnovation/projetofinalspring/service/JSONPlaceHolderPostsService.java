package one.digitalinnovation.projetofinalspring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.digitalinnovation.projetofinalspring.model.Posts;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, para o consumo da API do
 * <b>JSONPlaceHolder</b>.
 * 
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://jsonplaceholder.typicode.com/posts">JSONPlaceHolder</a>
 * 
 * @author AlessandraRosaRezende
 */

@FeignClient(name = "id", url = "https://jsonplaceholder.typicode.com/posts")
public interface JSONPlaceHolderPostsService {
    @GetMapping("/{id}")
	Posts consultarPosts(@PathVariable("id") Long id);
}