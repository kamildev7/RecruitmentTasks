import java.util.Scanner;

public class Solution2 {

    private static int[] plots;
    private static int firstPlot;
    private static int lastPlot;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        plots = new int[scanner.nextInt()];

        saveProfitabilityOfEachPlot(scanner);

        int profitability = findMaxProfitability();

        System.out.printf("%d %d %d", firstPlot + 1, lastPlot + 1, profitability);
    }

    private static int findMaxProfitability() {
        int max = 0, partial = 0, leftIndex = 0;
        for (int i = 0; i < plots.length; i++) {
            partial += plots[i];

            if (partial == 0 && max == 0) { //we don't want a set with profitability: 0 0 0 4
                leftIndex++;
            }

            if (partial < 0) { //start looking again from i+1 index
                partial = 0;
                leftIndex = i + 1;
            }
            if (partial > max) { //save the profitable set
                max = partial;
                lastPlot = i;
                firstPlot = leftIndex;

            } else if ((partial == max) && (lastPlot - firstPlot) > (i - leftIndex)) { //check if the number of plots is lower
                firstPlot = leftIndex;
                lastPlot = i;
            }

        }
        return max;
    }


    private static void saveProfitabilityOfEachPlot(Scanner scanner) {
        int index = 0;
        while (index < plots.length) {
            plots[index++] = scanner.nextInt();
        }
    }

}