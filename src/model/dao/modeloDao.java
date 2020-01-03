package model.dao;

import java.util.List;

import model.Entities.Modelo;

public interface modeloDao {

	void insert(Modelo obj);
	void update(Modelo obj);
	void delete(Integer id);
	Modelo findById(Integer id);
	List<Modelo> findAll();
}
