/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import hibernate.HibernateGenericLibrary;

/**
 *
 * @author Gustavo Vieira
 */
public class ClosingService {

    public static void closeSession()
    {
        HibernateGenericLibrary.closeSession();
    }
    
}
