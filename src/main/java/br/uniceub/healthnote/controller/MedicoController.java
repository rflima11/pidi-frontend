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

import br.uniceub.healthnote.model.Medico;
import br.uniceub.healthnote.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {


	@Autowired
	private MedicoService medicoService;
	
	//CRUD - creato - reado - updato - deleto 
	
	@PostMapping
	public ResponseEntity<?> salvarMedico(@RequestBody Medico medico) {
		Medico medicoSalvo = medicoService.save(medico);
		URI uri = UriComponentsBuilder.newInstance().path("medicos/{id}").buildAndExpand(medicoSalvo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarMedico(@PathVariable("id") Long id) {
		medicoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarMedico(@PathVariable("id") Long id, @RequestBody Medico medico) {
		medicoService.atualizar(id, medico);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> encontrarMedicoPorId(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(medicoService.findById(id).get());
	}
	
	@GetMapping
	public ResponseEntity<List<Medico>> listarMedicos() {
		return ResponseEntity.ok().body(medicoService.findAll());
	}
}
