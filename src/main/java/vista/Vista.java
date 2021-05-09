package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista extends JFrame{
    
    private JPanel jPanelPrincipal, jPanelTitulo, jPanelGestión, jPanelDecidir;
    
    public JButton jbIniciarSesion, jbRegistar, jbAceptar, jbImprimirUsuarios;
        
    public JTextField jTextFUsuario, jTextFContraseña, jTextFVerficarContraseña;
    
    private JLabel jLabelTitulo, jLabelUsuario, jLabelContraseña, jLabelVerificarContraseña;
            
    private Color rojoPastel = new Color(255, 66, 66);
    private Color verdePastel = new Color(119, 221, 119);

    public void vistaPrincipal(){
        
        setBounds(0, 0, 800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Usuarios Colombia");
        this.setLocationRelativeTo(null);
        
        jPanelPrincipal = new JPanel();
        jPanelPrincipal.setLayout(null);
        jPanelPrincipal.setBackground(rojoPastel);
        
        jPanelTitulo = new JPanel();
        jPanelTitulo.setBackground(verdePastel);
        jPanelTitulo.setBounds(5, 5, 775, 55);
                
        jPanelDecidir = new JPanel();
        jPanelDecidir.setLayout(null);
        jPanelDecidir.setBackground(verdePastel);
        jPanelDecidir.setBounds(5, 65, 150, 290);                
        
        jPanelGestión = new JPanel();
        jPanelGestión.setLayout(null);        
        jPanelGestión.setBackground(verdePastel);
        jPanelGestión.setBounds(160, 65, 620, 290);
         
        jTextFUsuario = new JTextField();
        jTextFUsuario.setBounds(190, 60, 140, 25);
        
        jTextFContraseña = new JTextField();
        jTextFContraseña.setBounds(190, 110, 140, 25);
        
        jTextFVerficarContraseña = new JTextField(10);
        jTextFVerficarContraseña.setBounds(190, 160, 140, 25);        
        
        jLabelTitulo = new JLabel("Inicio de sesión y/o registro Colombia");
        jLabelTitulo.setForeground(Color.black);
        jLabelTitulo.setFont(new Font("arial", Font.BOLD, 35));                   
        
        jLabelUsuario = new JLabel("Usuario:");
        jLabelUsuario.setForeground(Color.black);
        jLabelUsuario.setFont(new Font("arial", Font.PLAIN, 15));
        jLabelUsuario.setBounds(125, 60, 140, 25);

        jLabelContraseña = new JLabel("Contraseña:");
        jLabelContraseña.setForeground(Color.black);
        jLabelContraseña.setFont(new Font("arial", Font.PLAIN, 15));
        jLabelContraseña.setBounds(100, 110, 140, 25);        

        jLabelVerificarContraseña = new JLabel("Verificar Contraseña:");
        jLabelVerificarContraseña.setForeground(Color.black);
        jLabelVerificarContraseña.setFont(new Font("arial", Font.PLAIN, 15));
        jLabelVerificarContraseña.setBounds(40, 160, 140, 25);        
        
        jbIniciarSesion = new JButton("Iniciar Sesión");                 
        jbIniciarSesion.setForeground(Color.black);
        jbIniciarSesion.setFont(new Font("arial", Font.PLAIN, 15));
        jbIniciarSesion.setBounds(5, 100, 140, 25);
        
        jbRegistar = new JButton("Registrarse");                 
        jbRegistar.setForeground(Color.black);
        jbRegistar.setFont(new Font("arial", Font.PLAIN, 15));
        jbRegistar.setBounds(5, 140, 140, 25);
        
        jbAceptar = new JButton("Aceptar");                 
        jbAceptar.setForeground(Color.black);
        jbAceptar.setFont(new Font("arial", Font.PLAIN, 15));
        jbAceptar.setBounds(400, 85, 140, 25);        
        
        jbImprimirUsuarios = new JButton("Imprimir");                 
        jbImprimirUsuarios.setForeground(Color.black);
        jbImprimirUsuarios.setFont(new Font("arial", Font.PLAIN, 15));
        jbImprimirUsuarios.setBounds(400, 125, 140, 25);                    
        
        add(jPanelPrincipal);
        
        jPanelPrincipal.add(jPanelTitulo);        
        jPanelPrincipal.add(jPanelDecidir);                        
        jPanelPrincipal.add(jPanelGestión);        

        jPanelTitulo.add(jLabelTitulo);
        
        jPanelDecidir.add(jbIniciarSesion);
        jPanelDecidir.add(jbRegistar);                              
        
        jPanelGestión.add(jLabelUsuario);
        jPanelGestión.add(jTextFUsuario);
        jPanelGestión.add(jLabelContraseña);                
        jPanelGestión.add(jTextFContraseña);
        jPanelGestión.add(jLabelVerificarContraseña);                
        jPanelGestión.add(jTextFVerficarContraseña);
        jPanelGestión.add(jbAceptar);
        jPanelGestión.add(jbImprimirUsuarios);
        
    }
    
}