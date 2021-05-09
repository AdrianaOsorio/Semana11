package controlador;

import modelo.Usuario;
import vista.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener{

    private Usuario modelo;
    private Vista vista;
    private int iniSeReg;
    
    public Controlador(Usuario modelo, Vista vista){
        
        this.modelo = modelo;
        this.vista = vista;
        
    }        
    
    public void iniciarVista(){

        JOptionPane.showMessageDialog(null, "Seleccione si va a Iniciar Sesión o Registrarse.");        
        
        vista.vistaPrincipal();
        vista.jbIniciarSesion.addActionListener(this);
        vista.jbRegistar.addActionListener(this);
        vista.jbAceptar.addActionListener(this);
        vista.jbImprimirUsuarios.addActionListener(this);
        vista.setVisible(true);
            
        vista.jbAceptar.setEnabled(false);
        vista.jTextFUsuario.setEnabled(false);
        vista.jTextFContraseña.setEnabled(false);
        vista.jTextFVerficarContraseña.setEnabled(false);
               
    }
    
    @Override
    public void actionPerformed(ActionEvent e){            
        
        if(vista.jbIniciarSesion == e.getSource()){
        
            vista.jbAceptar.setEnabled(true);
            
            vista.jTextFUsuario.setEnabled(true);
            vista.jTextFContraseña.setEnabled(true);
            vista.jTextFVerficarContraseña.setEnabled(false);
            
            iniSeReg = 1;
                        
        }
        
        if(vista.jbRegistar == e.getSource()){
        
            vista.jbAceptar.setEnabled(true);
            
            vista.jTextFUsuario.setEnabled(true);
            vista.jTextFContraseña.setEnabled(true);
            vista.jTextFVerficarContraseña.setEnabled(true);
            
            iniSeReg = 2;
                    
        }
        
        if(vista.jbAceptar == e.getSource()){
        
            if(iniSeReg == 1){
            
                try {
                    
                    modelo.verificarUsuario(vista.jTextFUsuario.getText(), vista.jTextFContraseña.getText());
                    
                } 
                catch (IOException ex){
                    
                    System.out.println(e);
                    
                }
                
            }
            
            if(iniSeReg == 2){
                            
                modelo.setUsuario(vista.jTextFUsuario.getText());
                modelo.setContraseña(vista.jTextFContraseña.getText());
                modelo.setVerificarContraseña(vista.jTextFVerficarContraseña.getText());
                
                if(modelo.vacios()){
                
                    if(modelo.compararContraseñas()){
                    
                        try {
                            
                            modelo.crearUsuario();
                            JOptionPane.showMessageDialog(null, "Usuario registrado con exito.");
                            
                        } 
                        catch (IOException ex) {
                            
                            System.out.println(e);
                            
                        }
                    
                    }
                    else{
                    
                        modelo.compararContraseñas();                        
                        
                    }
                
                }
                 
            }     
            
        }
        
        if(vista.jbImprimirUsuarios == e.getSource()){
        
            try{
                
                modelo.imprimriUsuario();
                
            } 
            catch (IOException ex){
                
                System.out.println(e);
                
            }
        
        }
        
    }    
    
    public static void main(String[] args) throws IOException{
        
        Vista vista = new Vista();
        Usuario modelo = new Usuario();
        
        modelo.crearUsuario();
         
        Controlador ejecutar = new Controlador(modelo, vista);
        ejecutar.iniciarVista();

    }    
    
}
