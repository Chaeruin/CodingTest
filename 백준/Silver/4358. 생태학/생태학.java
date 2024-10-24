import java.util.*;
import java.util.Map.Entry;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> tree = new TreeMap<>();

        String str;

        while ((str = br.readLine()) != null && !str.isEmpty()) {
            tree.put(str, tree.getOrDefault(str, 0) + 1);
        }

        int sum = sumOfTree(tree);

        Map<String, Double> treeFreq = new TreeMap<>();

        for (Entry<String, Integer> tr : tree.entrySet()) {
            treeFreq.put(tr.getKey(), ((double)tr.getValue()/(double)sum) * 100);
        }
        
        for (Entry<String, Double> trf : treeFreq.entrySet()) {
            String valueResult = String.format("%.4f", trf.getValue());
            System.out.println(trf.getKey() + " " + valueResult);
        }
    }

    public static int sumOfTree(Map<String, Integer> tree) {
        int sum = 0;
        for (Entry<String, Integer> tr : tree.entrySet()) {
            sum += tr.getValue();
        }
        return sum;
    }
}
