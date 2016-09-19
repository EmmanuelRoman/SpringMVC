package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.AdminDao;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
}
