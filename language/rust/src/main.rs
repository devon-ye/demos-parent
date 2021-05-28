fn main() {
    let mut str: String = String::from("Hello word!");
   //str= str.replace( ' ',"%20");
  //  println!("result:{}",str);
    replace_space(str);
}


fn replace_space(str:String) -> String {
    let mut result = String::new();
    let mut last_end = 0;
    for (start, part) in str.match_indices(' ') {
        result.push_str(unsafe { str.get_unchecked(last_end..start) });
        result.push_str("%20");
        last_end = start + part.len();
    }
    result.push_str(unsafe { str.get_unchecked(last_end..str.len()) });
    println!("result###########{}",result);
    result
}

pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
    if nums.len() == 0 {
        return vec![-1, -1];
    }


    let mut left_index = 0;
    let mut right_index = nums.len();
    while left_index <= right_index {
        let mid = (left_index + right_index) / 2;
        if target < nums[mid] && mid >= 1 {
            right_index = mid - 1;
            println!(" right_index--:{}", right_index);
        } else if target > nums[mid] {
            left_index = mid + 1;
            println!(" left_index++:{}", left_index);
        } else if target == nums[mid] && target < nums[right_index] {
            right_index = mid;
            println!(" right_index:{}", right_index);
        } else if target == nums[mid] && target > nums[left_index] {
            left_index = mid;
            println!(" left_index:{}", left_index);
        } else if target.eq(&nums[left_index]) && target.eq(&nums[right_index]) {
            let left = left_index as i32;
            let right = right_index as i32;
            println!("return true");
            return vec![left, right];
        }
    }
    println!("return false left_idex:{} right_index:{}", left_index, right_index);
    return vec![-1, -1];
}