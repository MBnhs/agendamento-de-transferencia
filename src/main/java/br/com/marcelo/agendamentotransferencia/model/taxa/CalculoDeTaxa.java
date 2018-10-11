package br.com.marcelo.agendamentotransferencia.model.taxa;

import java.math.BigDecimal;

import br.com.marcelo.agendamentotransferencia.model.transferencia.Transferencia;

public interface CalculoDeTaxa {

	BigDecimal getTaxaDe(Transferencia transferencia);
	
}
