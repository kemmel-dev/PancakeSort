import model.Pancake;

public class PancakeSort {

    Pancake[] pancakes;
    public void bakePancakes(Pancake[] pancakes) {
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

    public Pancake[] getSortedPancakes() {
        return pancakes;
    }

    public boolean pancakesAreSorted() {
        return true;
    }
}
