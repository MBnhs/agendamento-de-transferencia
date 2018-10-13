package br.com.marcelo.agendamentotransferencia.model.transferencia;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.marcelo.agendamentotransferencia.model.conta.Conta;
import br.com.marcelo.agendamentotransferencia.model.taxa.TipoDeTaxa;

@Entity
public class Transferencia {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Conta contaOrigem;

	@OneToOne(cascade = CascadeType.ALL)
	private Conta contaDestino;

	private BigDecimal valor;
	private TipoDeTaxa tipoDeTaxa;
	private BigDecimal taxa;
	private LocalDate dataDaTransferencia;
	private LocalDate dataDeAgendamento;

	/*
	 * Apenas para a execução do teste unitário da classe TransparenciaRepository
	 */
	@SuppressWarnings("unused")
	private Transferencia() {
	}

	public Transferencia(Conta contaOrigem, Conta contaDestino, BigDecimal valor, LocalDate dataDeAgendamento) {
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

		taxa = tipoDeTaxa.getTaxaDe(this);

	}

	public Long getId() {
		return id;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public Conta getContaDestino() {
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
		sb.append(contaOrigem.getNumero());
		sb.append("\t");
		sb.append(contaDestino.getNumero());
		sb.append("\t");
		sb.append(dataDaTransferencia);
		sb.append("\t");
		sb.append(dataDeAgendamento);
		sb.append("\t");
		sb.append(valor);
		sb.append("\t");
		sb.append(taxa);
		sb.append("\t");
		sb.append(tipoDeTaxa);

		return sb.toString();
	}

}
