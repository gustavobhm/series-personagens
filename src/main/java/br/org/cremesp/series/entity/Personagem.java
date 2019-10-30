package br.org.cremesp.series.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PERSONAGEM_GUSTAVO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personagem {

	@Id
	@SequenceGenerator(name = "personagem_gustavo_sequence", sequenceName = "PERSONAGEM_GUSTAVO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personagem_gustavo_sequence")
	private Integer id;

	@NotNull
	@Column(unique = true)
	private String nome;

	@NotNull
	private String descricao;

	@NotNull
	@ManyToOne
	@JoinColumn(name="serie_id", referencedColumnName="id")
	@JsonBackReference
	private Serie serie;

}
