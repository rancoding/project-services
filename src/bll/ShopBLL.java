package bll;

import dao.Loja;

public class ShopBLL extends Loja {

    public ShopBLL() {
    }
    
    public ShopBLL(Loja shop)
    {
        super(shop.getIdloja(), shop.getLocalidade(), shop.getNome(), shop.getProdutolojas(), shop.getEntregas(), shop.getVendas());
    }
    
    @Override
    public String toString() {
        return super.getNome();
    }
    
}
