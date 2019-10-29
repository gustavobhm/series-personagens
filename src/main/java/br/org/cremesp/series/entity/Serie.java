package br.org.cremesp.series.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="SERIES_DANIEL")
public class Serie {

	@Id
	@SequenceGenerator(name="series_daniel_sequence", sequenceName="SERIES_DANIEL_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="series_daniel_sequence")
	private Integer id;
	
	@NotNull
	@Column(unique=true)
	private String nome;
	
	@NotNull
	private Integer anoInicio;
	
	private Integer anoFim;
	
	

	public Serie() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Serie(Integer id, @NotNull String nome, @NotNull Integer anoInicio, Integer anoFim) {
		super();
		this.id = id;
		this.nome = nome;
		this.anoInicio = anoInicio;
		this.anoFim = anoFim;
	}



	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getAnoInicio() {
		return anoInicio;
	}

	public Integer getAnoFim() {
		return anoFim;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoFim == null) ? 0 : anoFim.hashCode());
		result = prime * result + ((anoInicio == null) ? 0 : anoInicio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (anoFim == null) {
			if (other.anoFim != null)
				return false;
		} else if (!anoFim.equals(other.anoFim))
			return false;
		if (anoInicio == null) {
			if (other.anoInicio != null)
				return false;
		} else if (!anoInicio.equals(other.anoInicio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
