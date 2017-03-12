package main;


import main.Core.MainCore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csqueiroz
 */
public class Principal {
    
    public static void main (String[] args){
        new Principal().init();
    }
    
    public void init(){
        MainCore mainCore = new MainCore();
        mainCore.mainLoopCore();
    }
    

    
    
    
            
    
}
