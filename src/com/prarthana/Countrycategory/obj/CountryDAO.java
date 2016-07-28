/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.Countrycategory.obj;

import com.prarthana.Countrycategory.cat.CountryCategory;

/**
 *
 * @author Pavilion G4
 */
public interface CountryDAO {
       boolean insert(CountryCategory s);
  
    boolean delete(int code);
    CountryCategory getByCode(int code);
    CountryCategory getByName(String name);
    
    CountryCategory[] getAll();
    
}
