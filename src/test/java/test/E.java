package test;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * @author yanwenjie
 * @since 2018/12/6
 */

/**
 * H(X) = -(p0*log2(p0) + p1*log2(p1) + … + pm*log2(pm))
 */
public class E {
    public double[] probability(Map<Integer, Integer> map, int size) {
        double res[] = new double[map.size()];

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[i] = entry.getValue() / size;
        }
        return res;
    }

    double entropy(int[] xs) {
        if (xs.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashedMap();
        for (int i = 0; i < xs.length; i++) {
            int time = map.get(xs[i]);
            map.put(xs[i], ++time);
        }
        double res[] = probability(map, xs.length);

        double hx = 0;
        for (int i = 0; i < res.length; i++) {
            hx += res[i] * (Math.log10(res[i]) / Math.log10(2));
        }
        return -1 * hx;
    }
}
