package br.com.olindo.estoquelivraria.client.response;

import java.util.List;

public class DadosApiBooks {

	private String kind;
	private Integer totalItems;
	private List<ItemGoogleBooks> items;
	
	public String getKind() {
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public Integer getTotalItems() {
		return totalItems;
	}
	
	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
	
	public List<ItemGoogleBooks> getItems() {
		return items;
	}
	
	public void setItems(List<ItemGoogleBooks> items) {
		this.items = items;
	}
	
	
}
