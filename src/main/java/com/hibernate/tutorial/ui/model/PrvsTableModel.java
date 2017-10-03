/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.ui.model;

import com.hibernate.tutorial.entity.SkV015;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Талалаев
 */
public class PrvsTableModel extends AbstractTableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<SkV015> listPRVS;

    public PrvsTableModel(List<SkV015> list) {
        super();
        this.listPRVS = list;
    }

    public PrvsTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return listPRVS.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "номер";
            case 1:
                return "код специальности";
            case 2:
                return "название";
            case 3:
                return "Зависит от специальности";
            case 4:
                return "ОКСО";
            case 5:
                return "Дата начала";
            case 6:
                return "Дата окончания";

        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Short.class;
            case 1:
                return Short.class;
            case 2:
                return String.class;
            case 3:
                return Short.class;

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
        return true;
    }

    public SkV015 getRowByIndex(int rowIndex) {
        return listPRVS.get(rowIndex);

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SkV015 prvs = listPRVS.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return prvs.getRecid();
            case 1:
                return prvs.getCode();
            case 2:
                return prvs.getName();
            case 3:
                return prvs.getHigh()!=null ? prvs.getHigh():"";

            case 4:
                return prvs.getOkso()!=null ? prvs.getOkso(): "";
            case 5:
                return prvs.getDatebeg();
            case 6:
                return prvs.getDateend();
        }
        return Object.class;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
