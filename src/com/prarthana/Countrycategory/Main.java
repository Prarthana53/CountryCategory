/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.Countrycategory;

import com.prarthana.Countrycategory.cat.CountryCategory;
import com.prarthana.Countrycategory.obj.CountryDAO;
import com.prarthana.Countrycategory.obj.impl.CountryDAOImpl;
import java.util.Scanner;

/**
 *
 * @author Pavilion G4
 */
public class Main {

   
    public static void main(String[] args) {
        
           CountryDAO catDAO = new CountryDAOImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("COUNTRY CATEGORY MENU");
            System.out.println("........................................");
            System.out.println("1. Add Country");
            System.out.println("2. Delete Country By Country Code");
            System.out.println("3. Show all Country");
            System.out.println("4. Search Country By Code");
            System.out.println("5. Search Country By Name");
            System.out.println("6. Exit");
            System.out.println("Enter your choice[1-6]:");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Add Country");
                    CountryCategory s = new CountryCategory();
                    System.out.println("Enter Country Name: ");
                    s.setName(sc.next());
                    System.out.println("Enter Country Code: ");
                    s.setCode(sc.nextInt());
                    
                    System.out.println("Enter Country Capital: ");
                    s.setCapital(sc.next());
                    System.out.println("Enter Continent Name: ");
                    s.setContinent(sc.next());
                    System.out.println("Enter Description: ");
                    s.setDescription(sc.next());
                    System.out.println("Enter  Total area: ");
                    s.setArea(sc.nextInt());
                    System.out.println("Enter  Total Population: ");
                    s.setPopulation(sc.nextLong());
                    System.out.println("Enter Status: ");
                    s.setStatus(sc.nextBoolean());

                    if (catDAO.insert(s)) {
                        System.out.println("Inserted Successfully!!");
                    } else {
                        System.out.println("Can't add more Countries. Data Full!!");
                    }

                    break;
                case 2:
                    System.out.println("Enter Country Code to delete: ");
                    int idd = sc.nextInt();
                    if (catDAO.delete(idd)) {
                        System.out.println("The Country with Code no. " + idd + " has been deleted successfully.");
                    } else {
                        System.out.println("Country Code not found.");
                    }

                    break;
                case 3:
                    System.out.println("Country Category");
                    System.out.println(".................................");
                    CountryCategory[] cats = catDAO.getAll();
                    for (int i = 0; i < cats.length; i++) {
                        CountryCategory cc = cats[i];
                        if (cc != null) {
                            System.out.println("Country Code = " + cc.getCode());
                           
                            System.out.println("Country Name = " + cc.getName());
                             System.out.println("Capital = " + cc.getCapital());
                              System.out.println("Contitent = " + cc.getContinent());
                               System.out.println("Total Area = " + cc.getArea());
                            System.out.println("Total Population = " + cc.getPopulation());
                            System.out.println("Description = " + cc.getDescription());
                            System.out.println("Status = " + cc.isStatus());
                            System.out.println("=======================================");

                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter Country Code to search: ");
                    int id = sc.nextInt();
                  CountryCategory ccode = catDAO.getByCode(id);

                    System.out.println("Country Code = " + ccode.getCode());
                           
                            System.out.println("Country Name = " + ccode.getName());
                             System.out.println("Capital = " + ccode.getCapital());
                              System.out.println("Contitent = " + ccode.getContinent());
                               System.out.println("Total Area = " + ccode.getArea());
                            System.out.println("Total Population = " + ccode.getPopulation());
                            System.out.println("Description = " + ccode.getDescription());
                            System.out.println("Status = " + ccode.isStatus());

                    break;
                     case 5:
                    System.out.println("Enter Country Name to search: ");
                   String string= sc.next();
                    CountryCategory code = catDAO.getByName(string);

                   System.out.println("Country Name = " + code.getName());
                   System.out.println("Country Code = " + code.getCode());
                             System.out.println("Capital = " + code.getCapital());
                              System.out.println("Contitent = " + code.getContinent());
                               System.out.println("Total Area = " + code.getArea());
                            System.out.println("Total Population = " + code.getPopulation());
                            System.out.println("Description = " + code.getDescription());
                            System.out.println("Status = " + code.isStatus());

                    break;
             
                case 6:
                    System.out.println("Do you really want to exit [Y/N]");
                    if (sc.next().equalsIgnoreCase("y")) {
                        System.out.println("Thankyou, Visit Again.");
                        System.exit(0);
                    }
                    System.exit(0);
                    break;

            }

        }
    }

}
