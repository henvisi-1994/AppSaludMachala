package com.pulloquinga.app;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;

public class Recursos {
    static void texto_no_editable(EditText edit_text) {
        //edit_text.setFocusable(false);
        //edit_text.setEnabled(false);
        //edit_text.setCursorVisible(false);
        edit_text.setKeyListener(null);

    }

    public static Intent enlaces(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
        return intent;
    }
    public static <T> ArrayList<T> listToArrayList(List<T> list) {
        return list != null ? new ArrayList<>(list) : null;
    }
    public static void enviarMensajeWS(String telefono, String mensaje, Context contexto){
        Intent setIntent=new Intent();
        setIntent.setAction(Intent.ACTION_VIEW);
        String uri="whatsapp://send?phone="+telefono+"&text="+mensaje;
        setIntent.setData(Uri.parse(uri));
        contexto.startActivity(setIntent);
    }

    //metodo para validar si es un valor numerico
    public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
    //metodo para validar si es un valor texto


    //metodo para validar si es un email
    public static boolean isEmail(String cadena) {
        boolean resultado;
        if (Patterns.EMAIL_ADDRESS.matcher(cadena).matches()) {
            resultado = true;
        } else {
            resultado = false;
        }

        return resultado;
    }
    public static boolean isValidarCedula(String x) {
        int suma = 0;
        if (x.length() == 9) {
            return false;
        } else {
            int a[] = new int[x.length() / 2];
            int b[] = new int[(x.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < x.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(x.charAt(c)));
                c = c + 2;
                if (i < (x.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(x.charAt(d)));
                    d = d + 2;
                }
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length() - 1))))
                return true;
            else if (suma % 10 == 0 && x.charAt(x.length() - 1) == '0') {
                return true;
            } else {
                return false;
            }
        }
    }
    public static boolean ValidarRUC(String ruc){
        int num_provincias = 24;
        int prov = Integer.parseInt(ruc.substring(0, 2));
        boolean val = false;

        if (!((prov > 0) && (prov <= num_provincias))) {
            return val;
        }

        Integer v1,v2,v3,v4,v5,v6,v7,v8,v9;
        Integer sumatoria;
        Integer modulo;
        Integer digito;
        Integer sustraendo;
        int[] d = new int[ruc.length()];

        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(ruc.charAt(i) + "");
        }

        v1 = d[0]* 3;
        v2 = d[1]* 2;
        v3 = d[2]* 7;
        v4 = d[3]* 6;
        v5 = d[4]* 5;
        v6 = d[5]* 4;
        v7 = d[6]* 3;
        v8 = d[7]* 2;
        v9 = d[8];

        sumatoria = v1+v2+v3+v4+v5+v6+v7+v8;
        modulo = sumatoria % 11;
        sustraendo = modulo * 11;
        digito = 11-(sumatoria - sustraendo);

        if(digito == v9){
            val = true;
        }else
            val = false;
        return val;

    }


    //metodo para validar si editext esta vacio
    public static boolean Vacio(EditText campo){
        String dato = campo.getText().toString().trim();
        if(TextUtils.isEmpty(dato)){
            campo.setError("Campo Requerido");
            campo.requestFocus();
            return true;
        }
        else{
            return false;
        }
    }

}
