/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.ChessPiece.King;

import pedro.ieslaencanta.com.chess.model.ChessPiece.Piece;
import pedro.ieslaencanta.com.chess.model.ChessPiece.PieceType;

import pedro.ieslaencanta.com.chess.model.Move;
import pedro.ieslaencanta.com.chess.model.Position;

/**
 *
 * @author Pedro
 */
public class Game {

    private Board board;
    private PieceType turno;

    public Game() {
        this.board = new Board();
        this.turno = PieceType.White;
    }

    public boolean enroque(int i, PieceType tipo) {
        Piece tempo = null;
        tempo = this.board.getCell(5, 7).getPiece();
        this.board.getCell(5, 7).setPiece(null);
        this.board.getCell(5, 7).setPiece(tempo);
        this.board.getCell(5, 7).getPiece().setPosition(new Position(5, 5));
        return true;
    }

    /**
     * Mover una pieza si existe en la posición y es del turno
     *
     * @param startrow
     * @param startcol
     * @param endrow
     * @param endcol
     * @return
     */
    public Move move(int startrow, int startcol, int endrow, int endcol) {
        Move m = null;
        m = board.move(startrow, startcol, endrow, endcol);
        board.getCell(endrow, endcol).getPiece().setPosition(new Position(endrow, endcol));

        if (this.turno == PieceType.White) {
            setTurno(PieceType.Black);
        } else if (this.turno == PieceType.Black) {
            setTurno(PieceType.White);
        }
        return m;
    }

    /**
     * indica si alguna de las piezas se encuentra en posicion de dar jaque
     *
     *
     * @return movimiento que hace que el rey este en mate
     */
    public Move[] Jaque() {
        Move[] moves = null;
        moves = new Move[9];
        int c = 0;
        if (this.board != null) {
            for (int i = 0; i < this.board.getHeight(); i++) {
                for (int j = 0; j < this.board.getWidht(); j++) {
                    if (this.board.getCell(i, j).getPiece() != null && this.board.getCell(i, j).getPiece().getMoves(board) != null) {
                        for (int k = 0; k < this.board.getCell(i, j).getPiece().getMoves(board).length; k++) {
                            if (this.board.getCell(i, j).getPiece().getMoves(board)[k] != null && this.board.getCell(i, j).getPiece().getMoves(board)[k].getReplaced() == board.getReyblanco()) {
                                System.out.println("Movimiento " + this.board.getCell(i, j).getPiece().getMoves(board)[k].toString() + " hace jaque");
                                moves[c] = this.board.getCell(i, j).getPiece().getMoves(board)[k];
                                c++;
                            } else if (this.board.getCell(i, j).getPiece().getMoves(board)[k] != null && this.board.getCell(i, j).getPiece().getMoves(board)[k].getReplaced() == board.getReynegro()) {
                                System.out.println("Movimiento " + this.board.getCell(i, j).getPiece().getMoves(board)[k].toString() + " hace jaque");
                                moves[c] = this.board.getCell(i, j).getPiece().getMoves(board)[k];
                                c++;
                            }
                        }
                        // System.out.println(this.board.getCell(i, j).getPiece().getMoves(board));
                    }
                }
            }
        }
        if (c <= 0) {
            moves = null;
        }
        return moves;

    }

