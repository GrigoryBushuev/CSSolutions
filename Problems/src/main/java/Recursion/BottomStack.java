package Recursion;
import java.util.*;

public class BottomStack {
    public static <T> void push(Stack<T> bottomStack, T item) {
        if (bottomStack.empty()) {
            bottomStack.push(item);
            return;
        }
        T tempItem = bottomStack.pop();
        push(bottomStack, item);
        bottomStack.push(tempItem);
    }

//    public static <T> void push(Stack<T> bottomStack, T item) {
//        Stack<T> tempStack = new Stack<>();
//        while (!bottomStack.empty()) {
//            T tempItem = bottomStack.pop();
//            tempStack.push(tempItem);
//        }
//        bottomStack.push(item);//(1)
//        while (!tempStack.empty()) {
//            T tempItem = tempStack.pop();
//            bottomStack.push(tempItem);
//        }
//    }

    public static void main (String[] args){
        Stack<Integer> bottomStack = new Stack<>();
        push(bottomStack, 0);
        push(bottomStack, 1);
        push(bottomStack, 2);
        push(bottomStack, 3);

        while (!bottomStack.empty()) {
            System.out.println(bottomStack.pop());
        }
    }
}
