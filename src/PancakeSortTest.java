import model.Pancake;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PancakeSortTest {
    @Test
    public void ZeroDiameterPancakesAreRejected()
    {
        PancakeSort sorter = new PancakeSort();
        assertThrows(
                IllegalArgumentException.class,
                () -> sorter.bakePancakes( new Pancake[] {
                        new Pancake(0),
                        new Pancake(2),
                        new Pancake(3)
                })
        );
    }

    @Test
    public void NegativeDiameterPancakesAreRejected()
    {
        PancakeSort sorter = new PancakeSort();

        assertThrows(
                IllegalArgumentException.class,
                () -> sorter.bakePancakes( new Pancake[] {
                                new Pancake(-1),
                                new Pancake(2),
                                new Pancake(3)
                })
        );
    }

    @Test
    public void TooFewPancakesAreRejected()
    {
        PancakeSort sorter = new PancakeSort();

        assertThrows(
                IllegalArgumentException.class,
                () ->
                    sorter.bakePancakes( new Pancake[] {} )
        );
    }

    @Test
    public void TooManyPancakesAreRejected()
    {
        PancakeSort sorter = new PancakeSort();

        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Pancake[] pancakes = new Pancake[26];
                    Arrays.fill(pancakes, new Pancake(1));
                    sorter.bakePancakes(pancakes);
                }
        );
    }

    @Test
    public void SortedPancakesAreSortedWithoutSorting()
    {
        PancakeSort sorter = new PancakeSort();
        sorter.bakePancakes(new Pancake[] {
                new Pancake(3),
                new Pancake(2),
                new Pancake(1)
        });
        assert(sorter.pancakesAreSorted());
    }

    @Test
    public void SortedSameSizedPancakesAreSortedWithoutSorting()
    {
        PancakeSort sorter = new PancakeSort();
        sorter.bakePancakes(new Pancake[] {
                new Pancake(3),
                new Pancake(1),
                new Pancake(1)
        });
        assert(sorter.pancakesAreSorted());
    }

    @Test
    public void UnsortedPancakesAreUnsortedWithoutSorting()
    {
        PancakeSort sorter = new PancakeSort();
        sorter.bakePancakes(new Pancake[] {
                new Pancake(1),
                new Pancake(2),
                new Pancake(3)
        });
        assert(!sorter.pancakesAreSorted());
    }

    @Test
    public void SortedPancakesAreSortedAfterSorting()
    {
        PancakeSort sorter = new PancakeSort();
        sorter.bakePancakes(new Pancake[] {
                new Pancake(3),
                new Pancake(2),
                new Pancake(1)
        });
        sorter.sortPancakes();
        assert(sorter.pancakesAreSorted());
    }

    @Test
    public void SortedSameSizedPancakesAreSortedAfterSorting()
    {
        PancakeSort sorter = new PancakeSort();
        sorter.bakePancakes(new Pancake[] {
                new Pancake(3),
                new Pancake(1),
                new Pancake(1)
        });
        sorter.sortPancakes();
        assert(sorter.pancakesAreSorted());
    }

    @Test
    public void UnsortedPancakesAreSortedAfterSorting()
    {
        PancakeSort sorter = new PancakeSort();
        sorter.bakePancakes(new Pancake[] {
                new Pancake(1),
                new Pancake(2),
                new Pancake(3)
        });
        sorter.sortPancakes();
        assert(sorter.pancakesAreSorted());
    }
}
