//----------------CSD201 Function------------------------------------
//
//-------------LinkedList--------------------------------------
//
//=========INSERT=====================================
//
////add an element to the head of list --- insert first
//    void addFirst(Boo b) {
//        Node node = new Node(b);
//        if (isEmpty()) {
//            head = node;
//            tail = head;
//            return;
//        }
//
//        node.next = head;
//        head = node;
//    }
//
////add an element to the tail of list --- insert last
//    void addLast(Boo b) {
//        Node node = new Node(b);
//        if (isEmpty()) {
//            head = node;
//            tail = head;
//            return;
//        }
//
//        tail.next = node;
//        tail = node;
//    }
//
////add an item to the position pos
//void addPosition(Boo b, int pos) {
//        Node node = head;
//        Node insertNode = new Node(b);
//        int index = 1;
//        
//        if (pos == 1) {
//            insertNode.next = head;
//            head = insertNode;
//        }
//        
//        while (node.next != null) {
//            if (index == pos - 1) {
//                insertNode.next = node.next;
//                node.next = insertNode;
//                return;
//            }
//            
//            node = node.next;
//            ++index;
//        }
//        
//        node.next = insertNode;
//        tail = insertNode;
//    }
//
//=========INSERT=====================================
//
//====================DELETE======================
//
////delete a element at position x
//    void deletePosition(int x) {
//        
//        Node node = head;
//        int index = 1;
//        
//        if (x == 1) {
//            head = head.next;
//            return;
//        }
//        
//        while (node.next != null) {
//            if (index == x - 1) {
//                node.next = node.next.next;
//                
//                if (node.next == null)
//                    tail = node;
//                
//                return;
//            }
//            
//            node = node.next;
//            ++index;
//        }
//    }
//
//====================Get Information of List======================
//    //get the size of the list
//	int getSizeOfLinkList() {
//        int index = 0;
//        Node node = head;
//        
//        while (node != null) {
//            ++index;
//            node = node.next;
//        }
//        
//        return index;
//    }
//	
//	//lay phan tu vi tri pos trong linkedlist
//    Boo getElement(int pos) {
//        
//        Node node = head;
//        int index = 0;
//        while (node != null) {
//            
//            if (index + 1 == pos)
//                return node.info;
//            
//            if (index + 1 > pos)
//                return null;
//            
//            node = node.next;
//            ++index;
//        }
//        
//        return null;
//    }
//    
//=================================SORT================================
//	//get elements(return an arraylist) from <begin> to <end>
//    ArrayList<Node> getElementsFromBeginToEnd(int begin, int end) {
//        Node node = head;
//        int size = end - begin + 1;
//        ArrayList<Node> list = new ArrayList<>();
//        int index = 1;
//        
//        while (node != null) {
//            if (index > end)
//                return list;
//            
//            else if (index >= begin)
//                list.add(node);
//            
//            node = node.next;
//            ++index;
//        }
//        
//        return list;
//    }
//
////sort tang dan tu vi tri begin den end
//    void sortByASC(int begin, int end) {
//        
//        ArrayList<Node> list = getElementsFromBeginToEnd(begin, end);
//        
//        for (int i = 0; i < list.size(); ++i)
//            for (int j = i + 1; j < list.size(); ++j)
//			//chinh sua so sanh o day
//                if (list.get(i).info.sound > list.get(j).info.sound) {
//                    Boo tmp = list.get(i).info;
//                    list.get(i).info = list.get(j).info;
//                    list.get(j).info = tmp;
//                }        
//    }
//
//
////sort giam dan tu vi tri begin den end
//    void sortByDESC(int begin, int end) {
//        
//        ArrayList<Node> list = getElementsFromBeginToEnd(begin, end);
//        
//        for (int i = 0; i < list.size(); ++i)
//            for (int j = i + 1; j < list.size(); ++j)
//			//chinh sua so sanh o day
//                if (list.get(i).info.sound < list.get(j).info.sound) {
//                    Boo tmp = list.get(i).info;
//                    list.get(i).info = list.get(j).info;
//                    list.get(j).info = tmp;
//                }        
//    }
//
//=========================SORT===============================
//
//=======================tim vi tri nho nhat==============================
//    int getMinPosition() {
//        
//        int pos = 1;
//        int min;
//        int ans = 0;
//        
//        if (isEmpty())
//            return 0;
//        
//        min = head.info.weight;
//        Node node = head;
//        while (node != null) {
//            
//            if (node.info.weight < min) {
//                min = node.info.weight;
//                ans = pos;
//            }
//            
//            node = node.next;
//            pos++;
//        }
//        
//        return ans;
//    }

//==============================lay vi tri lon nhat===================
//int getMaxPosition() {
//        int pos = 1;
//        int min;
//        int ans = 0;
//        
//        if (isEmpty())
//            return 0;
//        
//        min = head.info.weight;
//        Node node = head;
//        while (node != null) {
//         
//            if (node.info.weight > min) {
//                min = node.info.weight;
//                ans = pos;
//            }
//            
//            node = node.next;
//            pos++;
//        }
//        
//        return ans;
//    }
//============================================================================