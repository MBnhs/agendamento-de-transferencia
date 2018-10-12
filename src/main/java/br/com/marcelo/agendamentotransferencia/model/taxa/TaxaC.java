package br.com.marcelo.agendamentotransferencia.model.taxa;

import java.math.BigDecimal;

import br.com.marcelo.agendamentotransferencia.exception.CalculoDeTaxaException;
import br.com.marcelo.agendamentotransferencia.model.transferencia.Transferencia;

public class TaxaC implements CalculoDeTaxa {

	@Override
	public BigDecimal getTaxaDe(Transferencia transferencia) {
		long dias = transferencia.getDiasEntreTransferenciaEAgendamento();

		if (dias > 10 && dias <= 20) {
			return transferencia.getValor().multiply(new BigDecimal(".08"));
		} else if (dias > 20 && dias <= 30) {
			return transferencia.getValor().multiply(new BigDecimal(".06"));
		} else if (dias > 30 && dias <= 40) {
			return transferencia.getValor().multiply(new BigDecimal(".04"));
		} else if (dias > 40 && transferencia.getValor().compareTo(new BigDecimal("100.00")) == 1) {
			return transferencia.getValor().multiply(new BigDecimal(".02"));
		} else {
			throw new CalculoDeTaxaException("Não foi encontrada uma taxa aplicável para a transferência.");
		}
	}

}
