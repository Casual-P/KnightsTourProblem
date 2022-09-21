package com.example.knigthstour;

import java.util.Arrays;
import java.util.Stack;

class ChessTablet {

    private final Stack<HorsesGraph> stack;
    int maxSize;
    int max;
    private final HorsesGraph[][] horsesGraphs;
    private final Position[] hodi;
    private final int[][] kletki;

    public ChessTablet(int max) {
        this.max = max;
        stack = new Stack<>();
        maxSize = max * max;
        horsesGraphs = new HorsesGraph[max][max];
        hodi = new Position[maxSize];
        kletki = new int[max][max];
    }

    public void solution() {
        horsesGraphs[0][0] = new HorsesGraph();
        Stack<Position> stackPositions = new Stack<>();
        stack.push(horsesGraphs[0][0]);
        Position curPos = new Position(0, 0);
        stackPositions.push(curPos);
        kletki[curPos.row][curPos.col] = 1;
        hodi[0] = curPos;
        int numHodov = 1;

        while (!stack.isEmpty()) {
            curPos = stackPositions.peek();
            HorsesGraph curHorse = stack.peek();
            int v = curHorse.getLinkedVertex();
            if (v == -1) {
                stack.pop();
                stackPositions.pop();
                numHodov--;
                kletki[curPos.row][curPos.col] = 0;
            } else {
                Position nextPos = newPosition(v, curPos.row, curPos.col);
                if (nextPos.row < 0 || nextPos.col < 0)
                    curHorse.vertices[v].setVisited(true);
                else if (nextPos.row > max - 1 || nextPos.col > max - 1)
                    curHorse.vertices[v].setVisited(true);
                else if (kletki[nextPos.row][nextPos.col] == 1)
                    curHorse.vertices[v].setVisited(true);
                else {
                    curHorse.vertices[v].setVisited(true);
                    stackPositions.push(nextPos);
                    horsesGraphs[nextPos.row][nextPos.col] = new HorsesGraph();
                    stack.push(horsesGraphs[nextPos.row][nextPos.col]);
                    numHodov++;
                    kletki[nextPos.row][nextPos.col] = 1;
                    hodi[numHodov - 1] = nextPos;
                }
            }
            if (numHodov == maxSize) {
                System.out.println(Arrays.deepToString(kletki));
                for (Position pos : hodi)
                    pos.dispPos();
                return;
            }
        }
    }


    public Position newPosition(int numTry, int curPosRow, int curPosCol) {
        if (numTry == 1) {
            return new Position(curPosRow + 2, curPosCol + 1);
        } else if (numTry == 2) {
            return new Position(curPosRow + 2, curPosCol - 1);
        } else if (numTry == 3) {
            return new Position(curPosRow - 2, curPosCol + 1);
        } else if (numTry == 4) {
            return new Position(curPosRow - 2, curPosCol - 1);
        } else if (numTry == 5) {
            return new Position(curPosRow + 1, curPosCol + 2);
        } else if (numTry == 6) {
            return new Position(curPosRow - 1, curPosCol + 2);
        } else if (numTry == 7) {
            return new Position(curPosRow - 1, curPosCol - 2);
        } else if (numTry == 8) {
            return new Position(curPosRow + 1, curPosCol - 2);
        }
        return null;
    }
}
