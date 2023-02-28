package com.coderscampus.assignment9.RecipesWebApplication.web;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.RecipesWebApplication.domain.Recipe;
import com.coderscampus.assignment9.RecipesWebApplication.service.FileService;

@RestController
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	
	@GetMapping("/all-recipes")
	public List<Recipe> readlAllRecipes() throws IOException{
		 return	fileService.getRecipe();
		 
	}
	
	@GetMapping("/gluten-free")
	public List<Recipe> readlGlutenFree() throws IOException{
		 return	fileService.getGlutenFree();
		 
	}
	@GetMapping("/vegan")
	public List<Recipe> readVegan() throws IOException{
		 return	fileService.getVegan();
		 
	}
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> readVeganAndGlutenFree() throws IOException{
		 return	fileService.getVeganAndGlutenFree();
		 
	}
	@GetMapping("/vegetarian")
	public List<Recipe> readlVegetarian() throws IOException{
		 return	fileService.getVegitarian();
		 
	}
	
}
