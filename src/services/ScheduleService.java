/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bll.EmployeeBLL;
import bll.ScheduleBLL;
import dao.Horario;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Vieira
 */
public class ScheduleService {
    
    public ScheduleService() {
    }
    
    /**
     * Gets a schedule list from the database
     * @return database schedules
     */
    private static List<Horario> getScheduleList()
    {
        List<Horario> scheduleList = HibernateGenericLibrary.executeHQLQuery("FROM Horario");
        return scheduleList;
    }
    
    /**
     * Converts a schedule list to a scheduleBLL list
     * @return BLL list
     */
    public static List<ScheduleBLL> getConvertedScheduleList()
    {
        
        List<Horario> scheduleList = ScheduleService.getScheduleList();
        List<ScheduleBLL> bll = new ArrayList<>();
        
        for(Horario schedule : scheduleList)
        {
            bll.add(new ScheduleBLL(schedule));
        }
        
        return bll;
    }
    
}
