package org.example;

import org.junit.jupiter.api.Test;


class ChessBoardTest {

    @Test
    void testChessBoard() {
        ChessBoard board = new ChessBoard();

        Piece pawn = new Piece("Pawn", "white");
        Piece knight = new Piece("Knight", "white");
        Piece bishop = new Piece("Bishop", "white");
        Piece rook = new Piece("Rook", "white");
        Piece queen = new Piece("Queen", "white");
        Piece king = new Piece("King", "white");
        Piece queen2 = new Piece("Queen", "black");
        Piece king2 = new Piece("King", "black");
        Piece rook2 = new Piece("Rook", "black");
        Piece pawn2 = new Piece("Pawn", "black");
        Piece knight2 = new Piece("Knight", "black");
        Piece bishop2 = new Piece("Bishop", "black");

        board.placePiece();
    }
}