package br.org.cremesp.series.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties
@Data
public class Usuario {

	private String identificacao;
	private String nome;
	private String email;
}
