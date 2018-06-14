/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bll.ProductBLL;
import dao.Produto;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Gustavo Vieira
 */
public class ProductService {
    
    public ProductService() {
    }
    
    /**
     * Gets a product list from the database
     * @return database products
     */
    private static List<Produto> getProductList()
    {
        List<Produto> productList = HibernateGenericLibrary.executeHQLQuery("FROM Produto");
        return productList;
    }
    
    /**
     * Converts a product list to a productBLL list
     * @return BLL list
     */
    public static List<ProductBLL> getConvertedProductList()
    {
        
        List<Produto> productList = ProductService.getProductList();
        List<ProductBLL> bll = new ArrayList<>();
        
        for(Produto product : productList)
        {
            bll.add(new ProductBLL(product));
        }
        
        return bll;
    }
    
    /**
     * Searches for a product with the same barCode as the new one in the category list 
     * @param productList
     * @param newBarCode
     * @return 
     */
    public static boolean checkForExistentProduct(ObservableList<ProductBLL> productList, String newBarCode)
    {
        if(!(productList.isEmpty()))
        {
            for(ProductBLL product : productList)
            {
                String barCode =String.valueOf(product.getCodbarras());

                if(newBarCode.equals(barCode))
                {
                    System.out.println(newBarCode);
                    System.out.println(barCode);
                    return true;
                }
            }
        }
        
        return false;
    }
    
}
