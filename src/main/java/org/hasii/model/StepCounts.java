package org.hasii.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author Humberto A. Sanchez II
 *
 */
@Root(strict=false)
@Entity
@Table(name = "STEP_COUNTS")
public class StepCounts extends BaseModel {

    @Column(name="WALK_BEGIN")
    private int walkBegin;
    @Column(name="WALK_END")
    private int walkEnd;
    /**
     * 
     * 
     */
    public StepCounts() {
    }
    public StepCounts(
                    @Element(name = "walkBegin") int theWalkBegin,
                    @Element(name = "walkEnd")   int theWalkEnd
            ) {
        walkBegin = theWalkBegin;
        walkEnd   = theWalkEnd;
    }
    @Element
    public int getWalkBegin() {
        return walkBegin;
    }

    public void setWalkBegin(int walkBegin) {
        this.walkBegin = walkBegin;
    }
    @Element
    public int getWalkEnd() {
        return walkEnd;
    }

    public void setWalkEnd(int walkEnd) {
        this.walkEnd = walkEnd;
    }
}