package br.org.cremesp.series.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SerieDTO {

	private Serie serie;

	private Usuario autor;

}
