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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SERIE_GUSTAVO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serie {

	@Id
	@SequenceGenerator(name = "serie_gustavo_sequence", sequenceName = "SERIE_GUSTAVO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serie_gustavo_sequence")
	private Integer id;
	
	@NotNull
	private String autor;

	@NotNull
	@Column(unique = true)
	private String nome;

	@NotNull
	private Integer anoInicio;

	private Integer anoFim;

	@OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Personagem> personagens;

}
