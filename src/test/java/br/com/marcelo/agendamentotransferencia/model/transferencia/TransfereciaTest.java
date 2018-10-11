package br.com.marcelo.agendamentotransferencia.model.transferencia;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import br.com.marcelo.agendamentotransferencia.model.transferencia.Transferencia;

public class TransfereciaTest {

	private Transferencia transferencia;

	@Test
	public void noMesmoDiaDoAgendamentoDeveTerUmaTaxaDe3ReaisMais3PorcentoDoValorASerTransferido() {
		transferencia = new Transferencia("1234", "4567", new BigDecimal("1000"), LocalDate.now());

		System.out.println(transferencia.getContaDestino());
		fail("Not yet implemented");
	}

	@Test
	public void ate10DiasDaDataDeAgendamentoDevePossuirUmaTaxaDe12ReaisMultiplicadoPelaQuantidadeDeDiasDaDataDeAgendamentoAteADataDeTransferencia() {
		fail("Not yet implemented");
	}

	@Test
	public void acimaDe10Ate20DiasDaDataDeAgendamentoDeveTerUmaTaxaDe8PorcentoSobreOValorTransferido() {
		fail("Not yet implemented");
	}

	@Test
	public void acimaDe20Ate30DiasDaDataDeAgendamentoDeveTerUmaTaxaDe6PorcentoSobreOValorTransferido() {
		fail("Not yet implemented");
	}

	@Test
	public void acimaDe30Ate40DiasDaDataDeAgendamentoDeveTerUmaTaxaDe4PorcentoSobreOValorTransferido() {
		fail("Not yet implemented");
	}

	@Test
	public void acimaDe40DiasDaDataDeAgendamentoEComValorSuperiorA100DeveTerUmaTaxaDe2PorcentoSobreOValorTransferido() {
		fail("Not yet implemented");
	}

	@Test
	public void acimaDe40DiasDaDataDeAgendamentoEComValorInferiorA100DeveLancarAlertoSobreErro() {
		fail("Not yet implemented");
	}

}