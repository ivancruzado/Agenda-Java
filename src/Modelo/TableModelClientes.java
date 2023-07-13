package Modelo;

import DTO.DTOClientes;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModelClientes extends AbstractTableModel {

    private String[] columnNames = {"Dni", "Nombre", "Apellido", "Direccion", "Numero Tel.", "Nacimiento"};
    private List<DTOClientes> dtoArrayList;



    public TableModelClientes(List<DTOClientes> list){
        this.dtoArrayList = list;
    }

    public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        int size;
        if (dtoArrayList == null) {
            size = 0;
        }
        else {
            size = dtoArrayList.size();
        }
        return size;
    }

    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 0) {
            temp = dtoArrayList.get(row).getDni();
        }
        else if (col == 1) {
            temp = dtoArrayList.get(row).getNombre();
        }
        else if (col == 2) {
            temp = dtoArrayList.get(row).getApellido();
        }
        else if (col == 3) {
            temp = dtoArrayList.get(row).getDireccion();
        }
        else if (col == 4) {
            temp = dtoArrayList.get(row).getNumeroTelefono();
        }
        else if (col == 5) {
            temp = dtoArrayList.get(row).getAnioNac();
        }
        return temp;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Class getColumnClass(int col) {return Integer.class; }



}
