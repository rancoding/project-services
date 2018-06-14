package services;

import bll.ShopBLL;
import dao.Loja;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

public class ShopService {

    public ShopService() {
    }
    
    /**
     * Gets a shop list from the database
     * @return database shops
     */
    private static List<Loja> getShopList()
    {
        List<Loja> shopList = HibernateGenericLibrary.executeHQLQuery("FROM Loja");
        return shopList;
    }
    
    /**
     * Converts a shop list to a shopBLL list
     * @return BLL list
     */
    public static List<ShopBLL> getConvertedShopList()
    {
        
        List<Loja> shopList = ShopService.getShopList();
        List<ShopBLL> bll = new ArrayList<>();
        
        for(Loja shop : shopList)
        {
            bll.add(new ShopBLL(shop));
        }
        
        return bll;
    }
}
