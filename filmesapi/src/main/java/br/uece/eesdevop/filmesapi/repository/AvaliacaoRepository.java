package br.uece.eesdevop.filmesapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.uece.eesdevop.filmesapi.domain.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
        List<Avaliacao> findAvaliacaoByFilmeId(Long id);
}
