package br.uniceub.healthnote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.uniceub.healthnote.model.Agendamento;
import br.uniceub.healthnote.service.abstrato.BaseService;

@Service
public class AgendamentoService extends BaseService<Agendamento, Long> {

	@Autowired
	private AgendamentoService agendamentoService;

	@Override
	protected JpaRepository<Agendamento, Long> getRepository() {
		return this.agendamentoService;
	}
	
	
}
