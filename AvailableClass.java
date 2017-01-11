/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gpagame;

/**
 *
 * @author s531749
 */
public class AvailableClass {
    private String name;
    private int difficulty;

    public AvailableClass(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
