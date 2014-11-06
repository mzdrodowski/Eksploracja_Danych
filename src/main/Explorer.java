/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michal
 */
public class Explorer {
    private static Explorer instance = null;
    
    private Explorer(){
        
    }
    
    
    
    public static Explorer getExplorer(){
        if(instance==null){
            instance = new Explorer();
        }
        return instance;
    }
    
   
    
    
    /**
     * Tworzy obiekt danych z pliku
     * @param f
     * @return 
     */
    public DataObject openDataFile(File f){
        DataObject dObj = null;
        List<List<Double>> array = new ArrayList<>();
        
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(f));
            
            String line;
            double d;
            String separator = " ";
            // próbowanie różnych separoatorów
            line = in.readLine();
            String[] tokens = line.split(separator);
            if(tokens.length<2){
                separator = "\t";
                tokens = line.split(separator);
            }
            if(tokens.length<2){
                separator = ",";
            }
             
            in.close();
            in = new BufferedReader(new FileReader(f));
            int rows=0, cols=0;
            while(in.ready()){
                
                line = in.readLine();
                tokens = line.split(separator);
                List<Double> row = new ArrayList<>();
                cols= 0;
                for(String s : tokens){
                    d = Double.parseDouble(s);
                    row.add(d);
                    cols++;
                } // while
                array.add(row);
                rows++;
            }
            
            in.close();
            
            double[][] data = new double[rows][cols];
            int i=0, j;
            for(List<Double> list : array){
                j=0;
                for(double cell : list){
                    data[i][j] = cell;
                    j++;
                }
                i++;
            }
            dObj = new DataObject(data, rows, cols, f.getName(), f.getAbsolutePath());

            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Explorer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(Explorer.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return dObj;    
    }
    
    /**
     * Podzaiał na obszary przynależności
     */
    public void divideToAffilationRegions(DataObject dataObject){
        int attrNum = dataObject.getAttributesNum();
        int rowNum = dataObject.getRows();

        
        class element {
            int orderNum;
            int label;
            
        }
        
        List<element> sortResults = new ArrayList<>();

        int i = 0;
        for(i=0;i<attrNum;i++){
            
        }
        
    } //divideToAffiliationRegions
    
    
}
