package br.com.fiap.bean;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CONSULTA")
@IdClass(ConsultaPK.class)
@SequenceGenerator(name="consulta", sequenceName="SQ_CONSULTA", allocationSize=1)
public class Consulta {
	
	@Id
	@ManyToOne
	@JoinColumn(name="CRM_MEDICO")
	private Medico medico;
	
	@Id
	@ManyToOne
	@JoinColumn(name="CD_PACIENTE")
	private Paciente paciente;
	
	@Id
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_CONSULTA")
	private Calendar data;
	
	@Column(name="DS_DIAGNOSTICO")
	private String diagnostico;
	
	public Consulta() {
		super();
	}
	
	public Consulta(Medico medico, Paciente paciente, Calendar data, String diagnostico) {
		super();
		this.medico = medico;
		this.paciente = paciente;
		this.data = data;
		this.diagnostico = diagnostico;
	}

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
