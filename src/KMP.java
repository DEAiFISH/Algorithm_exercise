/**
 * @description KMP字符串匹配算法   https://www.bilibili.com/video/BV1AY4y157yL
 *
 * @author DEAiFISH
 * @date 2023/10/23 22:28
 */
public class KMP {

    /**
     * @description KMP字符串匹配算法
     *
     * @author DEAiFISH
     * @date 2023/10/23 23:35
     * @param string 主串
     * @param patt 子串
     * @return int 若匹配到返回第一个字符下标；否则返回-1
     */
    public static int searchKMP(String string, String patt) {
        int lenS = string.length(), lenP = patt.length();
        int[] next = buildNext(patt);

        int i = 0;  //主串中的指针
        int j = 0;  //子串中的指针

        while (i < lenS) {
            if (string.charAt(i) == string.charAt(j)) {   //字符串匹配
                i++;
                j++;
            } else if (j > 0) { //匹配失败，跳转到next对应位置
                j = next[j - 1];
            } else {  //第一个字符匹配失败
                i++;
            }

            if (j == lenP) {
                return i - j;
            }
        }
        return -1;
    }

    /**
     * @description 计算next数组
     *
     * @author DEAiFISH
     * @date 2023/10/23 23:33
     * @param patt 子串
     * @return int[] next数组
     */
    private static int[] buildNext(String patt) {
        int len = patt.length();
        int[] next = new int[len];
        int prefixLen = 0;  //记录当前最长前后缀最长度
        int i = 1;
        while (i < len) {
            if (patt.charAt(i) == patt.charAt(prefixLen)) {
                prefixLen++;
                next[i] = prefixLen;
                i++;
            } else {
                if (prefixLen != 0) {
                    prefixLen = next[prefixLen - 1];
                } else {
                    i++;
                }
            }
        }

        return next;
    }

}
