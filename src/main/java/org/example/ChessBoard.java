package org.example;

public class ChessBoard {

    private final Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
        setStartBoard();
    }

    private void setStartBoard() {
        for (int i = 0; i < 8; i++) {
            Piece pawn = new Piece("Pawn", "white");
            setPiece(pawn, 1, i);
        }
        for (int i = 0; i < 8; i++) {
            Piece pawn = new Piece("Pawn", "black");
            setPiece(pawn, 6, i);
        }
        for (int i = 0; i < 2; i++) {
            Piece knight = new Piece("Knight", "white");
            if(i == 0){
                setPiece(knight, 0, 1);
            } else {
                setPiece(knight, 0, 6);
            }
        }
        for (int i = 0; i < 2; i++) {
            Piece knight = new Piece("Knight", "black");
            if(i == 0){
                setPiece(knight, 7, 1);
            } else {
                setPiece(knight, 7, 6);
            }
        }
        for (int i = 0; i < 2; i++) {
            Piece rook = new Piece("Rook", "white");
            if(i == 0){
                setPiece(rook, 0, 0);
            } else {
                setPiece(rook, 0, 7);
            }
        }
        for (int i = 0; i < 2; i++) {
            Piece rook = new Piece("Rook", "black");
            if(i == 0){
                setPiece(rook, 7, 0);
            } else {
                setPiece(rook, 7, 7);
            }
        }
        for (int i = 0; i < 2; i++) {
            Piece bishop = new Piece("Bishop", "white");
            if(i == 0){
                setPiece(bishop, 0, 2);
            } else {
                setPiece(bishop, 0, 5);
            }
        }
        for (int i = 0; i < 2; i++) {
            Piece bishop = new Piece("Bishop", "black");
            if(i == 0){
                setPiece(bishop, 7, 2);
            } else {
                setPiece(bishop, 7, 5);
            }
        }
        Piece king = new Piece("King", "white");
        setPiece(king, 0, 3);
        Piece queen = new Piece("Queen", "white");
        setPiece(queen, 0, 4);
        Piece king2 = new Piece("King", "black");
        setPiece(king2, 7, 3);
        Piece queen2 = new Piece("Queen", "black");
        setPiece(queen2, 7, 4);
    }

    public void setPiece(Piece piece, int row, int col) {
        if (row >= 0 && row < 8 && col >= 0 && col < 8) {
            board[row][col] = piece;
        }
    }

    public Piece getPiece(int row, int col) {
        if (row >= 0 && row < 8 && col >= 0 && col < 8) {
            return board[row][col];
        }
        return null;
    }

    public void removePiece(int row, int column) {
        board[row][column] = null;
    }

    public boolean canMove(int fromRow, int fromColumn, int toRow, int toColumn){
        if(getPiece(fromRow, fromColumn)!=null ){
            if(getPiece(toRow, toColumn)==null){
                return true;
            } else return !getPiece(fromRow, fromColumn).getColor().equals(getPiece(toRow, toColumn).getColor());
        } return false;
    }

    public void move(int fromRow, int fromColumn, int toRow, int toColumn){
            if(canMove(fromRow, fromColumn, toRow, toColumn)){
                Piece piece = getPiece(fromRow, fromColumn);
                setPiece(piece, toRow, toColumn);
                removePiece(fromRow, fromColumn);
            }
    }

    public void resetBoard(){
        setStartBoard();
    }

//            switch(getPiece(fromRow, fromColumn).getName()){
//                case "Pawn":
//
//                case "Knight":
//                    break;
//                case "Rook":
//                    break;
//                case "Bishop":
//                    break;
//                case "King":
//                    break;
//                case "Queen":
//                    break;
//                default:
//                    return false;
//            }
//            return true;
//        }
//        return false;

}
