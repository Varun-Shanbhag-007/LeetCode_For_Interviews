Map<Node, Node> clonedMap = new HashMap<Node, Node>();

    Node temp = head;
    Node current = head;
    
    while(temp != null){
        
    // Initially setting next and random pointers to null as we have not cloned them.
    clonedMap.put(temp, new Node(temp.val, null, null));
    temp = temp.next;
        
    }
    
    // Setting the next and random by retrieving from Map
    while(current != null){
        
    clonedMap.get(current).next =  clonedMap.get(current.next);
    clonedMap.get(current).random = clonedMap.get(current.random);
    current = current.next;
        
    }
    
    return clonedMap.get(head);
    
}
