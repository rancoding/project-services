package bll;

import dao.Tipoproduto;

public class CategoryBLL extends Tipoproduto {

    public CategoryBLL() {
    }
    
    public CategoryBLL(Tipoproduto category) {
        super(category.getIdtipoproduto(), category.getNome(), category.getProdutos());
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
}
