package br.com.diegomota.cursojsf.mb;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import br.com.diegomota.cursojsf.dto.NotaDTO;
import br.com.diegomota.cursojsf.rest.NotaRestConsumer;

@SessionScope
@Controller("notasBean")
class NotasBean {
	
	/** página de detalhes da nota */
	public static final String DETALHES_NOTA= "/detalhes.jsf";
	
	
	@Autowired
	private NotaRestConsumer notaRest;
	
	private List<NotaDTO> notas;
	
	private NotaDTO notaDTO;
	
	private String mensagem;
	
	public NotasBean() {
		
	}
	
	@PostConstruct
	public void init() {
		notas = notaRest.listar();
	}
	
	
	public String exibir(NotaDTO nota) {
		this.notaDTO = nota;
		return DETALHES_NOTA;
	}
	
	 @RequestMapping(path = "/notas/detalhes", method = RequestMethod.GET)	
	 public ModelAndView exibirPorId(@RequestParam("id") Integer id) {
		this.notaDTO = notaRest.buscarPorId(id);
		ModelAndView model = new ModelAndView(DETALHES_NOTA);
		return model;
	}
	
	public String entrarEditar(NotaDTO nota) {
		this.notaDTO = nota;
		return "form.jsf";
	}
	 
	public String atualizar() {
		notaRest.atualizar(this.notaDTO);
		mensagem = "Nota atualizada com sucesso!";
		return "notas.xhtml";
	}
	
	public String entrarInserir() {
		notaDTO = new NotaDTO();
		return "form.jsf";
	}
	
	
	public String inserir() {
		notaRest.inserir(this.notaDTO);
		mensagem = "Nota inserida com sucesso!";
		notas = notaRest.listar();
		return "notas.jsf";
	}
	
	
	public String exluir(NotaDTO nota){
		notaRest.excluir(nota);
		mensagem = "Nota excluida com sucesso!";
		notas = notaRest.listar();
		return "notas.jsf";
	}
	
	 
	
	public List<NotaDTO> getNotas() {
		return notas;
	}

	public void setNotas(List<NotaDTO> notas) {
		this.notas = notas;
	}

	public NotaDTO getNotaDTO() {
		return notaDTO;
	}

	public void setNotaDTO(NotaDTO notaDTO) {
		this.notaDTO = notaDTO;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
