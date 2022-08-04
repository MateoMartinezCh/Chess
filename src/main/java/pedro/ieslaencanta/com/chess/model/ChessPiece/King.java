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
public class King extends Piece {

    boolean used;
    private boolean enrocado;

    public King() {
        super();
        this.letter = 'K';
        this.used = false;
        this.enrocado = false;
    }

    public King(int row, int col, PieceType tipo, boolean vivo, String id) {
        super(row, col);
        this.type = tipo;
        this.alive = vivo;
        this.letter = 'K';
        this.setId(id);
        this.used = false;
        this.enrocado = false;
    }

    @Override
    public Move[] getMoves(Board board) {
        this.moves = new Move[12];
        Move tempo[];
        int c = 0;
        tempo = this.getHorizontalMoves(board, this.p.getRow(), this.p.getCol(), this.p.getCol() + 1);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        tempo = this.getHorizontalMoves(board, this.p.getRow(), this.p.getCol(), this.p.getCol() - 1);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        tempo = this.getVertical(board, this.p.getCol(), this.p.getRow(), this.p.getRow() + 1);
        for (int i = 0; i < tempo.length; i++) {

            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        tempo = this.getVertical(board, this.p.getCol(), this.p.getRow(), this.p.getRow() - 1);
        for (int i = 0; i < tempo.length; i++) {

            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        tempo = this.getDiagonal(board, 1, 1, 2);
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
        tempo = this.getDiagonal(board, 1, -1, 2);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        tempo = this.getDiagonal(board, -1, 1, 2);
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] != null) {
                this.moves[c] = tempo[i];
                c++;
            }
        }
        if (this.p.getCol() != 4) {
            used = true;
        }
        if (!used && this.p.clone().getCol() == 4) {

            if (board.getCell(this.p.clone().getRow(), this.p.clone().getCol() + 1).getPiece() == null
                    && board.getCell(this.p.clone().getRow(), this.p.clone().getCol() + 2).getPiece() == null
                    && board.getCell(this.p.clone().getRow(), this.p.clone().getCol() + 3).getPiece() != null
                    && board.getCell(this.p.clone().getRow(), this.p.clone().getCol() + 3).getPiece().getLetter() == 'R') {
                moves[c] = new Move(this, null, p.clone(), new Position(this.p.clone().getRow(), this.p.clone().getCol() + 2));
                c++;
            }
            if (board.getCell(this.p.clone().getRow(), this.p.clone().getCol() - 1).getPiece() == null
                    && board.getCell(this.p.clone().getRow(), this.p.clone().getCol() - 2).getPiece() == null
                    && board.getCell(this.p.clone().getRow(), this.p.clone().getCol() - 3).getPiece() == null
                    && board.getCell(this.p.clone().getRow(), this.p.clone().getCol() - 4).getPiece() != null
                    && board.getCell(this.p.clone().getRow(), this.p.clone().getCol() -4).getPiece().getLetter() == 'R') {

                moves[c] = new Move(this, null, p.clone(), new Position(this.p.clone().getRow(), this.p.clone().getCol() - 2));
                c++;
            }
        }
        return this.moves;

    }

    /**
     * @return the enrocado
     */
    public boolean isEnrocado() {
        return enrocado;
    }

    /**
     * @param enrocado the enrocado to set
     */
    public void setEnrocado(boolean enrocado) {
        this.enrocado = enrocado;
    }

}
