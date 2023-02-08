import model.Pancake;

public class PancakeSort {

    Pancake[] pancakes;
    public void bakePancakes(Pancake[] pancakes) {
        if (pancakes.length == 0 || pancakes.length > 25)
        {
            throw new IllegalArgumentException("Unsupported amount of pancakes provided.");
        }
        for (int i = 0; i < pancakes.length; i++) {
            if (pancakes[i].getDiameter() <= 0)
            {
                throw new IllegalArgumentException("Illegal diameter pancake provided.");
            }
        }
        this.pancakes = pancakes;
    }

    public void sortPancakes() {
    }

    public Pancake[] getPancakes() {
        return pancakes;
    }

    public boolean pancakesAreSorted() {
    int prevDiameter = Integer.MAX_VALUE;
        for (Pancake p : pancakes)
        {
            int diameter = p.getDiameter();
            if (diameter <= prevDiameter)
            {
                prevDiameter = diameter;
            } else {
                return false;
            }
        }
        return true;
    }
}
