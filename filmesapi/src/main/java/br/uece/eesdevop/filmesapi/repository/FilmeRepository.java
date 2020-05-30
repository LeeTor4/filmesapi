package br.uece.eesdevop.filmesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.uece.eesdevop.filmesapi.domain.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

	

}
