//==================Tree Function=====================================
//
//------------------------INSERT-------------------------------
//    Node insertRec(Node node, Bison b) {
//        if (node == null)
//            node = new Node(b);
//        //so sanh theo key --> chu y key cua element-object
//        if (node.info.hoof < b.hoof) 
//            node.right = insertRec(node.right, b);
//        else if (node.info.hoof > b.hoof)
//            node.left = insertRec(node.left, b);
//        
//        return node;
//    }
//
//    //lay cai nay de insert ne!!!!!!!!
//    void insert(Bison b) {
//        root = insertRec(root, b);
//    }
//---------------------------INSERT--------------------------------
//
//-----------------------------------------------------------------
//
//--------------------DELETE--------------------------------------
//	
//	//get Maxinum node from a node
//    Node getMaxNode(Node node) {
//        Node tmp = node;
//
//        while (tmp.left != null) {
//            tmp = tmp.right;
//        }
//
//        return tmp;
//    }
//	
////get Mininum node from a node
//    Node getMinNode(Node node) {
//        Node tmp = node;
//
//        while (tmp.left != null) {
//            tmp = tmp.left;
//        }
//
//        return tmp;
//    }
//
//    Node deleteByCopyingRec(Node node, Boo b) {
//        if (node == null) {
//            return null;
//        }
//        if (node.info.rate < b.rate) {
//            node.right = deleteByCopyingRec(node.right, b);
//        } else if (node.info.rate > b.rate) {
//            node.left = deleteByCopyingRec(node.left, b);
//        } else {
//
//            if (node.left == null && node.right == null) {
//                return null;
//            } else if (node.left != null && node.right != null) {
//                Node delNode = getMinNode(node.right);
//                deleteByCopyingRec(node.right, delNode.info);
//                node.info = delNode.info;
//            } else if (node.right == null) {
//                node = node.left;
//            } else {
//                node = node.right;
//            }
//        }
//
//        return node;
//    }
//	
//
//	//use this function to delete a element b
//    void deleteByCopying(Boo b) {
//        root = deleteByCopyingRec(root, b);
//    }
//
//
//----------------DELETE---------------------------------------
//
//------------------------------------------------------------
//
//--------------------Travesal-------------------------------
//
//======lay phan tu vi tri index theo cach duyet pre-order=====
//
//    void getElementPreorder(Node node, ArrayList<Node> list) {
//        if (node == null)
//            return;
//
//        list.add(node);
//        getElementPreorder(node.left, list);
//        getElementPreorder(node.right, list);
//    }
//    
////ham nay de lay
//    Node getElementPreorder(int index) {
//        ArrayList<Node> list = new ArrayList<>();
//        getElementPreorder(root, list);
//        return list.get(index - 1);
//    }
//
//==============================================================
//
//=======lay phan tu vi tri index theo cach duyet inorder======
//
//    void getElementInorder(Node node, ArrayList<Node> list) {
//        if (node == null)
//            return;
//
//        getElementInorder(node.left, list);
//        list.add(node);
//        getElementInorder(node.right, list);
//    }
//    //ham nay de lay
//    Node getElementInorder(int index) {
//        ArrayList<Node> list = new ArrayList<>();
//        getElementInorder(root, list);
//        return list.get(index - 1);
//    }
//
//=============================================================
//
//
//==========lay phan tu vi tri index theo cach duyet post-order===============
//
//    void getElementPostorder(Node node, ArrayList<Node> list) {
//        if (node == null)
//            return;
//
//        getElementPostorder(node.left, list);
//        getElementPostorder(node.right, list);
//        list.add(node);
//    }
//    
//    Node getElementPostorder(int index) {
//        ArrayList<Node> list = new ArrayList<>();
//        getElementPostorder(root, list);
//        return list.get(index - 1);
//    }
//
//====================================================================
//
//===================lay phan tu theo cach duyet breadth===============
//
//    void getElementBreadth(Node p, ArrayList<Node> list) {
//        if (p == null) {
//            return;
//        }
//        
//        Queue q = new Queue();
//        q.enqueue(p);
//        Node r;
//        while (!q.isEmpty()) {
//            r = q.dequeue();
//            list.add(r);
//            if (r.left != null) {
//                q.enqueue(r.left);
//            }
//            if (r.right != null) {
//                q.enqueue(r.right);
//            }
//        }
//    }
//    //dung ham nay de lay
//    Node getElementBreadth(int index) {
//        ArrayList<Node> list = new ArrayList<>();
//        getElementBreadth(root, list);
//        
//        return list.get(index - 1);
//    }
//=======================ROLATE===============================
//
//    Node getParentNodeOf(Node parent, Node node) {
//        Node ans = null;
//        if (parent == null) {
//            return null;
//        }
//        Node left = parent.left, right = parent.right;
//        //so sanh theo key
//        if (left != null && left.info.hoof == node.info.hoof) {
//            return parent;
//        }
//        if (right != null && right.info.hoof == node.info.hoof) {
//            return parent;
//        }
//        //so sanh theo key
//        if (parent.info.hoof < node.info.hoof) {
//            ans = getParentNodeOf(parent.right, node);
//        } else if (parent.info.hoof > node.info.hoof) {
//            ans = getParentNodeOf(parent.left, node);
//        }
//        
//        return ans;
//    }
//    
//    Node getParentNodeOf(Node node) {
//        return getParentNodeOf(root, node);
//    }
//    
//    void rolateLeft(Node node) {
//        Node parent = getParentNodeOf(node);
//        Node rightChild = node.right;
//        
//        if (rightChild != null) {
//            node.right = rightChild.left;
//            rightChild.left = node;
//            
//            if (parent != null) {
//                Node left = parent.left, right = parent.right;
//                
//                if (left != null && left.info.hoof == node.info.hoof) {
//                    parent.left = rightChild;
//                } else {
//                    parent.right = rightChild;
//                }
//            } else {
//                root = rightChild;
//            }
//        }
//    }
//    
//    void rolateRight(Node node) {
//        Node parent = getParentNodeOf(node);
//        Node leftChild = node.left;
//        
//        if (leftChild != null) {
//            node.left = leftChild.right;
//            leftChild.right = node;
//            
//            if (parent != null) {
//                Node left = parent.left, right = parent.right;
//                
//                if (left != null && left.info.hoof == node.info.hoof) {
//                    parent.left = leftChild;
//                } else {
//                    parent.right = leftChild;
//                }
//            } else {
//                root = leftChild;
//            }
//        }
//    }
//=================ROLATE=========================================
//
//=============BONUS============================================
//
//------------Tính chi�?u cao cây----------------------------------
//    int getMaxNumber(int x, int y) {
//        return (x < y) ? y : x;
//    }
//    
//    int getTreeHeightRec(Node node, int height) {
//        if (node == null)
//            return height;
//        
//        return getMaxNumber(getTreeHeightRec(node.left, height + 1), getTreeHeightRec(node.right, height + 1));
//    }
//
//    //ham tinh chieu cao cay
//    int getTreeHeight() {
//        return getTreeHeightRec(root, 0);
//    }
//------------------------------------------------------------------------------------------
//
//===================đếm số nốt con tại gốc là node===========================
//    int countNodeOfSubTree(Node node) {
//        if (node == null)
//            return 0;
//        
//        int count = 1 + countNodeOfSubTree(node.left) + countNodeOfSubTree(node.right);
//                
//        return count;
//    }
//=================================================================================
//
//======================dem so not la ========================
//    int countLeaf(Node node) {
//        if (node == null)
//            return 0;
//        if (node.left == null && node.right == null)
//            return 1;
//        
//        return countLeaf(node.left) + countLeaf(node.right);
//    }
//================================================
//
//==================== �?ếm số nốt lá trong Tree=================================
