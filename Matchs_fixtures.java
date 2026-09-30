import java.util.Scanner;

public class matchs_fixtures {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String[] teamnames = {"Team A","Team B","Team C","Team D"};

        int[] goalsFor = new int[4];
        int[] goalsAgainst = new int[4];
        int[] wins = new int[4];
        int[] draws = new int[4];
        int[] losses = new int[4];
        int[] points = new int[4];
        String[] match_results = new String[6];

        int[][] fixture = {{0,1},{0,2},{0,3},{1,2},{1,3},{2,3}};

        System.out.println("----------------TOURNAMENT FIXTURE----------------");

        for (int i = 0 ; i < fixture.length ; i++){
            int t1 = fixture[i][0];
            int t2 = fixture[i][1];
            System.out.println("Match "+(i+1)+": "+teamnames[t1]+" and "+teamnames[t2] );
        }

        for (int i = 0 ; i < fixture.length ; i++){
            int t1 = fixture[i][0];
            int t2 = fixture[i][1];
            System.out.println("---------------");
            System.out.println("Match "+(i+1));
            System.out.print(teamnames[t1]+":");
            int t1_score = scanner.nextInt();
            System.out.print(teamnames[t2]+":");
            int t2_score = scanner.nextInt();
            match_results[i] = "Match "+(i+1)+":"+teamnames[t1]+" "+t1_score+" and "+t2_score+" "+teamnames[t2];
            goalsFor[t1] += t1_score;
            goalsFor[t2] += t2_score;
            goalsAgainst[t1] += t2_score;
            goalsAgainst[t2] += t1_score;

            if (t1_score > t2_score){
                wins[t1] += 1;
                losses[t2] += 1;
                points[t1] += 3;
                points[t2] += 0;
            } else if (t1_score < t2_score) {
                wins[t2] += 1;
                losses[t1] += 1;
                points[t2] += 3;
                points[t1] += 0;
            }
            else {
                draws[t1] += 1;
                draws[t2] += 1;
                points[t1] += 1;
                points[t2] += 1;
            }
        }

        for (int i = 0 ; i < 4 ; i++){
            int average = goalsFor[i] - goalsAgainst[i];
            int matchs_played = wins[i] + draws[i] + losses[i];
            System.out.println(teamnames[i]+"\n"+"Match Played: "+matchs_played+"\t"+"Win: "+wins[i]
                    +"\t"+"Draw: "+draws[i]+"\t"+"Loss: "+losses[i]+"\t"+"Total Point: "+points[i]+"\t"+
                    "Goal difference: "+average);
        }

        int index_champ =0;
        int max_point = points[0];
        int max_average = goalsFor[0] - goalsAgainst[0];

        for (int i = 0 ; i < 4 ; i++){
            int first_average = goalsFor[i] - goalsAgainst[i];
            if (points[i] > max_point){
                index_champ = i;
                max_point = points[i];
            } else if (points[i] == max_point) {
                if (first_average > max_average){
                    index_champ = i;
                    max_average = first_average;
                }
            }
        }

        System.out.println("************************\nTHE CHAMPION IS : "+teamnames[index_champ]+"" +
                "\n************************");

    }
}
