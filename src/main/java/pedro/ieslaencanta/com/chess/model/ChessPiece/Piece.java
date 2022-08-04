/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.model.ChessPiece;

import java.util.logging.Level;
import java.util.logging.Logger;
import pedro.ieslaencanta.com.chess.model.Board;
import pedro.ieslaencanta.com.chess.model.Move;
import pedro.ieslaencanta.com.chess.model.Position;

/**
 *
 * @author Pedro
 */
public abstract class Piece {

    protected Position p;
    protected PieceType type;
    protected boolean alive;
    protected Move moves[];
    protected char letter;
    private String id;

    public Piece() {

    }

    public Piece(int row, int col) {
        this.p = new Position(row, col);
    }

    @Override
    public String toString() {
        return this.getId();
    }

    /**
     * Mueve una pieza a una posición del tablero, la comprobación se realiza en
     * canmove, no aqui
     *
     * @param board
     * @param row
     * @param col
     * @return devuelve un movimiento
     */
    public Move move(Board board, int row, int col) {
        Move move = null;
        Piece p = board.getCell(row, col).getPiece();
        move = new Move(this, p, this.p.clone(), new Position(row, col));
        return move;
    }

    protected Move[] getHorizontalMoves(Board b, int row, int start, int end) {
        Move m[] = new Move[7];
        boolean ocupado = false;
        int c = 0;
        //caso 1 start<end "Pieza arriba y buscamos hacia abajo"
        if (start < end) {
            for (int i = start; i <= end - 1 && !ocupado; i++) {
                if (i < 7) {
                    if (b.getCell(row, i + 1).getPiece() == null) {
                        m[c] = new Move(this, null, this.p.clone(), new Position(this.p.getRow(), this.p.getCol() + (c + 1)));
                        c++;

                    } else {
                        ocupado = true;
                        if (b.getCell(row, i + 1).getPiece().getType() != this.type) {
                            m[c] = new Move(this, b.getCell(row, i + 1).getPiece(), this.p.clone(), new Position(this.p.getRow(), this.p.getCol() + (c + 1)));
                            c++;
                        }
                    }
                }
            }
        }
        //caso 2 start>end "Pieza abajo y buscamos hacia arriba"
        if (start > end) {
            for (int i = start; i >= end + 1 && !ocupado; i--) {
                if (i > 0) {
                    if (b.getCell(row, i - 1).getPiece() == null) {
                        m[c] = new Move(this, null, this.p.clone(), new Position(this.p.getRow(), this.p.getCol() - (c + 1)));
                        c++;
                    } else {
                        ocupado = true;
                        if (b.getCell(row, i - 1).getPiece().getType() != this.type) {
                            m[c] = new Move(this, b.getCell(row, i - 1).getPiece(), this.p.clone(), new Position(this.p.getRow(), this.p.getCol() - (c + 1)));
                            c++;

                        }
                    }
                }
            }

        }

        return m;
    }

    protected Move[] getVertical(Board b, int col, int start, int end) {

        Move m[] = new Move[7];
        boolean ocup = false;
        int c = 0;
        //caso 1 start<end "Pieza arriba y buscamos hacia abajo"
        if (start < end) {
            for (int i = start; i <= end - 1 && !ocup; i++) {
                if (i < 7) {
                    if (b.getCell(i + 1, col).getPiece() == null) {
                        m[c] = new Move(this, null, this.p.clone(), new Position(this.p.getRow() + (c + 1), this.p.getCol()));
                        c++;

                    } else {
                        ocup = true;
                        if (b.getCell(i + 1, col).getPiece().getType() != this.type && this.letter != 'P') {
                            m[c] = new Move(this, b.getCell(i + 1, col).getPiece(), this.p.clone(), new Position(this.p.getRow() + (c + 1), this.p.getCol()));
                            c++;
                        }
                    }
                }
            }
        }
        //caso 2 start>end "Pieza abajo y buscamos hacia arriba"
        if (start > end) {
            for (int i = start; i >= end + 1 && !ocup; i--) {
                if (i > 0) {
                    if (b.getCell(i - 1, col).getPiece() == null) {
                        m[c] = new Move(this, null, this.p.clone(), new Position(this.p.getRow() - (c + 1), this.p.getCol()));
                        c++;
                    } else {
                        ocup = true;
                        if (b.getCell(i - 1, col).getPiece().getType() != this.type && this.letter != 'P') {
                            m[c] = new Move(this, b.getCell(i - 1, col).getPiece(), this.p.clone(), new Position(this.p.getRow() - (c + 1), this.p.getCol()));
                            c++;
                        }
                    }
                }
            }
        }

        return m;
    }

