package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ChessBoardTest {



        ChessBoard board = new ChessBoard();

        @Test
        void testSetPiece(){
            Piece testKnight = new Piece("Knight", "black");
            board.placePiece(testKnight, 2, 2);
            assertEquals(testKnight, board.getPiece(2, 2));
        }

        @Test
        void testGetPiece() {
        Piece a = board.getPiece(3,3);
        Piece b = board.getPiece(-1, -1);
        Piece c = board.getPiece(0, 2);
        Piece d = board.getPiece(8, 8);


        //then
        assertNull(a);
        assertNull(b);
        assertNull(d);
        assertEquals( c , board.getPiece(0, 2));
        assertEquals("Knight 0", board.getPiece(0, 1).getName());
        assertEquals( "white" , board.getPiece(0, 1).getColor());
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
        void testMove(){
            //given


            //when
            board.move(1,3, 2,3);
            board.move(0,1, 2,3);

            //then
            assertEquals("Pawn", board.getPiece(2, 3).getName());
            assertNull(board.getPiece(1, 3));
            assertEquals("Knight", board.getPiece(0, 1).getName());

        }
}