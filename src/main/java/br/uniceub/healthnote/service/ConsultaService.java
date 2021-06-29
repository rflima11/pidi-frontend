package br.uniceub.healthnote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.uniceub.healthnote.model.Consulta;
import br.uniceub.healthnote.repository.ConsultaRepository;
import br.uniceub.healthnote.service.abstrato.BaseService;

@Service
public class ConsultaService extends BaseService<Consulta, Long>  {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Override
	protected JpaRepository<Consulta, Long> getRepository() {
		return this.consultaRepository;
	}

	
	
}
