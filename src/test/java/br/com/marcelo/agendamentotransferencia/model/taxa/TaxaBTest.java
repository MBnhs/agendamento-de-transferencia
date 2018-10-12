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
public class TaxaBTest {

	@Mock
	Transferencia transferencia;

	@Test
	public void devePossuirUmaTaxaDe12ReaisMultiplicadoPelaQuantidadeDeDias() {
		when(transferencia.getDiasEntreTransferenciaEAgendamento()).thenReturn(5L);
		
		BigDecimal taxaDe = new TaxaB().getTaxaDe(transferencia);
		assertThat(new BigDecimal("60.00"), Matchers.comparesEqualTo(taxaDe));
	}

}
