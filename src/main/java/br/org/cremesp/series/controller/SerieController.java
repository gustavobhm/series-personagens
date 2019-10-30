package br.org.cremesp.series.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.cremesp.series.entity.Serie;
import br.org.cremesp.series.entity.SerieDTO;
import br.org.cremesp.series.exception.BadRequestException;
import br.org.cremesp.series.service.SerieService;

@RestController
@RequestMapping("/series")
public class SerieController {

	@Autowired
	private SerieService serieService;

	@PostMapping
	public void add(@RequestBody Serie serie) throws BadRequestException {
		serieService.add(serie);
	}

	@PutMapping
	public void update(@RequestBody Serie serie) throws BadRequestException {
		serieService.update(serie);
	}

	/* /series?ano=2010 */
	@GetMapping
	public List<Serie> getAll(@RequestParam(value = "ano-inicio", required = false) Integer anoInicio) {
		return serieService.getAll(anoInicio);
	}

	@GetMapping("/{id}")
	public SerieDTO get(@PathVariable Integer id) throws BadRequestException {
		return serieService.get(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		serieService.delete(id);
	}

}
