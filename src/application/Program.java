package application;

import model.Entities.Veiculo;
import model.dao.DaoFactory;
import model.dao.VeiculoDao;

public class Program {

	public static void main(String[] args) {
		
		VeiculoDao veiculoDao = DaoFactory.createVeiculoDao();
		
		Veiculo veic = veiculoDao.findById(1);
		
		System.out.println(veic);
	}

}
