package com.xiaofan.springcloud.pojo;



import java.io.Serializable;

public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    private String dsource;

    public Dept() {
    }

    public Dept(String dname) {
        this.dname = dname;
    }

    public Dept(Long deptno, String dname, String dsource) {
        this.deptno = deptno;
        this.dname = dname;
        this.dsource = dsource;
    }

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDsource() {
        return dsource;
    }

    public void setDsource(String dsource) {
        this.dsource = dsource;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", dsource='" + dsource + '\'' +
                '}';
    }
}
