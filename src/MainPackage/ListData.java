/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Joe
 */
public class ListData {
    
    String currentDir;
    String filename = "ListData.mlf";
    Path filePath;
    MainForm mform;
    
    public ListData(){
        
        currentDir = System.getProperty("user.dir");
        filePath = Paths.get(currentDir,filename);
        
        
        
    }
    
    public ListData(MainForm form){
        currentDir = System.getProperty("user.dir");
        filePath = Paths.get(currentDir,filename);
        mform = form;
        
    }
    
    public void WriteFile(ArrayList<String> listnames, ArrayList<ItemList> listofitemlists) 
            throws IOException{
        
        PrintWriter output = new PrintWriter(
                             new BufferedWriter(
                             new FileWriter(filename)));
        
        
        for(int i = 0; i < listnames.size(); i++){
            String listname = listnames.get(i);
            String lineToWrite = listname;
            
            for(int j = 0; j < listofitemlists.get(i).GetItemCount(); j++){
                lineToWrite += "," + listofitemlists.get(i).GetItem(j);
            }
            output.println(lineToWrite);
        }
        output.close();
        
        
    }
    
    
    
    public void ReadFile(ArrayList<String> listnames, ArrayList<ItemList> listofitemlists) 
            throws FileNotFoundException, IOException{
        
        if(Files.notExists(filePath)){
            Files.createFile(filePath);
        }
        
        BufferedReader input = new BufferedReader(
                               new FileReader(filePath.toString()));
        
        //String line = input.re
        
        
        
        
        
        
        
        while(input.ready()){
            String line = input.readLine();
            
            String[] columns = line.split(",");
            
            listnames.add(columns[0]);
            
            ItemList newList = new ItemList();
            
            for(int i = 1; i < columns.length; i++){
                newList.AddItem(columns[i]);
                
            }
            listofitemlists.add(newList); 
        }
        input.close();
        
        
    }
    
}
