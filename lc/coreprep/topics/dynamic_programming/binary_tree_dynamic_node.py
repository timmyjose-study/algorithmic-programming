from collections import deque

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def build_tree(nodes):
    def build_tree_rec(nodes, curr_idx):
        if curr_idx >= len(nodes) or nodes[curr_idx] == "null":
            return None
        node = TreeNode(int(nodes[curr_idx]))
        node.left = build_tree_rec(nodes, 2 * curr_idx + 1)
        node.right = build_tree_rec(nodes, 2 * curr_idx + 2)
        return node
    return build_tree_rec(nodes, 0)

def pre_order(root):
    def pre_order_helper(root, nodes):
        if root is None:
            return
        nodes.append(root.val)
        pre_order_helper(root.left, nodes)
        pre_order_helper(root.right, nodes)

    nodes = []
    pre_order_helper(root, nodes)

    if len(nodes) != 0:
        for node in nodes:
            print(node, end=' ')
        print()

def pre_order_iter(root):
    nodes = []

    st = []
    st.append(root)

    while len(st) != 0:
        node = st.pop()
        nodes.append(node.val)

        if node.right:
            st.append(node.right)

        if node.left:
            st.append(node.left)

    if len(nodes) != 0:
        for node in nodes:
            print(node, end= ' ')
        print()

def in_order(root):
    def in_order_helper(root, nodes):
        if root is None:
            return

        in_order_helper(root.left, nodes)
        nodes.append(root.val)
        in_order_helper(root.right, nodes)

    nodes = []
    in_order_helper(root, nodes)

    if len(nodes) != 0:
        for node in nodes:
            print(node, end = ' ')
        print()

def in_order_iter(root):
    nodes = []

    st = []
    curr_node = root

    while len(st) != 0 or curr_node is not None:
        while curr_node is not None:
            st.append(curr_node)
            curr_node = curr_node.left

        if len(st) != 0:
            node = st.pop()
            nodes.append(node.val)

            if node.right:
                curr_node = node.right

    if len(nodes) != 0:
        for node in nodes:
            print(node, end = ' ')
        print()

def post_order(root):
    def post_order_helper(root, nodes):
        if root is None:
            return

        post_order_helper(root.left, nodes)
        post_order_helper(root.right, nodes)
        nodes.append(root.val)

    nodes = []
    post_order_helper(root, nodes)

    if len(nodes) != 0:
        for node in nodes:
            print(node, end = ' ')
        print()

def post_order_iter(root):
    nodes = []

    st = []
    rev_st = []
    st.append(root)

    while len(st) != 0:
        node = st.pop()

        rev_st.append(node.val)

        if node.left:
            st.append(node.left)

        if node.right:
            st.append(node.right)

    while len(rev_st) != 0:
        nodes.append(rev_st.pop())

    if len(nodes) != 0:
        for node in nodes:
            print(node, end =  ' ')
        print()


def bfs(root):
    nodes = []

    q = deque()
    q.append(root)

    while q:
        node = q.popleft()
        nodes.append(node.val)

        if node.left:
            q.append(node.left)

        if node.right:
            q.append(node.right)

    if nodes:
        for node in nodes:
            print(node, end = ' ')
        print()
    

def bfs_rec(root):
    def bfs_rec_helper(q, nodes):
        if not q:
            return

        node = q.popleft()
        nodes.append(node.val)

        if node.left:
            q.append(node.left)

        if node.right:
            q.append(node.right)

        bfs_rec_helper(q, nodes)


    nodes = []

    q = deque()
    q.append(root)

    bfs_rec_helper(q, nodes)

    if nodes:
        for node in nodes:
            print(node, end = ' ')
        print()

def main():
    nodes = input().split()

    root = build_tree(nodes)
    pre_order(root)
    pre_order_iter(root)

    in_order(root)
    in_order_iter(root)

    post_order(root)
    post_order_iter(root)

    bfs(root)
    bfs_rec(root)

if __name__ == "__main__":
    main()