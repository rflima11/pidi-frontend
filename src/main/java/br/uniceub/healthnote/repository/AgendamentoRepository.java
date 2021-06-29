package br.uniceub.healthnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.uniceub.healthnote.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
