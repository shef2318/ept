import javax.lang.model.type.ArrayType;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * Created by р on 17.02.2015.
 */
public class Solver extends Thread {
    public static void solve1(ArrayList<Juice> data) {
        ArrayList<String> result = new ArrayList<String>();
        for (Juice juice: data) {
            for (String component: juice.components) {
                if (!result.contains(component) ) {
                    result.add(component);
                }
            }
        }
        try {
            PrintWriter out = new PrintWriter("juice1.out");
            for (String component : result) {
                out.println(component);
            }
            out.close();
        }
        catch (Exception e) {
            System.out.println("problems while writing");
        }
    }

    public static void solve2(ArrayList<Juice> data) {
        ArrayList<String> result = new ArrayList<String>();
        for (Juice juice: data) {
            for (String component: juice.components) {
                if (!result.contains(component) ) {
                    result.add(component);
                }
            }
        }
        Collections.sort(result, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }
        );

        try {
            PrintWriter out = new PrintWriter("juice2.out");
            for (String component : result) {
                out.println(component);
            }
            out.close();
        }
        catch (Exception e) {
            System.out.println("problems while writing");
        }
    }

    static boolean dfs(Integer x, ArrayList<ArrayList<Integer> > graph, ArrayList<Boolean> was, ArrayList<Integer>to,
                       ArrayList<Integer>with) {
        if (was.get(x) == true) {
            return false;
        }
        was.set(x, true);
        for (Integer go: graph.get(x)) {
            if (with.get(go) == -1) {
                with.set(go, x);
                to.set(x, go);
                return true;
            }
            if (dfs(with.get(go), graph, was, to, with) == true) {
                with.set(go, x);
                to.set(x, go);
                return true;
            }
        }
        return false;
    }

    public static void solve3(ArrayList<Juice> data) {
        for (Juice juice: data) {
            Collections.sort(juice.components);
        }
        //System.out.println(data.get(0).canBeAfter(data.get(1)));
        ArrayList<ArrayList<Integer> >graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < data.size(); i++) {
            ArrayList<Integer> edges = new ArrayList<Integer>();
            for (int j = 0; j < data.size(); j++) {
                if (data.get(i).canBeAfter(data.get(j))) {
                    if (data.get(j).canBeAfter(data.get(i))) {
                        if (i < j) {
                            edges.add(j);
                        }
                    }
                    else {
                        edges.add(j);
                    }
                }
            }
            graph.add(edges);
        }

        ArrayList<Integer> with = new ArrayList<Integer>(), to = new ArrayList<Integer>();
        ArrayList<Boolean> was = new ArrayList<Boolean>();

        for (int i = 0; i < data.size(); i++) {
            with.add(-1);
            to.add(-1);
            was.add(false);
        }

        for (int i = 0; i < data.size(); i++) {
            Collections.fill(was, false);
            dfs(i, graph, was, to, with);
        }

        Integer ans = 0;
        for (int i = 0; i < data.size(); i++) {
            if (to.get(i) == -1) {
                ans += 1;
            }
        }

        try {
            PrintWriter out = new PrintWriter("juice3.out");
            out.println(ans.toString());
            out.close();
        }
        catch (Exception e) {
            System.out.println("problems while writing");
        }
    }
}
