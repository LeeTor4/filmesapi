package br.uece.eesdevop.filmesapi.services.exceptions;

public class FilmeNaoEncontradoException extends RuntimeException{
      
	/**
	 * 
	 */
	private static final long serialVersionUID = -7022960301126033257L;

	public FilmeNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public FilmeNaoEncontradoException(String mensagem,Throwable causa) {
		super(mensagem,causa);
		
	}
}
