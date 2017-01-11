/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gpagame;

/**
 *
 * @author s531749
 */
public class RunTwoWeek {
    private int dayNumber;
    private int twoWeekIndex;
    private int sixWeekIndex;

    public RunTwoWeek(int sixWeekIndex, int twoWeekIndex) {
        this.sixWeekIndex = sixWeekIndex;
        this.twoWeekIndex = twoWeekIndex;
    }
    

    public void run(){
        Day one = new Day(sixWeekIndex, twoWeekIndex);
        one.runDay();
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getTwoWeekIndex() {
        return twoWeekIndex;
    }

    public void setTwoWeekIndex(int twoWeekIndex) {
        this.twoWeekIndex = twoWeekIndex;
    }

    
}
