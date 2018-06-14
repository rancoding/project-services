/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.Funcionario;

/**
 *
 * @author Gustavo Vieira
 */
public class EmployeeBLL extends Funcionario {

    public EmployeeBLL() {
    }
    
    public EmployeeBLL(Funcionario employee)
    {
        super(employee.getIdfuncionario(), employee.getHorario(), employee.getLocaltrabalho(), employee.getNome(), employee.getUsername(), employee.getPassword(), employee.getDatanascimento(), employee.getSexo(), employee.isActivo(), employee.isTipo(), employee.getMorada(), employee.getEntregasForIdfuncionariorecebe(), employee.getVendas(), employee.getEntregasForIdfuncionarioentrega(), employee.getPontohorarios());
    }
    
    @Override
    public String toString() {
        return super.getNome();
    }
    
}
