package com.springmvc.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AdminRowMapper implements RowMapper<Administrador> {

	@Override
	public Administrador mapRow(ResultSet rs, int rowNum) throws SQLException {
		Administrador admin = new Administrador();
		admin.setId(rs.getInt("id"));
		admin.setCargo(rs.getString("cargo"));
		admin.setNombre(rs.getString("nombre"));
		admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
		return admin;
	}

}
