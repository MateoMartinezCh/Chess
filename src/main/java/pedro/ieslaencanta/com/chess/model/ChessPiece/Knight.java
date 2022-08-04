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
public class Knight extends Piece {

    public Knight() {
        super();
        this.letter = 'N';
    }

    public Knight(int row, int col, PieceType tipo, boolean vivo, String id) {
        super(row, col);
        this.type = tipo;
        this.alive = vivo;
        this.letter = 'N';
        this.setId(id);
    }

    @Override
    public Move[] getMoves(Board board) {
        Move[] tempo = new Move[8];
        if (this.p.clone().getRow() + 2 < 8
                && this.p.clone().getRow() + 2 >= 0
                && this.p.clone().getCol() + 1 < 8
                && this.p.clone().getCol() + 1 >= 0) {

            if (board.getCell(this.p.clone().getRow() + 2, this.p.clone().getCol() + 1).getPiece() == null) {
                tempo[0] = new Move(this, null, p.clone(), new Position(this.p.clone().getRow() + 2, this.p.clone().getCol() + 1));
            } else {
                if (board.getCell(this.p.clone().getRow() + 2, this.p.clone().getCol() + 1).getPiece().getType() != this.type) {
                    tempo[0] = new Move(this, board.getCell(this.p.clone().getRow() + 2, this.p.clone().getCol() + 1).getPiece(), p.clone(), new Position(this.p.clone().getRow() + 2, this.p.clone().getCol() + 1));
                }
            }
        }
        if (this.p.clone().getRow() + 2 < 8
                && this.p.clone().getRow() + 2 >= 0
                && this.p.clone().getCol() - 1 < 8
                && this.p.clone().getCol() - 1 >= 0) {
            if (board.getCell(this.p.clone().getRow() + 2, this.p.clone().getCol() - 1).getPiece() == null) {
                tempo[1] = new Move(this, null, p.clone(), new Position(this.p.clone().getRow() + 2, this.p.clone().getCol() - 1));
            } else {
                if (board.getCell(this.p.clone().getRow() + 2, this.p.clone().getCol() - 1).getPiece().getType() != this.type) {
                    tempo[1] = new Move(this, board.getCell(this.p.clone().getRow() + 2, this.p.clone().getCol() - 1).getPiece(), p.clone(), new Position(this.p.clone().getRow() + 2, this.p.clone().getCol() - 1));
                }
            }
        }
        if (this.p.clone().getRow() + 1 < 8
                && this.p.clone().getRow() + 1 >= 0
                && this.p.clone().getCol() + 2 < 8
                && this.p.clone().getCol() + 2 >= 0) {
            if (board.getCell(this.p.clone().getRow() + 1, this.p.clone().getCol() + 2).getPiece() == null) {
                tempo[2] = new Move(this, null, p.clone(), new Position(this.p.clone().getRow() + 1, this.p.clone().getCol() + 2));
            } else {
                if (board.getCell(this.p.clone().getRow() + 1, this.p.clone().getCol() + 2).getPiece().getType() != this.type) {
                    tempo[2] = new Move(this, board.getCell(this.p.clone().getRow() + 1, this.p.clone().getCol() + 2).getPiece(), p.clone(), new Position(this.p.clone().getRow() + 1, this.p.clone().getCol() + 2));
                }
            }
        }
        if (this.p.clone().getRow() + 1 < 8
                && this.p.clone().getRow() + 1 >= 0
                && this.p.clone().getCol() - 2 < 8
                && this.p.clone().getCol() - 2 >= 0) {
            if (board.getCell(this.p.clone().getRow() + 1, this.p.clone().getCol() - 2).getPiece() == null) {
                tempo[3] = new Move(this, null, p.clone(), new Position(this.p.clone().getRow() + 1, this.p.clone().getCol() - 2));
            } else {
                if (board.getCell(this.p.clone().getRow() + 1, this.p.clone().getCol() - 2).getPiece().getType() != this.type) {
                    tempo[3] = new Move(this, board.getCell(this.p.clone().getRow() + 1, this.p.clone().getCol() - 2).getPiece(), p.clone(), new Position(this.p.clone().getRow() + 1, this.p.clone().getCol() - 2));

                }
            }
        }
        if (this.p.clone().getRow() - 2 < 8
                && this.p.clone().getRow() - 2 >= 0
                && this.p.clone().getCol() - 1 < 8
                && this.p.clone().getCol() - 1 >= 0) {
            if (board.getCell(this.p.clone().getRow() - 2, this.p.clone().getCol() - 1).getPiece() == null) {
                tempo[4] = new Move(this, null, p.clone(), new Position(this.p.clone().getRow() - 2, this.p.clone().getCol() - 1));
            } else {
                if (board.getCell(this.p.clone().getRow() - 2, this.p.clone().getCol() - 1).getPiece().getType() != this.type) {
                    tempo[4] = new Move(this, board.getCell(this.p.clone().getRow() - 2, this.p.clone().getCol() - 1).getPiece(), p.clone(), new Position(this.p.clone().getRow() - 2, this.p.clone().getCol() - 1));
                }
            }
        }
        if (this.p.clone().getRow() - 2 < 8
                && this.p.clone().getRow() - 2 >= 0
                && this.p.clone().getCol() + 1 < 8
                && this.p.clone().getCol() + 1 >= 0) {
            if (board.getCell(this.p.clone().getRow() - 2, this.p.clone().getCol() + 1).getPiece() == null) {
                tempo[5] = new Move(this, null, p.clone(), new Position(this.p.clone().getRow() - 2, this.p.clone().getCol() + 1));
            } else {
                if (board.getCell(this.p.clone().getRow() - 2, this.p.clone().getCol() + 1).getPiece().getType() != this.type) {
                    tempo[5] = new Move(this, board.getCell(this.p.clone().getRow() - 2, this.p.clone().getCol() + 1).getPiece(), p.clone(), new Position(this.p.clone().getRow() - 2, this.p.clone().getCol() + 1));
                }
            }
        }
        if (this.p.clone().getRow() - 1 < 8
                && this.p.clone().getRow() - 1 >= 0
                && this.p.clone().getCol() - 2 < 8
                && this.p.clone().getCol() - 2 >= 0) {
            if (board.getCell(this.p.clone().getRow() - 1, this.p.clone().getCol() - 2).getPiece() == null) {
                tempo[6] = new Move(this, null, p.clone(), new Position(this.p.clone().getRow() - 1, this.p.clone().getCol() - 2));
            } else {
                if (board.getCell(this.p.clone().getRow() - 1, this.p.clone().getCol() - 2).getPiece().getType() != this.type) {
                    tempo[6] = new Move(this, board.getCell(this.p.clone().getRow() - 1, this.p.clone().getCol() - 2).getPiece(), p.clone(), new Position(this.p.clone().getRow() - 1, this.p.clone().getCol() - 2));
                }
            }
        }
        if (this.p.clone().getRow() - 1 < 8
                && this.p.clone().getRow() - 1 >= 0
                && this.p.clone().getCol() + 2 < 8
                && this.p.clone().getCol() + 2 >= 0) {
            if (board.getCell(this.p.clone().getRow() - 1, this.p.clone().getCol() + 2).getPiece() == null) {
                tempo[7] = new Move(this, null, p.clone(), new Position(this.p.clone().getRow() - 1, this.p.clone().getCol() + 2));
            } else {
                if (board.getCell(this.p.clone().getRow() - 1, this.p.clone().getCol() + 2).getPiece().getType() != this.type) {
                    tempo[7] = new Move(this, board.getCell(this.p.clone().getRow() - 1, this.p.clone().getCol() + 2).getPiece(), p.clone(), new Position(this.p.clone().getRow() - 1, this.p.clone().getCol() + 2));
                }
            }
        }
        return tempo;
    }
}
