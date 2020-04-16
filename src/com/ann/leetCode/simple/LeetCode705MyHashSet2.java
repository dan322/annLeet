package com.ann.leetCode.simple;

// todo test 
// use BST
public class LeetCode705MyHashSet2 {
    private Bucket[] data;
    private final int capacity = 756;

    public LeetCode705MyHashSet2() {
        data = new Bucket[capacity];
        for (int i = 0; i < capacity; ++i)
            data[i] = new Bucket();
    }

    public void add(int key) {
        int index = hash(key);
        data[index].insert(key);
    }

    public void remove(int key) {
        int index = hash(key);
        data[index].delete(key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return data[index].contains(key);
    }

    private int hash(int key) {
        return (key % capacity);
    }

    class Bucket {
        BSTree container;

        Bucket() {
            container = new BSTree();
        }

        public void insert(int key) {
            container.insert(key);
        }

        public void delete(int key) {
            container.delete(key);
        }

        public boolean contains(int key) {
            return container.search(key) != null;
        }
    }

    class BSTree {
        TreeNode root;

        BSTree() {

        }

        public TreeNode insert(int key) {
            TreeNode node = root, prev = null;
            while (node != null && key != node.value) {
                prev = node;
                if (key < node.value)
                    node = node.left;
                else
                    node = node.right;
            }
            if (root == null) {
                root = new TreeNode(key);
            } else if (node == null) {
                node = new TreeNode(key);
                if (key < prev.value)
                    prev.left = node;
                else
                    prev.right = node;
            }
            return node;
        }

        public TreeNode delete(int key) {
            if (root == null)
                return null;
            // find delete node
            TreeNode node = root, prevNode = null;
            boolean isLeft = false;
            while (node != null && key != node.value) {
                prevNode = node;
                if (isLeft = key < node.value)
                    node = node.left;
                else
                    node = node.right;
            }
            if (node != null) {
                if (prevNode == null) {
                    root = null;
                    return node;
                }
                TreeNode childNode;
                // 如果删除的节点有右子节点，则找到右子节点的最左节点使之成为删除节点的左子树的父节点
                if (node.right != null) {
                    childNode = node.right;
                    TreeNode leftNode = childNode;
                    while (leftNode.left != null)
                        leftNode = leftNode.left;
                    leftNode.left = node.left;
                } else {
                    childNode = node.left;
                }
                if (isLeft)
                    prevNode.left = childNode;
                else
                    prevNode.right = childNode;
            }
            return node;
        }

        public TreeNode search(int key) {
            TreeNode node = root;
            while (node != null && key != node.value) {
                if (key < node.value)
                    node = node.left;
                else
                    node = node.right;
            }
            return node;
        }
    }

    class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int val) {
            value = val;
        }
    }
}
