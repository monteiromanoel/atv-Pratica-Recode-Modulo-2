package br.com.agencia.model;

import java.util.Date;

public class Reserva {
	private int id;
	private int num_passageiros;
	private Date data_reserva;
	private String destino;
	private Double preco;
	private Cliente idCliente;
	private String tipoPacote;
	private Viagem idViagem;
	
	public Reserva() {
		this.preco = 0.0;
	};
	public String getTipoPacote() {
		return tipoPacote;
	}
	public void setTipoPacote(String tipoPacote) {
		this.tipoPacote = tipoPacote;
	}
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	
	public Viagem getIdViagem() {
		return idViagem;
	}
	public void setIdViagem(Viagem idViagem) {
		this.idViagem = idViagem;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum_passageiros() {
		return num_passageiros;
	}
	public void setNum_passageiros(int num_passageiros) {
		this.num_passageiros = num_passageiros;
	}
	public Date getData_reserva() {
		return data_reserva;
	}
	public void setData_reserva(Date data_reserva) {
		this.data_reserva = data_reserva;
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
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double calcularPrecoFinal(int num_passageiros) {
		return this.preco * num_passageiros;
	}

	
	
}
