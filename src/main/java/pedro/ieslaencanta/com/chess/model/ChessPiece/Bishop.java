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
public class Bishop extends Piece {

    public Bishop() {
        super();
        this.letter = 'B';
    }

    public Bishop(int row, int col, PieceType tipo, boolean vivo, String id) {
        super(row, col);
        this.type = tipo;
        this.alive = vivo;
        this.letter = 'B';
        this.setId(id);
    }

    @Override
    public Move[] getMoves(Board board) {
        this.moves = new Move[15];
        Move tempo[];
        int c = 0;
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
