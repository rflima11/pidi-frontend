package br.uniceub.healthnote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.uniceub.healthnote.model.Agendamento;
import br.uniceub.healthnote.model.Paciente;
import br.uniceub.healthnote.repository.AgendamentoRepository;
import br.uniceub.healthnote.repository.PacienteRepository;
import br.uniceub.healthnote.service.abstrato.BaseService;

@Service
public class PacienteService extends BaseService<Paciente, Long> {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private MedicoService medicoService;

	@Override
	protected JpaRepository<Paciente, Long> getRepository() {
		return this.pacienteRepository;
	}

	public Paciente atualizar(Long id, Paciente paciente) {
		if(super.findById(id).isPresent()) {
			paciente.setId(id);
			return super.save(paciente);	
		}
		return null;
	}

	public Agendamento agendarConsulta(Agendamento agendamento) {
		Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);
		medicoService.atualizarAgenda(agendamentoSalvo);
		return agendamentoSalvo;
		
	}
}
