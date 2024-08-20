import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class ListaTareas {
    private List <String> listaTareas;
    private String nomTarea;

    private final Scanner SC = new Scanner(System.in);

    public ListaTareas (){
        this.listaTareas = new ArrayList<>();
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

public void buscarTarea(){

    System.out.println("Intoduce el nombre de la tarea que estas buscando");
    String nombreTarea = SC.nextLine();

    if(this.listaTareas.stream().anyMatch(t -> t.equalsIgnoreCase(nombreTarea))){
       System.out.println("La tarea existe");

    } else {
        System.err.println("No hay ninguna tarea con ese nombre");
    }
}

@Override
public String toString(){
    StringBuilder sb = new StringBuilder();

    sb.append("Lista de Tareas:\n");

    this.listaTareas.forEach(t -> sb.append(t).append("\n"));

    return sb.toString();
}

public String setNomTarea(String nomTarea) throws InputMismatchException {
    if(this.nomTarea.isEmpty() || this.nomTarea.isBlank() ||  nomTarea.chars().anyMatch(Character::isDigit)){
        throw new InputMismatchException ("La tarea no puede estar vacia o contener numeros");
    }

    return this.nomTarea = nomTarea;
}

} 
