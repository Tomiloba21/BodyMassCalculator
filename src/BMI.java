import javax.swing.*;
import java.text.DecimalFormat;

/**
 * This class represents a Body Mass Index (BMI) calculator.
 */
public class BMI {
    // DecimalFormat object for formatting BMI values
    private static final DecimalFormat df = new DecimalFormat("0.00");

    // Instance variables to store weight in kilograms and height in meters
    private  int weight;
    private double height;

        /**
     * Constructor for creating a BMI object with given weight and height.
     * 
     * @param weight the weight of the person in kilograms
     * @param height the height of the person in meters
     */
    public BMI(int weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public String BMI(){
        try {
            double bodyMassIndex = this.weight/Math.pow(this.height, 2);
            String result = "Your Body mass Index is " + df.format(bodyMassIndex) + "kg/m^2";
            if (bodyMassIndex < 18.5)  {
                return result + "\n Underweight";
            } else if (bodyMassIndex > 18.5 && bodyMassIndex < 25.0 ) {
                return result + "\n Normal ";
            } else if (bodyMassIndex > 25.0 && bodyMassIndex < 30) {
                return result +"\n Overweight ";

            } else if (bodyMassIndex > 30 ) {
                return result + "\n Obese ";
            }else {
                //this won't call
                return "Out of Bounds ";
            }
        }catch (MatchException me){
            return me.getMessage();
        }

    }
    /**
    *These getter and setter methods provide encapsulation, 
    *allowing controlled access to the instance variables 
    *while protecting them from direct manipulation.
    */
    
    /**
     * Returns the weight of the person in kilograms.
     * 
     * @return the weight of the person
     */
    public int getWeight() {
        return weight;
    }
    
    /**
     * Sets the weight of the person in kilograms.
     * 
     * @param weight the new weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    /**
     * Returns the height of the person in meters.
     * 
     * @return the height of the person
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * Sets the height of the person in meters.
     * 
     * @param height the new height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
