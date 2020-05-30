package br.uece.eesdevop.filmesapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.uece.eesdevop.filmesapi.domain.Avaliacao;
import br.uece.eesdevop.filmesapi.domain.Filme;
import br.uece.eesdevop.filmesapi.repository.AvaliacaoRepository;
import br.uece.eesdevop.filmesapi.services.FilmesService;

@RestController
@RequestMapping("/filmes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FilmeResources {

	@Autowired
	private FilmesService filmeServices;
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Filme>>  listar() {		
		return ResponseEntity.status(HttpStatus.OK).body(filmeServices.listar());				
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Filme> salvar(@RequestBody Filme filme) {
		
	  filme	= filmeServices.salvar(filme);
	
	
	  
	   return ResponseEntity.status(HttpStatus.CREATED).body(filme);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id")  Long id) {
		Filme filme = filmeServices.buscar(id);		
		return ResponseEntity.status(HttpStatus.OK).body(filme);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id")  Long id) {
		filmeServices.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Filme filme,@PathVariable("id")  Long id) {
		filme.setId(id);
		filmeServices.atualizar(filme);		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}/avaliacao", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarAvaliacao(@PathVariable("id") Long filmeId, @RequestBody Avaliacao avaliacao) {
		filmeServices.salvarAvaliacao(filmeId, avaliacao);
		
	
		URI  uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}/avaliacao", method = RequestMethod.GET)
	public ResponseEntity<List<Avaliacao>>  listarAvaliacao(@PathVariable("id") Long filmeId) {		
		return ResponseEntity.status(HttpStatus.OK).body(avaliacaoRepository.findAvaliacaoByFilmeId(filmeId));				
	}
	
}
