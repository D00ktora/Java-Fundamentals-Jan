/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 31.1.2023 г.
 * Time: 18:38
 */
package P18ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class P04Songs {
    public static class Song {
        String typeList;
        String name;
        String time;
        Song(String typeList, String name, String time){
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        String getName() {
            return this.name;
        }
        String getType() {
            return this.typeList;
        }
        String getTime(){
            return this.time;
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            String input = scanner.nextLine();
            String type = input.split("_")[0];
            String name = input.split("_")[1];
            String time = input.split("_")[2];
            Song song = new Song(type,name,time);
            songs.add(song);
        }
        String input = scanner.nextLine();
        if (input.contains("all")) {
            for (int i = 0; i < songs.size(); i++) {
                System.out.println(songs.get(i).getName());
            }
        } else {
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getType().equals(input)) {
                    System.out.println(songs.get(i).getName());
                }
            }
        }
    }
}
