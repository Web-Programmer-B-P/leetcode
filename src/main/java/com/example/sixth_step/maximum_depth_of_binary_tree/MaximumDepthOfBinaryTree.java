package com.example.sixth_step.maximum_depth_of_binary_tree;

import com.example.sixth_step.TreeNode;

import java.util.ArrayDeque;

import static com.example.sixth_step.utils.Utils.buildTree;

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest
 * leaf node.
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildTree(arr);
//        System.out.println(maxDepthRecursion(root));
//        System.out.println(maxDepthQueue(root));
        System.out.println(maxDepthStack(root));
    }

    public static int maxDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthRecursion(root.left);
        int rightDepth = maxDepthRecursion(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static int maxDepthQueue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static int maxDepthStack(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ArrayDeque<TreeNode> stackOfNodes = new ArrayDeque<>();
        ArrayDeque<Integer> stackOfDepth = new ArrayDeque<>();
        stackOfNodes.push(root);
        stackOfDepth.push(1);
        int max = 0;
        while (!stackOfNodes.isEmpty()) {
            TreeNode topNode = stackOfNodes.poll();
            int depth = stackOfDepth.poll();
            max = Math.max(max, depth);
            if (topNode.left != null) {
                stackOfNodes.push(topNode.left);
                stackOfDepth.push(depth + 1);
            }
            if (topNode.right != null) {
                stackOfNodes.push(topNode.right);
                stackOfDepth.push(depth + 1);
            }
        }

        return max;
    }
}
