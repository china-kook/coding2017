package com.ikook.linked;

/**
 * Created by ikook on 2017/3/12.
 */
public class LinkedUtilTest {
    /**
     * 2017.03.05 数据结构测试
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("--------------把该链表逆置 例如链表为 3->7->10 , 逆置后变为 10->7->3-------------- ");
        LinkedUtil linkedUtil = new LinkedUtil();
        linkedUtil.add(3);
        linkedUtil.add(7);
        linkedUtil.add(10);
        linkedUtil.reverse();

        System.out.print(linkedUtil.get(0));
        for (int i = 1; i < linkedUtil.size(); i++) {
            System.out.print("->" + linkedUtil.get(i));
        }


        System.out.println();
        System.out.println("--------------删除一个单链表的前半部分-------------- ");

        LinkedUtil linkedUtil2 = new LinkedUtil();
        linkedUtil2.add(2);
        linkedUtil2.add(5);
        linkedUtil2.add(7);
        linkedUtil2.add(8);
        linkedUtil2.add(10);
        linkedUtil2.removeFirstHalf();

        System.out.print(linkedUtil2.get(0));
        for (int i = 1; i < linkedUtil2.size(); i++) {
            System.out.print("->" + linkedUtil2.get(i));
        }

        System.out.println();
        System.out.println("--------------从第i个元素开始， 删除length 个元素 ， 注意i从0开始-------------- ");

        LinkedUtil linkedUtil3 = new LinkedUtil();
        linkedUtil3.add(2);
        linkedUtil3.add(5);
        linkedUtil3.add(7);
        linkedUtil3.add(8);
        linkedUtil3.add(10);
        linkedUtil3.remove(1, 3);

        System.out.print(linkedUtil3.get(0));
        for (int i = 1; i < linkedUtil3.size(); i++) {
            System.out.print("->" + linkedUtil3.get(i));
        }

        System.out.println();
        System.out.println("--------------已知链表中的元素以值递增有序排列，并以单链表作存储结构。 从当前链表中中删除在list中出现的元素-------------- ");

        LinkedUtil linkedUtil4 = new LinkedUtil();
        linkedUtil4.add(2);
        linkedUtil4.add(5);
        linkedUtil4.add(7);
        linkedUtil4.add(8);
        linkedUtil4.add(10);

        LinkedUtil lista = new LinkedUtil();
        lista.add(5);
        lista.add(8);

        linkedUtil4.subtract(lista);

        System.out.print(linkedUtil4.get(0));
        for (int i = 1; i < linkedUtil4.size(); i++) {
            System.out.print("->" + linkedUtil4.get(i));
        }

        System.out.println();
        System.out.println("--------------假定当前链表和list均包含已升序排列的整数 从当前链表中取出那些list所指定的元素-------------- ");

        LinkedUtil linkedUtil5 = new LinkedUtil();
        linkedUtil5.add(11);
        linkedUtil5.add(101);
        linkedUtil5.add(201);
        linkedUtil5.add(301);
        linkedUtil5.add(401);
        linkedUtil5.add(501);
        linkedUtil5.add(601);
        linkedUtil5.add(701);

        LinkedUtil temp = new LinkedUtil();
        temp.add(1);
        temp.add(3);
        temp.add(4);
        temp.add(6);

        int[] res = linkedUtil5.getElements(temp);
        System.out.print("[" + res[0]);
        for (int i = 1; i < res.length; i++) {
            System.out.print(" " + res[i]);
        }
        System.out.print("]");

        System.out.println();
        System.out.println("--------------删除表中所有值相同的多余元素（使得操作后的线性表中所有元素的值均不相同）-------------- ");


        LinkedUtil linkedUtil6 = new LinkedUtil();
        linkedUtil6.add(11);
        linkedUtil6.add(11);
        linkedUtil6.add(201);
        linkedUtil6.add(31);
        linkedUtil6.add(41);
        linkedUtil6.add(41);
        linkedUtil6.add(51);
        linkedUtil6.add(51);
        linkedUtil6.add(51);
        linkedUtil6.add(701);
        linkedUtil6.add(701);
        linkedUtil6.removeDuplicateValues();

        System.out.print(linkedUtil6.get(0));
        for (int i = 1; i < linkedUtil6.size(); i++) {
            System.out.print("->" + linkedUtil6.get(i));
        }

        System.out.println();
        System.out.println("--------------试写一高效的算法，删除表中所有值大于min且小于max的元素（若表中存在这样的元素）-------------- ");



        LinkedUtil linkedUtil7 = new LinkedUtil();
        linkedUtil7.add(1);
        linkedUtil7.add(1);
        linkedUtil7.add(2);
        linkedUtil7.add(4);
        linkedUtil7.add(5);
        linkedUtil7.add(7);

        linkedUtil7.removeRange(2,7);

        System.out.print(linkedUtil7.get(0));
        for (int i = 1; i < linkedUtil7.size(); i++) {
            System.out.print("->" + linkedUtil7.get(i));
        }


        System.out.println();
        System.out.println("--------------现要求生成新链表C，其元素为当前链表和list中元素的交集，且表C中的元素有依值递增有序排列-------------- ");


        LinkedUtil linkedUtil8 = new LinkedUtil();
        linkedUtil8.add(1);
        linkedUtil8.add(2);
        linkedUtil8.add(4);
        linkedUtil8.add(5);
        linkedUtil8.add(6);
        linkedUtil8.add(7);

        LinkedUtil linked = new LinkedUtil();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(5);
        linked.add(7);

        LinkedUtil newLinked = linkedUtil8.intersection(linked);

        System.out.print(newLinked.get(0));
        for (int i = 1; i < newLinked.size(); i++) {
            System.out.print("->" + newLinked.get(i));
        }
    }
}
