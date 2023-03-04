package com.coderscampus.assignment9.RecipesWebApplication.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment9.RecipesWebApplication.domain.Recipe;



@Service
public class RecipesService {
	@Autowired
	RecipesRepository dataReader;

	public List<Recipe> getRecipe() throws IOException {
		return dataReader.getAllRecipes();
	}
	
	public List<Recipe> getVegan() throws IOException {
		return dataReader.getVeganRecipes();
	}
	public List<Recipe> getVeganAndGlutenFree() throws IOException {
		return dataReader.geteVeganAndGlutenFreeRecipes();
	}
	public List<Recipe> getGlutenFree() throws IOException {
		return dataReader.getGlutenFreeRecipes();
	}
	public List<Recipe> getVegitarian() throws IOException {
		return dataReader.getVegitarianRecipe();
	}

}
