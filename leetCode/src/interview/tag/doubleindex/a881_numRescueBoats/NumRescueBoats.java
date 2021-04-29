package interview.tag.doubleindex.a881_numRescueBoats;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMAny;

import java.util.Arrays;

/**
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 * <p>
 * * 输入：people = [3,2,2,1], limit = 3
 * * 输出：3
 * * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 */
public class NumRescueBoats {

    /**
     *错误示范1：先将数组进行排序，然后两两进行取和，小于limit则加入，否则加入单个，对于[1,2,2,3]，limit=4，如果是这样，（1，2），（2），（3），需要三次
     * 显然不对，应该为2两次
     */
    public int numRescueBoats_false1(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }
        int n = 0;
        Arrays.sort(people);
        for (int i = people.length - 1; i > 0; ) {
            if (people[i] + people[i-1] < limit) {
                i -= 2;
            } else {
              i--;
            }
            n++;
        }
        return n;
    }

    /**
     * 要想将船数最小，应该将最大的和最小的进行搭配组成一队进行运输
    */
    public int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0 || limit<1) {
            return 0;
        }
        Arrays.sort(people);
        int minIndex = 0;
        int maxIndex = people.length-1;
        int num = 0;
        while (minIndex < maxIndex) {
            if (people[maxIndex] + people[minIndex] <= limit) {
                minIndex++;
                maxIndex--;
            }else{
                maxIndex--;
            }
            num++;
        }
//        必须得加minIndex==maxIndex，例如[1,2,2],limit=3，第一次循环后minIndex=1,maxIndex=1，退出循环，实际上中间的2还没访问
//        可以将while循环的<,变成<=，最后就不用判断了
        return minIndex==maxIndex ? num+1 : num;
    }
}
