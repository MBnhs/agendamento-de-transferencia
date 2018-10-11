package br.com.marcelo.agendamentotransferencia.model.taxa;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.marcelo.agendamentotransferencia.model.transferencia.Transferencia;

@RunWith(MockitoJUnitRunner.class)
public class TaxaATest {

	@Mock
	Transferencia transferencia;
	
	@Test
	public void deveTerUmaTaxaDe3ReaisMais3PorcentoDoValorASerTransferido() {
		when(transferencia.getValor()).thenReturn(new BigDecimal("10.00"));
		BigDecimal taxaDe = new TaxaA().getTaxaDe(transferencia);
		assertThat(new BigDecimal("3.30"), Matchers.comparesEqualTo(taxaDe));
	}

}
