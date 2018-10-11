package br.com.marcelo.agendamentotransferencia.model.taxa;

import java.math.BigDecimal;

import br.com.marcelo.agendamentotransferencia.model.transferencia.Transferencia;

public enum TipoDeTaxa {

	TIPO_A(new TaxaA()), TIPO_B(new TaxaB()), TIPO_C(new TaxaC());

	private CalculoDeTaxa calculoDeTaxa;

	private TipoDeTaxa(CalculoDeTaxa calculoDeTaxa) {
		this.calculoDeTaxa = calculoDeTaxa;
	}

	public BigDecimal getTaxaDe(Transferencia transferencia) {
		return calculoDeTaxa.getTaxaDe(transferencia);
	}

}