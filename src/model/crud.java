/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Nova Nur Fauziah
 */
public interface crud {
    public void create();
    public void read();
    public void store();
    public void update(String uid, List<Object> data);
    public void delete(String uid);
}
