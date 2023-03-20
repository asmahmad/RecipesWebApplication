package com.coderscampus.assignment9.RecipesWebApplication.web;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.RecipesWebApplication.domain.Recipe;
import com.coderscampus.assignment9.RecipesWebApplication.service.RecipesService;

@RestController
public class RecipesController {
	
	@Autowired
	private RecipesService recipeService;
	
	
	@GetMapping("/all-recipes")
	public List<Recipe> readlAllRecipes() throws IOException{
		 return	recipeService.getRecipe();
		 
	}
	
	@GetMapping("/gluten-free")
	public List<Recipe> readlGlutenFree() throws IOException{
		 return	recipeService.getGlutenFree();
		 
	}
	@GetMapping("/vegan")
	public List<Recipe> readVegan() throws IOException{
		 return	recipeService.getVegan();
		 
	}
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> readVeganAndGlutenFree() throws IOException{
		 return	recipeService.getVeganAndGlutenFree();
		 
	}
	@GetMapping("/vegetarian")
	public List<Recipe> readlVegetarian() throws IOException{
		 return	recipeService.getVegitarian();
		 
	}
	
}
