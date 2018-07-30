package com.learn.leetcode;

public class ListReversal {
	
	public Node reversal(Node node){
		
		//���÷�ת�����ͷָ��
		Node revNode= null;
		
		while(node != null){
			//��ԭ�������һ��λ�ñ��浽��ʱ������
			Node temp = node.getNext();
			//����ǰλ��ָ��ת�����ͷ
			node.setNext(revNode);
			//��ͷָ���޸�Ϊ��ǰ�ڵ�
			revNode = node;
			//�����ݸ���ԭ��ͷ
			node = temp;
		}
		
		return revNode;
	}
	
	/**
	 * 1���ݹ�ֱ�����һ���ڵ㣬��ʱnodeΪ���һ���ڵ㣬�ߵ�if��֧�������һ���ڵ�
	 * 2��revNode�������һ���ڵ��ֵ����ʱnodeΪ�����ڶ��ڵ㣬
	 * 3����ʱ���ҵ�node�ĺ�һ���ڵ㣬��node��һ���ڵ�ָ��node
	 * 4���Ͽ�node��ָ�룬��ֹѭ��
	 * @param node
	 * @return
	 */
	
	public Node in_Reversal(Node node){
		//��һ�������Ƿ�ֹnodeΪ�յ����
		if(node == null || node.getNext() == null) return node;
		Node revNode = in_Reversal(node.getNext());
		node.getNext().setNext(node); 
		node.setNext(null);
		return revNode;
	}
	
	public static void main(String... args){
		Node node = null;

		for(int i= 0;i<10;i++){
			Node temp = new Node();
			temp.setData(i+"");
			temp.setNext(node);
			node = temp;
		}
		
		Node temp = node;
		while( temp != null){
			System.out.print(temp.getData()+",");
			temp = temp.getNext();
		}
		
		System.out.println();
		node = new ListReversal().in_Reversal(node);
		
		while(node!= null){
			System.out.print(node.getData()+",");
			node = node.getNext();
		}
	}
}
