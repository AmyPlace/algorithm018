# 用 add first 或 add last 这套新的 API 改写 Deque 的代码

[https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html](https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html)

```java
Deque<String> deque = new LinkedList<String>();
deque.push("a");
deque.push("b");
deque.push("c");
System.out.println(deque);

String str = deque.peek();
System.out.println(str);
System.out.println(deque);

while (deque.size() > 0) {
 System.out.println(deque.pop());
}
System.out.println(deque);
```

改寫後

```java
Deque<String> deque = new LinkedList<String>();
deque.addLast("a");
deque.addLast("b");
deque.addLast("c");
System.out.println(deque);

String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);

while (deque.size() > 0) {
 System.out.println(deque.pollFirst());
}

System.out.println(deque);
```