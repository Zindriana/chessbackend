package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ChessBoardTest {



        ChessBoard board = new ChessBoard();

        @Test
        void testSetPiece(){
            Piece testKnight = new Piece("Knight", "black");
            board.setPiece(testKnight, 2, 2);
            assertEquals(testKnight, board.getPiece(2, 2));
        }

        @Test
        void testGetPiece() {
        Piece a = board.getPiece(3,3);
        Piece b = board.getPiece(-1, -1);
        Piece c = board.getPiece(0, 2);
        Piece d = board.getPiece(8, 8);
        //Piece e = board.getPiece(0, 3);


        //then
        assertNull(a);
        assertNull(b);
        assertNull(d);
        assertEquals( c , board.getPiece(0, 2));
        assertEquals("Knight", board.getPiece(0, 1).getName());
        assertEquals( "white" , board.getPiece(0, 1).getColor());
        //assertEquals( "Queen" , board.getPiece(0, 3).getName());
        assertNull(board.getPiece(3, 3));
        assertNull(board.getPiece(5, 5));

        }

        @Test
        void testCanMove(){
            boolean move1 = board.canMove(0,0, 3,3);
            boolean move2 = board.canMove(1,0, 1,2);
            boolean move3 = board.canMove(3,3, 5,5);
            boolean move4 = board.canMove(-1,-1, 1,2);
            boolean move5 = board.canMove(6,0, 1,2);
                assertTrue(move1);
                assertFalse(move2);
                assertFalse(move3);
                assertFalse(move4);
                assertTrue(move5);
        }

        @Test
        void testRemovePiece(){
            //given
            board.setPiece(new Piece("Rook", "black"), 5, 5);

            //when
            board.removePiece(5,5);
            board.removePiece(4,4);

            //then
            assertNull(board.getPiece(5,5));
            assertNull(board.getPiece(4,4));
        }

        @Test
        void testMove(){
            //given
            Piece piece1 = board.getPiece(1,3); // it is a pawn at the beginning of the game
            Piece piece2 = board.getPiece(0,1); //it is a knight at the beginning of the game
            Piece piece3 = board.getPiece(7,7); //it is a rook at the beginning of the game
            Piece piece4 = board.getPiece(3,3); //it is null at the beginning of the
            //Piece piece5 = board.getPiece(0,3); //it is a queen at the beginning of the game

            //when
            board.move(1,3, 2,3);
            board.move(0,1, 2,3);
            board.move(7, 7, 1, 1);
            board.move(3, 3, 4, 4);
            board.move(0,3, 2, 4);

            //then
            assertEquals(piece1.getName(), board.getPiece(2, 3).getName());
            assertNull(board.getPiece(1, 3));
            assertEquals(piece2, board.getPiece(0, 1));
            assertEquals(piece3, board.getPiece(1, 1));
            assertEquals(piece3.getColor(), board.getPiece(1, 1).getColor());
            assertNull(piece4);
            assertNull(board.getPiece(4, 4));
        }

        @Test
        void testResetBoard(){
            //given
            Piece piece5 = board.getPiece(0,3); //it is a queen at the beginning of the game
            board.move(0,3, 2, 4);

            //when
            board.resetBoard();

            //then
            assertEquals(piece5.getName(), board.getPiece(0,3).getName());

        }


}