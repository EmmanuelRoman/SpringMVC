package com.springmvc.service;

import java.sql.Timestamp;
import java.util.Date;

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
}
