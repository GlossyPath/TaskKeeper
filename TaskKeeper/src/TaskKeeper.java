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

        ListaTareas nuevaListaTareas = new ListaTareas();

        nuevaListaTareas.añadirTarea("Recoger los platos");
        nuevaListaTareas.añadirTarea("Limpiar los armarios");

        System.out.println(nuevaListaTareas);
    
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

    public MiPlantilla() {

        setBackground(Color.WHITE);
        Texto textoYBoton = new Texto();
        textoYBoton.setBounds(50, 100, 300, 50); 
        add(textoYBoton);

    }

    @Override
   public void paintComponent (Graphics g) {
    super.paintComponent(g);//invocamos al metodo de JPanel

    String mensaje = "¡Bienvenido a TaskKeeper!";

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
   }
}

class Texto extends JPanel implements ActionListener {

    private JTextField textField;
    private JButton button;

    public Texto() {
        textField = new JTextField(20);
        button = new JButton("Enviar");

        // Añadir los componentes al panel
        add(textField);
        add(button);

        // Añadir el ActionListener al botón
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String textoCapturado = textField.getText();
        System.out.println("Texto capturado: " + textoCapturado);
        // Aquí puedes hacer más cosas con el texto capturado
    }
}


