package com.sda.model;

public class Department {
    private int departmentId;
    private String departmentName;
    private String jobTitle;
    private int salary;

    public Department(String departmentName, String jobTitle, int salary) {
        this.departmentName = departmentName;
        this.jobTitle = jobTitle;
        this.salary = salary;

    }

    public Department(int departmentId, String departmentName, String jobTitle, int salary) {
        this(departmentName, jobTitle, salary);
        this.departmentId = departmentId;
    }

    public Department(int departmentId) {

    }

    public Department(String departmentName) {

    }

    public String Department(String departmentName) {
      return departmentName;
    }

    public int Department(int departmentId) {
        return departmentId;

    }
    // vreau sa apelez constructorul de mai sus

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Cel mai smecher departament{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                '}';
    }

}

