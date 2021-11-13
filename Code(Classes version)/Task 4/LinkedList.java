public class LinkedList {

    Node head;

    public void enterData(Patient waitPatient){ // https://www.youtube.com/watch?v=SMIq13-FZSE
        Node node=new Node(); //create new object of node class
        node.data=waitPatient;
        node.next=null;

        if(head==null){
            head=node;
        }
        else{
            Node v=head;
            while(v.next!=null){
                v=v.next;
            }
            v.next=node;
        }
        System.out.println("Added to waiting list:"+node.data.firstName);
    }

    /*public void deleteData(int index) {
        Node v1temp = new Node();
        if (index == 0) {
            head = head.next;
        } else {
            Node v = head;
            Node v1 = null;
            for (int i = 0; i < index; i++) {
                v = v.next;
            }
            v1 = v.next;
            v.next = v1.next;
            //System.out.println("n1 " + n1.data);
            //v1temp=v1;
            //v1 = null;
            //System.out.println("v1" + v1.data);
            System.out.println("v1" + v1.data);
            System.out.println("v1" + v1.data.firstName);
            v1=null;
        }
        //return v1temp.data;
    }*/
    public Patient deleteData(int index)
    {
        Patient tempvar = null;
        if(index==0)
        {
            tempvar = head.data;
            head = head.next;

        }
        else
        {
            Node n = head;
            Node n1 = null;
            for(int i=0;i<index-1;i++)
            {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            //System.out.println("n1 " + n1.data);
            tempvar = n1.data;
            n1 = null;
        }
        return tempvar;
    }
    public void show(){
        Node node = head;

        while(node.next!=null)
        {
            System.out.println(node.data.firstName);
            node = node.next;
        }
        //System.out.println(node.data);
    }
    public String get(int index) {
        if (index <= 0) { //Index must be 0 or higher
            return ("error");
        }
        Node current = head.next;
        for (int i = 1; i < index; i++) {
            if (current.next == null)
                throw new ArrayIndexOutOfBoundsException();
            current = current.next;
        }
        return current.data.firstName;
    }
}