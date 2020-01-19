/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author alex
 */
@NamedQuery(name = "findall.employee", query = "select e from Employee e")
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JoinColumn // to create a foreign key in Adress, otherwise we have a join table
    Collection<Adress> adressList;

    public Collection<Adress> getAdressList() {
        return adressList;
    }

    public void setAdressList(Collection<Adress> adressList) {
        this.adressList = adressList;
    }
    //@Id
    //@TableGenerator(allocationSize=1)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@SequenceGenerator(name="Emp_Gen", sequenceName="Emp_Seq",allocationSize=1,initialValue=65)
    //@GeneratedValue(generator="Emp_Gen",strategy = GenerationType.SEQUENCE)
    @TableGenerator(name = "Emp_Gen", allocationSize = 1)
    @Id
    @GeneratedValue(generator = "Emp_Gen")
    private Long id;
    private String name;

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creationdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Employee[ id=" + id + " ]";
    }

}
