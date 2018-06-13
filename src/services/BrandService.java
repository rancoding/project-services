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

/**
 *
 * @author Gustavo Vieira
 */
public class BrandService {

    public BrandService() {
    }
    
    /**
     * Gets a shop list from the database
     * @return database shops
     */
    private List<Marca> getBrandList()
    {
        List<Marca> shopList = HibernateGenericLibrary.executeHQLQuery("FROM Loja");
        HibernateGenericLibrary.closeSession();
        
        return shopList;
    }
    
    /**
     * Converts a shop list to a shopBLL list
     * @return BLL list
     */
    public List<BrandBLL> getConvertedBrandList()
    {
        
        List<Marca> brandList = this.getBrandList();
        List<BrandBLL> bll = new ArrayList<>();
        
        for(Marca brand : brandList)
        {
            bll.add(new BrandBLL(brand));
        }
        
        return bll;
    }
    
}
