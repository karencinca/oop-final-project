/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.DAO;
import java.util.HashMap;

/**
 *
 * @author Vitor
 */
public interface DAO<E,T> {
    public void create(T t);
    public boolean read(T t);
    public boolean delete(T t);
    public HashMap<E,T> readAll();
    public T readById(int id);
}
