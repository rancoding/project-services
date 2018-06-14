/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.Produto;

/**
 *
 * @author Gustavo Vieira
 */
public class ProductBLL extends Produto {

    public ProductBLL() {
    }
    
    public ProductBLL(Produto product)
    {
        super(product.getCodbarras(), product.getCor(), product.getMarca(), product.getTamanho(), product.getTipoproduto(), product.getDescricao(), product.getPrecocompra(), product.getPrecovenda(), product.getGenero(), product.getProdutolojas(), product.getProdutovendas(), product.getCaixas(), product.getProdutoentregas());
    }

    @Override
    public String toString() {
        return super.getDescricao();
    }
}
