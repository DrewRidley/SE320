public class GenericStack<Item> {
    private Object[] arr;
    private int len;
    private int capacity;

    public GenericStack() {
        capacity = 2;
        arr = new Object[capacity];  
        len = 0;
    }

    public GenericStack(int cap) {
        this.capacity = cap;
        this.arr = new Object[cap];  
        len = 0;
    }

    public int getSize() {
        return this.len;
    }

    @SuppressWarnings("unchecked")
    public Item peek() {
        if (this.len == 0) {
            return null;
        } else {
            return (Item) arr[this.len - 1];
        }
    }

    public void push(Item n) {
        if (len == capacity) {
            //grow the array
            this.capacity *= 2;
            Object[] newArr = new Object[this.capacity];
            for (int i = 0; i < this.len; i++) { 
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[len] = n;
        len++;
    }

    @SuppressWarnings("unchecked")
    public Item pop() {
        if (this.len == 0) {
            return null;
        } else {
            Item ret = (Item) arr[this.len - 1];
            arr[this.len - 1] = null;
            this.len--;
            return ret;
        }
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    @Override
    public String toString() {
        //Can use string builder here to make a nice toString override.
        StringBuilder sb = new StringBuilder("Stack: [");  
        for (int i = 0; i < len; i++) {
            sb.append(arr[i]);
            if (i < len - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //This is to test that the stack functions as expected.
    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);  
    }
}