package com.example.demo.services;

import com.example.demo.Exception.Emptyrepo;
import com.example.demo.Exception.Invalidname;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.repo;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Exception.Invalidid;

import java.util.List;

@Service
@RequestMapping
public class services {

    @Autowired
    private repo r;
    public List<Employee> viewAll() throws Emptyrepo
    {
        if(r.findAll().isEmpty())
        {
            throw new Emptyrepo();
        }
        return r.findAll();
    }

    public Employee getEmpid(int i) throws Invalidid
    {
        if(r.findById(i).isPresent())
            return r.findById(i).get();
        else
            throw new Invalidid();
    }

    public Employee getEmpName(String n) throws Invalidname
    {
        for(Employee e:r.findAll())
        {
            if( e.getEname().equals(n))
            {
                return e;
            }
        }
        throw new Invalidname();
    }

    public String addEmp(Employee e)
    {
        if(r.findById(e.getEid()).isPresent())
            return "Employee already exists";
        r.save(e);
        return "Employee added successfully";
    }

    public String deleteEmp(int id) throws Invalidid
    {
        if(r.findById(id).isPresent())
        {
            r.delete(r.getById(id));
            return "Deleted successfully";
        }
        throw new Invalidid();
    }
    public String updaten(int id,String name) throws Invalidid
    {
        if(r.findById(id).isPresent())
        {
            Employee e=r.findById(id).get();
            e.setEname(name);
            r.save(e);
            return "Name updated";
        }
        throw new Invalidid();
    }

    public String updateA(int id,int age) throws Invalidid
    {
        if(r.findById(id).isPresent())
        {
            Employee e=r.findById(id).get();
            e.setAge(age);
            r.save(e);
            return "Age updated";
        }
        throw new Invalidid();
    }
    public String updatePos(int id,String pos ) throws Invalidid
    {
        if(r.findById(id).isPresent())
        {
            Employee e=r.findById(id).get();
            e.setPosition(pos);
            r.save(e);
            return "Position updated";
        }
        throw new Invalidid();
    }
    public String updatePho(int id,long ph) throws Invalidid
    {
        if(r.findById(id).isPresent())
        {
            Employee e=r.findById(id).get();
            e.setPhone(ph);
            r.save(e);
            return "Number updated";
        }
        throw new Invalidid();
    }

    public String updateAdd(int id,String add) throws Invalidid
    {
        if(r.findById(id).isPresent())
        {
            Employee e=r.findById(id).get();
            e.setAddress(add);
            r.save(e);
            return "Address updated";
        }
        throw new Invalidid();
    }

    public String retAsset(int id) throws Invalidid
    {
        if(r.findById(id).isPresent())
        {
            return r.findById(id).get().getAsset_Id();
        }
        else
            throw new Invalidid();
    }


}
