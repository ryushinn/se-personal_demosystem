package cn.edu.buaa.se.demosystem.bean;

import java.util.Date;

public class Apparatus {
    private  Integer apparaId;
    private String apparaName;
    private String labName;
    private Date buyTime;
    private String boughtBy;

    public Integer getApparaId() {
        return apparaId;
    }

    public void setApparaId(Integer apparaId) {
        this.apparaId = apparaId;
    }

    public String getApparaName() {
        return apparaName;
    }

    public void setApparaName(String apparaName) {
        this.apparaName = apparaName;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getBoughtBy() {
        return boughtBy;
    }

    public void setBoughtBy(String boughtBy) {
        this.boughtBy = boughtBy;
    }

    @Override
    public String toString() {
        return "Apparatus{" +
                "appraId=" + apparaId +
                ", appraName='" + apparaName + '\'' +
                ", labName='" + labName + '\'' +
                ", buyTime=" + buyTime +
                ", boughtBy='" + boughtBy + '\'' +
                '}';
    }
}
