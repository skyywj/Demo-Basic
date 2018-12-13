package test;

import java.util.ArrayList;

/**
 * @author yanwenjie
 * @since 2018/12/6
 */
public class D {

    static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> seqs) {
        if (seqs == null) {
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        int signal = -1;
        while (!seqs.isEmpty()) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < seqs.size(); i++) {
                if (seqs.get(i).size() > 0) {
                    if (seqs.get(i).get(0) < min) {
                        min = seqs.get(i).get(0);
                        signal = i;
                    }
                }
            }
            res.add(min);
            seqs.get(signal).remove(0);
            if (seqs.get(signal).size() == 0) {
                seqs.remove(signal);
            }
        }
        return res;
    }

    public static void main(String... args) {
//        ArrayList<ArrayList<Integer>> seqs = new ArrayList<>();
//        ArrayList<Integer> seq = new ArrayList<>();
//        seq.add(0);
//        seq.add(1);
//        seq.add(2);
//        seq.add(3);
//        seqs.add(seq);
//        ArrayList<Integer> seq1 = new ArrayList<>();
//        seq1.add(-1);
//        seq1.add(3);
//        seq1.add(5);
//        seq1.add(9);
//        seqs.add(seq1);
//        System.out.print(merge(seqs));
//        seq.remove(0);
//        System.out.print(seq);
        System.out.print((Math.log10(8) / Math.log10(2)));
    }
}
