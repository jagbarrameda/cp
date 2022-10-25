import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * This could be solved by either a few runs of Dijkstra algorithm
 * or one run of Floyd and then a few look-ups, one for each of the pairs to find.
 *
 * There is the same problem with lower time constraint - TSHPATH
 *
 * Solved after a few improvements:
 * 1. Use buffered reader + string.split instead of Scanner
 * 1. Use adjacency list as array of ArrayLists
 * 1. Break search when reached target city
 * 1. Dijkstra with Priority Queue
 * 1. HashMap for cities name to index mapping
 */
public class m15Shpath {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(new InputStreamReader(System.in));
//        Scanner scanner = new Scanner(new File("m15.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("m15.txt"));
        int tests = Integer.parseInt(br.readLine());
        while (tests-- > 0) {
            Country m = new Country();
            m.loadTestCase(br);
            m.solveTestCase(br);
            br.readLine();
        }
    }

    static class Country {
        int nCities = 0;
        ArrayList<City>[] streetCosts;
        Map<String, Integer> names = new HashMap<>();

        private void loadTestCase(BufferedReader br) throws IOException {
            nCities = Integer.parseInt(br.readLine());
            names.clear();
            streetCosts = new ArrayList[nCities];

            for (int i = 0; i < nCities; i++) {
                streetCosts[i] = new ArrayList<>();
                loadCity(i, br);
            }
        }

        private void loadCity(int cityIndex, BufferedReader br) throws IOException {
            String name = br.readLine();
            names.put(name, cityIndex);

            String s;
            int nNeighbors = Integer.parseInt(br.readLine());
            for (int i = 0; i < nNeighbors; i++) {
                s = br.readLine();
                int pos = s.indexOf(' ');
                int neighbor = Integer.parseInt(s.substring(0, pos)) - 1;
                int cost = Integer.parseInt(s.substring(pos + 1));
                City p = new City();
                p.id = neighbor;
                p.dist = cost;
                streetCosts[cityIndex].add(p);
            }
        }

        private void solveTestCase(BufferedReader br) throws IOException {
            int r = Integer.parseInt(br.readLine());
            ;
            while (r-- > 0) {
                String s = br.readLine();
                int pos = s.indexOf(' ');
                int indexFrom = names.get(s.substring(0, pos));
                int indexTo = names.get(s.substring(pos + 1));
                System.out.println(getShortestPathCost(indexFrom, indexTo));
            }
        }

        private int getShortestPathCost(int from, int to) {
            PriorityQueue<City> cities = new PriorityQueue<>();
            int[] shortestPathCosts = new int[nCities];
            boolean[] visited = new boolean[nCities];
            for (int i = 0; i < nCities; i++) {
                shortestPathCosts[i] = -1;
                visited[i] = false;
            }
            visited[from] = true;

            City city = new City();
            city.id = from;
            city.dist = 0;
            cities.add(city);

            while (!cities.isEmpty()) {
                city = cities.poll();
                if (city.id == to) break;
                // add neighbors of city.id to be visited
                for (City neighbor : streetCosts[city.id]) {
                    if (visited[neighbor.id]) continue;
                    int cost = city.dist + neighbor.dist;
                    if (shortestPathCosts[neighbor.id] < 0 || cost < shortestPathCosts[neighbor.id]) {
                        shortestPathCosts[neighbor.id] = cost;
                        City newP = new City();
                        newP.id = neighbor.id;
                        newP.dist = cost;
                        cities.add(newP);
                    }
                }
                visited[city.id] = true;
            }
            return shortestPathCosts[to];
        }
    }

    static class City implements Comparable<City> {
        int id;
        int dist;

        @Override
        public int compareTo(City o) {
            return this.dist - o.dist;
        }
    }
}
