package br.org.cremesp.series.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.org.cremesp.series.entity.Usuario;

@FeignClient(name = "usuarios", url = "http://dk01.cremesp.org.br:8000/usuarios")
public interface UsuarioClient {

	@GetMapping("/{identificacao}")
	public Usuario getByIdentificacao(@PathVariable(value = "identificacao") String identificacao);

}
