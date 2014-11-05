/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author michal
 */
public class DataObject implements TableModel{
    private int rows;
    private int columns;
    private String name;
    private String location;
    private double[][] data;
    
    List tableModelListenerList;
    
    
    DataObject(double[][] data, int row, int col, String name, String location){
        this.data = data;
        this.rows = row;
        this.columns = col;
        this.name = name;
        
        tableModelListenerList = new ArrayList();
        
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }


    public double[][] getData() {
        return data.clone();
    }


    public int getRows() {
        return rows;
    }


    public int getColumns() {
        return columns;
    }
    

    public int getAttributesNum(){
        return (columns-1);
    }
    

    @Override
    public int getRowCount() {
        return rows;
    }

    @Override
    public int getColumnCount() {
        return columns;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if(columnIndex==(columns-1)){
            return "Klasa";
        }else{
            int num = 65 + columnIndex;
            String s = "" + (char)num;
            return s;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Double.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        tableModelListenerList.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        tableModelListenerList.remove(l);
    }
    

    
    
}
