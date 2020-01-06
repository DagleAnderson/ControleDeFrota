package modal.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DBException;
import model.Entities.Marca;
import model.Entities.Modelo;
import model.Entities.Veiculo;
import model.dao.VeiculoDao;

public class VeiculoDaoJDBC implements VeiculoDao{

	private Connection conn;
	
	public VeiculoDaoJDBC(Connection conection){
		this.conn = conection;
	}
	@Override
	public void insert(Veiculo obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Veiculo obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Veiculo findById(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {	
			st = conn.prepareStatement(
					"SELECT veiculo.*,modelo.nome_mod as modelo,marca.nome_marca as marca FROM veiculo "
					 + "INNER JOIN modelo ON veiculo.modelo_id = modelo.id_mod "
					 + "INNER JOIN marca ON modelo.marca_id = marca.id_marca " 
					 + "WHERE veiculo.id_veic =?");
					
					st.setInt(1,id);
					rs = st.executeQuery();
					
					if(rs.next()){
						Marca marca = new Marca();
						marca.setDescricao(rs.getString("marca"));
						Modelo modelo = new Modelo();
						modelo.setId(rs.getInt("modelo_id"));
						modelo.setDescricao(rs.getString("modelo"));
						modelo.setMarca(marca);
						Veiculo obj = new Veiculo(
								rs.getInt("id_veic"),
								rs.getString("descricao_veic"),
								rs.getString("ano_veic"),
								rs.getDouble("km_rodado_veic"),
								rs.getString("placa_veic"),
								rs.getString("chassi_veic"),
								rs.getString("renavam_veic"),
								modelo
								);	
						
						return obj;
		
					}
					return null;
					
					
			
		} catch (SQLException e) {
			throw new  DBException(e.getMessage());
		}
		finally {
			DB.closeResultset(rs);
			DB.closeStatement(st);
		}
	
	}

	@Override
	public List<Veiculo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
