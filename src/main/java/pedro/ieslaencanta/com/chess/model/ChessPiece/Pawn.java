/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedro.ieslaencanta.com.chess.model.ChessPiece;

import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.Move;
import pedro.ieslaencanta.com.chess.model.Position;

/**
 *
 * @author Mateo
 */
public class Pawn extends Piece {

    boolean used;

    public Pawn() {
        super();
        this.letter = 'P';
        this.used = false;
    }

    public Pawn(int row, int col, PieceType tipo, boolean vivo, String id) {
        super(row, col);
        this.type = tipo;
        this.alive = vivo;
        this.letter = 'P';
        this.used = false;
        this.setId(id);
    }

    @Override
    public Move[] getMoves(Board board) {
        this.moves = new Move[30];
        Move tempo[];
        int c = 0;
        if (this.type == PieceType.Black) {
            tempo = this.getVertical(board, this.p.getCol(), this.p.getRow(), this.p.getRow() + 1);
            for (int i = 0; i < tempo.length; i++) {

                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }
            if (this.p.getRow() != 1) {
                used = true;
            }
            if (!used) {
                tempo = this.getVertical(board, this.p.getCol(), this.p.getRow(), this.p.getRow() + 2);
                for (int i = 0; i < tempo.length; i++) {

                    if (tempo[i] != null) {
                        this.moves[c] = tempo[i];
                        c++;
                    }
                }

            }

            tempo = this.getDiagonal(board, 1, 1, 2);
            for (int i = 0; i < tempo.length; i++) {
                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }

            tempo = this.getDiagonal(board, 1, -1, 2);
            for (int i = 0; i < tempo.length; i++) {
                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }

        } else {
            tempo = this.getVertical(board, this.p.getCol(), this.p.getRow(), this.p.getRow() - 1);
            for (int i = 0; i < tempo.length; i++) {

                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }
            if (this.p.getRow() != 6) {
                used = true;
            }
            if (!used) {
                tempo = this.getVertical(board, this.p.getCol(), this.p.getRow(), this.p.getRow() - 2);
                for (int i = 0; i < tempo.length; i++) {

                    if (tempo[i] != null) {
                        this.moves[c] = tempo[i];
                        c++;
                    }
                }

            }

            tempo = this.getDiagonal(board, -1, 1, 2);
            for (int i = 0; i < tempo.length; i++) {
                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }
            tempo = this.getDiagonal(board, -1, -1, 2);
            for (int i = 0; i < tempo.length; i++) {
                if (tempo[i] != null) {
                    this.moves[c] = tempo[i];
                    c++;
                }
            }
        }

        return this.moves;
        /*if (this.p.getRow() == 0) {
            System.out.println("Transformaciónnnnn de id --> " + board.getCell(p.getRow(), p.getCol()).getPiece().getId());
            board.getCell(p.getRow(), p.getCol()).getPiece().reinaId("QW1");
            System.out.println(board.getCell(p.getRow(), p.getCol()).getPiece().getId());
        }
        //tempo=this.getVertical(board, p.getCol(),p.getRow(), p.clone().getRow()+1);
        return tempo;*/
    }
}
