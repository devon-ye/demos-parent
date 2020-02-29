package org.devon.algorithms.strings;


/**
 * 0:48	1:49	2:50	3:51	4:52	5:53	6:54	7:55	8:56	9:57   A:65	 B:66	C:67	D:68	E:69	F:70	G:71	H:72	I:73	J:74	K:75	L:76	M:77	N:78	O:79	P:80	Q:81	R:82	S:83	T:84	U:85	V:86	W:87	X:88	Y:89	Z:90   	a:97	b:98	c:99	d:100	e:101	f:102	g:103	h:104	i:105	j:106	k:107	l:108	m:109	n:110	o:111	p:112	q:113	r:114	s:115	t:116	u:117	v:118	w:119	x:120	y:121	z:122
 */
public class LSD {

    //通过前W个字符将字符数组 a[] 排序
    public static String[] sort(String[] a,int W) {

        if(a == null) return null;
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = W-1; d >= 0 ; d--) {

            //根据第d个字符，用键索引计数法排序
            int[] count = new int[R+1];
            //计算出现频率
            for (int i = 0; i <N ; i++) {
                //取出第d位字符的索引下标+1编码 并计数
                count[a[i].charAt(d)+1]++;
            }
            //将频率转换为索引
            for (int r = 0; r <R ; r++) {
                count[r+1]+= count[r];
            }
            //将元素分类
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            //回写
            for (int i = 0; i <N ; i++) {
                a[i] = aux[i];
            }

        }
        return a;

    }


    public static void main(String[] args) {

       String[] sorted = LSD.sort(new String[]{"4PGC398","2IYE230","3CI0720","1ICK750","10HV845","4JZY524","1ICK750","3CI0720","10HV845","10HV845","2RLA629","2RLA629","3ATW723"},7);
        for (int i = 0; i < sorted.length; i++) {
            System.out.printf(sorted[i]+"\t");
        }

    }


}
