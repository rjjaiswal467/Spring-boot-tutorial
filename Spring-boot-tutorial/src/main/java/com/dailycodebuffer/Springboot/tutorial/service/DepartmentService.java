package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentid);

    public void deleteDepartmentById(Long departmentid);

    public Department updateDepartment(Long departmentid, Department department);

    public Department fetchByName(String departmentName);
}
