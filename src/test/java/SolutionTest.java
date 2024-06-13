import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author zf
 */


public class SolutionTest {

    @Test
    public  void testRemoveDuplicates(){
        String inputStr="aabcccbbad";
        Solution solution = new Solution();
        String result= solution.removeDuplicates(inputStr,false);

        assertEquals("d",result);
    }

    @Test
    public  void testReplaceDuplicates(){
        String inputStr="abcccbadaaaa";
        Solution solution = new Solution();
        String result= solution.removeDuplicates(inputStr,true);

        assertEquals("d",result);
    }

}
