package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}



class Result {   
    public static SinglyLinkedListNode deleteEven(SinglyLinkedListNode listHead) {
    // Write your code here
        SinglyLinkedListNode node = listHead;
        SinglyLinkedListNode list = null;
        while(node != null){
            if((node.data & 1) == 1){
                if(list == null){
                    list = new SinglyLinkedListNode(node.data);
                }
                else{
                    list.next = new SinglyLinkedListNode(node.data);
                }
            }
            node = node.next;
        }
        return list;
    }

}

public class question_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(13 & 1);
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        SinglyLinkedList listHead = new SinglyLinkedList();
//
//        int listHeadCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, listHeadCount).forEach(i -> {
//            try {
//                int listHeadItem = Integer.parseInt(bufferedReader.readLine().trim());
//
//                listHead.insertNode(listHeadItem);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        SinglyLinkedListNode result = Result.deleteEven(listHead.head);
//
//        SinglyLinkedListPrintHelper.printList(result, "\n", bufferedWriter);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
