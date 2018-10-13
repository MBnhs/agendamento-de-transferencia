package br.com.marcelo.agendamentotransferencia.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.marcelo.agendamentotransferencia.model.transferencia.Transferencia;
import br.com.marcelo.agendamentotransferencia.repository.TransferenciaRepository;

@Controller
public class TransferenciaController {

	@Autowired
	TransferenciaRepository dao;

	@RequestMapping("/")
	public String mostraTransferencias(Model model) {
		Iterable<Transferencia> transferencias = dao.findAll();
		model.addAttribute("transferencias", transferencias);
		return "transferencias";
	}

	@RequestMapping("/novaTransferencia")
	public String mostraNovaTransferencia() {
		return "novaTransferencia";
	}

	@RequestMapping(value = "/cadastraTransferencia", method = RequestMethod.POST)
	public String cadastraTransferencia(@RequestParam String contaOrigem, @RequestParam String contaDestino,
			@RequestParam BigDecimal valor,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataDeAgendamento) {

		dao.save(new Transferencia(contaOrigem, contaDestino, valor, dataDeAgendamento));

		return "redirect:/";
	}

}
