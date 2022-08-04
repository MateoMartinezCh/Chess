/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.model;

import pedro.ieslaencanta.com.chess.model.ChessPiece.*;

/**
 *
 * @author Pedro
 */
public class Board {

    private Cell[][] cells;
    private King reyblanco;
    private King reynegro;

    public Board() {
        this.reset();
    }

    public void reset() {
        this.cells = new Cell[8][8];
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }
        this.cells[0][0].setPiece(new Rook(0, 0, PieceType.Black, true, "0"));
        this.cells[0][1].setPiece(new Knight(0, 1, PieceType.Black, true, "0"));
        this.cells[0][2].setPiece(new Bishop(0, 2, PieceType.Black, true, "0"));
        this.cells[0][3].setPiece(new Queen(0, 3, PieceType.Black, true, "0"));
        this.cells[0][4].setPiece(new King(0, 4, PieceType.Black, true, "0"));
        this.cells[0][5].setPiece(new Bishop(0, 5, PieceType.Black, true, "1"));
        this.cells[0][6].setPiece(new Knight(0, 6, PieceType.Black, true, "1"));
        this.cells[0][7].setPiece(new Rook(0, 7, PieceType.Black, true, "1"));
        this.cells[1][0].setPiece(new Pawn(1, 0, PieceType.Black, true, "0"));
        this.cells[1][1].setPiece(new Pawn(1, 1, PieceType.Black, true, "1"));
        this.cells[1][2].setPiece(new Pawn(1, 2, PieceType.Black, true, "2"));
        this.cells[1][3].setPiece(new Pawn(1, 3, PieceType.Black, true, "3"));
        this.cells[1][4].setPiece(new Pawn(1, 4, PieceType.Black, true, "4"));
        this.cells[1][5].setPiece(new Pawn(1, 5, PieceType.Black, true, "5"));
        this.cells[1][6].setPiece(new Pawn(1, 6, PieceType.Black, true, "6"));
        this.cells[1][7].setPiece(new Pawn(1, 7, PieceType.Black, true, "7"));
        this.cells[6][0].setPiece(new Pawn(6, 0, PieceType.White, true, "0"));
        this.cells[6][1].setPiece(new Pawn(6, 1, PieceType.White, true, "1"));
        this.cells[6][2].setPiece(new Pawn(6, 2, PieceType.White, true, "2"));
        this.cells[6][3].setPiece(new Pawn(6, 3, PieceType.White, true, "3"));
        this.cells[6][4].setPiece(new Pawn(6, 4, PieceType.White, true, "4"));
        this.cells[6][5].setPiece(new Pawn(6, 5, PieceType.White, true, "5"));
        this.cells[6][6].setPiece(new Pawn(6, 6, PieceType.White, true, "6"));
        this.cells[6][7].setPiece(new Pawn(6, 7, PieceType.White, true, "7"));
        this.cells[7][0].setPiece(new Rook(7, 0, PieceType.White, true, "0"));
        this.cells[7][1].setPiece(new Knight(7, 1, PieceType.White, true, "0"));
        this.cells[7][2].setPiece(new Bishop(7, 2, PieceType.White, true, "0"));
        this.cells[7][3].setPiece(new Queen(7, 3, PieceType.White, true, "1"));
        this.cells[7][4].setPiece(new King(7, 4, PieceType.White, true, "1"));
        this.cells[7][5].setPiece(new Bishop(7, 5, PieceType.White, true, "1"));
        this.cells[7][6].setPiece(new Knight(7, 6, PieceType.White, true, "1"));
        this.cells[7][7].setPiece(new Rook(7, 7, PieceType.White, true, "0"));
        this.reyblanco = (King) this.getCell(7, 4).getPiece();
        this.reynegro = (King) this.getCell(0, 4).getPiece();
    }

    public Cell getCell(int row, int col) {
        return this.cells[row][col];
    }  

    public int getHeight() {
        return this.cells.length;
    }

    public int getWidht() {
        return this.cells[0].length;
    }

    public Move move(int star_row, int star_col, int end_row, int end_col) {
        Piece p = this.cells[star_row][star_col].getPiece();
        Move m = null;
            if (p != null) {
                m = p.move(this, end_row, end_col);
                this.cells[star_row][star_col].setPiece(null);
                this.cells[end_row][end_col].setPiece(p);
                System.out.println(this);
            }
        
        return m;
    }

    @Override
    public String toString() {
        StringBuffer vuelta = new StringBuffer();
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[i].length; j++) {
                vuelta.append(this.cells[i][j].toString());
            }
            vuelta.append("\n");
        }
        return vuelta.toString();
    }

    /**
     * @return the reyblanco
     */
    public King getReyblanco() {
        return reyblanco;
    }

    /**
     * @param reyblanco the reyblanco to set
     */
    public void setReyblanco(King reyblanco) {
        this.reyblanco = reyblanco;
    }

    /**
     * @return the reynegro
     */
    public King getReynegro() {
        return reynegro;
    }

    /**
     * @param reynegro the reynegro to set
     */
    public void setReynegro(King reynegro) {
        this.reynegro = reynegro;
    }

}
