/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gpagame;

import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @author s531749
 */
public class Day {

    private int semesterIndex;
    private int sixWeekIndex;
    private int twoWeekIndex;
    private double wakeUpTime;
    private double hour = 5.0;
    Scanner in = new Scanner(System.in);

    public Day(int sixWeekIndex, int twoWeekIndex) {
        this.semesterIndex = Game.user.getSemesterNumber();
        this.sixWeekIndex = sixWeekIndex;
        this.twoWeekIndex = twoWeekIndex;
    }

    public void runDay() {
        wakeUp();
    }

    public void wakeUp() {
        System.out.println("You just woke up");
        printTime(hour);
        study();
        System.out.println("Study worked ");
        System.out.println("What would you like to do? Go back to sleep, study, or spend time getting ready?");
    }

    public static void printTime(double time) {
        DecimalFormat out = new DecimalFormat("00");

        int howManyHours = 0;
        double leftOver = 0;
        int partOfHour;
        for (int i = 1; i < 28; i++) {
            if (time > i) {
                howManyHours++;
            }
        }
        leftOver = time - howManyHours;
        partOfHour = decimalToTime(leftOver);
        if (partOfHour == 60) {
            howManyHours++;
            partOfHour = 0;
        }

        if (howManyHours == 0 || howManyHours == 24) {
            System.out.println("The current time 12" + ":" + out.format(partOfHour));

        } else if (howManyHours >= 1 && time < 12) {
            System.out.println("The current time " + howManyHours + ":" + out.format(partOfHour) + "AM");
        } else if (howManyHours == 12) {
            System.out.println("The current time " + howManyHours + ":" + out.format(partOfHour) + "PM");
        } else if (howManyHours > 12 && howManyHours < 24) {
            System.out.println("The current time " + (howManyHours - 12) + ":" + out.format(partOfHour) + "PM");
        } else if (howManyHours > 24) {
            System.out.println("The current time " + (howManyHours - 24) + ":" + out.format(partOfHour) + "AM");
        }
    }

    public static int decimalToTime(double decimal) {
        double time = 0;
        int toReturn = 0;
        time = Math.round(100 * (decimal * 3 / 5));
        toReturn = (int) time;

        return toReturn;
    }

    public void study() {
        System.out.print("Here is your schedule: ");
        Game.user.semseters.get(this.semesterIndex).printSchedule();
        boolean valid = false;
        while(!valid){
        
            System.out.print("Which period would you like to study for: ");
            int period = in.nextInt();
            if (period > 0 && period <= 7) {
                period--;
                System.out.println("period is in range");
                ClassTaking temp = Game.user.semseters.get(this.semesterIndex).sixWeeks.get(this.sixWeekIndex).taking.get(period);
                System.out.println("good 1");
                temp.twoWeeks.get(this.twoWeekIndex).getHoursPutIn();
                System.out.println("good so far");
                        //.twoWeeks.get(this.twoWeekIndex).addTimeStudied(30);
                valid = true;

            } else {
                System.out.println("Invalid Input in else");
                study();
           }
        System.out.println("Method finished");
    }
}}
