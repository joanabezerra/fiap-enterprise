package br.com.fiap.bean;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CONSULTA")
@SequenceGenerator(name="consulta", sequenceName="SQ_CONSULTA", allocationSize=1)
public class Consulta {
	
	private Medico medico;
	private Paciente paciente;
	
	@Column(name="DT_CONSULTA")
	private Calendar data;
	
	@Column(name="DS_DIAGNOSTICO")
	private String diagnostico;
	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
}
