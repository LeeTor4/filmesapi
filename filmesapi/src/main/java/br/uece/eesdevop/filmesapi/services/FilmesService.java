package br.uece.eesdevop.filmesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.uece.eesdevop.filmesapi.domain.Avaliacao;
import br.uece.eesdevop.filmesapi.domain.Filme;
import br.uece.eesdevop.filmesapi.repository.AvaliacaoRepository;
import br.uece.eesdevop.filmesapi.repository.FilmeRepository;
import br.uece.eesdevop.filmesapi.services.exceptions.FilmeNaoEncontradoException;

@Service
public class FilmesService {

	@Autowired
	private FilmeRepository filmesRepository;
	
	@Autowired
	private AvaliacaoRepository avaliavaoRepository;

	public List<Filme> listar(){
		return filmesRepository.findAll();
	}
	
	public Filme buscar(Long id) {
		Filme filme = filmesRepository.findById(id).orElse(null);
		if(filme == null) {
			throw new FilmeNaoEncontradoException("O Filme não pode ser encontrado!!");
		}
		
		return filme;
	}
	
	public Filme salvar(Filme filme) {
		filme.setId(null);
		 
		
		return filmesRepository.save(filme);
	}
	
	public void deletar(Long id) {
		try {
			filmesRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new FilmeNaoEncontradoException("O Filme não pôde ser encontrado!!!");
		}
	}
	
	public void atualizar(Filme filme) {
		verificarExistencia(filme.getId());
		filmesRepository.save(filme);
	}
	private void verificarExistencia(Long id) {
		buscar(id);
	}
	
	public Avaliacao salvarAvaliacao(Long filmeId, Avaliacao avaliacao) {
		 Filme filme  = buscar(filmeId);
		 
		 avaliacao.setFilme(filme);
		
		 return avaliavaoRepository.save(avaliacao);
	}
	

}
