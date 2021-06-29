package br.uniceub.healthnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.uniceub.healthnote.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
