## 2017编程提高社群作业：数据结构习题、实现多线程下载(2017.03.05)

- ### [数据结构习题Coding](https://github.com/china-kook/coding2017/blob/master/group18/935542673/Coding/20170305/src/com/ikook/linked/LinkedUtil.java)

  - 实现把链表逆置 例如链表为 3->7->10 , 逆置后变为 10->7->3。关键代码如下：

    ```java
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
  ```

  - 实现删除一个单链表的前半部分 例如：list = 2->5->7->8 , 删除以后的值为 7->8。关键代码如下：

     ```java
  for (int i = 0; i <= (this.size / 2); i++) {
        removeFirst();
  }
  ```

  - 实现从第i个元素开始， 删除length 个元素 ， 注意i从0开始

    ```java
  for (int j = i; j < length + 1; j++) {
        this.remove(i);
  }
  ```

  - 实现假定当前链表和list均包含已升序排列的整数 从当前链表中取出那些list所指定的元素

    ```java
    for (int i = 0; i < list.size; i++) {
      int temp = (int) list.get(i);
      res[index] = (int) this.get(temp);
      index++;
    }
    ```

 - 实现从当前链表中中删除在list中出现的元素

    ```java
    while (iterator.hasNext()) {
      Object e = iterator.next();
      for (int i = 0; i < list.size; i++) {
        if (e.equals(list.get(i))) {
          iterator.remove();
        }
      }
    }
    ```

  - 实现删除表中所有值相同的多余元素（使得操作后的线性表中所有元素的值均不相同）

    ```java
    while (iterator.hasNext()) {
      Object current = iterator.next();
      if (cursor != null && current.equals(cursor)) {
        iterator.remove();
      } else {
        cursor = current;
      }
    }
    ```

 - 实现删除表中所有值大于min且小于max的元素（若表中存在这样的元素）

    ```java
  for(int i=0;i<size;i++){
        fun(node,min,max);
        node = node.next;
  }
  if(nodeData > min && nodeData < max){
        size--;
        if(node.next.next==null){
          node.next = null;
          return;
        }else{
          node.next = node.next.next;
        }
        fun(node,min,max);
  }
  ```

  - 实现要求生成新链表C，其元素为当前链表和list中元素的交集，且表C中的元素有依值递增有序排列

    ```java
  for(int i=0;i<size;i++){
        for(int j=0;j<list.size;j++){
          if(this.get(i).equals(list.get(j))){
            newLinked.add(this.get(i));
          }
        }
  }
  ```

- ### [实现多线程下载](https://github.com/china-kook/coding2017/tree/master/group18/935542673/Coding/20170305/src/com/ikook/download)

    尚未实现。其中涉及的一些知识还未学习。

- ### 数据结构习题以及多线程实现测试类

  - ##### [数据结构习题 Test Coding](https://github.com/china-kook/coding2017/blob/master/group18/935542673/Coding/20170305/junit/com/ikook/linked/LinkedUtilTest.java)

  - ##### [Struts Test Coding](https://github.com/china-kook/coding2017/blob/master/group18/935542673/Coding/20170305/junit/com/ikook/download/FileDownloaderTest.java)
