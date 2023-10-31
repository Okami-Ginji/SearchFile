/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dataacess.WordFileDAO;

/**
 *
 * @author Administrator
 */
public class WordFileRepository implements IWordFileRepository{

    @Override
    public void getInput(int choice) {
        WordFileDAO.Instance().getInput(choice);
    }
    
}
