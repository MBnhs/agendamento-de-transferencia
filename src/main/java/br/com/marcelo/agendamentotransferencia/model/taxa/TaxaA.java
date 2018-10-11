package br.com.marcelo.agendamentotransferencia.model.taxa;

import java.math.BigDecimal;

import br.com.marcelo.agendamentotransferencia.model.transferencia.Transferencia;

public class TaxaA implements CalculoDeTaxa {

	@Override
	public BigDecimal getTaxaDe(Transferencia transferencia) {
		BigDecimal taxa = new BigDecimal("3.00").add(transferencia.getValor().multiply(new BigDecimal(".03")));
		return taxa;
	}

}
