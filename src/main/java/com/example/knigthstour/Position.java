package com.example.knigthstour;

class Position {
    int row;
    int col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void dispPos() {
        System.out.println("//row = " + row + ", col = " + col);
    }
}
