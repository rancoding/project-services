/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.Marca;
import dao.Produto;
import java.util.Set;

/**
 *
 * @author Gustavo Vieira
 */
public class BrandBLL extends Marca {

    public BrandBLL() {
    }

    public BrandBLL(byte idmarca, String nome) {
        super(idmarca, nome);
    }

    public BrandBLL(byte idmarca, String nome, Set<Produto> produtos) {
        super(idmarca, nome, produtos);
    }
    
    public BrandBLL(Marca brand) {
        super(brand.getIdmarca(), brand.getNome(), brand.getProdutos());
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
    
    
}
