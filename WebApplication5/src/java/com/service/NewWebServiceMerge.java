/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Adress;
import com.entity.Employee;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jws.WebService;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alex
 */
@Stateless
@WebService
public class NewWebServiceMerge {
    
     @PersistenceContext(unitName = "WebApplication5PU")
    private EntityManager em;
    
    
         public String insertEmpAlreadYThere(String name,Long id) throws  NamingException {

        Employee emp = new Employee();
        emp.setName(name);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Adress addr = new Adress();
        addr.setTypeOfAdress("home");
        addr.setStreet("terzopoulou 12");
        ArrayList<Adress> addrlist = new ArrayList<>(); 
        addrlist.add(addr);
        emp.setAdressList(addrlist);
        emp.setCreationdate(date);
        emp.setId(id);
        em.merge(emp);
        //em.getTransaction().begin();

        String result;
//        if (findemp(name).isEmpty() == false) { 
//            result = " created";
//        } else {
//            result = " not created";
//        }
      
        return "Employee " + name ;

    }
     
     
     
}
