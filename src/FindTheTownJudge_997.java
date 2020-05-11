// In a town, there are N people labelled from 1 to N.
// There is a rumor that one of these people is secretly the town judge.
//
// If the town judge exists, then:
//      1. The town judge trusts nobody.
//      2. Everybody (except for the town judge) trusts the town judge.
//      3. There is exactly one person that satisfies properties 1 and 2.

// You are given trust,
// an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
//
// If the town judge exists and can be identified, return the label of the town judge.
// Otherwise, return -1.


public class FindTheTownJudge_997 {
    public static void main(String[] args) {
        int N = 4;
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};

        int result = findJudge(N, trust);
        System.out.println(result);
    }

    public static int findJudge(int N, int[][] trust) {
        int[] count = new int[N];
        int[] trusted = new int[N];

        for(int i = 0; i < trust.length; i++)
        {
            int a = trust[i][0];
            int b = trust[i][1];
            count[a - 1]++;
            trusted[b - 1]++;
        }

        for(int i = 0; i < N; i++)
        {
            if(count[i] == 0 && trusted[i] == N - 1)
            {
                return i + 1;
            }
        }
        return -1;
    }
}
