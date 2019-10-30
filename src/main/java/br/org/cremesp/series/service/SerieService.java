package br.org.cremesp.series.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.cremesp.series.client.UsuarioClient;
import br.org.cremesp.series.entity.Serie;
import br.org.cremesp.series.entity.SerieDTO;
import br.org.cremesp.series.entity.Usuario;
import br.org.cremesp.series.exception.BadRequestException;
import br.org.cremesp.series.repository.SerieRepository;

@Service
public class SerieService {

	@Autowired
	private SerieRepository serieRepository;

	@Autowired
	private UsuarioClient usuarioClient;

	public void add(Serie serie) throws BadRequestException {
		if (serie.getId() != null) {
			throw new BadRequestException("Identificados da série não deve ser informado na inclusão.");
		}
		this.serieRepository.save(serie);
	}

	public void update(Serie serie) throws BadRequestException {
		if (serie.getId() == null) {
			throw new BadRequestException("Identificador da série deve ser informado na alteração.");
		}
		this.serieRepository.save(serie);
	}

	public List<Serie> getAll(Integer anoInicio) {
		if (anoInicio == null)
			return this.serieRepository.findAll();
		else
			return this.serieRepository.findByAnoInicio(anoInicio);
	}

	public SerieDTO get(Integer id) throws BadRequestException {
		try {

			Serie serie = this.serieRepository.findById(id).get();
			Usuario autor = this.usuarioClient.getByIdentificacao(serie.getAutor());
			SerieDTO serieDTO = new SerieDTO(serie,autor);

			return serieDTO;
		} catch (NoSuchElementException e) {
			throw new BadRequestException("Não existe série para o identificador informado");
		}
	}

	public void delete(Integer id) {
		this.serieRepository.deleteById(id);
	}
}
