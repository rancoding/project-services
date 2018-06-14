/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bll.BrandBLL;
import dao.Marca;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Gustavo Vieira
 */
public class BrandService {

    public BrandService() {
    }
    
    /**
     * Gets a brand list from the database
     * @return database brands
     */
    private static List<Marca> getBrandList()
    {
        List<Marca> brandList = HibernateGenericLibrary.executeHQLQuery("FROM Marca");
        return brandList;
    }
    
    /**
     * Converts a brand list to a brandBLL list
     * @return BLL list
     */
    public static List<BrandBLL> getConvertedBrandList()
    {
        
        List<Marca> brandList = BrandService.getBrandList();
        List<BrandBLL> bll = new ArrayList<>();
        
        for(Marca brand : brandList)
        {
            bll.add(new BrandBLL(brand));
        }
        
        return bll;
    }
    
    /**
     * Searches for a brand with the same name as the one sent as argument within the brand list
     * @param brandList list that will be searched
     * @param name name that will be compared
     * @param nonCharacters to be replaced characters
     * @return name existence
     */
    public static boolean checkForExistentBrand(ObservableList<BrandBLL> brandList, String name, String nonCharacters)
    {
        if(!(brandList.isEmpty()))
        {
            for(BrandBLL brand : brandList)
            {
                String brandName = StringUtils.stripAccents(brand.getNome().replaceAll(nonCharacters, "").toLowerCase());

                if(name.equals(brandName))
                {
                    return true;
                }
            }
        }
            
        return false;
    }
    
    /**
     * Checks if the brand name typed in the text field already exists
     * @param brandList list that will be searched
     * @param brand to be ignored brand
     * @param name name that will be compared
     * @param nonCharacters to be replaced characters
     * @return name existence
     */
    public static boolean checkIfNameExists(ObservableList<BrandBLL> brandList, BrandBLL brand, String name, String nonCharacters)
    {
        for(BrandBLL b : brandList)
        {
            if(b.getIdmarca() != brand.getIdmarca())
            {
                String currentBrandName = StringUtils.stripAccents(b.getNome().replaceAll(nonCharacters, "").toLowerCase());
                
                if(name.equals(currentBrandName))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
}
