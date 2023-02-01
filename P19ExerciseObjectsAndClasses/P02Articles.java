/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.2.2023 г.
 * Time: 5:43
 */
package P19ExerciseObjectsAndClasses;

import java.util.Scanner;

public class P02Articles {

    public static class Artical {
        String title;
        String content;
        String author;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Artical(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        void edit(String newContent) {
            this.content = newContent;
        }
        void changeAuthor(String newAuthor) {
            this.author = newAuthor;
        }
        void rename(String newTitle) {
            this.title = newTitle;
        }

        void printClass() {
            System.out.printf("%s - %s: %s%n",this.title, this.content, this.author);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String title = input.split(", ")[0];
        String content = input.split(", ")[1];
        String author = input.split(", ")[2];
        Artical myClass = new Artical(title,content,author);
        int operations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < operations; i++) {
            input = scanner.nextLine();
            if (input.contains("Edit:")) {
                String newContent = input.split(": ")[1];
                myClass.edit(newContent);
            } else if (input.contains("ChangeAuthor:")) {
                String newAuthor = input.split(": ")[1];
                myClass.changeAuthor(newAuthor);
            } else if (input.contains("Rename:")) {
                String newTitle = input.split(": ")[1];
                myClass.rename(newTitle);
            }
        }
        myClass.printClass();
    }
}
