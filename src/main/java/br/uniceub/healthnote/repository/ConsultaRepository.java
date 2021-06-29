package br.uniceub.healthnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.uniceub.healthnote.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
