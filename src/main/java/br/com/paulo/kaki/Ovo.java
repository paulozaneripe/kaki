package br.com.paulo.kaki;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ovo {
	
	private Integer fritada;
	private final Integer tamanho;
	private final Boolean estragado;
	private Boolean quebrado;
	
	public Ovo(Boolean estragado, int tamanho) {
		this.estragado = estragado;
		this.quebrado = false;
		this.fritada = 0;
		this.tamanho = tamanho;
	}
	
	public void quebrar() {
		if(this.estaQuebrado() == true) {
			throw new RuntimeException("Ovo já está quebrado");
		}
		this.quebrado = true;
	}
	
	public void fritar() {
		if(this.estaQuebrado() == false) {
			throw new RuntimeException("Ovo não está quebrado");
		}
		
		this.fritada++;
	}

	public EnumStatusOvo pegarStatus() {
		
		if(estragado != true) {
			if (fritada > 0 && tamanho > 0) {
				BigDecimal f = BigDecimal.valueOf(fritada);
				BigDecimal t = BigDecimal.valueOf(tamanho);
				BigDecimal ponto = f.divide(t, 2, RoundingMode.FLOOR);
				
				if (ponto.compareTo(BigDecimal.valueOf(1)) < 0) {
					return EnumStatusOvo.CRU;
				}
				if (ponto.compareTo(BigDecimal.valueOf(3)) < 0) {
					return EnumStatusOvo.DELÍCIA;
				}
				return EnumStatusOvo.QUEIMADO;
			}
			return EnumStatusOvo.CRU;
		}
			return EnumStatusOvo.ESTRAGADO;
	}
	
	public Boolean estaEstragado( ) {
		return estragado;
	}

	public Boolean estaQuebrado() {
		return quebrado;
	}

}
