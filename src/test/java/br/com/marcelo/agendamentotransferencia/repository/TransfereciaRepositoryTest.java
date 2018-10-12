package br.com.marcelo.agendamentotransferencia.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.Resource;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.marcelo.agendamentotransferencia.AgendamentoDeTransferenciaApplication;
import br.com.marcelo.agendamentotransferencia.PerfilDeTesteH2Config;
import br.com.marcelo.agendamentotransferencia.model.transferencia.Transferencia;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AgendamentoDeTransferenciaApplication.class, PerfilDeTesteH2Config.class })
@ActiveProfiles("test")
public class TransfereciaRepositoryTest {

	@Resource
	TransferenciaRepository dao;

	@Test
	public void deveGravarUmRegistroDeTransferenciaNaBaseDeDados() {
		Transferencia transferencia = new Transferencia("1234", "4567", new BigDecimal("1000"), LocalDate.now());
		dao.save(transferencia);
		Transferencia transferenciaEncontrada = dao.findById(transferencia.getId()).get();
		assertEquals(transferencia.getId(), transferenciaEncontrada.getId());
		assertEquals(transferencia.getContaOrigem(), transferenciaEncontrada.getContaOrigem());
		assertEquals(transferencia.getContaDestino(), transferenciaEncontrada.getContaDestino());
		assertEquals(transferencia.getDataDaTransferencia(), transferenciaEncontrada.getDataDaTransferencia());
		assertEquals(transferencia.getDataDeAgendamento(), transferenciaEncontrada.getDataDeAgendamento());
		assertThat(transferencia.getValor(), Matchers.comparesEqualTo(transferenciaEncontrada.getValor()));
		assertThat(transferencia.getTaxa(), Matchers.comparesEqualTo(transferenciaEncontrada.getTaxa()));
		assertEquals(transferencia.getTipoDeTaxa(), transferenciaEncontrada.getTipoDeTaxa());

	}

}
