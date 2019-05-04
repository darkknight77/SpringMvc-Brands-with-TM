package org.brands.service;

import java.util.List;

import org.brands.dao.BrandDao;
import org.brands.model.BrandModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
	@Autowired
	private BrandDao brandDao;
	
	public List<BrandModel> getBrands(){
		
		return brandDao.getBrands();
		
	}

	public void addBrand(BrandModel brand) {
		// TODO Auto-generated method stub
		brandDao.addBrand(brand);
	}

	public BrandModel getBrand(int id) {
		// TODO Auto-generated method stub
		return brandDao.getBrand(id);
	}

	public void deleteBrand(int id) {
		// TODO Auto-generated method stub
		brandDao.deleteBrand(id);
	}
	

}
