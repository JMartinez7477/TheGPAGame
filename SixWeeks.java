/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gpagame;
import java.util.*;
/**
 *
 * @author s531749
 */
public class SixWeeks {
    private double sixWeeksGrade;
    private int weekNum;
    private int dificulty;
    ArrayList<Class> classes = Game.user.semseters.get(Game.user.getSemesterNumber()).classes;
    ArrayList<ClassTaking> taking = new ArrayList<ClassTaking>();
    private int sixWeekIndex;


    public SixWeeks(int sixWeekIndex) {
        this.sixWeekIndex = sixWeekIndex;
    }

    public void run(){
        createClassesTaking();
        RunSixWeek run = new RunSixWeek(sixWeekIndex);
        run.run();

    }
    public void doSixWeeks() {

    }

    public void createClassesTaking(){
        //System.out.println("Classes taking");
        for (int i = 0; i < classes.size(); i++) {
            ClassTaking adding = new ClassTaking(classes.get(i).getPeriod(), classes.get(i).getClassName(), classes.get(i).getDifficulty(), classes.get(i).getClassIndex(), sixWeekIndex);
            taking.add(adding);
            //System.out.println(taking.get(i).getPeriod() + ": " + taking.get(i).getClassName() + " with difficulty of " + taking.get(i).getDifficulty());
        }
    }

    public void newWeek(){
        weekNum++;
    }
    
    public void newMinorGrade(){

    }

    public void newTest(){}

    public void determineGPA(){

    }

}
