package br.com.marcelo.agendamentotransferencia.model.transferencia;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

import br.com.marcelo.agendamentotransferencia.model.taxa.TipoDeTaxa;

public class Transferencia {

	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valor;
	private TipoDeTaxa tipoDeTaxa;
	private BigDecimal taxa;
	private LocalDate dataDaTransferencia;
	private LocalDate dataDeAgendamento;

	public Transferencia(String contaOrigem, String contaDestino, BigDecimal valor, LocalDate dataDeAgendamento) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.dataDaTransferencia = LocalDate.now();
		this.dataDeAgendamento = dataDeAgendamento;

		long dias = getDiasEntreTransferenciaEAgendamento();

		if (dias == 0) {
			tipoDeTaxa = TipoDeTaxa.TIPO_A;
		}

		else if (dias <= 10) {
			tipoDeTaxa = TipoDeTaxa.TIPO_B;
		}

		else {
			tipoDeTaxa = TipoDeTaxa.TIPO_C;
		}


	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public TipoDeTaxa getTipoDeTaxa() {
		return tipoDeTaxa;
	}

	public LocalDate getDataDaTransferencia() {
		return dataDaTransferencia;
	}

	public LocalDate getDataDeAgendamento() {
		return dataDeAgendamento;
	}

	public Long getDiasEntreTransferenciaEAgendamento() {
		return Duration.between(dataDaTransferencia.atStartOfDay(), dataDeAgendamento.atStartOfDay()).toDays();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(contaOrigem);
		sb.append("\t");
		sb.append(contaDestino);
		sb.append("\t");
		sb.append(dataDaTransferencia);
		sb.append("\t");
		sb.append(dataDeAgendamento);
		sb.append("\t");
		sb.append(taxa);
		sb.append("\t");
		sb.append(tipoDeTaxa);

		return sb.toString();
	}
}
