package services;

import dao.Armazem;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class WarehouseService {

    public WarehouseService() {
    }
    
    /**
     * Retrieves all warehouses from the database
     * @return database warehouses
     */
    private List<Armazem> getWarehouseList()
    {
        /* Initializes and opens the database session using hibernate */
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        List<Armazem> warehouseList;
        warehouseList = session.createCriteria(Armazem.class).list();
        
        session.close();
        
        return warehouseList;
    }
}
