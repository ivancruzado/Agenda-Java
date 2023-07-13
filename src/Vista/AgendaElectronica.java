package Vista;

import Controlador.ControllerPersonas;
import DTO.DTOClientes;
import Modelo.TablaClientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaElectronica extends JFrame{

    JPanel panel1;
    ControllerPersonas controller;
    public AgendaElectronica(){
        setSize(650,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Agenda Electronica");
        setLocationRelativeTo(null);
        componentes();
        controller = ControllerPersonas.getInstances();
        this.setVisible(true);
    }

    private void componentes(){
        paneles();
        botones();
    }

    private void paneles(){
        panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);;
        panel1.setLayout(null);
        add(panel1);
    }

    private void botones(){
        JLabel titulo = new JLabel("Agenda Electronica");
        //titulo.setOpaque(true);
        Font fuente = new Font("times new roman", Font.BOLD,25);
        titulo.setFont(fuente);
        titulo.setForeground(Color.blue);
        titulo.setBounds(220,35,230,30);
        panel1.add(titulo);

        JLabel dni = new JLabel("DNI :");
        dni.setForeground(Color.blue);
        dni.setBounds(85,120,79,30);
        panel1.add(dni);

        JTextField dniLbl = new JTextField();
        dniLbl.setBounds(170,120,140,25);
        panel1.add(dniLbl);

        JLabel nombre = new JLabel("Nombre :");
        nombre.setForeground(Color.blue);
        nombre.setBounds(85,200,79,30);
        panel1.add(nombre);

        JTextField nombreTF = new JTextField();
        nombreTF.setBounds(170,200,140,25);
        panel1.add(nombreTF);

        JLabel apellido = new JLabel("Apellido :");
        apellido.setForeground(Color.blue);
        apellido.setBounds(85,280,79,30);
        panel1.add(apellido);

        JTextField apellidoTF = new JTextField();
        apellidoTF.setBounds(170,280,140,25);
        panel1.add(apellidoTF);

        JLabel direccion = new JLabel("Direccion :");
        direccion.setForeground(Color.blue);
        direccion.setBounds(350,120,79,30);
        panel1.add(direccion);

        JTextField direccionTX = new JTextField();
        direccionTX.setBounds(430,120,140,25);
        panel1.add(direccionTX);

        JLabel telefono = new JLabel("Telefono :");
        telefono.setForeground(Color.blue);
        telefono.setBounds(350,200,79,30);
        panel1.add(telefono);

        JTextField telefonoTF = new JTextField();
        telefonoTF.setBounds(430,200,140,25);
        panel1.add(telefonoTF);

        JLabel nacimiento = new JLabel("Año nac. :");
        nacimiento.setForeground(Color.blue);
        nacimiento.setBounds(350,280,79,30);
        panel1.add(nacimiento);

        JTextField nacTF = new JTextField();
        nacTF.setBounds(430,280,140,25);
        panel1.add(nacTF);

        JButton guardar = new JButton("Guardar");
        guardar.setBounds(220,350,120,30);
        panel1.add(guardar);

        JButton verLista = new JButton("Ver Clientes");
        verLista.setBounds(380,350,140,30);
        panel1.add(verLista);

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dniInt = Integer.parseInt(dniLbl.getText());
                int telefonoInt = Integer.parseInt(telefonoTF.getText());
                int nacInt = Integer.parseInt(nacTF.getText());
                controller.agregarCliente(new DTOClientes(dniInt,nombreTF.getText(),apellidoTF.getText(),direccionTX.getText(),telefonoInt,nacInt));
                dniLbl.setText(null);
                nombreTF.setText(null);
                apellidoTF.setText(null);
                direccionTX.setText(null);
                telefonoTF.setText(null);
                nacTF.setText(null);
            }
        });

        verLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TablaClientes table = new TablaClientes();
                AgendaElectronica.this.dispose();
                table.setVisible(true);
            }
        });
    }

}
