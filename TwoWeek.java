/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gpagame;


/**
 *
 * @author s531749
 */
public class TwoWeek {
     
    private int dayNumber;
    private int testGrade;
    private int hoursPutIn;
    private int hoursNeeded;
    private int sixWeekIndex;
    private int twoWeekIndex;

    public TwoWeek(int sixWeekIndex, int twoWeekIndex, int dayNumber, int difficulty){      
        this.sixWeekIndex = sixWeekIndex;
        this.twoWeekIndex = twoWeekIndex;
        this.dayNumber = dayNumber;
        hoursNeeded = (difficulty * 2) + ((100-Game.user.getIntelligence())/10);
    }


    public int determineGrade(){
        double percentOfHours = hoursPutIn/hoursNeeded;
        double grade = percentOfHours;
        grade -=(Game.user.getTiredness()/5);
        return (int)grade;
    }

    public void addTimeStudied(int beingAdded){
        hoursPutIn += beingAdded;
    }

    public int getHoursPutIn() {
        return hoursPutIn;
    }

    public void setHoursPutIn(int hoursPutIn) {
        this.hoursPutIn = hoursPutIn;
    }

    public int getTestGrade() {
        return testGrade;
    }

    public void setTestGrade(int testGrade) {
        this.testGrade = testGrade;
    }
    

}
