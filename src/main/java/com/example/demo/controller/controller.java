package com.example.demo.controller;

import com.example.demo.Exception.Emptyrepo;
import com.example.demo.Exception.Invalidid;
import com.example.demo.Exception.Invalidname;
import com.example.demo.entity.Employee;
import com.example.demo.services.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
public class controller {

    @Autowired
    private services s;

    @GetMapping("/all")
    public List<Employee> a() throws Emptyrepo {
        try{return s.viewAll();}
        catch (Emptyrepo er)
        {
            return null;
        }
    }

    @PostMapping("/add")
    public String add(@RequestBody Employee e) {
        return s.addEmp(e);
    }

    @GetMapping("/byid")
    public Employee getById(@RequestParam int id) throws Invalidid {
        try{return s.getEmpid(id);}
        catch (Invalidid ii)
        {
            return null;
        }
    }

    @GetMapping("/byname")
    public Employee getByName(@RequestParam String n) throws Invalidname {
        try{return s.getEmpName(n);}
        catch (Invalidname en)
        {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) throws Invalidid {
        try{return s.deleteEmp(id);}
        catch (Invalidid ii)
        {
            return null;
        }
    }

    @PatchMapping("/updaten/{id}/{name}")
    public String updaten(@PathVariable int id, @PathVariable String name) throws Invalidid {
        try{return s.updaten(id, name);}
        catch (Invalidid ii)
        {
            return null;
        }
    }
    @PatchMapping("/updateage/{id}/{age}")
    public String updateage(@PathVariable int id, @PathVariable int age) throws Invalidid {
        try{return s.updateA(id, age);}
        catch (Invalidid ii)
        {
            return null;
        }

    }
    @PatchMapping("/updateadd/{id}/{add}")
    public String updateadd(@PathVariable int id, @PathVariable String add) throws Invalidid {
        try{return s.updateAdd(id, add);}
        catch (Invalidid ii)
        {
            return null;
        }
    }
    @PatchMapping("/updatenum/{id}/{num}")
    public String updatenum(@PathVariable int id, @PathVariable long num) throws Invalidid {
        try{return s.updatePho(id, num);}
        catch (Invalidid ii)
        {
            return null;
        }
    }
    @PatchMapping("/updatepos/{id}/{pos}")
    public String updatepos(@PathVariable int id, @PathVariable String pos) throws Invalidid {
        try {return s.updatePos(id, pos);}
        catch (Invalidid ii)
        {
            return null;
        }
    }
}
