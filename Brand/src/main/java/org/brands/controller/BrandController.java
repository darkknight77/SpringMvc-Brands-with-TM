package org.brands.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.brands.model.BrandModel;
import org.brands.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BrandController {
	@Autowired
	private BrandService service;

	@GetMapping("/")
	public String h(){
			
		return "index";
	} 
	
	@GetMapping("/brands")
	public String getBrands(ModelMap map ){
			List<BrandModel> brands=new ArrayList();
		    brands=service.getBrands();
		    System.out.println(brands);
		    map.put("brands", brands);
		    
		return "NewFile";
	} 
	
	@GetMapping("/addBrand")
	public String addBrand(ModelMap map){
		BrandModel brand=new BrandModel("","");
		System.out.println("ADD******");
		map.put("brand", brand);
		return "addBrand";
	}
	
	@PostMapping("/addBrand")
	public String addBrandToDb(ModelMap map,@Valid BrandModel brand,BindingResult result){
		
		if(result.hasErrors()){
			return "/addBrand";
		}
		System.out.println("Post add:  "+brand);
		service.addBrand(brand);
		
		return "redirect:/brands";
	}
	
	@GetMapping("/updateBrand")
	public String updateBrand(ModelMap map,@RequestParam int id){
		BrandModel brand=service.getBrand(id);
		System.out.println("Update******");
		System.out.println(brand);
		map.put("brand", brand);
		return "updateBrand";
	}
	
	@PostMapping("/updateBrand")
	public String updateBrandToDb(ModelMap map,@Valid BrandModel brand,BindingResult result){
		
		if(result.hasErrors()){
			return "/updateBrand";
		}
		System.out.println("Post update:  "+brand);
		service.addBrand(brand);
		
		return "redirect:/brands";
	}
	
	
	@GetMapping("/deleteBrand")
	public String deleteBrandFromDb(ModelMap map,@RequestParam int id){
		
	service.deleteBrand(id);
		
		return "redirect:/brands";
	}
	
	
	
}

