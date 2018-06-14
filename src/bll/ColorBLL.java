package bll;

import dao.Cor;

public class ColorBLL extends Cor {

    public ColorBLL() {
    }
    
    public ColorBLL(Cor color)
    {
        super(color.getIdcor(), color.getNome(), color.getProdutos());
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
}
