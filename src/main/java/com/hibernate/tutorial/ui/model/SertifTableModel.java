/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.ui.model;

import com.hibernate.tutorial.entity.Sertif;
import com.hibernate.tutorial.entity.SkV015;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author ��������
 */
public class SertifTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Sertif> listSertif;
    
    
     public SertifTableModel(List<Sertif> listSertif) {
        super();
        this.listSertif = listSertif;
    }

    @Override
    public int getRowCount() {
        return listSertif.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    
    

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "� �����������";
            case 1:
                return "��������������� �����";
            case 2:
                return "���� ���������";
            case 3:
                return "�������������";
            
            case 4:
                return "��������������";
            case 5:
                return "���� ����������";
            case 6:
                return "ID";

        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Date.class;
            case 3:
                return Integer.class;
          
            case 4:
                return Integer.class;
            case 5:
                return Date.class;
            case 6:
                return Integer.class;
        }
        return Object.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
       Sertif sertif = listSertif.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sertif.getNSert();
            case 1:
                return sertif.getRegNum();
            case 2:
                return sertif.getDateEnd();
            case 3:
                return sertif.getPrvs().getName();
           
            case 4:
                return sertif.getIddokt().getIddokt();
            case 5:
                return sertif.getDateadd();
            case 6:
                return sertif.getId();
        }
        return Object.class;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeTableModelListener(TableModelListener listener) {
       listeners.remove(listener);
    }

}