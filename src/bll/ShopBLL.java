package bll;

import dao.Entrega;
import dao.Localidade;
import dao.Loja;
import dao.Produtoloja;
import dao.Venda;
import java.util.Set;

public class ShopBLL extends Loja {

    public ShopBLL() {
    }
    
    public ShopBLL(Loja shop)
    {
        super(shop.getIdloja(), shop.getLocalidade(), shop.getNome(), shop.getProdutolojas(), shop.getEntregas(), shop.getVendas());
    }

    public ShopBLL(byte idloja, Localidade localidade, String nome) {
        super(idloja, localidade, nome);
    }

    public ShopBLL(byte idloja, Localidade localidade, String nome, Set<Produtoloja> produtolojas, Set<Entrega> entregas, Set<Venda> vendas) {
        super(idloja, localidade, nome, produtolojas, entregas, vendas);
    }
    
    @Override
    public String toString() {
        return super.getNome();
    }
    
}
