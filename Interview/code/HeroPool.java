package test;

/**
 * Created by Aidan on 2021/9/11 20:58
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class HeroPool {
    public static void main(String[] args) {
        int result = getTeams(new int[]{0, 1, 2, 3, 4});
        System.out.println(result);
    }

    public static int getTeams(int[] heros) {
        // write code here
        int countZero = 0, countOne = 0, countTwo = 0, countThree = 0, countFour = 0;
        for (int i = 0; i < heros.length; i++) {
            switch (heros[i]) {
                case 0: {
                    countZero++;
                    break;
                }
                case 1: {
                    countOne++;
                    break;
                }
                case 2: {
                    countTwo++;
                    break;
                }
                case 3: {
                    countThree++;
                    break;
                }
                case 4: {
                    countFour++;
                    break;
                }
            }
        }
        return countZero * countOne * countTwo * countThree * countFour;
    }
}
