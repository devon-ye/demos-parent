//------------------------------------stack data structure------------------------------------------
#[derive(Clone, Debug)]
struct StackNode<T> {
    val: T,
    next: Option<Box<StackNode<T>>>,
}

#[derive(Debug)]
struct Stack<T> {
    top: Option<Box<StackNode<T>>>,
}

impl<T> Stack<T> {
    pub fn new() -> Stack<T> {
        Stack { top: None }
    }

    pub fn pop(&mut self) -> StackNode<T> {
        let val = self.top.take();
        match val {
            None => None,
            Some(&mut x) => {
                self.top = x.next.take();
                Some(x.val)
            }
        }
    }

    pub fn push(&mut self, value: T) {
        let newNode = StackNode::new(value);
        let next = self.top.take();
        newNode.next = next;
        self.top = Some(Box::new(newNode));
    }
}

#[test]
fn stack_test() {
    struct TestI32 {
        a: i32,
    }
    let stack = Stack::<i32>::new();
    stack.push(stack, Some(4));
    assert_eq!(stack.pop(), Some(4));
}

//------------------------------------- stack  end -------------------------------------------------

//------------------------------------- Queue start ------------------------------------------------

#[derive(Debug)]
struct Queue<T> {
    data: Vec<T>,
}

impl<T> Queue<T> {
    fn new() -> Self {
        Queue { data: Vec::new() }
    }

    fn push(&mut self, element: T) {
        self.data.push(element);
    }

    fn pop(&mut self) -> T {
        self.data.remove(0);
    }
}

fn main() {
    let mut q = Queue::new();
    q.push(1);
    q.push(2);
    q.push(3);
    println!("{:?}", q);
    q.pop();
    println!("{:?}", q);
    q.pop();
    println!("{:?}", q);
}
