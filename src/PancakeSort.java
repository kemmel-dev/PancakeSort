import model.Pancake;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PancakeSort {

    Pancake[] pancakes;
    public void bakePancakes(Pancake[] pancakes) {
        Set<Integer> diameters = new HashSet<Integer>();
        if (pancakes.length == 0 || pancakes.length > 25)
        {
            throw new IllegalArgumentException("Unsupported amount of pancakes provided.");
        }
        for (int i = 0; i < pancakes.length; i++) {
            if (pancakes[i].getDiameter() <= 0)
            {
                throw new IllegalArgumentException("Illegal diameter pancake provided.");
            }
            else if (diameters.contains(pancakes[i].getDiameter())) {
                throw new IllegalArgumentException("At least two pancakes with the same size were provided.");
            }
            else {
                diameters.add(pancakes[i].getDiameter());
            }
        }
        this.pancakes = pancakes;
    }

    public void sortPancakes() {
        int n = this.pancakes.length;
        int maxIndex = -1;
        while (n > 1) {
            maxIndex = getIndexOfLargestPancake(n);
            flipPancakes(maxIndex);
            flipPancakes(n - 1);
            n --;
        }
        Collections.reverse(Arrays.asList(pancakes));
    }

    private void flipPancakes(int atIndex) {
        int left = 0;
        while (left < atIndex) {
            Pancake tmp = this.pancakes[left];
            this.pancakes[left] = this.pancakes[atIndex];
            this.pancakes[atIndex] = tmp;
            atIndex --;
            left ++;
        }
    }

    private int getIndexOfLargestPancake(int n) {
        int targetIndex = 0;
        for (int i = 0; i < n; i++) {
            if (this.pancakes[i].getDiameter() > this.pancakes[targetIndex].getDiameter())
            {
                targetIndex = i;
            }
        }
        return targetIndex;
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
