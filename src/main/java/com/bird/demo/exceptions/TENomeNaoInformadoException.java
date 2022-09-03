package com.bird.demo.exceptions;

public class TENomeNaoInformadoException extends Exception{
	public TENomeNaoInformadoException() {
		super("Nome não informado!");
	}
}
