package br.uniceub.healthnote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.uniceub.healthnote.model.Agendamento;
import br.uniceub.healthnote.model.Medico;
import br.uniceub.healthnote.model.Paciente;
import br.uniceub.healthnote.repository.MedicoRepository;
import br.uniceub.healthnote.service.abstrato.BaseService;

@Service
public class MedicoService extends BaseService<Medico, Long> {

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	protected JpaRepository<Medico, Long> getRepository() {
		return this.medicoRepository;
	}
	
	public Medico atualizar(Long id, Medico medico) {
		if(super.findById(id).isPresent()) {
			medico.setId(id);
			return super.save(medico);	
		}
		return null;
	}

	public void atualizarAgenda(Agendamento agendamento) {
		Medico medico = agendamento.getMedico();
		agendamento.getMedico().getAgendamentos().add(agendamento);
		 super.save(medico);
	}
	
	

}
