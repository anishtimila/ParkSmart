package com.topa.techpark;


/**
 * Created by anish on 11/19/2017.
 */

public class parkdata {
    private String rowNo;
    private String lotName = "";
    private String FreeSpace;

    public  void setrowNo(String rowNo){
        this.rowNo = rowNo;
    }

    public String getrowNo() {
        return rowNo;
    }

    public void setlotName(String lotName) {
        this.lotName = lotName;
    }

    public String getlotName() {
        return lotName;
    }

    public void setFreeSpace(String FreeSpace) {
        this.FreeSpace = FreeSpace;
    }

    public String getFreeSpace() {
        return FreeSpace;
    }
}
