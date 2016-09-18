package com.springmvc.dao;

import java.util.List;

import com.springmvc.pojo.Administrador;

public interface AdminDao {
	public boolean save(Administrador admin);

	public List<Administrador> findAll();

	public Administrador findById(int id);

	public List<Administrador> findByNombre(String nombre);

	public boolean update(Administrador admin);

	public boolean delete(int id);

	public int[] saveAll(List<Administrador> adminList);
}
