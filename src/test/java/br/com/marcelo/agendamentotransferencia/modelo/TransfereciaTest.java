package br.com.marcelo.agendamentotransferencia.modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TransfereciaTest {

	@Before
	public void antes() {

	}

	@Test
	public void noMesmoDiaDoAgendamentoDeveTerUmaTaxaDe3ReaisMais3PorcentoDoValorASerTransferido() {
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
	public void acimaDe40DiasDaDataDeAgendamentoEComValorSuperiorA100DeveTerUmaTaxaDe8PorcentoSobreOValorTransferido() {
		fail("Not yet implemented");
	}

	@Test
	public void acimaDe40DiasDaDataDeAgendamentoEComValorInferiorA100DeveLancarAlertoSobreErro() {
		fail("Not yet implemented");
	}

}
