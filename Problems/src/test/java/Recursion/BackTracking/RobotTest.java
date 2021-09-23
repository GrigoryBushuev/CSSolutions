package Recursion.BackTracking;

import Recursion.Robot.*;
import Recursion.Robot.Robot;
import org.junit.Test;

public class RobotTest {

    public class RobotFake implements Robot
    {
        public boolean move() {
            var result = true;
            return result;
        }

        public void turnLeft() {

        }

        public void turnRight() {

        }

        public void clean() {

        }
    }

    @Test
    public void robotSolutionTest() {
        var robotSolution = new Solution();
        robotSolution.cleanRoom(new RobotFake());
    }
}
