/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author sebas
 */
public class JugadorList implements IManager<Jugador> {
    
    private HashSet<Jugador> list;

    public JugadorList() {
        list = new HashSet<>();
    }
    
    

    @Override
    public boolean add(Jugador element) {
        return list.add(element);
    }

    @Override
    public Jugador get(Jugador element) {
        return element;
    }

    @Override
    public boolean set(Jugador element) {
        for (Jugador current:list) {
            if (current.getName().equals(element.getName())) {
                list.remove(current);
                list.add(current);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Jugador element) {
        for (Jugador current:list) {
            if (current.getName().equals(element.getName())) {
                list.remove(current);
                return true;
            }
        }
        return false;
    }

    @Override
    public List getAll() {
        return new ArrayList<>(list);
    }
    
}
