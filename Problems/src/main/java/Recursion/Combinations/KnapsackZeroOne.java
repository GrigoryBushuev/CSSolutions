package Recursion.Combinations;

import java.util.*;

public class KnapsackZeroOne {
    public record KnapsackItem(int weight, int value) {}

    public class Knapsack {
        private List<KnapsackItem> items;
        private int maxWeight;
        private int value;

        public Knapsack(List<KnapsackItem> items, int maxWeight, int value) {
            this.setItems(items);
            this.setMaxWeight(maxWeight);
            this.setValue(value);
        }

        public List<KnapsackItem> getItems() {
            return items;
        }

        public void setItems(List<KnapsackItem> items) {
            this.items = items;
        }

        public int getMaxWeight() {
            return maxWeight;
        }

        public void setMaxWeight(int maxWeight) {
            this.maxWeight = maxWeight;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public List<KnapsackItem> getKnapsack(ArrayList<KnapsackItem> items, int maxWeight) {
        var current = new Knapsack(new LinkedList<>(), 0, 0);
        var result = new Knapsack(new LinkedList<>(), 0, 0);
        getKnapsack(current, items, maxWeight, 0, result);
        return result.getItems();
    }

    private void getKnapsack(Knapsack current, ArrayList<KnapsackItem> items, int maxWeight, int index, Knapsack result) {
        if (current.getValue() > result.getValue() && current.getMaxWeight() <= maxWeight) {
            result.setItems(current.getItems());
            result.setValue(current.getValue());
            result.setMaxWeight(current.getMaxWeight());
        }
        if (index == items.size()) {
            return;
        }
        getKnapsack(current, items, maxWeight, index + 1, result);
        var nextItem = items.get(index);
        if (current.getMaxWeight() + nextItem.weight() > maxWeight) {
            return;
        }
        LinkedList<KnapsackItem> toAdd = new LinkedList<>(current.getItems());
        toAdd.add(nextItem);
        var next = new Knapsack(toAdd, current.getMaxWeight() + nextItem.weight(), current.getValue() + nextItem.value());
        getKnapsack(next, items, maxWeight, index + 1, result);
    }
}
