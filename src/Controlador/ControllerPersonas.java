package Controlador;

import DTO.DTOClientes;
import Modelo.Clientes;

import java.util.ArrayList;
import java.util.List;

public class ControllerPersonas {

    private static ArrayList<Clientes> listaClientes;
    private static ControllerPersonas CONTROLLER = null;

    private ControllerPersonas(){};

    public static synchronized ControllerPersonas getInstances(){
        if(CONTROLLER == null) {
            CONTROLLER = new ControllerPersonas();
            initClientes();
        }
        return CONTROLLER;
    }

    public static void initClientes(){
        listaClientes = new ArrayList<>();
        listaClientes.add(new Clientes(4228673,"juan","garcia","av de mayo 1982",113567546,1967));
        listaClientes.add(new Clientes(4028471,"Martin","Fonseca","Lima 380",116675241,1978));
    }

    public static Clientes toModel(DTOClientes dto) {
        Clientes cliente = new Clientes(dto.getDni(),dto.getNombre(),dto.getApellido(),dto.getDireccion(),dto.getNumeroTelefono(),dto.getAnioNac());
        return cliente;
    }

    public static DTOClientes toDTO(Clientes sucursales){
        DTOClientes dto = new DTOClientes(sucursales.getDni(),sucursales.getNombre(),sucursales.getApellido(),sucursales.getDireccion(),sucursales.getNumeroTelefono(),sucursales.getAnioNac());
        return dto;
    }

    public void agregarCliente(DTOClientes dto){

        Clientes cliente = toModel(dto);
        listaClientes.add(cliente);
    }

    public List<DTOClientes> getAll(){
        List<DTOClientes> listaDto= new ArrayList<>();
        for (Clientes listaCliente : listaClientes) {
            listaDto.add(toDTO(listaCliente));
        }
        return listaDto;

    }

}