    /**
     *
     * @param b tablero
     * @param dirx si va hacia la izquierda o derecha
     * @param diry si va hacia arriba o hacia abajo
     * @return movimientos posibles en esa diagonal
     *
     * protected Move[] getDiagonal(Board b, int dirx, int diry) {
     *
     * return this.getDiagonal(b, dirx, diry, b.getHeight()); }
     */
    /**
     * Se ha de pasar la cantidad de celdas que quieres calcular +1 para que lo
     * calcule todo bien
     *
     * @param b tablero
     * @param dirx direccion de la diagonal en el eje x -1 izquierda, 1 derecha
     * @param diry direccionde la diagonal en el eje y -1 arriba, 1 abajo
     * @param lenght longitud máxima
     * @return
     */
    protected Move[] getDiagonal(Board b, int dirx, int diry, int lenght) {

        Move moves[] = new Move[24];
        boolean ocupado = false;
        int c = 0;
        // CASO 0 LA PIEZA Va Hacia Abajo a la derecha
        for (int i = 1; i < lenght && !ocupado; i++) {
            if (dirx == 1 && diry == 1) {
                if (p.clone().getRow() + i * dirx < 8 && p.clone().getCol() + i * diry < 8) {
                    if (b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece() == null && this.letter != 'P') {
                        moves[c] = new Move(this, null, this.p.clone(), new Position(this.p.getRow() + c + 1, this.p.getCol() + c + 1));
                        c++;

                    } else {
                        ocupado = true;
                        if (this.letter != 'P' && b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece().getType() != this.type) {
                            moves[c] = new Move(this, b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece(), this.p.clone(), new Position(this.p.getRow() + c + 1, this.p.getCol() + c + 1));
                            c++;
                        } else if (this.letter == 'P' &&b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece() != null&& b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece().getType() != this.type) {
                            moves[c] = new Move(this, b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece(), this.p.clone(), new Position(this.p.getRow() + c + 1, this.p.getCol() + c + 1));
                            c++;
                        }

                    }
                }
            }
            // CASO 1 LA PIEZA Va Hacia arrina a la izquierda
            if (dirx == -1 && diry == -1) {
                if (p.clone().getRow() + i * dirx >= 0 && p.clone().getCol() + i * diry >= 0) {
                    if (b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece() == null && this.letter != 'P') {
                        moves[c] = new Move(this, null, this.p.clone(), new Position(this.p.getRow() - c - 1, this.p.getCol() - c - 1));
                        c++;

                    } else {
                        ocupado = true;
                        if (this.letter != 'P' && b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece().getType() != this.type) {
                            moves[c] = new Move(this, b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece(), this.p.clone(), new Position(this.p.getRow() - c - 1, this.p.getCol() - c - 1));
                            c++;
                        } else if (this.letter == 'P' &&b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece() != null&& b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece().getType() != this.type) {
                            moves[c] = new Move(this, b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece(), this.p.clone(), new Position(this.p.getRow() - c - 1, this.p.getCol() - c - 1));
                            c++;
                        }
                    }
                }
            }

            if (dirx == 1 && diry == -1) {
                if (p.clone().getRow() + i * dirx < 8 && p.clone().getCol() + i * diry >= 0) {
                    if (b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece() == null && this.letter != 'P') {
                        moves[c] = new Move(this, null, this.p.clone(), new Position(this.p.getRow() + c + 1, this.p.getCol() - c - 1));
                        c++;

                    } else {
                        ocupado = true;
                        if (this.letter != 'P' && b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece().getType() != this.type) {
                            moves[c] = new Move(this, b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece(), this.p.clone(), new Position(this.p.getRow() + c + 1, this.p.getCol() - c - 1));
                            c++;
                        } else if (this.letter == 'P' &&b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece() != null&& b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece().getType() != this.type) {
                            moves[c] = new Move(this, b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece(), this.p.clone(), new Position(this.p.getRow() + c + 1, this.p.getCol() - c - 1));
                            c++;
                        }
                    }
                }
            }
            if (dirx == -1 && diry == 1) {
                if (p.clone().getRow() + i * dirx >= 0 && p.clone().getCol() + i * diry < 8) {
                    if (b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece() == null && this.letter != 'P') {
                        moves[c] = new Move(this, null, this.p.clone(), new Position(this.p.getRow() - c - 1, this.p.getCol() + c + 1));
                        c++;

                    } else {
                        ocupado = true;
                        if (this.letter != 'P' && b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece().getType() != this.type) {
                            moves[c] = new Move(this, b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece(), this.p.clone(), new Position(this.p.getRow() - c - 1, this.p.getCol() + c + 1));
                            c++;
                        } else if (this.letter == 'P' &&b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece() != null&& b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece().getType() != this.type) {
                            moves[c] = new Move(this, b.getCell(p.clone().getRow() + i * dirx, p.clone().getCol() + i * diry).getPiece(), this.p.clone(), new Position(this.p.getRow() - c - 1, this.p.getCol() + c + 1));
                            c++;
                        }
                    }
                }
            }
        }
        return moves;
    }

    public boolean canmove(Board board, int row, int col) {
        boolean vuelta = true;

        return vuelta;
    }

    public Move[] getCalculatedMoves() {
        return this.moves;
    }

    public abstract Move[] getMoves(Board board);

    /**
     * @return the letter
     */
    public char getLetter() {
        return letter;
    }

    /**
     * @param letter the letter to set
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * @return the p
     */
    public Position getPosition() {
        return p;
    }

    /**
     * @return the type
     */
    public PieceType getType() {
        return type;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param p the p to set
     */
    public void setPosition(Position p) {
        this.p = p;
    }

    /**
     * @param type the type to set
     */
    public void setType(PieceType type) {
        this.type = type;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = this.letter + ((this.getType() == PieceType.White) ? "W" : "B") + id;
    }

}
