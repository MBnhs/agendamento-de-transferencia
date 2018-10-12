package br.com.marcelo.agendamentotransferencia.model.transferencia;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.marcelo.agendamentotransferencia.model.taxa.TipoDeTaxa;

@Entity
public class Transferencia {

	@Id
	@GeneratedValue
	private Long id;

	private String contaOrigem;
	private String contaDestino;
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

		taxa = tipoDeTaxa.getTaxaDe(this);

	}

	public Long getId() {
		return id;
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
		sb.append(valor);
		sb.append("\t");
		sb.append(taxa);
		sb.append("\t");
		sb.append(tipoDeTaxa);

		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contaDestino == null) ? 0 : contaDestino.hashCode());
		result = prime * result + ((contaOrigem == null) ? 0 : contaOrigem.hashCode());
		result = prime * result + ((dataDaTransferencia == null) ? 0 : dataDaTransferencia.hashCode());
		result = prime * result + ((dataDeAgendamento == null) ? 0 : dataDeAgendamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((taxa == null) ? 0 : taxa.hashCode());
		result = prime * result + ((tipoDeTaxa == null) ? 0 : tipoDeTaxa.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transferencia other = (Transferencia) obj;
		if (contaDestino == null) {
			if (other.contaDestino != null)
				return false;
		} else if (!contaDestino.equals(other.contaDestino))
			return false;
		if (contaOrigem == null) {
			if (other.contaOrigem != null)
				return false;
		} else if (!contaOrigem.equals(other.contaOrigem))
			return false;
		if (dataDaTransferencia == null) {
			if (other.dataDaTransferencia != null)
				return false;
		} else if (!dataDaTransferencia.equals(other.dataDaTransferencia))
			return false;
		if (dataDeAgendamento == null) {
			if (other.dataDeAgendamento != null)
				return false;
		} else if (!dataDeAgendamento.equals(other.dataDeAgendamento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (taxa == null) {
			if (other.taxa != null)
				return false;
		} else if (!taxa.equals(other.taxa))
			return false;
		if (tipoDeTaxa != other.tipoDeTaxa)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
