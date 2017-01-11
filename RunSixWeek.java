/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gpagame;

/**
 *
 * @author s531749
 */
public class RunSixWeek {

    private int sixWeekIndex;
    private int twoWeekIndex;


    public RunSixWeek(int sixWeekIndex) {
           this.sixWeekIndex = sixWeekIndex;
    }

    public void run(){
        RunTwoWeek one = new RunTwoWeek(sixWeekIndex, twoWeekIndex);
        twoWeekIndex ++;
        one.run();
    }
    
}
