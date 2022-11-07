package com.greatlearning.lab3.dsa.problem2;

import java.util.HashSet;
import java.util.Scanner;

public class FindSumPair 
{
	static class Node
	{
		int nodeData;
		Node leftNode,rightNode;
	}
	static Node newNode(int nodeData)
	{
		Node temp=new Node();
		temp.nodeData=nodeData;
		temp.leftNode=null;
		temp.rightNode=null;
		return temp;
	}
	public Node insert(Node root,int data)
	{
		if(root==null)
			return newNode(data);
		if(data<root.nodeData)
			root.leftNode=insert(root.leftNode, data);
		else
			root.rightNode=insert(root.rightNode, data);
		return root;
	}
	public boolean findPairUtil(Node root,int sum,HashSet<Integer> set)
	{
		if(root==null)
			return false;
		if(findPairUtil(root.leftNode, sum, set))
			return true;
		if(set.contains(sum-root.nodeData)) {
			System.out.println("Pair is found ("+(sum-root.nodeData)+", "+root.nodeData+ ")");
			return true;
		}
		else
			set.add(root.nodeData);
		return findPairUtil(root.rightNode, sum, set);
	}
	public void findPairWithGivenSum(Node root,int sum)
	{
		HashSet<Integer> set=new HashSet<>();
		if(!findPairUtil(root, sum, set))
			System.out.println("Pairs do not exist");
	}
	public static void main(String[] args) {
		Node root=null;
		FindSumPair findSumPair=new FindSumPair();
		root=findSumPair.insert(root, 40);
		root=findSumPair.insert(root, 20);
		root=findSumPair.insert(root, 60);
		root=findSumPair.insert(root, 10);
		root=findSumPair.insert(root, 30);
		root=findSumPair.insert(root, 50);
		root=findSumPair.insert(root, 70);
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter the Sum to find a Pair");
		int sum = sc.nextInt();
				
		findSumPair.findPairWithGivenSum(root, sum);
	}
}
