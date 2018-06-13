package bll;

import dao.Armazem;
import dao.Caixa;
import dao.Entrega;
import dao.Localidade;
import java.util.Set;

public class WarehouseBLL extends Armazem {

    public WarehouseBLL() {
        super();
    }

    public WarehouseBLL(Armazem warehouse) {
        super(warehouse.getIdarmazem(), warehouse.getLocalidade(), warehouse.getNome(), warehouse.getCaixas(), warehouse.getEntregas());
    }
    
    public WarehouseBLL(byte idarmazem, Localidade localidade, String nome) {
        super(idarmazem, localidade, nome);
    }

    public WarehouseBLL(byte idarmazem, Localidade localidade, String nome, Set<Caixa> caixas, Set<Entrega> entregas) {
        super(idarmazem, localidade, nome, caixas, entregas);
    }
    
    @Override
    public String toString() {
        return super.getNome();
    }
    
}
