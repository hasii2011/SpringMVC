package org.hasii.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
@Entity
@Table(name = "RUN_SUMMARY")
public class RunSummary extends BaseModel {

    @Column(name="WORKOUT_NAME",nullable=true)
    private String      workoutName;

    @Column(name="WORKOUT_TIME",nullable=true)
    private String      workoutTime;

    @Column(name="DURATION", nullable=true)
    private int       duration;

    @Column(name="DURATION_STRING", nullable=true)
    private String      durationString;

    @Column(name="CALORIES", nullable=true)
    private int        calories;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="step_counts_id")
    private StepCounts  stepCounts;
    
    /**
     * 
     * 
     */
    public RunSummary() {
        
    }
    public RunSummary(
                      @Element(name = "workoutName")     String     theWorkoutName,
                      @Element(name = "time")            String     theTime,
                      @Element(name = "duration")        int        theDuration,
                      @Element(name = "durationString")  String     theDurationString,
                      @Element(name = "calories")        int        theCalories,
                      @Element(name = "stepCounts")      StepCounts theStepCounts
                     ) {

        workoutName    = theWorkoutName;
        workoutTime    = theTime;
        duration       = theDuration;
        durationString = theDurationString;
        calories       = theCalories;
        stepCounts     = theStepCounts;
    }

    @Element
    public String getWorkoutName() {
        return workoutName;
    }
    public void setWorkoutName(String theWorkoutName) {
        workoutName = theWorkoutName;
    }
    @Element(name="time")
    public String getWorkoutTime() {
        return workoutTime;
    }
    public void setWorkoutTime(String theTime) {
        workoutTime = theTime;
    }
    @Element(name="duration")
    public int getDuration() {
        return duration;
    }
    public void setDuration(int theDuration) {
        duration = theDuration;
    }
    @Element(required=false)
    public String getDurationString() {
        return durationString;
    }
    public void setDurationString(String theDurationString) {
        durationString = theDurationString;
    }
    @Element
    public int getCalories() {
        return calories;
    }
    public void setCalories(int theCalories) {
        calories = theCalories;
    }
    @Element
    public StepCounts getStepCounts() {
        return stepCounts;
    }
    public void setStepCounts(StepCounts stepCounts) {
        this.stepCounts = stepCounts;
    }
}