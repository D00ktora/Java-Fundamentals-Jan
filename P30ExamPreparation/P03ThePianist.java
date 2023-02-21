/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.2.2023 г.
 * Time: 8:08
 */
package P30ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03ThePianist {
    public static class Piece {
        String piece;
        String composer;
        String key;

        public String getPiece() {
            return piece;
        }

        public void setPiece(String piece) {
            this.piece = piece;
        }

        public String getComposer() {
            return composer;
        }

        public void setComposer(String composer) {
            this.composer = composer;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Piece(String piece, String composer, String key) {
            this.piece = piece;
            this.composer = composer;
            this.key = key;
        }

        void printPiece() {
            System.out.printf("%s -> Composer: %s, Key: %s%n",this.piece,this.composer,this.key);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPieces = Integer.parseInt(scanner.nextLine());
        List<Piece> pieceList = new ArrayList<>();

        for (int i = 0; i < numberOfPieces; i++) {
            String input = scanner.nextLine();
            String piece = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String key = input.split("\\|")[2];
            Piece pieceToAdd = new Piece(piece,composer,key);
            pieceList.add(pieceToAdd);
        }

        String command = scanner.nextLine();

        while (!command.contains("Stop")) {
            if (command.contains("Add")){
                String piece = command.split("\\|")[1];
                String composer = command.split("\\|")[2];
                String key = command.split("\\|")[3];
                if (notContainPiece(piece,pieceList)) {
                    Piece toAdd = new Piece(piece,composer,key);
                    pieceList.add(toAdd);
                    System.out.printf("%s by %s in %s added to the collection!%n",piece,composer,key);
                } else {
                    System.out.printf("%s is already in the collection!%n",piece);
                }
            } else if (command.contains("Remove")) {
                String piece = command.split("\\|")[1];
                if (!notContainPiece(piece, pieceList)) {
                    Piece objectRemove = objectToRemove(piece, pieceList);
                    if (objectRemove != null) {
                        pieceList.remove(objectRemove);
                        System.out.printf("Successfully removed %s!%n",piece);
                    }
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                }
            } else if (command.contains("ChangeKey")) {
                String piece = command.split("\\|")[1];
                String key = command.split("\\|")[2];
                if (!notContainPiece(piece,pieceList)) {
                    for (Piece pieces : pieceList) {
                        if (pieces.piece.equals(piece)) {
                            pieces.setKey(key);
                            System.out.printf("Changed the key of %s to %s!%n",piece,key);
                            break;
                        }
                    }
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                }
            }
            command = scanner.nextLine();
        }

        for (Piece piece : pieceList) {
            piece.printPiece();
        }

    }

    private static Piece objectToRemove(String piece, List<Piece> pieceList) {
        for (Piece pieces : pieceList) {
            if (pieces.piece.equals(piece)) {
                Piece forRemove = pieces;
                return forRemove;
            }
        }
        return null;
    }

    private static boolean notContainPiece(String piece, List<Piece> pieceList) {
        for (Piece pieces : pieceList) {
            if (pieces.piece.equals(piece)) {
                return false;
            }
        }
        return true;
    }
}
