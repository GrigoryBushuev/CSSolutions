package DynamicProgramming;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class TriangleTest {
    @Test
    void minimumTotalTest() {
        var sut = new Triangle();
        var triangle1 = new LinkedList<List<Integer>>()
        {{
            add(new LinkedList<>() {{ add(2); }});
            add(new LinkedList<>() {{ add(3); add(4); }});
            add(new LinkedList<>() {{ add(5); add(6); add(7); }});
            add(new LinkedList<>() {{ add(4); add(1); add(8); add(3); }});
        }};
        Assert.assertEquals(11, sut.getMinimumTotalTopDown(triangle1));
        Assert.assertEquals(11, sut.getMinimumTotalBottomUp(triangle1));
        Assert.assertEquals(11, sut.getMinimumTotalBottomUpInPlace(triangle1));
        var triangle2 = new LinkedList<List<Integer>>()
        {{
            add(new LinkedList<>() {{ add(-10); }});
        }};
        Assert.assertEquals(-10, sut.getMinimumTotalTopDown(triangle2));
        Assert.assertEquals(-10, sut.getMinimumTotalBottomUp(triangle2));
        Assert.assertEquals(-10, sut.getMinimumTotalBottomUpInPlace(triangle2));

        //[
        //  [-1],
        //  [2, 3],
        //  [1, -1, -3]
        //]
        var triangle3 = new LinkedList<List<Integer>>()
        {{
            add(new LinkedList<>() {{ add(-1); }});
            add(new LinkedList<>() {{ add(2); add(3); }});
            add(new LinkedList<>() {{ add(1); add(-1); add(-3); }});
        }};
        Assert.assertEquals(-1, sut.getMinimumTotalTopDown(triangle3));
        Assert.assertEquals(-1, sut.getMinimumTotalBottomUp(triangle3));
        Assert.assertEquals(-1, sut.getMinimumTotalBottomUpInPlace(triangle3));

        /*
        * [
            [-7],
            [-2, 1],
            [-5,-5, 9],
            [-4,-5, 4, 4],
            [-6,-6, 2,-1,-5],
            [ 3, 7, 8,-3, 7,-9],
            [-9,-1,-9, 6, 9, 0, 7],
            [-7, 0,-6,-8, 7, 1,-4, 9],
            [-3, 2,-6,-9,-7,-6,-9, 4, 0],
            [-8,-6,-3,-9,-2,-6, 7,-5, 0, 7],
            [-9,-1,-2, 4,-2, 4, 4,-1, 2,-5, 5],
            [ 1, 1,-6, 1,-2,-4, 4,-2, 6,-6, 0, 6],
            [-3,-3,-6,-2,-6,-2, 7,-9,-5,-7,-5, 5, 1]
        ]*/
        var triangle4 = new LinkedList<List<Integer>>()
        {{
            add(new LinkedList<>() {{ add(-7); }});
            add(new LinkedList<>() {{ add(-2); add(1); }});
            add(new LinkedList<>() {{ add(-5); add(-5); add(9); }});
            add(new LinkedList<>() {{ add(-4); add(-5); add(4); add(4); }});
            add(new LinkedList<>() {{ add(-6); add(-6); add(2); add(-1); add(-5); }});
            add(new LinkedList<>() {{ add(3); add(7); add(8); add(-3); add(7); add(-9); }});
            add(new LinkedList<>() {{ add(-9); add(-1); add(-9); add(6); add(9); add(0); add(7); }});
            add(new LinkedList<>() {{ add(-7); add(0); add(-6); add(-8); add(7); add(1); add(-4); add(9); }});
            add(new LinkedList<>() {{ add(-3); add(2); add(-6); add(-9); add(-7); add(-6); add(-9); add(4); add(0); }});
            add(new LinkedList<>() {{ add(-8); add(-6); add(-3); add(-9); add(-2); add(-6); add(7); add(-5); add(0); add(7); }});
            add(new LinkedList<>() {{ add(-9); add(-1); add(-2); add(4); add(-2); add(4); add(4); add(-1); add(2); add(-5); add(5); }});
            add(new LinkedList<>() {{ add(1); add(1); add(-6); add(1); add(-2); add(-4); add(4); add(-2); add(6); add(-6); add(0); add(6); }});
            add(new LinkedList<>() {{ add(-3); add(-3); add(-6); add(-2); add(-6); add(-2); add(7); add(-9); add(-5); add(-7); add(-5); add(5); add(1); }});
        }};
        Assert.assertEquals(-63, sut.getMinimumTotalTopDown(triangle4));
        Assert.assertEquals(-63, sut.getMinimumTotalBottomUp(triangle4));
        Assert.assertEquals(-63, sut.getMinimumTotalBottomUpInPlace(triangle4));
    }
}