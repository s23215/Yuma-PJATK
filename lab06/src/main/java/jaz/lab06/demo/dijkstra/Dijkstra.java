package jaz.lab06.demo.dijkstra;

import com.sun.xml.bind.v2.TODO;

public class Dijkstra {
    public int minDistance(int dist[],Boolean b[]){
        int min = Integer.MAX_VALUE, index = -1;
        for (int x = 0; x < 5; x++){
            if (b[x] == false && dist [x] <= min){
                min = dist[x];
                index = x;
            }
        }
        return index;
    }
    public void dijkstra(int graph[][]){
        //TODO
        //iloscPunktow w danym obszarze
        int iloscPunktow=5;
        int dist[] = new int[iloscPunktow];
        Boolean b[] = new Boolean[iloscPunktow];
        for (int i = 0; i < iloscPunktow; i++){
            dist[i] = Integer.MAX_VALUE;
            b[i] = false;
        }
        dist[0] = 0;
        for (int count = 0; count < iloscPunktow; count++){
            int u = minDistance(dist,b);
            b[u] = true;
            for (int x = 0; x < 5; x++){
                if (!b[x]&&graph[u][x]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][x]<dist[x]){
                    dist[x] = dist[u]+graph[u][x];
                }
            }
        }
    }
    public void core() {
        //TODO
        //lista kosztow z punktu do punktu...
        int graph[][] = new int[][]{{}, {}, {}};


        Dijkstra p = new Dijkstra();
        p.dijkstra(graph);
    }
}
