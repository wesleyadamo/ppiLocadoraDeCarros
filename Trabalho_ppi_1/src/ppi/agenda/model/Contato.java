package ppi.agenda.model;

import java.util.Calendar;

public class Contato {
	
	private Long id; 
	private String nome; 
	private String email; 
	private String endereco; 
	private Calendar dataNascimento;
	private String telefone;
	
	
	public String getNome() { 
		return this.nome; 
	} 
	
	public void setNome(String novo) { 
		this.nome = novo; 
	}
	
	public String getEmail() { 
		return this.email; 
	} 
	
	public void setEmail(String novo) { 
		this.email = novo; 
	}
	
	public String getEndereco() { 
		return this.endereco; 
	} 
	
	public void setEndereco(String novo) { 
		this.endereco = novo; 
	}
	
	public Long getId() { 
		return this.id; 
	}
	
	public void setId(Long novo) { 
		this.id = novo; 
	}
	
	public Calendar getDataNascimento() { 
		return this.dataNascimento; 
	} 
	
	public void setDataNascimento(Calendar dataNascimento) { 
		this.dataNascimento = dataNascimento; 
	}	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String toString(){
		
		return this.getId() + " - Nome: " + this.nome+ ", Email: " 
					+this.email+ ", Endereço: " +this.endereco+ ", Nascimento: "
						+this.dataNascimento.getTime() + " Telefone: " + this.telefone;
	}
	

}
