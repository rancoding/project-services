package bll;

import dao.Armazem;

public class WarehouseBLL extends Armazem {

    public WarehouseBLL() {
        super();
    }

    public WarehouseBLL(Armazem warehouse) {
        super(warehouse.getIdarmazem(), warehouse.getLocalidade(), warehouse.getNome(), warehouse.getCaixas(), warehouse.getEntregas());
    }
    
    @Override
    public String toString() {
        return super.getNome();
    }
    
}
