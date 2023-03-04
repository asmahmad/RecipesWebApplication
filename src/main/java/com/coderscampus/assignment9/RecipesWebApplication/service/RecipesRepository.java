package com.coderscampus.assignment9.RecipesWebApplication.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Repository;

import com.coderscampus.assignment9.RecipesWebApplication.domain.Recipe;

@Repository
public class RecipesRepository {
	private List<Recipe> recipe = new ArrayList<>();
	private List<Recipe> recipeVegan = new ArrayList<>();
	private List<Recipe> recipeGlutenFree = new ArrayList<>();
	private List<Recipe> recipeVeganAndGlutenFree = new ArrayList<>();
	private List<Recipe> recipeVegitarian = new ArrayList<>();
	
	public void getData () throws IOException{

		//Leveraging Maven to use code for parsing csv file 
		// FileReader, CSVFormat, CSVRecord
		Reader in =  new FileReader("recipes.txt");
		
		String[] HEADERS = { "Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes", 
												"Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", "Vegetarian"};

		CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader(HEADERS).setSkipHeaderRecord(true).setEscape('\\').setIgnoreSurroundingSpaces(true).build();		
		Iterable<CSVRecord> records = csvFormat.parse(in);		
	
		Recipe newRecipe;
		for (CSVRecord record : records) {
			
			Integer cookingMinutes = Integer.parseInt(record.get(0));
		    Boolean daqiryFree = Boolean.parseBoolean(record.get(1));
		    Boolean glutenFree = Boolean.parseBoolean(record.get(2));
		    String recipeInstruction = record.get(3);
		    Double preparationMinutes =  Double.parseDouble(record.get(4));
		    Double pricePerServing = Double.parseDouble(record.get(5));
		    Integer readyInMinutes = Integer.parseInt(record.get(6));
		    Integer servings = Integer.parseInt(record.get(7));
		    Double spoonacularScore = Double.parseDouble(record.get(8));
		    String title = record.get(9);
		    Boolean vegan = Boolean.parseBoolean(record.get(10));
		    Boolean vegetarian = Boolean.parseBoolean(record.get(11));
		    
		   newRecipe = new Recipe(cookingMinutes,daqiryFree,glutenFree,recipeInstruction, preparationMinutes, pricePerServing,
				   readyInMinutes,servings,spoonacularScore,title,vegan,vegetarian);
		   
		   
		   //Adding all the recipes in ArrayList recipe:
		   recipe.add(newRecipe);

		   //Adding all Vegan recipes in ArrayList recipeVegan:
		   if (vegan){
			   newRecipe = new Recipe(cookingMinutes,daqiryFree,glutenFree,recipeInstruction, preparationMinutes, pricePerServing,
					   readyInMinutes,servings,spoonacularScore,title,vegan,vegetarian);
			   recipeVegan.add(newRecipe);
		   }
		   
		 //Adding all the Gluten-Free in ArrayList:
		   if (glutenFree){
			   newRecipe = new Recipe(cookingMinutes,daqiryFree,glutenFree,recipeInstruction, preparationMinutes, pricePerServing,
					   readyInMinutes,servings,spoonacularScore,title,vegan,vegetarian);
			   recipeGlutenFree.add(newRecipe);
		   }
		   
		 //Adding all the Vegetarian in ArrayList:
		   if (vegetarian){
			   newRecipe = new Recipe(cookingMinutes,daqiryFree,glutenFree,recipeInstruction, preparationMinutes, pricePerServing,
					   readyInMinutes,servings,spoonacularScore,title,vegan,vegetarian);
			   recipeVegitarian.add(newRecipe);
		   }
		   
		 //Adding all the Gluten-free & Vegan in ArrayList:
		   if (glutenFree && vegan){
			   newRecipe = new Recipe(cookingMinutes,daqiryFree,glutenFree,recipeInstruction, preparationMinutes, pricePerServing,
					   readyInMinutes,servings,spoonacularScore,title,vegan,vegetarian);
			   recipeVeganAndGlutenFree.add(newRecipe);
		   }
		   
		}
				

	}
	public List<Recipe> getAllRecipes () throws IOException{
		getData();
		return recipe;
	}
	public List<Recipe> getVeganRecipes () throws IOException{
		getData();
		return recipeVegan;
	}
	public List<Recipe> getGlutenFreeRecipes () throws IOException{
		getData();
		return recipeGlutenFree;
	}
	public List<Recipe> geteVeganAndGlutenFreeRecipes () throws IOException{
		getData();
		return recipeVeganAndGlutenFree;
	}
	public List<Recipe> getVegitarianRecipe () throws IOException{
		getData();
		return recipeVegitarian;
	}
	
}
	