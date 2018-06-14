/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.Horario;

/**
 *
 * @author Gustavo Vieira
 */
public class ScheduleBLL extends Horario {

    public ScheduleBLL() {
    }
    
    public ScheduleBLL(Horario schedule)
    {
        super(schedule.getIdhorario(), schedule.getHoraprimeiraentrada(), schedule.getHoraprimeirasaida(), schedule.getHorasegundaentrada(), schedule.getHorasegundasaida(), schedule.getFuncionarios(), schedule.getPontohorarios());
    }
    
}
