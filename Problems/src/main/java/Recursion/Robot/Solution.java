package Recursion.Robot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private class Spot {
        private int x;
        private int y;
        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() { return this.x; }
        public int y() { return this.y; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Spot spot = (Spot) o;

            if (x != spot.x) return false;
            return y == spot.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
    private final Set<Spot> visited = new HashSet();
    private final List<Spot> directions = List.of(new Spot(0, 1), new Spot(1, 0), new Spot(0, -1), new Spot(-1, 0));

    public void cleanRoom(Robot robot) {
        var startSpot = new Spot(0, 0);
        robot.clean();
        this.visited.add(startSpot);
        cleanRoom(robot, startSpot, 0);
    }

    private void cleanRoom(Robot robot, Spot currentSpot, int direction) {
        for (var i = 0; i < 4; i++) {
            var currentDirection = directions.get(direction);
            var newSpot = new Spot(currentSpot.x() + currentDirection.x(), currentSpot.y() + currentDirection.y());
            if (!this.visited.contains(newSpot) && robot.move()) {
                robot.clean();
                this.visited.add(newSpot);
                cleanRoom(robot, newSpot, direction);
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
            direction = (direction + 1) % 4;
        }
        robot.turnLeft();
        robot.move();
    }
}

