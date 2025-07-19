/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.HashMap;
import model.Person;
import utils.MetaInfo;

/**
 *
 * @author Vitor
 */
public class PersonDAO implements DAO<Integer, Person> {

    private HashMap<Integer, Person> userData;
    private static PersonDAO instance;
    
    private PersonDAO(){
        userData = new HashMap();
    }
    
    public static PersonDAO getInstance(){
        if(instance == null){
            instance = new PersonDAO();
        }
        return instance;
    }
    
    @Override
    public void create(Person t) {
        t.setId(MetaInfo.userCount++);
        userData.put(t.getId(), t);
    }

    @Override
    public boolean read(Person t) {
        return userData.containsValue(t);
    }

    @Override
    public boolean delete(Person t) {
        userData.remove(t.getId());
        return true;
    }

    @Override
    public HashMap<Integer, Person> readAll() {
        return userData;
    }

    @Override
    public Person readById(int id) {
        return userData.get(id);
    }
    
    public void update(Person t) {
        if(userData.containsKey(t.getId())) {
            userData.put(t.getId(), t);
        }
    }

    public HashMap<Integer, Person> getUserData() {
        return userData;
    }

    public void setUserData(HashMap<Integer, Person> userData) {
        this.userData = userData;
    }
}
