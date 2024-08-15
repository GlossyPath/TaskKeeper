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

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


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

    }
}
