package PokemonFolder14;
import java.util.HashMap;
import java.util.Map;

public class PokemonDamageCalculator {
    private Map<String, Map<String, Double>> typeChart;

    public PokemonDamageCalculator() {
        typeChart = new HashMap<>();

    
        Map<String, Double> fireChart = new HashMap<>();
        fireChart.put("불", 1.0);
        fireChart.put("물", 0.5);
        fireChart.put("풀", 2.0);
        typeChart.put("불", fireChart);

        Map<String, Double> waterChart = new HashMap<>();
        waterChart.put("불", 2.0);
        waterChart.put("물", 1.0);
        waterChart.put("풀", 0.5);
        typeChart.put("물", waterChart);

        Map<String, Double> grassChart = new HashMap<>();
        grassChart.put("불", 0.5);
        grassChart.put("물", 2.0);
        grassChart.put("풀", 1.0);
        typeChart.put("풀", grassChart);
    }

    public double calculateDamage(String attackType, String defenseType) {
        if (!typeChart.containsKey(attackType) || !typeChart.containsKey(defenseType)) {
            System.out.println("잘못된 타입입니다.");
            return 0.0;
        }

        Map<String, Double> attackChart = typeChart.get(attackType);
        double damageMultiplier = attackChart.getOrDefault(defenseType, 1.0);
        return damageMultiplier;
    }
}
