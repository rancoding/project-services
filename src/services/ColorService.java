package services;

import bll.ColorBLL;
import dao.Cor;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import org.apache.commons.lang3.StringUtils;

public class ColorService {
    
    public ColorService() {
    }
    
    /**
     * Gets a color list from the database
     * @return database colors
     */
    private static List<Cor> getColorList()
    {
        List<Cor> colorList = HibernateGenericLibrary.executeHQLQuery("FROM Cor");
        return colorList;
    }
    
    /**
     * Converts a color list to a colorBLL list
     * @return BLL list
     */
    public static List<ColorBLL> getConvertedColorList()
    {
        
        List<Cor> colorList = ColorService.getColorList();
        List<ColorBLL> bll = new ArrayList<>();
        
        for(Cor color : colorList)
        {
            bll.add(new ColorBLL(color));
        }
        
        return bll;
    }
    
    /**
     * Searches for a color with the same name as the one sent as argument within the color list
     * @param colorList list that will be searched
     * @param name name that will be compared
     * @param nonCharacters to be replaced characters
     * @return name existence
     */
    public static boolean checkForExistentColor(ObservableList<ColorBLL> colorList, String name, String nonCharacters)
    {
        if(!(colorList.isEmpty()))
        {
            for(ColorBLL color : colorList)
            {
                String colorName = StringUtils.stripAccents(color.getNome().replaceAll(nonCharacters, "").toLowerCase());

                if(name.equals(colorName))
                {
                    return true;
                }
            }
        }
            
        return false;
    }
    
    /**
     * Checks if the color name typed in the text field already exists
     * @param colorList list that will be searched
     * @param color to be ignored color
     * @param name name that will be compared
     * @param nonCharacters to be replaced characters
     * @return name existence
     */
    public static boolean checkIfNameExists(ObservableList<ColorBLL> colorList, ColorBLL color, String name, String nonCharacters)
    {
        for(ColorBLL c : colorList)
        {
            if(c.getIdcor()!= color.getIdcor())
            {
                String currentColorName = StringUtils.stripAccents(c.getNome().replaceAll(nonCharacters, "").toLowerCase());
                
                if(name.equals(currentColorName))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
}
