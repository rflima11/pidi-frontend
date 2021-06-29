package br.uniceub.healthnote.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.uniceub.healthnote.model.abstrato.BaseModel;

@Entity
public class Medico extends BaseModel{

	
	private String crm;
	
	private String especialidade;
	
	@JsonIgnore
	@OneToMany(cascade =  CascadeType.ALL)
	private List<Agendamento> agendamentos = new ArrayList<>();
	
	public Medico() {
		
	}
	
	
	
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}



	public Medico(String crm) {
		this.crm = crm;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
	
		
	
	
}
