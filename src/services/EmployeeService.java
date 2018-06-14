/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bll.EmployeeBLL;
import dao.Funcionario;
import hibernate.HibernateGenericLibrary;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Gustavo Vieira
 */
public class EmployeeService {
    
    public EmployeeService() {
    }
    
    /**
     * Gets a employee list from the database
     * @return database employees
     */
    private static List<Funcionario> getEmployeeList()
    {
        List<Funcionario> employeeList = HibernateGenericLibrary.executeHQLQuery("FROM Funcionario");
        return employeeList;
    }
    
    /**
     * Gets a list of employees in a given work location ID
     * @param workLocationID location where employee is working
     * @return employee list
     */
    public static List<EmployeeBLL> getWorkLocationEmployeeList(byte workLocationID) {
        
        List<Funcionario> employeeList = HibernateGenericLibrary.executeHQLQuery("FROM Funcionario WHERE idlocaltrabalho = " + workLocationID);
        
        List<EmployeeBLL> bll = new ArrayList<>();
        
        for(Funcionario employee : employeeList)
        {
            bll.add(new EmployeeBLL(employee));
        }
        
        return bll;
    }
    
    /**
     * Converts a employee list to a employeeBLL list
     * @return BLL list
     */
    public static List<EmployeeBLL> getConvertedEmployeeList()
    {
        
        List<Funcionario> employeeList = EmployeeService.getEmployeeList();
        List<EmployeeBLL> bll = new ArrayList<>();
        
        for(Funcionario employee : employeeList)
        {
            bll.add(new EmployeeBLL(employee));
        }
        
        return bll;
    }
    
    /**
     * Searches for a employee with the same name as the one sent as argument within the employee list
     * @param employeeList list that will be searched
     * @param name name that will be compared
     * @param nonCharacters to be replaced characters
     * @return name existence
     */
    public static boolean checkForExistentEmployee(ObservableList<EmployeeBLL> employeeList, String name, String nonCharacters)
    {
        if(!(employeeList.isEmpty()))
        {
            for(EmployeeBLL employee : employeeList)
            {
                String employeeName = StringUtils.stripAccents(employee.getNome().replaceAll(nonCharacters, "").toLowerCase());

                if(name.equals(employeeName))
                {
                    return true;
                }
            }
        }
            
        return false;
    }
    
    /**
     * Checks if the employee name typed in the text field already exists
     * @param employeeList list that will be searched
     * @param employee to be ignored employee
     * @param name name that will be compared
     * @param nonCharacters to be replaced characters
     * @return name existence
     */
    public static boolean checkIfNameExists(ObservableList<EmployeeBLL> employeeList, EmployeeBLL employee, String name, String nonCharacters)
    {
        for(EmployeeBLL e : employeeList)
        {
            if(e.getIdfuncionario()!= employee.getIdfuncionario())
            {
                String currentEmployeeName = StringUtils.stripAccents(e.getNome().replaceAll(nonCharacters, "").toLowerCase());
                
                if(name.equals(currentEmployeeName))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
}
