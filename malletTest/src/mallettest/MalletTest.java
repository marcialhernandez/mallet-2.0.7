/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mallettest;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcial
 */
public class MalletTest {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
        String directorioClasificador="src/clasificador";
        String directorioDatosAClasificar="src/data";
        
        File dirClasificadores = new File(directorioClasificador);
        File dirDatos = new File(directorioDatosAClasificar);
        File[] listadoDeClasificadores = dirClasificadores.listFiles();
        File[] listadoDeDatosDeEntrada = dirDatos.listFiles();
        malletTrain clasificador=new malletTrain();
        //banderaCrear indica si hay que crear o no un nuevo indice invertido
        //En caso que si, es true, en caso que no, es false
        if (listadoDeClasificadores != null) {
            
            for (File clasificadorActual : listadoDeClasificadores) {
                
                if (!clasificadorActual.getName().equals(".DS_Store")){
                    System.out.println(clasificadorActual.getName());
                    try {
                        clasificador.loadClassifier(clasificadorActual);
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(MalletTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }//fin if (!child.getName().equals(".DS_Store"))
                
                for (File datoEntradaActual : listadoDeDatosDeEntrada) {
                    if (!datoEntradaActual.getName().equals(".DS_Store")){
                    System.out.println(datoEntradaActual.getName());
                        try {
                            //clasificador.printLabelings(datoEntradaActual);
                            clasificador.creaArchivoTemporal("singleInstance");
                            System.out.println("Clasificando primera entrada... formato entrada Mallet");
                            clasificador.printDatoSingle("1", "A romantic zen baseball comedy gets 4 BIG stars from me!");
                            System.out.println("Clasificando segunda entrada... formato de entrada indice Invertido");
                            clasificador.printDatoSingle("4", "Another Abysmal Digital Copy has random pixelations combined with muddy light and vague image resolution");
                            Map<String, String> clasificacionSingle=clasificador.obtieneClasificacionSingle("4", "Another Abysmal Digital Copy has random pixelations combined with muddy light and vague image resolution");  
                            System.out.println("Clasificando tercera entrada... imprimiendo desde map");
                            
                            for (Map.Entry<String,String> entry : clasificacionSingle.entrySet()) {                              
                              String key = entry.getKey();
                              String value = entry.getValue();
                              System.out.println(key+":"+value);

                            }

                        } catch (IOException ex) {
                            Logger.getLogger(MalletTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
                
            } //fin for (File child : directoryListing)
            
}
        
        
        
    }
    
}
