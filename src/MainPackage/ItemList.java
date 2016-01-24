/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.util.ArrayList;

/**
 *
 * @author Joe
 */
public class ItemList {
    
    ArrayList<String> items;
    
    public ItemList(){
        items = new ArrayList<>();

    }
    
    
    public void AddItem(String name){
        items.add(name);
    }
    
    public void RemoveItem(String name){
        for(int i = 0; i < items.size(); i++){
            if(name == items.get(i)){
                items.remove(i);
            }
        }
    }
    
    public int GetItemCount(){
        return items.size();
    }
    
    public String GetItem(int index){
        return items.get(index);
    }
}
