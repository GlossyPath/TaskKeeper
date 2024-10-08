/**
 * 
 * TaskKeeper es una aplicación simple y eficiente desarrollada en Java para gestionar
 * y guardar tus tareas diarias. Con una interfaz fácil de usar, TaskKeeper permite
 * a los usuarios agregar, editar, y eliminar tareas, asegurándose de que nunca se pierdan
 * las tareas importantes. Es una herramienta ideal para aquellos que buscan una solución 
 * ligera y sin complicaciones para llevar un registro de sus tareas.
 * 
 *@version 1.0;
 *
 * @since 15/08/2024;
 * 
 * @author GlossyPath;
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TaskKeeper {

    public static void main(String[] args) {
        
        MyFrame frame = new MyFrame();

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}

class MyFrame extends JFrame {

    public MyFrame(){

        setTitle("Task_Keeper");

        Toolkit getToolkit = Toolkit.getDefaultToolkit();    
        Dimension size = getToolkit.getScreenSize();

        int height = size.height;
        int width = size.width;

        setSize(width/2, height/2);
        setLocation(width/4, height/4);

        MiPlantilla plantilla = new MiPlantilla();

        add(plantilla);
    }
}

class MiPlantilla extends JPanel {

    private JTextField textField;
    private JButton button;
    private String textoCapturado;

    public MiPlantilla() {

        setBackground(Color.WHITE);

        setLayout(null);  // Usar un layout nulo para posicionar los componentes manualmente

        this.textField = new JTextField(20);
        
        this.button = new JButton("Enviar"); 

        add(textField);
        add(button);


        button.addActionListener(new ActionListener() {  // CLASE INTERNA ANÓNIMA
            @Override
            public void actionPerformed(ActionEvent e) {
                textoCapturado = textField.getText();
                System.out.println("Texto capturado: " + textoCapturado);
                // Aquí puedes hacer más cosas con el texto capturado
            }
        });
    }
    
    public String getTextoCapturado() {
        return textoCapturado;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        String mensaje = "¡Bienvenido a TaskKeeper!", tareaParaGuardar = "Tarea para guardar:";


        Graphics2D g2 = (Graphics2D) g;

        Font tipoLetra = new Font("Yu Gothic UI", Font.BOLD, 20);
        g2.setFont(tipoLetra);
        g2.setColor(Color.BLACK);

        final int ANCHO = getWidth();
        final int ALTO = getHeight();

        int anchoTexto = g2.getFontMetrics().stringWidth(mensaje);
        int altoTexto = g2.getFontMetrics().getHeight();

        int x = (ANCHO - anchoTexto) / 2;
        int y = (ALTO - altoTexto) / 2 + altoTexto;

        g2.drawString(mensaje, x, 50);
        g2.drawString(tareaParaGuardar, x/2, 100);

        textField.setBounds((x/2) + 180, 80, 200, 30); 
        button.setBounds((x/2)+360, 80, 80, 30); 

        
    }
}