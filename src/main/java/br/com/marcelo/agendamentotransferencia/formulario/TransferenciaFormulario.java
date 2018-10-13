package br.com.marcelo.agendamentotransferencia.formulario;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.marcelo.agendamentotransferencia.model.transferencia.Transferencia;

public class TransferenciaFormulario {

	@NotBlank
	@Size(min=6, max=6)
	private String contaOrigem;
	
	@NotBlank
	@Size(min=6, max=6)
	private String contaDestino;
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDeAgendamento;

	public String getContaOrigem() {
		return contaOrigem;
	}
	
	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}
	
	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataDeAgendamento() {
		return dataDeAgendamento;
	}
	
	public void setDataDeAgendamento(LocalDate dataDeAgendamento) {
		this.dataDeAgendamento = dataDeAgendamento;
	}

	@AssertTrue
	public boolean isDataDeAgendamentoValida() {
		return dataDeAgendamento!=null && !dataDeAgendamento.isBefore(LocalDate.now());
	}
	
	@AssertTrue
	public boolean isValorPositivo() {
		return valor != null && valor.compareTo(BigDecimal.ZERO) > 0; 
	}
	
	public Transferencia getTransferencia() {
		return new Transferencia(contaOrigem, contaDestino, valor, dataDeAgendamento);
	}
	
}
