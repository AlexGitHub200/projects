/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Adress;
import com.entity.Employee;
//import com.entity.Employee_;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import javax.jms.JMSException;
import javax.jws.WebService;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author alex
 */
@Stateless
@WebService
public class WebServTest {

   

    @PersistenceContext(unitName = "WebApplication5PU")
    private EntityManager em;

    public String insertEmp(String name) throws JMSException, NamingException {

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
        em.persist(emp);
        //em.getTransaction().begin();

        String result;
        if (findemp(name).isEmpty() == false) { 
            result = " created";
        } else {
            result = " not created";
        }
      
        return "Employee " + name + result;

    }
    
    
//    void persist(Object object) {
//        em.persist(object);
//    }

    public List<Employee> findemp(String name) {

        //Employee emp = new Employee();
        ////emp.setName(name);
        TypedQuery query = em.createQuery("SELECT e FROM Employee e where e.name like :custName",
                Employee.class).setParameter("custName", "%"+name+"%");

        //emp = em.find(Employee.class, new Long(1));
        //System.out.print("the id is" + emp.getId() + " the name is " + emp.getName());
        return query.getResultList();

    }

    @TransactionAttribute(NOT_SUPPORTED)//performance improvement as the entities become detached
    public List<Employee> findAllEmployees() {
        //TypedQuery query = em.createQuery("SELECT e FROM Employee e",
        //      Employee.class);

        TypedQuery query = em.createNamedQuery("findall.employee", Employee.class);
        return query.getResultList();
    }
    
//    @TransactionAttribute(NOT_SUPPORTED)
//    public List<String> findAllNames(){
//        TypedQuery query = em.createNamedQuery("findall.employeeNames",String.class);
//        
//        return query.getResultList();
//    }

    public List<Employee> findAllCriteria(String name) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> createQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> emp = createQuery.from(Employee.class);
        //createQuery.select(emp).where(criteriaBuilder.equal(emp.get(Employee_.name), name));// use CM instead of just a string!
        createQuery.select(emp);

        TypedQuery<Employee> q = em.createQuery(createQuery);
        return q.getResultList();
    }
}
