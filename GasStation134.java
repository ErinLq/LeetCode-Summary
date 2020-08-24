public class GasStation134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int station = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            tank = tank + gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                station = i + 1;
            }
        }
        return (gasSum < costSum) ? -1 : station;
    }
}
