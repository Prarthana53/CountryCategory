/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.Countrycategory.obj.impl;

import com.prarthana.Countrycategory.cat.CountryCategory;
import com.prarthana.Countrycategory.obj.CountryDAO;



/**
 *
 * @author Pavilion G4
 */
public class CountryDAOImpl implements CountryDAO {
    private int counter=0;
    private CountryCategory[] catList=new CountryCategory[5];

    @Override
    public boolean insert(CountryCategory s) {
           if(counter==catList.length){
            return false;
        }
      catList[counter]=s;
      counter++;
        return true;
        
    }

    @Override
    public boolean delete(int code) {
         for(int i=0;i<catList.length;i++){
        CountryCategory s=catList[i]; 
        if(s!=null && s.getCode()==code){
            catList[i]=null;
            return true;
        }
        
        }
        return false;
    }

    @Override
    public CountryCategory getByCode(int code) {
          for(int i=0;i<catList.length;i++){
        CountryCategory s=catList[i]; 
        if(s!=null && s.getCode()==code){
            
            return s;
        }
        
        }
        return null;
        
    }

    @Override
    public CountryCategory getByName(String name) {
            for(int i=0;i<catList.length;i++){
        CountryCategory s=catList[i]; 
        if(s!=null && s.getName().equalsIgnoreCase(name)){
            
            return s;
        }
        
        }
        return null;
    }

    @Override
    public CountryCategory[] getAll() {
        return catList;
    }
  
}
