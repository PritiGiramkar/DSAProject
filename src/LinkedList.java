
public class LinkedList {
  Node head;
  Node tail;
  
  LinkedList() {
    head = tail = null;
  }
  
  
  // 1) public void addSong(String title, String duration)
  // Precond: title and duration are the title and duration as input in the command prompt
  // Effect : a new node is created and added to the beginning of the doubly linked list.
  // The title and duration is applied to the new node.
  // If the list is empty, a new node is created as the starting node of the list.
  public void addSong(String title, String duration) {
    //Create a new node
    Node newNode = new Node(title, duration);
    
    //If list is empty
    if(head == null) {
      head = tail = newNode;
      head.previous = null;
      tail.next = null;
    }
    else {
      tail.next = newNode;
      newNode.previous = tail;
      tail = newNode;
      tail.next = null;
    }
  }
  
  
  // 2) public int findSong(String t)
  // Precond : Playlist is already populated with multiple nodes using addSong()
  // Effect : the program finds the exact match of the song t and returns the track number / position of the
  // song in the playlist.
  public int findSong(String t) {
    Node current = head;
    int position = 1;
    
    while (current != null) {
      if (current.title.equals(t)) {
        return position;
      }
      current = current.next;
      position++;
    }
    
    return -1; // Song not found
  }
  
  
  // 3) public void deleteAtPos(int pos)
  // Precond: Playlist is already populated with multiple nodes using addSong()
  // Effect: Deletes the song at position pos input in the command prompt. Ensure the position is a valid one.
  public void deleteAtPos(int pos) {
    if (head == null) {
      return; // Empty playlist
    }
    
    if (pos == 1) {
      head = head.next;
      if (head != null) {
        head.previous = null;
      }
      return;
    }
    
    int position = 1;
    Node current = head;
    while (current != null && position < pos) {
      current = current.next;
      position++;
    }
    
    if (current == null) {
      return; // Invalid position
    }
    
    if (current.next != null) {
      current.next.previous = current.previous;
    }
    
    if (current.previous != null) {
      current.previous.next = current.next;
    }
  }

  
  // 4) public String getSongAtPos(int pos)
  // Precond : Playlist is already populated with multiple nodes using addSong()
  // Effect: Returns the song title at the given position. This is used to traverse the playlist (next track /
  // previous track)
  public String getSongAtPos(int pos) {
    if (isEmpty() || pos < 1) {
      return null;
    }
  
    Node current = head;
    int currentPosition = 1;
  
    while (current != null && currentPosition < pos) {
      current = current.getNext();
      currentPosition++;
    }
  
    if (current != null) {
      return current.getSong();
    } else {
      return null;
    }
  }
  
  private boolean isEmpty() {
    return head == null;
  }
  
  
  // 5) public void sortList()
  // Precond : Playlist is already populated with multiple nodes using addSong()
  // Effect : Sorts the songs in the playlist in alphabetical order based on the song title
  public void sortList() {
    if (isEmpty() || head == tail) {
      return; // Nothing to sort
    }
  
    boolean swapped;
    Node current;
    Node previous = null;
  
    do {
      swapped = false;
      current = head;
    
      while (current.getNext() != previous) {
        Node nextNode = current.getNext();
        if (current.getSong().compareTo(nextNode.getSong()) > 0) {
          swapNodes(current, nextNode);
          swapped = true;
        }
        current = current.getNext();
      }
      previous = current;
    } while (swapped);
  }
  
  private void swapNodes(Node node1, Node node2) {
    String tempSong = node1.getSong();
    node1.setSong(node2.getSong());
    node2.setSong(tempSong);
  }
  // 6) public void display()
  // Precond: none
  // Effect : Displays the position, song title and duration of all the songs in the playlist.
  public void display() {
    if (isEmpty()) {
      System.out.println("Playlist is empty.");
    } else {
      System.out.println("========== Playlist ==========");
      Node current = head;
      int position = 1;
    
      while (current != null) {
        System.out.println("Position: " + position);
        System.out.println("Song: " + current.getSong());
        System.out.println("Duration: " + current.getDuration());
        System.out.println("-----------------------------");
      
        current = current.getNext();
        position++;
      }
      System.out.println("==============================");
    }
  }
}


