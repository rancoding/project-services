package services;

import bll.WarehouseBLL;
import dao.Armazem;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

public class WarehouseService {

    public WarehouseService() {
    }
    
    /**
     * Retrieves all warehouses from the database
     * @return database warehouses
     */
    private List<Armazem> getWarehouseList()
    {
        List<Armazem> warehouseList = HibernateGenericLibrary.executeHQLQuery("FROM Armazem");
        HibernateGenericLibrary.closeSession();
        
        return warehouseList;
    }
    
    /**
     * Converts an warehouse list to a warehouseBLL list
     * @return BLL list
     */
    public List<WarehouseBLL> getConvertedWarehouseList()
    {
        List<Armazem> warehouseList = this.getWarehouseList();
        List<WarehouseBLL> bll = new ArrayList<>();
        
        for(Armazem warehouse : warehouseList)
        {
            bll.add(new WarehouseBLL(warehouse));
        }
        
        return bll;
    }
}
