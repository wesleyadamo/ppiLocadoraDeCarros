package ppi.agenda.model;

public class Carro {
	
	private int id;
	private String modelo;
	private String categoria;
	private String renavan;
	private String anoFabricacao;
	private double tarifaDia;
	private int disponivel;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getRenavan() {
		return renavan;
	}
	
	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}
	
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public double getTarifaDia() {
		return tarifaDia;
	}
	
	public void setTarifaDia(double tarifaDia) {
		this.tarifaDia = tarifaDia;
	}

	public int getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(int disponivel) {
		this.disponivel = disponivel;
	}
	
}