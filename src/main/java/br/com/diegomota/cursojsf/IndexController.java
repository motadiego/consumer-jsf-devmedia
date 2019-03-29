package br.com.diegomota.cursojsf;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope(value="request")
public class IndexController {
	
	private String mensagem;
	
	public IndexController() {
		mensagem = "Ola mundo 2"; 
	}
	
	@RequestMapping("*/")
	private String index() {
		return "index.xhtml";
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	public String listarNotas() {
		return "notas.xhtml";
	}
	
}
