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
	 * 获取链表倒数第K个节点
	 * 1、扩展原有Node，在NewNode中加入计数器
	 * 2、递归到最后一个元素，此时k开始做--，并返回
	 * 3、当k递减到0时，此时说明当前的node及时所求的node，存入NewNode中并返回
	 * 4、带有倒数第K个Node的NewNode将一直返回致顶层
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
	 * 双指针
	 * 1、nBehind先行k步，此时nBehind的位置-nAhead的位置=k
	 * 2、nAhead和nBehind保持同步长，一起向后移动
	 * 3、nBehind先达到列表尾部，此时nAhead所在位置即是所求结果
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
