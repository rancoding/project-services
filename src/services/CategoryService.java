/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bll.CategoryBLL;
import dao.Tipoproduto;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Gustavo Vieira
 */
public class CategoryService {
    
    public CategoryService() {
    }
    
    /**
     * Gets a category list from the database
     * @return database categories
     */
    private static List<Tipoproduto> getCategoryList()
    {
        List<Tipoproduto> categoryList = HibernateGenericLibrary.executeHQLQuery("FROM Tipoproduto");
        return categoryList;
    }
    
    /**
     * Converts a category list to a categoryBLL list
     * @return BLL list
     */
    public static List<CategoryBLL> getConvertedCategoryList()
    {
        
        List<Tipoproduto> categoryList = CategoryService.getCategoryList();
        List<CategoryBLL> bll = new ArrayList<>();
        
        for(Tipoproduto category : categoryList)
        {
            bll.add(new CategoryBLL(category));
        }
        
        return bll;
    }
    
    /**
     * Searches for a category with the same name as the new one in the category list
     * @param categoryList list that will be searched
     * @param name name that will be compared
     * @param nonCharacters to be replaced characters
     * @return name existence
     */
    public static boolean checkForExistentCategory(ObservableList<CategoryBLL> categoryList, String name, String nonCharacters)
    {
        if(!(categoryList.isEmpty()))
        {
            for(Tipoproduto category : categoryList)
            {
                String categoryName = StringUtils.stripAccents(category.getNome().replaceAll(nonCharacters, "").toLowerCase());

                if(name.equals(categoryName))
                {
                    return true;
                }
            }
        }
            
        return false;
    }
    
    /**
     * Checks if the category name typed in the text field already exists
     * @param productTypeList list that will be searched
     * @param productType to be ignored brand
     * @param name name that will be compared
     * @param nonCharacters to be replaced characters
     * @return name existence
     */
    public static boolean checkIfNameExists(ObservableList<CategoryBLL> productTypeList, CategoryBLL productType, String name, String nonCharacters)
    {
        for(CategoryBLL type : productTypeList)
        {
            if(type.getIdtipoproduto() != productType.getIdtipoproduto())
            {
                String typeName = StringUtils.stripAccents(type.getNome().replaceAll(nonCharacters, "").toLowerCase());
                
                if(name.equals(typeName))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}