    /**
     * Si el rey que se le pasa esta en jaque
     *
     * @param rey
     * @return
     */
    /*
    private boolean IsJaque(Piece rey) {
        boolean vuelta = false;
        if (this.board != null) {
            for (int i = 0; i < this.board.getHeight(); i++) {
                for (int j = 0; j < this.board.getWidht(); j++) {
                    if (this.board.getCell(i, j).getPiece() != null && this.board.getCell(i, j).getPiece().getMoves(board) != null) {
                        for (int k = 0; k < this.board.getCell(i, j).getPiece().getMoves(board).length; k++) {
                            if (this.board.getCell(i, j).getPiece().getMoves(board)[k] != null && this.board.getCell(i, j).getPiece().getMoves(board)[k].getReplaced() == rey) {
                                System.out.println("Le hacen jaque a el rey de color: " + rey.getType() + " Con la pieza: " + this.board.getCell(i, j).getPiece());
                                vuelta = true;
                            }
                        }
                        // System.out.println(this.board.getCell(i, j).getPiece().getMoves(board));
                    }
                }
            }
        }
        return vuelta;
    }
     */
    /**
     * Si el movimiento del rey que se le pasa esta en jaque
     *
     * @param rey
     * @return
     *//*
    private boolean Kingcanmove(Move m, King king) {
        boolean vuelta = false;
        if (this.board != null) {
            for (int i = 0; i < this.board.getHeight(); i++) {
                for (int j = 0; j < this.board.getWidht(); j++) {
                    if (this.board.getCell(i, j).getPiece() != null && this.board.getCell(i, j).getPiece().getType() != king.getType() && this.board.getCell(i, j).getPiece().getMoves(board) != null) {
                        for (int k = 0; k < this.board.getCell(i, j).getPiece().getMoves(board).length; k++) {
                            if (this.board.getCell(i, j).getPiece().getMoves(board)[k] != null && this.board.getCell(i, j).getPiece().getMoves(board)[k].getEnd() == m.getEnd()) {
                                System.out.println("ESTE " + this.board.getCell(i, j).getPiece().getMoves(board)[k]);
                                vuelta = true;
                            }
                        }
                        // System.out.println(this.board.getCell(i, j).getPiece().getMoves(board));
                    }
                }
            }
        }
        return vuelta;
    }
*/
    /**
     * Se comprueba jaquemate si antes es jaque y se le pasa el color de la
     * última jugada y comprueba para el rey contrario
     *
     * @return si al rey se le hace mate y ya no se puede mover
     */
    public boolean JaqueMate(PieceType type) {
        //es jaque mientras no pueda hacer algun movimiento
        //vuelta false si libre, true si muere
        /*
        King reyacomprobar;
        Move[] movimientosdelrey;
        Move[] movimientosposiblesdelrey = new Move[9];
        int contadormovimientosposiblesdelrey = 0;
        boolean vuelta = false;
        if (type == board.getReyblanco().getType()) {
            reyacomprobar = board.getReyblanco();
            System.out.println("Estoy comprobando al rey -> " + reyacomprobar + " que está en " + reyacomprobar.getPosition());
        } else {
            reyacomprobar = board.getReynegro();
            System.out.println("Estoy comprobando al rey -> " + reyacomprobar + " que está en " + reyacomprobar.getPosition());
        }
        movimientosdelrey = reyacomprobar.getMoves(board);

        for (int i = 0; i < movimientosdelrey.length; i++) {
            if (movimientosdelrey[i] != null) {
                movimientosposiblesdelrey[contadormovimientosposiblesdelrey] = movimientosdelrey[i];
                contadormovimientosposiblesdelrey++;

            }
        }
        for (int i = 0; i < movimientosposiblesdelrey.length; i++) {
            if (movimientosposiblesdelrey[i] != null) {
                if (Kingcanmove(movimientosposiblesdelrey[i], reyacomprobar)) {
                    movimientosdelrey[i] = null;
                    contadormovimientosposiblesdelrey--;
                }
            }
        }

        if (contadormovimientosposiblesdelrey <= 0) {
            Piece piezaquenecesitomatarparasalvaralrey = null;
            if (this.board != null) {
                for (int i = 0; i < this.board.getHeight(); i++) {
                    for (int j = 0; j < this.board.getWidht(); j++) {
                        if (this.board.getCell(i, j).getPiece() != null && this.board.getCell(i, j).getPiece().getMoves(board) != null) {
                            for (int k = 0; k < this.board.getCell(i, j).getPiece().getMoves(board).length; k++) {
                                if (this.board.getCell(i, j).getPiece().getMoves(board)[k] != null && this.board.getCell(i, j).getPiece().getMoves(board)[k].getReplaced() == reyacomprobar) {
                                    piezaquenecesitomatarparasalvaralrey = this.board.getCell(i, j).getPiece();
                                    if (IsJaque(piezaquenecesitomatarparasalvaralrey)) {
                                        vuelta = false;
                                    } else {
                                        vuelta = true;
                                    }
                                }
                            }
                            // System.out.println(this.board.getCell(i, j).getPiece().getMoves(board));
                        }
                    }
                }
            }
        }*/
        return false;
    }

    /**
     * Si una ficha se puede mover o no a partir de las coordenadas
     *
     * @param startrow
     * @param startcol
     * @param endrow
     * @param endcol
     * @return
     */
    public boolean canMove(int startrow, int startcol, int endrow, int endcol) {
        boolean vuelta = false;
        Move[] m;
        Piece p = board.getCell(startrow, startcol).getPiece();
        if (p != null && p.getType() == this.turno) {
            //Aquí calculated moves
            m = p.getMoves(board);
            for (int i = 0; i < m.length && !vuelta; i++) {
                if (m[i] != null
                        && m[i].getEnd().getCol() == endcol
                        && m[i].getEnd().getRow() == endrow) {
                    vuelta = true;
                }
            }
        }

        return vuelta;
    }

    /**
     * Para una celda devuelve los movimientos calculados de esa celda de estar
     * una pieza en ella
     *
     * @param row
     * @param col
     * @return movimientos posibles
     * @see pedro.ieslaencanta.com.chess.model.Move
     */
    //esto se podrá implementar más adelante
    public Move[] getCalculatesMoves(int row, int col) {
        Move m[] = this.getMoves(row, col);
        if (board.getCell(row, col) != null) {
            m = this.board.getCell(row, col).getPiece().getMoves(this.board);
        }
        return m;
    }

    /**
     * Calcula y devuelve los movimeintos posibles para esa figura si en la
     * celda se encuentra una figura, los movimientos se quedan almacenados en
     * la figura
     *
     * @param row
     * @param col
     * @return Movimientos posibles
     * @see pedro.ieslaencanta.com.chess.model.Move
     */
    public Move[] getMoves(int row, int col) {
        Move m[] = null;
        if (board.getCell(row, col) != null) {
            m = this.board.getCell(row, col).getPiece().getMoves(this.board);
        }

        return m;
    }

    public void reset() {
        this.board.reset();
    }

    public PieceType getPieceType(int row, int col) {
        PieceType pt = this.board.getCell(row, col).getPiece().getType();

        return pt;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return the turno
     */
    public PieceType getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(PieceType turno) {
        this.turno = turno;
    }

}
