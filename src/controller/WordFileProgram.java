/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import repository.WordFileRepository;
import view.Menu;

/**
 *
 * @author Administrator
 */
public class WordFileProgram extends Menu<String>{
    
    static String[] mc = {"Count Word In File", "Find File By Word", "Exit"};
    WordFileRepository program;
    
    public WordFileProgram() {
        super("\t Word Program", mc);
        program = new WordFileRepository();
    }

    @Override
    public void execute(int n) {
        switch(n) {
            case 1 :
                program.getInput(n);
                break;
            case 2:
                program.getInput(n);
                break;
            case 3:
                System.exit(0);
        }
    }
}
