package br.com.marcelo.agendamentotransferencia.model.taxa;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.marcelo.agendamentotransferencia.model.transferencia.Transferencia;

@RunWith(MockitoJUnitRunner.class)
public class TaxaCTest {

	@Mock
	Transferencia transferencia;

	@Test
	public void acimaDe10Ate20DiasDeveTerUmaTaxaDe8PorcentoSobreOValorTransferido() {
		when(transferencia.getValor()).thenReturn(new BigDecimal("10.00"));
		when(transferencia.getDiasEntreTransferenciaEAgendamento()).thenReturn(11L);

		BigDecimal taxaDe = new TaxaC().getTaxaDe(transferencia);
		assertThat(new BigDecimal(".8"), Matchers.comparesEqualTo(taxaDe));
	}

	@Test
	public void acimaDe20Ate30DiasDeveTerUmaTaxaDe6PorcentoSobreOValorTransferido() {
		when(transferencia.getValor()).thenReturn(new BigDecimal("10.00"));
		when(transferencia.getDiasEntreTransferenciaEAgendamento()).thenReturn(21L);

		BigDecimal taxaDe = new TaxaC().getTaxaDe(transferencia);
		assertThat(new BigDecimal(".6"), Matchers.comparesEqualTo(taxaDe));
	}

	@Test
	public void acimaDe30Ate40DiasDeveTerUmaTaxaDe4PorcentoSobreOValorTransferido() {
		when(transferencia.getValor()).thenReturn(new BigDecimal("10.00"));
		when(transferencia.getDiasEntreTransferenciaEAgendamento()).thenReturn(31L);

		BigDecimal taxaDe = new TaxaC().getTaxaDe(transferencia);
		assertThat(new BigDecimal(".4"), Matchers.comparesEqualTo(taxaDe));

	}

	@Test
	public void acimaDe40DiasDaDataDeAgendamentoEComValorSuperiorA100DeveTerUmaTaxaDe2PorcentoSobreOValorTransferido() {
		when(transferencia.getValor()).thenReturn(new BigDecimal("101.00"));
		when(transferencia.getDiasEntreTransferenciaEAgendamento()).thenReturn(41L);

		BigDecimal taxaDe = new TaxaC().getTaxaDe(transferencia);
		assertThat(new BigDecimal("2.02"), Matchers.comparesEqualTo(taxaDe));

	}

	@Test
	public void acimaDe40DiasDaDataDeAgendamentoEComValorInferiorA100DeveLancarAlertoSobreErro() {
		fail("Not yet implemented");
	}

}
