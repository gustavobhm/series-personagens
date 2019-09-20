package br.org.cremesp.series.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.cremesp.series.entity.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer>{
	public List<Serie> findByAnoInicio(Integer anoInicio);

}
