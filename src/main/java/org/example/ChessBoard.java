package org.example;

public class ChessBoard {

    private Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            Piece pawn = new Piece("Pawn " + i, "white");
            board[1][i] = pawn;
        }
        for (int i = 0; i < 8; i++) {
            Piece pawn = new Piece("Pawn " + i, "black");
            board[6][i] = pawn;
        }
        for (int i = 0; i < 2; i++) {
            Piece knight = new Piece("Horse " + i, "white");

        }
        for (int i = 0; i < 2; i++) {
            Piece knight = new Piece("Horse " + i, "black");
        }
        for (int i = 0; i < 2; i++) {
            Piece rook = new Piece("Rook " + i, "white");
            if(i == 0){
                board[0][0] = rook;
            } else {
                board[0][7] = rook;
            }
        }
        for (int i = 0; i < 2; i++) {
            Piece rook = new Piece("Rook " + i, "black");
            if(i == 0){
                board[7][0] = rook;
            } else {
                board[7][7] = rook;
            }
        }
        for (int i = 0; i < 2; i++) {
            Piece bishop = new Piece("Bishop " + i, "white");
            if(i == 0){
                board[0][2] = bishop;
            } else {
                board[0][5] = bishop;
            }
        }
        for (int i = 0; i < 2; i++) {
            Piece bishop = new Piece("Bishop " + i, "black");
            if(i == 0){
                board[7][2] = bishop;
            } else {
                board[7][5] = bishop;
            }
        }
        Piece king = new Piece("King", "white");
        board[0][4] = king;
        Piece queen = new Piece("Queen", "white");
        board[0][3] = queen;
        Piece king2 = new Piece("King 2", "black");
        board[7][4] = king2;
        Piece queen2 = new Piece("Queen 2", "black");
        board[7][3] = queen2;
    }

    public void placePiece(Piece piece, int row, int col) {
        if (row >= 0 && row < 8 && col >= 0 && col < 8) {
            board[row][col] = piece;
        }
    }

    // Hämta en Piece från en specifik koordinat
    public Piece getPiece(int row, int col) {
        if (row >= 0 && row < 8 && col >= 0 && col < 8) {
            return board[row][col];
        }
        return null;
    }
}
