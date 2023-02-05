/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.2.2023 г.
 * Time: 5:45
 */
package P19ExerciseObjectsAndClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P11TeamworkProjects {
    public static class Teams {
        String creator;
        String name;
        List<String> members = new ArrayList<>();

        public Teams(String creator, String name) {
            this.creator = creator;
            this.name = name;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getMembers() {
            return members;
        }

        public void setMembers(List<String> members) {
            this.members = members;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfClasses = Integer.parseInt(scanner.nextLine());
        List<Teams> teamsList = new ArrayList<>();
        for (int i = 0; i < numberOfClasses; i++) {
            String inputLine = scanner.nextLine();
            String[] inputArr = inputLine.split("-");
            String user = inputArr[0];
            String name = inputArr[1];
            if (doseNotExist(teamsList, name)) {
                if (isNotCreator(teamsList,user)) {
                    Teams team = new Teams(user, name);
                    teamsList.add(team);
                    System.out.printf("Team %s has been created by %s!%n",name, user);
                } else {
                    System.out.printf("%s cannot create another team!%n",user);
                }
            } else {
                System.out.printf("Team %s was already created!%n", name);
            }
        }

        String members = scanner.nextLine();
        while (!members.contains("end of assignment")) {
            String[] member = members.split("->");
            String memberName = member[0];
            String memberTeam = member[1];
            if (!doseNotExist(teamsList,memberTeam)) {
                if (isNotMember(teamsList, memberName) && isNotCreator(teamsList, memberName)) {
                    for (Teams teams : teamsList) {
                        if (teams.name.equals(memberTeam)) {
                            teams.members.add(memberName);
                            break;
                        }
                    }
                } else {
                    System.out.printf("Member %s cannot join team %s!%n",memberName, memberTeam);
                }
            } else {
                System.out.printf("Team %s does not exist!%n",memberTeam);
            }
            members = scanner.nextLine();
        }
        List<Teams> dispached = new ArrayList<>();
        for (int i = 0; i < teamsList.size(); i++) {
            if (teamsList.get(i).members.size() == 0) {
                Teams dispach = teamsList.get(i);
                dispached.add(dispach);
                teamsList.remove(i);
                i--;
            }
        }


        for (int i = 0; i < teamsList.size() - 1; i++) {
            Teams tempTeam = null;
            if (teamsList.get(i+1).name.compareTo(teamsList.get(i).name) < 1) {
                tempTeam = teamsList.get(i);
                teamsList.set(i, teamsList.get(i+1));
                teamsList.set(i+1, tempTeam);
            }
        }

        for (Teams teams : teamsList) {
            Collections.sort(teams.members);
            //Collections.reverse(teams.members);
        }

        for (Teams teams : teamsList) {
            System.out.printf("%s%n",teams.name);
            System.out.printf("- %s%n",teams.creator);
            for (String member : teams.members) {
                System.out.printf("-- %s%n",member);
            }
        }

        System.out.printf("Teams to disband:%n");
        for (Teams teams : dispached) {
            System.out.printf("%s%n",teams.name);
        }

        System.out.println();
    }

    private static boolean isNotMember(List<Teams> teamsList, String memberName) {
        for (Teams teams : teamsList) {
            for (String member : teams.members) {
                if (member.equals(memberName)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isNotCreator(List<Teams> teamsList, String user) {
        for (Teams teams : teamsList) {
            if (teams.creator.equals(user)) {
                return false;
            }
        }
        return true;
    }

    private static boolean doseNotExist(List<Teams> teamsList, String name) {
        for (Teams teams : teamsList) {
            if (teams.name.equals(name)) {
                return false;
            }
        }
        return true;
    }
}
