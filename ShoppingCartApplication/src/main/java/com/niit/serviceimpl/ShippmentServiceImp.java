package com.niit.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ShippmentDao;
import com.niit.domain.Shippment;
import com.niit.service.ShippmentService;
@Service
public class ShippmentServiceImp implements ShippmentService {
	@Autowired
	ShippmentDao shippmentDao;
	

	@Transactional
	public void add(Shippment shippment) {
		shippmentDao.add(shippment);
		
	}

	@Transactional
	public void edit(Shippment shippment) {
		shippmentDao.edit(shippment);
		
	}

}
