//------------------------------------stack data structure----------------------------------
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
        self.top = Some(Box::new(node));
    }
}
