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
		
		List<Veiculo> veic = veiculoDao.findByModelo(md);
		
		System.out.println(veic);
	}

}
