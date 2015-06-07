/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mallettest;

import java.io.File;
import java.io.IOException;
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
                            clasificador.printLabelings(datoEntradaActual);
                            //Aqui se tiene que aplicar la funcion
                        } catch (IOException ex) {
                            Logger.getLogger(MalletTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
                
            } //fin for (File child : directoryListing)
            
            
            /*parseJSONFile entradaBD;
            JSONArray documentos;
            FileWriter fichero = new FileWriter("entradaMallet.txt");
            BufferedWriter pw = new BufferedWriter(fichero);
            int contador=0;
            
            for (File child : directoryListing) {
                
                //Para cada documento
                entradaBD = new parseJSONFile();
                documentos = new JSONArray(); 
                //Se usa esta forma para ignorar un documento dentro de la carpeta bd
                if (child.getName().equals(".DS_Store")){
                continue;}
                documentos = entradaBD.obtieneDocumentos("/bd/"+child.getName());
                contador=entradaBD.addDocuments(documentos,fichero,pw,contador);
                System.out.println(contador+"");
            }
            fichero.close();
                    
        }
    }*/
}
        
        
        
    }
    
}
