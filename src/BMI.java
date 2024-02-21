import javax.swing.*;
import java.text.DecimalFormat;
public class BMI {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private  int weight;
    private double height;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
