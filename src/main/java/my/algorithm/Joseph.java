package my.algorithm;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by paul on 2015/6/26.
 *
 */
public class Joseph {
    /**
     *
     * @param list
     * 从第m个人开始
     * @param n
     * 数到n的删除
     */
    public static void doWithList(LinkedList<String> list,int n) throws Exception {
        System.out.println("the init list:" + list);
        int count = 0;
        String target = "";
        if (list == null || list.size() ==0){
            throw new Exception("list不能空");
        }

        while (list.size() > 0){
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                target = iterator.next();
                if (++count == n){
                    iterator.remove();
                    count = 0;
                    System.out.println(target);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        doWithList(list,2);
    }
}
