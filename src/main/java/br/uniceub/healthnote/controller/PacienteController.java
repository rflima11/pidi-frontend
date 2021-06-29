package br.uniceub.healthnote.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.uniceub.healthnote.model.Agendamento;
import br.uniceub.healthnote.model.Paciente;
import br.uniceub.healthnote.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	//CRUD - creato - reado - updato - deleto 
	
	@PostMapping
	public ResponseEntity<?> salvarPaciente(@RequestBody Paciente paciente) {
		Paciente pacienteSalvo = pacienteService.save(paciente);
		URI uri = UriComponentsBuilder.newInstance().path("pacientes/{id}").buildAndExpand(pacienteSalvo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPaciente(@PathVariable("id") Long id) {
		pacienteService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarPaciente(@PathVariable("id") Long id, @RequestBody Paciente paciente) {
		pacienteService.atualizar(id, paciente);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> encontrarPacientePorId(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(pacienteService.findById(id).get());
	}
	
	@GetMapping
	public ResponseEntity<List<Paciente>> listarPacientes() {
		return ResponseEntity.ok().body(pacienteService.findAll());
	}
	
	@PostMapping("/agendar-consulta")
	public ResponseEntity<?> agendarConsulta(@RequestBody Agendamento agendamento) {
		pacienteService.agendarConsulta(agendamento);
		URI uri = UriComponentsBuilder.newInstance().path("agendamento/{id}").buildAndExpand(agendamento.getId()).toUri();
		return ResponseEntity.created(null).build();
	}
 
}
