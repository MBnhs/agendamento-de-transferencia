package br.com.marcelo.agendamentotransferencia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.marcelo.agendamentotransferencia.formulario.TransferenciaFormulario;
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
	public String cadastraTransferencia(@ModelAttribute @Valid TransferenciaFormulario transferenciaFormulario, BindingResult result) {

		if (result.hasErrors()) {
			return "redirect:/novaTransferencia";
		}
		
		dao.save(transferenciaFormulario.getTransferencia());

		return "redirect:/";
	}

}
