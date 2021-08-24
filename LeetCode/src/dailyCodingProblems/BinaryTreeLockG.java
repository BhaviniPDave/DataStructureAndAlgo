package dailyCodingProblems;

/**
 * Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants
 * or ancestors are not locked.
 *
 * Design a binary tree node class with the following methods:
 *
 * is_locked, which returns whether the node is locked
 * lock, which attempts to lock the node. If it cannot be locked, then it should return false.
 * Otherwise, it should lock it and return true.
 * unlock, which unlocks the node. If it cannot be unlocked, then it should return false.
 * Otherwise, it should unlock it and return true.
 *
 * You may augment the node to add parent pointers or any other property you would like.
 * You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes.
 * Each method should run in O(h), where h is the height of the tree.
 */
public class BinaryTreeLockG {

    private class BinaryTreeNode {
        int val;
        boolean locked = false;
        BinaryTreeNode parent;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        int lockedDescendantCount = 0;
    }

    public boolean is_locked(BinaryTreeNode node) {
        return node.locked;
    }

    public boolean lock(BinaryTreeNode node) {
        if (is_locked(node)) {
            return true;
        }
        if (!canLockOrUnlock(node)) {
            return false;
        }
        node.locked = true;
        BinaryTreeNode parentNode = node.parent;
        while (parentNode != null) {
            parentNode.lockedDescendantCount += 1;
            parentNode = parentNode.parent;
        }
        return true;
    }

    public boolean unlock(BinaryTreeNode node) {
        if (!is_locked(node)) {
            return true;
        }
        if (!canLockOrUnlock(node)) {
            return false;
        }
        node.locked = false;
        BinaryTreeNode parentNode = node.parent;
        while (parentNode != null) {
            parentNode.lockedDescendantCount -= 1;
            parentNode = parentNode.parent;
        }
        return true;
    }

    private boolean canLockOrUnlock(BinaryTreeNode node) {
        if (node.lockedDescendantCount > 0) {
            return false;
        }
        BinaryTreeNode parentNode = node.parent;
        while (parentNode != null) {
            if (parentNode.locked) {
                return false;
            }
            parentNode = parentNode.parent;
        }
        return true;
    }
}
