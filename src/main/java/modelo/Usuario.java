package modelo;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import vista.Validaciones;

public class Usuario implements Validaciones{
    
    private String usuario, contraseña, verificarContraseña;   
    int usuariosRegistrados = 1;
    ArrayList usuarioContra = new ArrayList(); 
    
    public Usuario(){
        
        usuario = "UsuarioPorDefecto";
        contraseña = "ContraseñaPorDefecto";
        verificarContraseña = "";
        
    }   

    public int getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public void setUsuariosRegistrados(int usuariosRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    public String getVerificarContraseña() {
        return verificarContraseña;
    }

    public void setVerificarContraseña(String verificarContraseña) {
        this.verificarContraseña = verificarContraseña;
    }

    public void crearUsuario() throws IOException{
    
        File archivo = new File("usuarios_creados.txt");
        
        archivo.createNewFile();
        
        //String ruta = this.getClass().getResource("/usuarios_creados.txt").getFile();
        String ruta = "C:/Users/adria/OneDrive/Documentos/NetBeansProjects/Semana11/usuarios_creados.txt";
        FileWriter escribirArchivo = new FileWriter(ruta);

        PrintWriter escribir = new PrintWriter(escribirArchivo);
        escribir.println("usuario: "+getUsuario());
        escribir.println("contraseña: "+getContraseña());

        usuarioContra.add(getUsuario());
        usuarioContra.add(getContraseña());
        escribir.close();
        
    }
    
    public void imprimriUsuario() throws IOException{

        FileReader leerArchivo = null;
        Properties p = new Properties();
        
        String ruta = "C:/Users/adria/OneDrive/Documentos/NetBeansProjects/Semana11/usuarios_creados.txt";
        //String ruta = this.getClass().getResource("/usuarios_creados.txt").getFile();
        leerArchivo = new FileReader(ruta);
        p.load(leerArchivo);
        
        if(p.getProperty("usuario").equals("UsuarioPorDefecto") || p.getProperty("contraseña").equals("ContraseñaPorDefecto")){
        
            JOptionPane.showMessageDialog(null, "No ha registrado ningun usuario.");
            
        }
        else{
        
            JOptionPane.showMessageDialog(null, "El usuario es: "+p.getProperty("usuario")+" La contraseña es: "+p.getProperty("contraseña"));
        
        }

    }
    
    public void verificarUsuario(String usuario, String contraseña) throws IOException{

        FileReader leerArchivo = null;
        Properties p = new Properties();
        
        String ruta = "C:/Users/adria/OneDrive/Documentos/NetBeansProjects/Semana11/usuarios_creados.txt";
        //String ruta = this.getClass().getResource("/usuarios_creados.txt").getFile();
        leerArchivo = new FileReader(ruta);
        p.load(leerArchivo);        
        
        if(usuarioContra.contains("UsuarioPorDefecto")){
        
            usuarioContra.remove("UsuarioPorDefecto");
            
        }
        if(usuarioContra.contains("ContraseñaPorDefecto")){
        
            usuarioContra.remove("ContraseñaPorDefecto");
            
        }        
        
        
        if(p.getProperty("usuario").equals(usuarioContra.get(0)) && p.getProperty("contraseña").equals(usuarioContra.get(1))){
        
            if(usuario.equals(usuarioContra.get(0)) && contraseña.equals(usuarioContra.get(1))){
            
                JOptionPane.showMessageDialog(null, "Usuario registrado previamente con exito puede acceder a la aplicaión.");
            
            }
            else{
            
                JOptionPane.showMessageDialog(null, "Ningun usuario ha sido registrado, acceso denegado.");
            
            }
            
        }
        else{
        
            JOptionPane.showMessageDialog(null, "Ningun usuario ha sido registrado, acceso denegado.");
        
        }
           
    }
    
    @Override
    public boolean usuarioNoValido(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contraseñaNoValida(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarContraseña(){
        
        boolean verificar;
        
        if(getContraseña().equals(getVerificarContraseña())){
        
           verificar = true;
            
        }
        else{
            
            verificar = false;
            
        }
        
        return verificar;
        
    }

    @Override
    public boolean vacios(){
        
        if(getContraseña().equals("") && getVerificarContraseña().equals("")){
                
            JOptionPane.showMessageDialog(null, "Contraseñas vacias, porfavor digite las contraseñas");
            return false;

        }
        else{

            if(getUsuario().equals("")){

                JOptionPane.showMessageDialog(null, "Digite un usuario");
                return false;

            }
            else{
                
                return true;

            }

        }        

    }

    @Override
    public boolean compararContraseñas() {

        if(getContraseña().equals(getVerificarContraseña())){
        
            return true;
        
        }
        else{
            
            JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
            return false;
            
        }

    }
        
}
