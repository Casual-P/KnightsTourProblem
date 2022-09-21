package com.example.knigthstour;

class HorsesGraph {
    private final int[][] adjTab;
    public Vertex[] vertices;
    int size;

    HorsesGraph() {
        size = 9;
        adjTab = new int[size][size];
        vertices = new Vertex[size];
        addVertecies();
        addEdges();
    }

    private void addVertecies() {
        vertices[0] = new Vertex('A');
        vertices[1] = new Vertex('B');
        vertices[2] = new Vertex('C');
        vertices[3] = new Vertex('D');
        vertices[4] = new Vertex('E');
        vertices[5] = new Vertex('F');
        vertices[6] = new Vertex('G');
        vertices[7] = new Vertex('H');
        vertices[8] = new Vertex('I');
    }

    private void addEdges() {
        adjTab[0][1] = 1;
        adjTab[0][2] = 1;
        adjTab[0][3] = 1;
        adjTab[0][4] = 1;
        adjTab[0][5] = 1;
        adjTab[0][6] = 1;
        adjTab[0][7] = 1;
        adjTab[0][8] = 1;
    }

    public int getLinkedVertex() {
        for (int i = 1; i < size; i++)
            if (adjTab[0][i] == 1 && !vertices[i].isVisited())
                return i;
        return -1;
    }
}
