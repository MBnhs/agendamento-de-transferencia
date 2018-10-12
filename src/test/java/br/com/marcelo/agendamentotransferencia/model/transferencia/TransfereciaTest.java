package br.com.marcelo.agendamentotransferencia.model.transferencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hamcrest.Matchers;
import org.junit.Test;

import br.com.marcelo.agendamentotransferencia.exception.CalculoDeTaxaException;
import br.com.marcelo.agendamentotransferencia.model.taxa.TipoDeTaxa;

public class TransfereciaTest {

	private Transferencia transferencia;

	@Test
	public void noMesmoDiaDoAgendamentoDeveTerUmaTaxaDe3ReaisMais3PorcentoDoValorASerTransferido() {
		transferencia = new Transferencia("1234", "4567", new BigDecimal("1000"), LocalDate.now());
		assertThat(new BigDecimal("33.00"), Matchers.comparesEqualTo(transferencia.getTaxa()));
	}

	@Test
	public void ate10DiasDaDataDeAgendamentoDevePossuirUmaTaxaDe12ReaisMultiplicadoPelaQuantidadeDeDiasDaDataDeAgendamentoAteADataDeTransferencia() {
		transferencia = new Transferencia("1234", "4567", new BigDecimal("1000"), LocalDate.now().plusDays(10));
		assertThat(new BigDecimal("120.00"), Matchers.comparesEqualTo(transferencia.getTaxa()));
	}

	@Test
	public void acimaDe10Ate20DiasDaDataDeAgendamentoDeveTerUmaTaxaDe8PorcentoSobreOValorTransferido() {
		transferencia = new Transferencia("1234", "4567", new BigDecimal("1000"), LocalDate.now().plusDays(20));
		assertThat(new BigDecimal("80.00"), Matchers.comparesEqualTo(transferencia.getTaxa()));
	}

	@Test
	public void acimaDe20Ate30DiasDaDataDeAgendamentoDeveTerUmaTaxaDe6PorcentoSobreOValorTransferido() {
		transferencia = new Transferencia("1234", "4567", new BigDecimal("1000"), LocalDate.now().plusDays(30));
		assertThat(new BigDecimal("60.00"), Matchers.comparesEqualTo(transferencia.getTaxa()));
	}

	@Test
	public void acimaDe30Ate40DiasDaDataDeAgendamentoDeveTerUmaTaxaDe4PorcentoSobreOValorTransferido() {
		transferencia = new Transferencia("1234", "4567", new BigDecimal("1000"), LocalDate.now().plusDays(40));
		assertThat(new BigDecimal("40.00"), Matchers.comparesEqualTo(transferencia.getTaxa()));
	}

	@Test
	public void acimaDe40DiasDaDataDeAgendamentoEComValorSuperiorA100DeveTerUmaTaxaDe2PorcentoSobreOValorTransferido() {
		transferencia = new Transferencia("1234", "4567", new BigDecimal("1000"), LocalDate.now().plusDays(41));
		assertThat(new BigDecimal("20.00"), Matchers.comparesEqualTo(transferencia.getTaxa()));
	}

	@Test(expected = CalculoDeTaxaException.class)
	public void acimaDe40DiasDaDataDeAgendamentoEComValorInferiorA100DeveLancarAlertoSobreErro() {
		transferencia = new Transferencia("1234", "4567", new BigDecimal("99.00"), LocalDate.now().plusDays(41));
	}

	@Test
	public void noMesmoDiaDoAgendamentoDeveTerTaxaDoTipoA() {
		transferencia = new Transferencia("1234", "4567", new BigDecimal("1000"), LocalDate.now());
		assertEquals(TipoDeTaxa.TIPO_A, transferencia.getTipoDeTaxa());
	}

	@Test
	public void ate10DiasDaDataDeAgendamentoTerTaxaDoTipoB() {
		transferencia = new Transferencia("1234", "4567", new BigDecimal("1000"), LocalDate.now().plusDays(10));
		assertEquals(TipoDeTaxa.TIPO_B, transferencia.getTipoDeTaxa());
	}

	@Test
	public void acimaDe10DiasDaDataDeAgendamentoTerTaxaDoTipoC() {
		transferencia = new Transferencia("1234", "4567", new BigDecimal("1000"), LocalDate.now().plusDays(11));
		assertEquals(TipoDeTaxa.TIPO_C, transferencia.getTipoDeTaxa());
	}

}
