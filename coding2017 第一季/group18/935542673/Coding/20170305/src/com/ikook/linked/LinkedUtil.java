package com.ikook.linked;

import java.util.NoSuchElementException;

public class LinkedUtil implements MyList {
    private Node first;
    private Node last;
    private int size;

    //--------------------------------------- 以下是 2017.03.05 的作业 ------------------------------------------//


    /**
     * 把该链表逆置 例如链表为 3->7->10 , 逆置后变为 10->7->3
     */
    public void reverse() {
        LinkedUtil newLinked = new LinkedUtil();

        for (MyIterator iterator = this.iterator(); iterator.hasNext(); ) {
            Object i = iterator.next();
            iterator.remove();
            newLinked.addFirst(i);
        }

        for (MyIterator iterator = newLinked.iterator(); iterator.hasNext(); ) {
            Object i = iterator.next();
            iterator.remove();
            this.addLast(i);
        }
    }

    /**
     * 删除一个单链表的前半部分 例如：list = 2->5->7->8 , 删除以后的值为 7->8 如果list = 2->5->7->8->10
     * ,删除以后的值为7,8,10
     */
    public void removeFirstHalf() {
        for (int i = 0; i <= (this.size / 2); i++) {
            removeFirst();
        }
    }

    /**
     * 从第i个元素开始， 删除length 个元素 ， 注意i从0开始
     *
     * @param i
     * @param length
     */
    public void remove(int i, int length) {
        for (int j = i; j < length + 1; j++) {
            this.remove(i);
        }
    }

    /**
     * 假定当前链表和list均包含已升序排列的整数 从当前链表中取出那些list所指定的元素 例如当前链表 =
     * 11->101->201->301->401->501->601->701 listB = 1->3->4->6
     * 返回的结果应该是[101,301,401,601]
     *
     * @param list
     */
    public int[] getElements(LinkedUtil list) {

        int[] res = new int[list.size];
        int index = 0;

        for (int i = 0; i < list.size; i++) {
            int temp = (int) list.get(i);
            res[index] = (int) this.get(temp);
            index++;
        }

        return res;
    }

    /**
     * 已知链表中的元素以值递增有序排列，并以单链表作存储结构。 从当前链表中中删除在list中出现的元素
     *
     * @param list
     */
    public void subtract(LinkedUtil list) {

        MyIterator iterator = this.iterator();
        while (iterator.hasNext()) {

            Object e = iterator.next();
            for (int i = 0; i < list.size; i++) {
                if (e.equals(list.get(i))) {
                    iterator.remove();
                }
            }

        }

    }

    /**
     * 已知当前链表中的元素以值递增有序排列，并以单链表作存储结构。 删除表中所有值相同的多余元素（使得操作后的线性表中所有元素的值均不相同）
     */
    public void removeDuplicateValues() {

        MyIterator iterator = iterator();
        Object cursor = null;
        while (iterator.hasNext()) {
            Object current = iterator.next();
            if (cursor != null && current.equals(cursor)) {
                iterator.remove();
            } else {
                cursor = current;
            }
        }
    }

    /**
     * 已知链表中的元素以值递增有序排列，并以单链表作存储结构。 试写一高效的算法，删除表中所有值大于min且小于max的元素（若表中存在这样的元素）
     *
     * @param min
     * @param max
     */
    public void removeRange(int min, int max) {
        Node node = first;
        for(int i=0;i<size;i++){
            fun(node,min,max);

            node = node.next;

        }
    }

    private void fun(Node node,int min, int max ){
        if(node.next == null){
            return;
        }

        int nodeData = Integer.valueOf(node.next.data.toString());
        if(nodeData > min && nodeData < max){
            size--;
            if(node.next.next==null){
                node.next = null;
                return;
            }else{
                node.next = node.next.next;

            }

            fun(node,min,max);
        }else{
            return;
        }
    }
    /**
     * 假设当前链表和参数list指定的链表均以元素依值递增有序排列（同一表中的元素值各不相同）
     * 现要求生成新链表C，其元素为当前链表和list中元素的交集，且表C中的元素有依值递增有序排列
     *
     * @param list
     */
    public LinkedUtil intersection(LinkedUtil list) {
        LinkedUtil newLinked = new LinkedUtil();
        for(int i=0;i<size;i++){
            for(int j=0;j<list.size;j++){
                if(this.get(i).equals(list.get(j))){
                    newLinked.add(this.get(i));
                }
            }
        }
        return newLinked;
    }

    //--------------------------------------- 以上是 2017.03.05 的作业 ------------------------------------------//

