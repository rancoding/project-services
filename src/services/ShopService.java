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
    private List<Loja> getShopList()
    {
        List<Loja> shopList = HibernateGenericLibrary.executeHQLQuery("FROM Loja");
        HibernateGenericLibrary.closeSession();
        
        return shopList;
    }
    
    /**
     * Converts a shop list to a shopBLL list
     * @return BLL list
     */
    public List<ShopBLL> getConvertedShopList()
    {
        
        List<Loja> shopList = this.getShopList();
        List<ShopBLL> bll = new ArrayList<>();
        
        for(Loja shop : shopList)
        {
            bll.add(new ShopBLL(shop));
        }
        
        return bll;
    }
}
