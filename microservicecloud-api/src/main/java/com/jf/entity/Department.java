package com.jf.entity;

import java.io.Serializable;

/**
 * @author 潇潇暮雨
 * @create 2018-12-01   18:46
 */
public class Department implements Serializable {
    private Integer deptId;

    private String deptName;
    
    private String db_source;
    

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDb_source() {
        return db_source;
    }

    public void setDb_source(String db_source) {
        this.db_source = db_source;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", db_source='" + db_source + '\'' +
                '}';
    }
}
