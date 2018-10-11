package br.com.marcelo.agendamentotransferencia.model.taxa;

import java.math.BigDecimal;

import br.com.marcelo.agendamentotransferencia.model.transferencia.Transferencia;

public class TaxaB implements CalculoDeTaxa {

	@Override
	public BigDecimal getTaxaDe(Transferencia transferencia) {
		return null;
	}

}
