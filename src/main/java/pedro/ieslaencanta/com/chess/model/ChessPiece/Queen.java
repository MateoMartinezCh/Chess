/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedro.ieslaencanta.com.chess.model.ChessPiece;

import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.Move;

/**
 *
 * @author Mateo
 */
public class Queen extends Piece {

    public Queen() {
        super();
        this.letter = 'Q';
    }

    public Queen(int row, int col, PieceType tipo, boolean vivo, String id) {
        super(row, col);
        this.type = tipo;
        this.alive = vivo;
        this.letter = 'Q';
        this.setId(id);
    }

    @Override
    public Move[] getMoves(Board board) {
        this.moves = new Move[30];
        Move tempo[];
        int c = 0;
        tempo = this.getHorizontalMoves(board, this.p.getRow(), this.p.getCol(), 0);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        tempo = this.getHorizontalMoves(board, this.p.getRow(), this.p.getCol(), 7);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        tempo = this.getVertical(board, this.p.getCol(), this.p.getRow(), 7);
        for (int i = 0; i < tempo.length; i++) {

            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        tempo = this.getVertical(board, this.p.getCol(), this.p.getRow(), 0);
        for (int i = 0; i < tempo.length; i++) {
            //System.out.println("Tempo " + i + "--> " + tempo[i]);

            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        tempo = this.getDiagonal(board, 1, 1, 8);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        tempo = this.getDiagonal(board, -1, -1, 8);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        tempo = this.getDiagonal(board, 1, -1, 8);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        tempo = this.getDiagonal(board, -1, 1, 8);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        return this.moves;
    }
}
