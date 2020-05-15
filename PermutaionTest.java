import org.junit.Test;
import static org.junit.Assert.*;


public class PermutaionTest {

    @Test
    public void count_Test1 () {
        Permutation permutation = new Permutation("Haider");
        Integer ouput = permutation.num_of_permutaion(permutation.str);
        Integer expectedoutput = 720;
        assertEquals(expectedoutput,ouput);
    }

    @Test
    public void count_Test2 () {
        Permutation permutation = new Permutation("ABCC");
        Integer ouput = permutation.num_of_permutaion(permutation.str);
        Integer expectedoutput = 12;
        assertEquals(expectedoutput,ouput);
    }

    @Test
    public void count_Test3 () {
        Permutation permutation = new Permutation("AABBCCDD");
        Integer ouput = permutation.num_of_permutaion(permutation.str);
        Integer expectedoutput = 2520;
        assertEquals(expectedoutput,ouput);
    }

    @Test
    public void Empty_count () {
        Permutation permutation = new Permutation("");
        Integer ouput = permutation.num_of_permutaion(permutation.str);
        Integer expectedoutput = 1;
        assertEquals(expectedoutput,ouput);
    }

    @Test
    public void null_check () {
        Permutation permutation = new Permutation(null);
        Integer ouput = permutation.num_of_permutaion(permutation.str);
        Integer expectedoutput = -1;
        assertEquals(expectedoutput,ouput);
    }


}
