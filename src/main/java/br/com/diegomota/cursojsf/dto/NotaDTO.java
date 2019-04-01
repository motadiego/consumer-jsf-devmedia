package br.com.diegomota.cursojsf.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotaDTO implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message="Titulo: Preenchimento obrigatório")
	@Length(min=5 , max=20 , message="Titulo: O tamanho deve ser entre 5 e 20 caracteres")
	private String title;
	
	@NotEmpty(message="Corpo: Preenchimento obrigatório")
	private String body;
	
	public NotaDTO() {
		
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}



	@Override
	public String toString() {
		return "NotaDTO [id=" + id + ", title=" + title + ", body=" + body + "]";
	}
	
	
	

}
