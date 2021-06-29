package br.uniceub.healthnote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uniceub.healthnote.model.Agendamento;
import br.uniceub.healthnote.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoService;
	
	
	@GetMapping
	public ResponseEntity<List<Agendamento>> listarAgendamentos() {
		return ResponseEntity.ok().body(agendamentoService.findAll());
	}
}
