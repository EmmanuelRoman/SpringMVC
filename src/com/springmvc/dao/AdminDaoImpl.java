package com.springmvc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.pojo.AdminRowMapper;
import com.springmvc.pojo.Administrador;

@Component("adminDao")
public class AdminDaoImpl implements AdminDao {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Administrador admin) {
		// MapSqlParameterSource paramMap = new MapSqlParameterSource();
		// paramMap.addValue("nombre", admin.getNombre());
		// paramMap.addValue("cargo", admin.getCargo());
		// paramMap.addValue("fechaCreacion", admin.getFechaCreacion());

		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		return jdbcTemplate.update(
				"insert into administrador(nombre, cargo, fechaCreacion) values(:nombre, :cargo, :fechaCreacion)",
				paramMap) == 1;
	}

	@Override
	public List<Administrador> findAll() {
		return jdbcTemplate.query("SELECT * FROM ADMINISTRADOR", (RowMapper<Administrador>) (rs, rowNum) -> {
			Administrador admin = new Administrador();
			admin.setId(rs.getInt("id"));
			admin.setCargo(rs.getString("cargo"));
			admin.setNombre(rs.getString("nombre"));
			admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
			return admin;
		});
	}

	@Override
	public Administrador findById(int id) {
		// return (Administrador) jdbcTemplate.query("SELECT * FROM
		// ADMINISTRADOR WHRE ID=:ID",
		// new MapSqlParameterSource("id", id), new AdminRowMapper());

		return jdbcTemplate.queryForObject("SELECT * FROM ADMINISTRADOR WHERE ID=:id",
				new MapSqlParameterSource("id", id), new AdminRowMapper());
	}

	@Override
	public List<Administrador> findByNombre(String nombre) {
		return jdbcTemplate.query("SELECT * FROM ADMINISTRADOR WHERE NOMBRE LIKE :nombre",
				new MapSqlParameterSource("nombre", "%" + nombre + "%"), new AdminRowMapper());
	}

	@Override
	public boolean update(Administrador admin) {
		return jdbcTemplate.update(
				"UPDATE ADMINISTRADOR SET NOMBRE=:nombre, CARGO=:cargo, FECHACREACION=:fechaCreacion WHERE ID=:id",
				new BeanPropertySqlParameterSource(admin)) == 1;
	}

	@Override
	public boolean delete(int id) {
		return jdbcTemplate.update("DELETE FROM ADMINISTRADOR WHERE ID=:id", new MapSqlParameterSource("id", id)) == 1;
	}

	@Transactional
	@Override
	public int[] saveAll(List<Administrador> adminList) {
		SqlParameterSource[] batchValues = SqlParameterSourceUtils.createBatch(adminList.toArray());
		return jdbcTemplate.batchUpdate(
				"insert into administrador(nombre, cargo, fechaCreacion) values(:nombre, :cargo, :fechaCreacion)",
				batchValues);

	}

}
