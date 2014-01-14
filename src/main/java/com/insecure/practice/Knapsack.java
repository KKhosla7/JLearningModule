package com.insecure.practice;

/**
 * IntelliJ Idea 13 Community Edition
 * Created by karan.khosla on 1/13/14.
 */

public class Knapsack {

    private int numberOfItems;
    private int maxKnapsackWeight;
    private int[] profit;
    private int[] weight;
    private boolean[] takeSolution;

    public Knapsack(int numberOfItems, int maxKnapsackWeight) {
        this.numberOfItems = numberOfItems;
        this.maxKnapsackWeight = maxKnapsackWeight;
        profit = new int[numberOfItems + 1];
        weight = new int[numberOfItems + 1];
        takeSolution = new boolean[numberOfItems + 1];
    }

    private void generateRandomKnapsackInstances() {
        for (int nItem = 1; nItem <= numberOfItems; nItem++) {
            profit[nItem] = (int) (Math.random() * 1000);
            weight[nItem] = (int) (Math.random() * maxKnapsackWeight);
        }
    }

    private void determineOptions() {
        int[][] options = new int[numberOfItems + 1][maxKnapsackWeight + 1];
        boolean[][] solutions = new boolean[numberOfItems + 1][maxKnapsackWeight + 1];
        for (int nItem = 1; nItem <= numberOfItems; nItem++) {
            for (int nWeight = 1; nWeight <= maxKnapsackWeight; nWeight++) {
                int option1 = options[nItem - 1][nWeight]; // don't takeSolution item n
                int option2 = Integer.MIN_VALUE;
                if (weight[nItem] <= nWeight)
                    option2 = profit[nItem] + options[nItem - 1][nWeight - weight[nItem]]; // takeSolution item n
                options[nItem][nWeight] = Math.max(option1, option2);
                solutions[nItem][nWeight] = (option2 > option1);
            }
        }
        determineItemsToTake(solutions);
    }

    private void determineItemsToTake(boolean[][] sol) {
        for (int nItem = numberOfItems, nWeight = maxKnapsackWeight; nItem > 0; nItem--) {
            if (sol[nItem][nWeight]) {
                takeSolution[nItem] = true;
                nWeight = nWeight - weight[nItem];
            } else {
                takeSolution[nItem] = false;
            }
        }
    }

    private void printResults() {
        String result = String.format("Item \t Profit \t Weight \t Take \n\n");
        for (int nItem = 1; nItem <= numberOfItems; nItem++)
            result += String.format("%d \t\t %d \t\t %d \t\t %s \n", nItem, profit[nItem], weight[nItem], takeSolution[nItem]);
        System.out.println(result);
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        knapsack.generateRandomKnapsackInstances();
        knapsack.determineOptions();
        knapsack.printResults();
    }
}
