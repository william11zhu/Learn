package com.learn.leetcode;

public class GetSpecifyNode {

	
	private class NewNode{
		
		private int count;
		private Node node;
		
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public Node getNode() {
			return node;
		}
		public void setNode(Node node) {
			this.node = node;
		}
		
		public NewNode(int k){
			count = k;
		}
		
		
	}
	
	/**
	 * ��ȡ��������K���ڵ�
	 * 1����չԭ��Node����NewNode�м��������
	 * 2���ݹ鵽���һ��Ԫ�أ���ʱk��ʼ��--��������
	 * 3����k�ݼ���0ʱ����ʱ˵����ǰ��node��ʱ�����node������NewNode�в�����
	 * 4�����е�����K��Node��NewNode��һֱ�����¶���
	 * @param node
	 * @param k
	 * @return
	 */
	public NewNode getSpecifyNode(Node node, Integer k) {

		if (node == null) {
			return new NewNode(k);
		}
		NewNode reNode = getSpecifyNode(node.getNext(), k);
		int count = reNode.getCount();
		reNode.setCount(--count);
		if(count==0){
			reNode.setNode(node);
			return reNode;
		}else{
			return reNode;
		}
	}
	
	/**
	 * ˫ָ��
	 * 1��nBehind����k������ʱnBehind��λ��-nAhead��λ��=k
	 * 2��nAhead��nBehind����ͬ������һ������ƶ�
	 * 3��nBehind�ȴﵽ�б�β������ʱnAhead����λ�ü���������
	 * @param node
	 * @param k
	 * @return
	 */
	public Node getSpecifyNode_2(Node node, int k) {
		Node nBehind = node;
		Node nAhead = node;
		int i = 0;
		while(nBehind != null){
			i++;
			nBehind = nBehind.getNext();
			if(i > k){
				nAhead = nAhead.getNext();
			}
		}
		if(i < k){
			return null;
		}
		return nAhead;
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
		
		//NewNode reNode = new GetSpecifyNode().getSpecifyNode(node, 1);
		//System.out.println(reNode.getNode().getData());
		
		Node node2 = new GetSpecifyNode().getSpecifyNode_2(node, 5);
		System.out.println(node2 == null ? null:node2.getData());
	}
}
