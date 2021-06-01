package com.pulloquinga.app;

import java.util.ArrayList;

public class ArrayCentrosMedicos {
    static ArrayList<CentroMedico> CentrosMedicos = new ArrayList();
    public static void InizializaDati(){

        CentrosMedicos.add(new CentroMedico(1,"U.M.M. Dr. Pomerio Cabrera","Medicina General,Obstetricia,Odontología,Psicología,Medico Cirujano,Ginecología,Hospitalización,Partos,Nebulizaciones,Laboratorio,Farmacia,Enfermeria,Medicina General(Medicos Residentes","Barrio 4 de Abril","(07)2927200 / (07)2927201","https://goo.gl/maps/LhQwcLiFNsLtJ1bn9"));

    }
    public static CentroMedico BuscarCentroMedico(int id) {
        CentroMedico resultado = null;
        for (CentroMedico centromedico : CentrosMedicos) {
            if (centromedico.getId()==id) {
                resultado = centromedico;
                break;
            }
        }
        return resultado;
    }

}
