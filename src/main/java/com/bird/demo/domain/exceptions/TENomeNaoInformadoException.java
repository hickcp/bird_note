package com.bird.demo.domain.exceptions;

public class TENomeNaoInformadoException extends Exception{
	public TENomeNaoInformadoException() {
		super("Nome não informado!");
	}
}
