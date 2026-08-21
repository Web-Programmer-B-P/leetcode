package com.example.sixth_step.utils;


import com.example.sixth_step.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Utils {
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode parent = queue.poll();
            // левый потомок
            if (i < arr.length && arr[i] != null) {
                parent.left = new TreeNode(arr[i]);
                queue.offer(parent.left);
            }
            i++;
            // правый потомок
            if (i < arr.length && arr[i] != null) {
                parent.right = new TreeNode(arr[i]);
                queue.offer(parent.right);
            }
            i++;
        }
        return root;
    }
}
