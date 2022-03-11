package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 *  - Stack  ->  후입선출(LIFO)의 자료구조
 *  	꺼낸 데이터는 자동으로 삭제됨
 *  
 *  - Queue  ->  선입선출(FIFO)의 자료구조
 *  
 *  Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다.
 */

public class StackCueueTest {

	public static void main(String[] args) {
		
		/*
		 * 	Stack의 명령
		 * 	1. 자료를 입력 : push(입력값)
		 *  2. 자료를 출력(데이터 꺼내오기) :  pop() -> 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제한다.
		 *  						   peek() -> 삭제없이 자료를 꺼내온다.
		 */
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		
		System.out.println("현재 stack : " + stack);
		System.out.println();
		String data = stack.pop();
		System.out.println("꺼내온 값 : " + data); // 강감찬 꺼내옴
		System.out.println("꺼내온 값 : " + stack.pop());  // 변학도 꺼내옴
		System.out.println("현재 stack : " + stack);  // [홍길동, 일지매]
		System.out.println();
		
		stack.push("성춘향");
		System.out.println("추가 후 stack : " + stack);  // [홍길동, 일지매, 성춘향]
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("현재 stack : " + stack);  // [홍길동, 일지매]
		
		System.out.println("삭제없이 꺼내온 값 : " + stack.peek());  // 일지매
		System.out.println("현재 stack : " + stack);  // [홍길동, 일지매]
		
		System.out.println("-----------------------------------------");
		/*
		 *  Queue의 명령
		 *  1. 자료를 입력 :  offer(입력값)
		 *  2. 자료를 출력 : poll() -> 자료를 꺼내온 후 Queue에서 꺼내온 자료를 삭제한다.
		 *  			  peek() -> 삭제없이 자료를 꺼내온다.
		 */
		Queue<String> queue = new LinkedList<String>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("현재 queue의 값 : " + queue);  // [홍길동, 일지매, 변학도, 강감찬]

		String temp = queue.poll();
		System.out.println("꺼내온 값 : " + temp);  // 홍길동
		System.out.println("꺼내온 값 : " + queue.poll());  // 일지매
		System.out.println("현재 queue의 값 : " + queue);  // [변학도, 강감찬]
		
		queue.offer("성춘향");
		System.out.println("현재 queue의 값 : " + queue);  // [변학도, 강감찬, 성춘향]
		
		System.out.println("꺼내온 값 : " + queue.poll());  // 변학도
		System.out.println("현재 queue의 값 : " + queue);  // [강감찬, 성춘향]
		
		System.out.println("삭제없이 꺼내온 값 : " + queue.peek());
		System.out.println("현재 queue의 값 : " + queue);  // [강감찬, 성춘향]

	}

}
