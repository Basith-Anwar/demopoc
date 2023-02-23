package com.example.demo;

import com.example.demo.Exception.Emptyrepo;
import com.example.demo.Exception.Invalidid;
import com.example.demo.Exception.Invalidname;
import com.example.demo.controller.controller;
import com.example.demo.entity.Employee;
import com.example.demo.services.services;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	services s;
	@Autowired
	controller c=new controller();
	@Test
	void contextLoads() throws Invalidid, Invalidname, Emptyrepo {
		Assert.assertThrows(Emptyrepo.class,()->{s.viewAll();});
		Employee e=new Employee();
		e.setEid(1);
		e.setEname("Basith");
		e.setAddress("Banaswadi");
		e.setPhone(8990999097L);
		e.setAge(23);
		e.setPosition("MANAGER");
		e.setAsset_Id("laptop");
		Assert.assertEquals("Employee added successfully",s.addEmp(e));
		Assert.assertEquals("Basith",s.getEmpid(1).getEname());
		Assert.assertEquals("Banaswadi",s.getEmpid(1).getAddress());
		Assert.assertEquals(23,s.getEmpName("Basith").getAge());
		Assert.assertEquals("laptop",s.getEmpid(1).getAsset_Id());
		Assert.assertEquals("MANAGER",s.getEmpid(1).getPosition());
		Assert.assertEquals(8990999097l,s.getEmpid(1).getPhone());
		Assert.assertEquals(1,s.getEmpName("Basith").getEid());
		Assert.assertEquals("Employee already exists",s.addEmp(e));
		e.setEname("Rahul");
		e.setAddress("Jakur");
		e.setPhone(809809999);
		e.setAge(23);
		e.setPosition("TESTER");
		e.setEid(2);
		e.setAsset_Id("Desktop");
		Assert.assertEquals("Employee added successfully",s.addEmp(e));
		Assert.assertEquals("Desktop",s.retAsset(2));
		Assert.assertEquals("Age updated",s.updateA(1,23));
		Assert.assertEquals("Address updated",s.updateAdd(1,"SA Reddy layout"));
		Assert.assertEquals("Name updated",s.updaten(1,"Basith Anwar"));
		Assert.assertEquals("Number updated",s.updatePho(1,8867381127l));
		Assert.assertEquals("Position updated",s.updatePos(1,"ANALAYST"));
		Assert.assertEquals("Deleted successfully",s.deleteEmp(1));
		Assert.assertEquals("Deleted successfully",s.deleteEmp(2));
		Exception ex=Assert.assertThrows(Invalidid.class,()->{s.updateA(1,21);});
		Assert.assertThrows(Invalidid.class,()->{s.updateAdd(1,"re");});
		Assert.assertThrows(Invalidid.class,()->{s.updaten(1,"deepak");});
		Assert.assertThrows(Invalidid.class,()->{s.updatePho(1,1l);});
		Assert.assertThrows(Invalidid.class,()->{s.updatePos(1,"ANALYST");});
		Assert.assertThrows(Invalidid.class,()->{s.getEmpid(1);});
		Assert.assertThrows(Invalidname.class,()->{s.getEmpName("Basith");});
		Assert.assertNull(c.a());
		Assert.assertEquals("Employee added successfully",c.add(e));
		Assert.assertEquals("Rahul",c.getById(2).getEname());
		Assert.assertEquals(2,c.getByName("Rahul").getEid());
		Assert.assertEquals("Name updated",c.updaten(2,"Sai Rahul"));
		Assert.assertEquals("Age updated",c.updateage(2,23));
		Assert.assertEquals("Address updated",c.updateadd(2,"Hegdenagar"));
		Assert.assertEquals("Number updated",c.updatenum(2,9l));
		Assert.assertEquals("Position updated",c.updatepos(2,"MANAGER"));
		Assert.assertEquals(false,c.a().isEmpty());
		Assert.assertEquals("Deleted successfully",c.deleteById(2));
		Assert.assertNull(c.getById(2));
		Assert.assertNull(c.getByName("Rahul"));
		Assert.assertNull(c.updaten(2,"Sai Rahul"));
		Assert.assertNull(c.updateage(2,23));
		Assert.assertNull(c.updateadd(2,"Hegdenagar"));
		Assert.assertNull(c.updatenum(2,9l));
		Assert.assertNull(c.updatepos(2,"MANAGER"));
		Assert.assertNull(c.deleteById(2));
	}


}
