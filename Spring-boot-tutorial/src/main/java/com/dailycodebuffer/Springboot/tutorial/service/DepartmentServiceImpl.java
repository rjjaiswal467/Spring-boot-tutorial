package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentid) {
        return departmentRepository.findById(departmentid).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentid) {
        departmentRepository.deleteById(departmentid);
    }

    @Override
    public Department updateDepartment(Long departmentid, Department department) {
        Department department1 = departmentRepository.findById(departmentid).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            department1.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            department1.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            department1.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(department1);
    }

    @Override
    public Department fetchByName(String departmentName) {
//        return departmentRepository.findByName(departmentName); Failed to create query for method public abstract com.dailycodebuffer.Springboot.tutorial.entity.Department
        // com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository.findByName(java.lang.String)! No property name found for type Department!

        //If you dont want to use the JPA repository then you can go with JPQL query using @Query annotation

        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
