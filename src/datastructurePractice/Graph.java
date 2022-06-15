package datastructurePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    int vertex;
    LinkedList<Integer> list[];

    public Graph(int vertex){
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for(int i = 0; i < vertex; i++){
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int start, int end){
        list[start].addFirst(end);
        list[end].addFirst(start);
    }

    public void removeEdge(int start, int end){
        list[start].remove(end);
        list[end].remove(start);
    }

    public void removeVertex(int vertex){
        for(int i = 0; i < list[vertex].size(); i++){
            removeEdge(vertex, list[vertex].get(i));
        }

        list[vertex].remove();
    }

    public List<Integer> dfsRecursive(int start){
        List<Boolean> visited = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result = dfs(start, visited, result);
        return result;
    }

    public List<Integer> dfs(int vertex, List<Boolean> visited, List<Integer> result){
        if (vertex == 0){
            return result;
        }
        visited.set(vertex, true);
        result.add(vertex);
        for (Integer integer : list[vertex]) {
            if(!visited.get(integer)){
                return dfs(integer, visited, result);
            }
        }
        return result;
    }

    public List<Integer> dfsIterative(int start){
        List<Boolean> discovered = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        numbers.add(start);
        while (numbers != null){
            vertex = numbers.remove(0);
            if(vertex > numbers.size() || numbers.get(vertex) == null){
               result.add(vertex);
               discovered.set(vertex, true);
               numbers.addAll(list[vertex]);
            }
        }

        return result;

    }

}
