package org.hasii.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;



@Root(strict=false)
@Entity
@Table(name="SPORTS_DATA")
public class SportsData extends BaseModel {


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="run_summary_id")
    private RunSummary runSummary;

    @Column
    private String  vers;
    @Column
    private String  dataType;
    /**
     * 
     * 
     */
    public SportsData() {

    }
    public SportsData(@Element(name   = "vers")       String theVers,
                      @Attribute(name = "type")       String theType,
                      @Element(name   = "runSummary") RunSummary theSummary
                      ) {

        vers       = theVers;
        dataType   = theType;
        runSummary = theSummary;
    }
    @Element
    public RunSummary getRunSummary() {
        return runSummary;
    }

    public void setRunSummary(RunSummary theRunSummary) {
        runSummary = theRunSummary;
    }

    @Element
    public String getVers() {
        return vers;
    }
    public void setVers(String theVers) {
        this.vers = theVers;
    }
    @Attribute(name="type")
    public String getType() {
        return dataType;
    }
    public void setType(String theType) {
        this.dataType = theType;
    }
}