package Week5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamFixtures {

    public static void main(String[] args) {
        List<String> evenTeams = new ArrayList<>();
        evenTeams.add("Galatasaray");
        evenTeams.add("Bursaspor");
        evenTeams.add("Fenerbahçe");
        evenTeams.add("Beşiktaş");
        evenTeams.add("Başakşehir");
        evenTeams.add("Trabzonspor");

        List<String> oddTeams = new ArrayList<>();
        oddTeams.add("Galatasaray");
        oddTeams.add("Bursaspor");
        oddTeams.add("Fenerbahçe");
        oddTeams.add("Beşiktaş");
        oddTeams.add("Başakşehir");
        oddTeams.add("Trabzonspor");
        oddTeams.add("Boluspor");

        System.out.println("Çift sayıda takım için fikstür:");
        generateFixture(evenTeams);

        System.out.println("##############################################");
        System.out.println("\nTek sayıda takım için fikstür:");
        generateFixture(oddTeams);
    }

    public static void generateFixture(List<String> teams) {
        if (teams.size() % 2 != 0) {
            teams.add("Bay"); // Takım sayısını çift yapmak için "Bay" ekle
        }

        int numTeams = teams.size();
        int totalRounds = numTeams - 1;
        int matchesPerRound = numTeams / 2;

        List<String> homeTeams = new ArrayList<>();
        List<String> awayTeams = new ArrayList<>();

        // Takımları karıştır
        Collections.shuffle(teams);

        // Takımları iki listeye böl
        for (int i = 0; i < numTeams / 2; i++) {
            homeTeams.add(teams.get(i));
            awayTeams.add(teams.get(numTeams - 1 - i));
        }

        System.out.println("Çift Devreli Lig Fikstürü:\n");

        for (int round = 0; round < totalRounds * 2; round++) {
            System.out.println();
            System.out.println("Round " + (round + 1));
            System.out.println();

            for (int match = 0; match < matchesPerRound; match++) {
                if (round % 2 == 0) {
                    System.out.println(homeTeams.get(match) + " vs " + awayTeams.get(match));
                } else {
                    System.out.println(awayTeams.get(match) + " vs " + homeTeams.get(match));
                }
            }

            // Takımları döndür
            if (round % 2 == 0) {
                rotateTeams(homeTeams, awayTeams);
            } else {
                rotateTeams(awayTeams, homeTeams);
            }
        }
    }

    private static void rotateTeams(List<String> homeTeams, List<String> awayTeams) {
        String temp = homeTeams.remove(homeTeams.size() - 1);
        homeTeams.add(1, awayTeams.remove(0));
        awayTeams.add(temp);
    }
}
