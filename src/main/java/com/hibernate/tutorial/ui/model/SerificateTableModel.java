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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Талалаев
 */
public class SerificateTableModel extends AbstractTableModel {

    private Set<TableModelListener> listeners = new HashSet<>();

    private List<Sertif> listSertificates;

    public SerificateTableModel(List<Sertif> listSertif) {
        super();
        this.listSertificates = listSertif;
    }

    @Override
    public int getRowCount() {
        return getListSertificates().size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    public Sertif getRowByIndex(int rowIndex) {
        return getListSertificates().get(rowIndex);

    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "№ сертификата";
            case 1:
                return "Регистрационный номер";
            case 2:
                return "Дата окончания";
            case 3:
                return "Специальность";
            case 4:
                return "Специальность(код)";

            case 5:
                return "Принадлежность";
            case 6:
                return "Дата добавления";
            case 7:
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
                return String.class;
            case 4:
                return Integer.class;

            case 5:
                return Integer.class;
            case 6:
                return Date.class;
            case 7:
                return Integer.class;
        }
        return Object.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Sertif sertif = getListSertificates().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sertif.getNSert();
            case 1:
                return sertif.getRegNum();
            case 2:
                return sertif.getDateEnd();
            case 3:
                return sertif.getPrvs() != null ? sertif.getPrvs().getName() : "";
            case 4:
                return sertif.getPrvs() != null ? sertif.getPrvs().getCode() : "";

            case 5:
                return sertif.getIddokt().getIddokt();
            case 6:
                return sertif.getDateadd();
            case 7:
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

    /**
     * @return the listSertificates
     */
    public List<Sertif> getListSertificates() {
        return listSertificates;
    }

    /**
     * @param listSertificates the listSertificates to set
     */
    public void setListSertificates(List<Sertif> listSertificates) {
        this.listSertificates = listSertificates;
    }

}
