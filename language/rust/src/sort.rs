struct Input<T> {
    input: T,
}

impl<T> Input<T> {
    pub fn bubble(array: &Input<T>) -> &Input<T> {
        println!("executing... bubble sort");
        let ids = 12;
    }
}

impl<T> Input<T> {
    pub fn search(nums: Vec<&T>, target: &T) -> i32 {
        let mut start_index = 0;
        let mut end_index = nums.len() - 1;

        while start_index <= end_index {
            let mid = (&start_index + end_index) / 2;

            if target > nums[mid] {
                start_index = mid + 1;
            } else if target < nums[mid] {
                end_index = mid - 1;
            } else {
                let res = mid as i32;
                return res;
            }
        }
        return -1;
    }
}

fn main() {}

