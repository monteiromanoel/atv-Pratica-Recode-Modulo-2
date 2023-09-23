package br.com.agencia.model;

public class Viagem {
	private int id;
	private String destino;
	private Double preco;
	private String data_ida;
	private String data_volta;
	private String descricao;
	private String adicional;
	private String tipo_pacote;

	public Viagem() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(double d) {
		this.preco = d;
	}
	public String getData_ida() {
		return data_ida;
	}
	public void setData_ida(String data_ida) {
		this.data_ida = data_ida;
	}
	public String getData_volta() {
		return data_volta;
	}
	public void setData_volta(String data_volta) {
		this.data_volta = data_volta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAdicional() {
		return adicional;
	}
	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}
	public String getTipo_pacote() {
		return tipo_pacote;
	}

	public void setTipo_pacote(String tipo_pacote) {
		this.tipo_pacote = tipo_pacote;
	}
	
	public String toString() {
	    return "ID da Viagem: " + this.id;
	}
	
}
