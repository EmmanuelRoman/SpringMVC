package com.springmvc.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.AdminDao;
import com.springmvc.pojo.Administrador;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public boolean save(Administrador admin) {
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		return adminDao.save(admin);
	}

	public List<Administrador> findAll() {
		return adminDao.findAll();
	}

	public Administrador findById(int id) {
		return adminDao.findById(id);
	}

	public boolean saveOrUpdate(Administrador admin) {
		if (admin.getId() == 0) {
			admin.setFechaCreacion(new Timestamp(new Date().getTime()));
			return adminDao.save(admin);
		} else {
			return adminDao.update(admin);
		}
	}
}
