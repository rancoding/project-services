package bll;

import dao.Armazem;

public class WarehouseBLL extends Armazem {

    public WarehouseBLL() {
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
}
