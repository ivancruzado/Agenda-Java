package Modelo;

import Controlador.ControllerPersonas;
import Vista.AgendaElectronica;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablaClientes extends JFrame {

    private TableModelClientes tableModel;
    private JTable table;
    ControllerPersonas controller;
    TableRowSorter<TableModelClientes> sorter;
    public TablaClientes(){
        setTitle("Table de clientes");
        setBounds(30,20,750,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller = ControllerPersonas.getInstances();

        tableModel = new TableModelClientes(controller.getAll());

        table = new JTable(tableModel);
        setLocationRelativeTo(null);
        table.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700,600));
        JPanel panel = new JPanel();
        JTextField dni = new JTextField();
        dni.setPreferredSize(new Dimension(200, dni.getPreferredSize().height));
        JLabel etiqueta = new JLabel("Dni:");
        JButton botonBuscar = new JButton("Buscar");
        JButton volverAtras = new JButton("Volver atras");
        JButton eliminar = new JButton("Eliminar");

        JButton modificar = new JButton("Editar");


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(volverAtras);
        buttonPanel.add(etiqueta);
        buttonPanel.add(dni);
        buttonPanel.add(botonBuscar);
        buttonPanel.add(eliminar);
        buttonPanel.add(modificar);
        buttonPanel.add(volverAtras);

        panel.add(buttonPanel);

        panel.add(scrollPane);
        add(panel,BorderLayout.CENTER);

        volverAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TablaClientes.this.dispose();
                AgendaElectronica agenda = new AgendaElectronica();
                agenda.setVisible(true);
            }
        });

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorter.setRowFilter(RowFilter.regexFilter(dni.getText(),0));
            }
        });

    }
}