    /**
     * 在链表的头部插入新的元素
     *
     * @param obj
     */
    public void addFirst(Object obj) {
        final Node f = first;
        final Node newNode = new Node(null, obj, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.previous = newNode;
        size++;
    }

    /**
     * 在链表尾部插入新的元素
     *
     * @param obj
     */
    public void addLast(Object obj) {
        final Node l = last;
        final Node newNode = new Node(l, obj, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    /**
     * 在链表中插入新的元素
     *
     * @param obj
     */
    public void add(Object obj) {
        addLast(obj);
    }

    /**
     * 在指定位置插入新的元素
     *
     * @param index
     * @param obj
     */
    public void add(int index, Object obj) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException("索引位置越界");
        }

        if (index == size) {
            addLast(obj);
        } else {
            Node temp = node(index);
            final Node pred = temp.previous;
            final Node newNode = new Node(pred, obj, temp);
            temp.previous = newNode;
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            size++;
        }
    }

    /**
     * 返回集合的size。
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断集合是非为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取链表头部的元素
     *
     * @return
     */
    public Object getFirst() {
        final Node f = first;
        if (f == null) {
            throw new NoSuchElementException("没有找到指定的元素");
        }

        return f.data;
    }

    /**
     * 获取链表尾部的元素
     *
     * @return
     */
    public Object getLast() {
        final Node l = last;
        if (l == null) {
            throw new NoSuchElementException("没有找到指定的元素");
        }

        return l.data;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index
     * @return
     */
    public Object get(int index) {
        rangeCheckElementIndex(index);
        return node(index).data;
    }

    /**
     * 更改指定位置的元素
     *
     * @param index
     * @param element
     * @return
     */
    public Object set(int index, Object element) {
        rangeCheckElementIndex(index);
        Node temp = node(index);
        Object oldValue = temp.data;
        temp.data = element;
        return oldValue;
    }


    /**
     * 删除链表头部的元素
     *
     * @return
     */
    public Object removeFirst() {
        final Node f = first;
        if (f == null) {
            throw new NoSuchElementException("没有找到指定的元素");
        }

        final Object element = f.data;
        final Node next = f.next;
        f.data = null;
        f.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.previous = null;
        }
        size--;

        return element;
    }

    /**
     * 删除链表尾部的元素
     *
     * @return
     */
    public Object removeLast() {
        final Node l = last;
        if (l == null) {
            throw new NoSuchElementException("没有找到指定的元素");
        }

        final Object element = l.data;
        final Node prev = l.previous;
        l.data = null;
        l.previous = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;

        return element;
    }

    /**
     * 删除指定元素
     *
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (Node temp = first; temp != null; temp = temp.next) {
                if (temp.data == null) {
                    deleteElement(temp);
                    return true;
                }
            }
        } else {
            for (Node temp = first; temp != null; temp = temp.next) {
                if (o.equals(temp.data)) {
                    deleteElement(temp);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     * @return
     */
    public Object remove(int index) {
        rangeCheckElementIndex(index);
        return deleteElement(node(index));
    }

    /**
     * 删除指定节点元素
     *
     * @param temp
     * @return
     */
    private Object deleteElement(Node temp) {
        final Object element = temp.data;
        final Node next = temp.next;
        final Node prev = temp.previous;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            temp.previous = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.previous = prev;
            temp.next = null;
        }

        temp.data = null;
        size--;

        return element;
    }

    /**
     * 检查索引元素的范围
     *
     * @param index
     */
    private void rangeCheckElementIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("索引越界");
        }
    }

    /**
     * 返回指定索引位置的节点
     *
     * @param index
     * @return
     */
    Node node(int index) {
        if (index < (size >> 1)) {
            Node temp = first;
            for (int i = 0; i < index; i++)
                temp = temp.next;
            return temp;
        } else {
            Node temp = last;
            for (int i = size - 1; i > index; i--)
                temp = temp.previous;
            return temp;
        }
    }

    /**
     * 用于表示一个节点
     *
     * @author ikook
     */
    private static class Node {
        Node previous; // 上一个节点
        Object data;
        Node next; // 下一个节点

        public Node(Node previous, Object data, Node next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 返回一个迭代器的实现类
     *
     * @return
     */
    public MyIterator iterator() {
        return new LinkIter();
    }

    /**
     * 迭代器的实现类
     *
     * @author ikook
     */
    private class LinkIter implements MyIterator {
        private Node lastRet; //始终指向刚遍历完的节点
        private Node next; // 当前指向的节点
        private int nextIndex; //当前节点的索引值

        LinkIter() {
            next = node(0);
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException("没有找到指定的元素, 迭代器遍历失败");
            }

            lastRet = next;
            next = next.next;
            nextIndex++;
            return lastRet.data;
        }

        @Override
        public void remove() {
            if (lastRet == null) {
                throw new IllegalStateException("非法状态异常，删除失败");
            }

            Node lastNext = lastRet.next;
            deleteElement(lastRet);
            if (next == lastRet) {
                next = lastNext;
            } else {
                nextIndex--;
            }
            lastRet = null;
        }

    }
}
