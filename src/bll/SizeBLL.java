/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.Tamanho;

/**
 *
 * @author Gustavo Vieira
 */
public class SizeBLL extends Tamanho {

    public SizeBLL() {
    }
    
    public SizeBLL(Tamanho size)
    {
        super(size.getIdtamanho(), size.getDescricao(), size.getProdutos());
    }

    @Override
    public String toString() {
        return super.getDescricao();
    }
    
}
