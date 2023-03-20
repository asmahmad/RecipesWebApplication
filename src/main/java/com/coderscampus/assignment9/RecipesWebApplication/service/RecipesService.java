package com.coderscampus.assignment9.RecipesWebApplication.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment9.RecipesWebApplication.domain.Recipe;


@Service
public class RecipesService {
	@Autowired
	RecipesRepository recipeRepo;

	public List<Recipe> getRecipe() throws IOException {

		return recipeRepo.getAllRecipes();
	}
	
	public List<Recipe> getVegan() throws IOException {
		
		return recipeRepo.getAllRecipes() 
						 .stream()
						 .filter(x-> x.getVegan())
						 .collect(Collectors.toList());
	}
	public List<Recipe> getVeganAndGlutenFree() throws IOException {
		return recipeRepo.getAllRecipes() 
				 		 .stream()
				 		 .filter(x-> x.getVegan() && x.getGlutenFree())
				 		 .collect(Collectors.toList());
	}
	public List<Recipe> getGlutenFree() throws IOException {
		return recipeRepo.getAllRecipes() 
						 .stream()
						 .filter(x -> x.getGlutenFree())
						 .collect(Collectors.toList());
	}
	public List<Recipe> getVegitarian() throws IOException {
		return recipeRepo.getAllRecipes() 
						 .stream()
						 .filter(x->x.getVegetarian())
						 .collect(Collectors.toList());
	}

}
