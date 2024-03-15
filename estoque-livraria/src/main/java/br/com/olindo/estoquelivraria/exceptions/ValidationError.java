package br.com.olindo.estoquelivraria.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends Error {

	public ValidationError(Long timestamp, Integer status, String msg, String path) {
		super(timestamp, status, msg, path);
		// TODO Auto-generated constructor stub
	}

	private List<FieldMessage> list = new ArrayList<>();

	
	public List<FieldMessage> getErros() {
		return list;
	}

	public void addError(String fieldName, String messagem) {
		list.add(new FieldMessage(fieldName, messagem));
	}

}
