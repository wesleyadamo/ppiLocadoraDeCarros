package ppi.agenda.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Cliente {
	
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	private String telefone;
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Calendar getDataNascimento() {
		return dataNascimento;
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
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	
	// Gets e Sets para auxilio
	
	
	// Get e set entre String(front) e Calendar(Objeto)


	// Recebe a String da data e insere no objeto como calendar
	public void setDataNascimentoString(String dataNascimento) {
		
		try {
			
			java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
			Calendar dataCalendar = Calendar.getInstance();
			dataCalendar.setTime(date);
			
			this.dataNascimento = dataCalendar;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
	}
	
	// Retorna String ja formatada
	public String getDataNascimentoString() {

		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

		return data.format(this.dataNascimento.getTime());

	}
	
	//----------------------
	
	
	// Get e set para trabalhar com o banco
	
	// Trabalhar com a data Vindo ou Indo para o Banco
	
	// Recebe a data do Sql e insere no formado Calendar
	public void setDataNascimentoFromSQL(Date dataNascimento) {

		// montando a data atrav�s do Calendar
		Calendar data = Calendar.getInstance();
		data.setTime(dataNascimento);
		this.dataNascimento = data;

	}

	// Retorna a data Calendar em formato Date do SQL
	public Date getDataNascimentoToSQL() {
		return new Date(dataNascimento.getTimeInMillis());
	}
	

}
