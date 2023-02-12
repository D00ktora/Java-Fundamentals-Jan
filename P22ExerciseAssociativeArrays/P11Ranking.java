/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 9.2.2023 г.
 * Time: 18:39
 */
package P22ExerciseAssociativeArrays;

import java.util.*;


public class P11Ranking {

    public static class User {
        String contest;
        String password;
        String userName;
        int points;

        public User(String contest, String password, String userName, int points) {
            this.contest = contest;
            this.password = password;
            this.userName = userName;
            this.points = points;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> contests = new LinkedHashMap<>();
        List<User> userList = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.contains("end of contests")) {
            String contest = input.split(":")[0];
            String password = input.split(":")[1];
            contests.put(contest,password);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.contains("end of submissions")) {
            String contest = input.split("=>")[0];
            String password = input.split("=>")[1];
            String userName = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);
            boolean exist = false;
            if (contests.containsKey(contest)) {
                if (contests.get(contest).equals(password)) {
                    for (User user : userList) {
                        if (user.userName.equals(userName) && user.contest.equals(contest)) {
                            if (user.points < points) {
                                int userCurrentPoints = user.points;
                                userCurrentPoints = points;
                                user.points = userCurrentPoints;
                                exist = true;
                                break;
                            } else if (user.points > points) {
                                exist = true;
                                break;
                            } else if (!user.contest.equals(contest) && user.userName.equals(userName)) {
                                User newUser = new User(contest,password,userName,points);
                                userList.add(newUser);
                                exist = true;
                                break;
                            }
                        }
                    }
                    if (!exist) {
                        User newUser = new User(contest, password, userName, points);
                        userList.add(newUser);
                    }
                }
            }
            input = scanner.nextLine();
        }

        String userNameWithMostPoints = "-99999";
        int pointsTemp = -9999;
        for (User user : userList) {
            String userForIterate = user.userName;
            int userPoints = 0;
            for (User user1 : userList) {
                if (user1.userName.equals(userForIterate)) {
                    userPoints += user1.points;
                }
            }
            if (userPoints > pointsTemp) {
                userNameWithMostPoints = user.userName;
                pointsTemp = userPoints;
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", userNameWithMostPoints, pointsTemp);
        System.out.println("Ranking:");

        TreeMap<String, List<String>> mapForPrint = new TreeMap<>();

        TreeMap<Integer, String> student = new TreeMap<>();
        for (User user1 : userList) {
            String contest = user1.contest;
            int points = user1.points;
            student.put(points, contest);
        }

        List<String> tempList = new ArrayList<>();

        //for (User user : userList) {
        for (Map.Entry<Integer, String> studentss : student.entrySet()) {
            int studentValue = studentss.getKey();
            //String name = user.userName;

//            if (mapForPrint.containsKey(user.userName)) {
//                tempList = mapForPrint.get(user.userName);
//            } else {
//                tempList = new ArrayList<>();
//            }


            //for (Map.Entry<Integer, String> stringStringEntry : student.entrySet()) {
            for (User user : userList) {
                String name = user.userName;
                if (mapForPrint.containsKey(user.userName)) {
                    tempList = mapForPrint.get(user.userName);
                } else {
                    tempList = new ArrayList<>();
                }
                String contest = "";
                String tempContest = studentss.getValue();
                int tempValue = studentss.getKey();
                String userContest = user.contest;
                int userPoints = user.points;
                if (tempContest.equals(userContest) && tempValue == userPoints) {
                    contest = studentss.getValue() + " -> " + studentss.getKey();
                    tempList.add(contest);
                }
                mapForPrint.put(name, tempList);
            }
        }

        for (Map.Entry<String, List<String>> stringListEntry : mapForPrint.entrySet()) {
            Collections.reverse(stringListEntry.getValue());
        }

        for (Map.Entry<String, List<String>> stringListEntry : mapForPrint.entrySet()) {
            System.out.println(stringListEntry.getKey());
            List<String> listForPrint = stringListEntry.getValue();
            for (String s : listForPrint) {
                System.out.printf("#  %s%n", s);
            }
        }










    }
}
