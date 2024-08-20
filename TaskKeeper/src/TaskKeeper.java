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
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.JFrame;


public class TaskKeeper {

    public static void main(String[] args) {
        
        MyFrame frame = new MyFrame();

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
    }    
}


class ListaTareas {

    private List listaTareas;
    private String nomTarea;

    public ListaTareas (String nomTarea){

        this.listaTareas = new ArrayList<>();
        this.nomTarea = setNomTarea(nomTarea);
    }

public void añadirTarea(String nomTarea){
    if(this.listaTareas.stream().anyMatch(tarea -> tarea.equals(nomTarea))){
        System.out.println("La tarea ya existe");

    } else {
        this.listaTareas.add(nomTarea);
    }
}

public void eliminarTarea(int posicion){
    if (posicion < 0 || posicion >= this.listaTareas.size()) {
        System.out.println("Índice fuera de rango");

    } else if (this.listaTareas.isEmpty()) {
        System.out.println("La lista de tareas está vacía");

    } else {
        String tareaEliminada = (String) this.listaTareas.get(posicion);
        this.listaTareas.remove(posicion);
        System.out.println("Tarea " + tareaEliminada + " eliminada correctamente");
    }
}

public void buscarTarea(String nomTarea){

}

public String toString(){
    StringBuilder sb = new StringBuilder();

    sb.append("Lista de Tareas:\n");

    this.listaTareas.forEach(t -> sb.append(t).append("\n"));

    return sb.toString();
}

public List getListaTareas() {
    return listaTareas;
}

public void setListaTareas(List listaTareas) {
    this.listaTareas = listaTareas;
}

public String getNomTarea() {
    return nomTarea;
}

public String setNomTarea(String nomTarea) throws InputMismatchException {
    if(this.nomTarea.isEmpty() || this.nomTarea.isBlank() ||  nomTarea.chars().anyMatch(Character::isDigit)){
        throw new InputMismatchException ("La tarea no puede estar vacia o contener numeros");
    }

    return this.nomTarea = nomTarea;
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
