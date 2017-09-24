package ppi.agenda.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		
		SimpleDateFormat formatoDesejado = new SimpleDateFormat("yyyy/MM/dd");

		Date data = new SimpleDateFormat("dd/MM/yyyy").parse("19/02/2012");
		
		String dataParaBanco = new SimpleDateFormat("yyyy/MM/dd").format(data);
		
		
		System.out.println(dataParaBanco);



	}

}
