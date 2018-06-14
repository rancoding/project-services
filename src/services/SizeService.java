/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bll.SizeBLL;
import dao.Tamanho;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Gustavo Vieira
 */
public class SizeService {
    
    public SizeService() {
    }
    
    /**
     * Gets a size list from the database
     * @return database sizes
     */
    private static List<Tamanho> getSizeList()
    {
        List<Tamanho> sizeList = HibernateGenericLibrary.executeHQLQuery("FROM Tamanho");
        return sizeList;
    }
    
    /**
     * Converts a size list to a sizeBLL list
     * @return BLL list
     */
    public static List<SizeBLL> getConvertedSizeList()
    {
        
        List<Tamanho> sizeList = SizeService.getSizeList();
        List<SizeBLL> bll = new ArrayList<>();
        
        for(Tamanho size : sizeList)
        {
            bll.add(new SizeBLL(size));
        }
        
        return bll;
    }
    
    /**
     * Searches for a size with the same name as the one sent as argument within the size list
     * @param sizeList list that will be searched
     * @param name name that will be compared
     * @param nonCharacters to be replaced characters
     * @return name existence
     */
    public static boolean checkForExistentSize(ObservableList<SizeBLL> sizeList, String name, String nonCharacters)
    {
        if(!(sizeList.isEmpty()))
        {
            for(SizeBLL size : sizeList)
            {
                String sizeName = StringUtils.stripAccents(size.getDescricao().replaceAll(nonCharacters, "").toLowerCase());

                if(name.equals(sizeName))
                {
                    return true;
                }
            }
        }
            
        return false;
    }
    
    /**
     * Checks if the size name typed in the text field already exists
     * @param sizeList list that will be searched
     * @param size to be ignored size
     * @param name name that will be compared
     * @param nonCharacters to be replaced characters
     * @return name existence
     */
    public static boolean checkIfNameExists(ObservableList<SizeBLL> sizeList, SizeBLL size, String name, String nonCharacters)
    {
        for(SizeBLL s : sizeList)
        {
            if(s.getIdtamanho() != size.getIdtamanho())
            {
                String currentSizeName = StringUtils.stripAccents(s.getDescricao().replaceAll(nonCharacters, "").toLowerCase());
                
                if(name.equals(currentSizeName))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
}
