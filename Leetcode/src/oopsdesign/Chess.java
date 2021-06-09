package src.oopsdesign;

import java.util.List;

public class Chess {
}


 enum GameStatus {
    ACTIVE, BLACK_WIN, WHITE_WIN, FORFEIT, STALEMATE, RESIGNATION
}

enum AccountStatus2 {
    ACTIVE, CLOSED, CANCELED, BLACKLISTED, NONE
}

 class Address2 {
     private String streetAddress;
     private String city;
     private String state;
     private String zipcode;
     private String country;
 }


class Person2 {
    private String name;
    private Address address;
    private String email;
    private String phone;
}

abstract class Piece{
    private boolean killed=false;
    private boolean white = false;


    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public abstract boolean canMove(Board board, Box start, Box end);
}

class Box{

    private Piece piece;
    private int x;
    private int y;

    public Box(Piece piece, int x, int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}


class King extends Piece{
    private boolean castlingDone = false;

    public King(boolean killed, boolean white) {
        super(white);
    }

    public boolean isCastlingDone(){
        return this.castlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if(end.getPiece().isWhite() == this.isWhite())
            return false;

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x+y == 1) return true; //Check if this move won't result in king being attacked

        return this.isValidCastling(board,start,end);
    }

    private boolean isValidCastling(Board board, Box start, Box end) {
        if(this.isCastlingDone()) return false;

        // Check for the white king castling
        //Castling rules
        return true;
    }

    public boolean isCastlingMove(Box start, Box end){
        return true;
    }
}

class Knight extends Piece{

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {

        if(end.getPiece().isWhite() && this.isWhite()) return false;  //Same color

        int x = Math.abs(start.getX()-end.getX());
        int y = Math.abs(start.getY()-end.getY());
        return x*y ==2;
    }
}

class Board{
    Box[][] board;

    Board(){
        this.resetBoard();
    }

    public Box getBox(int x, int y){
        if(x < 0 || y < 0 || x > 7 || y > 7 ){
            //error
        }
        return board[x][y];
    }

    void resetBoard(){
        //initialize everything again
    }
}

class Player2 extends Account{
    private Person2 person;
    private boolean whiteSide = false;

    public Player2(Person2 person, boolean whiteSide) {
        this.person = person;
        this.whiteSide = whiteSide;
    }

    public boolean isWhiteSide(){
        return this.whiteSide;
    }
}


class Move{
    private Player2 player;
    private Box start;
    private Box end;
    private Piece pieceMoved;
    private Piece pieceKilled;
    private boolean castlingMove = false;

    public Move(Player2 player, Box start, Box end) {
        this.player = player;
        this.start = start;
        this.end = end;
    }

    public boolean isCastlingMove() {
        return castlingMove;
    }

    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }

    public Box getStart() {
        return start;
    }

    public Box getEnd() {
        return end;
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }
}

class Game{
    private Player2[] players;
    private Board board;
    private Player2 currentPlayer;
    private GameStatus gameStatus;
    private List<Move> movesPlayed;

    public Game() {
        players = new Player2[2];
    }

    public void initialize(Player2 p1, Player2 p2){
        players[0] = p1;
        players[1] = p2;

        board.resetBoard();

        if(p1.isWhiteSide()) this.currentPlayer = p1;
        else this.currentPlayer = p2;

        movesPlayed.clear();
    }

    public boolean isEnd(){
      return this.gameStatus != GameStatus.ACTIVE;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean playerMove(Player2 player, int startX, int startY, int endX, int endY){
        Box startBox = board.getBox(startX,startY);
        Box endBox = board.getBox(endX,endY);
        Move move = new Move(player, startBox,endBox);
        return this.makeMove(move, player);
    }

    private boolean makeMove(Move move, Player2 player){
        Piece sourcePiece = move.getStart().getPiece();
        if(sourcePiece != null) return false;

        if(player != currentPlayer) return false;

        if(sourcePiece.isWhite() != player.isWhiteSide()) return false;

        if(!sourcePiece.canMove(board, move.getStart(), move.getEnd())) return false;

        Piece destPiece = move.getStart().getPiece();
        if(destPiece != null){
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        movesPlayed.add(move);

        //move from start box to end
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        if(destPiece != null && destPiece instanceof King){
            if(player.isWhiteSide()) this.setGameStatus(GameStatus.WHITE_WIN);
            else this.setGameStatus(GameStatus.BLACK_WIN);
        }

        //change turn
        this.currentPlayer = this.currentPlayer == players[0] ? players[1] : players[0];
        return true;


    }
}





