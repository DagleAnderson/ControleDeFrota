package application;


import java.util.List;

import model.Entities.Marca;
import model.Entities.Modelo;
import model.Entities.Veiculo;
import model.dao.DaoFactory;
import model.dao.VeiculoDao;

public class Program {

	public static void main(String[] args) {
		
		VeiculoDao veiculoDao = DaoFactory.createVeiculoDao();
		
		Modelo md = new Modelo(1, "bitrem", new Marca(1,"Fiat"));
		
		Veiculo veic = new Veiculo(null,"caminhão", "2000", 124.22,"asd123","1234536","asd123", md);
		
		veiculoDao.insert(veic);
		
		System.out.println(veic.getId());
	}

}
