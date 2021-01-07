use std::time::Instant;

//Binary Search Tree
pub fn find_number_in2_d_array(matrix: Vec<Vec<i32>>, target: i32) -> bool {
    if matrix.len() == 0 || matrix[0].len() == 0 {
        return false;
    }
    for v in &matrix {
        let mut left = 0;
        let mut right = v.len() - 1;
        if v[left] < target && target < v[right] {
            //==== Binary Search =========
            while left <= right {
                let mut mid = (left + right) / 2;
                if v[mid] < target {
                    left = mid + 1;
                } else if v[mid] > target {
                    right = mid - 1;
                } else {
                    println!("Binary Search find target: {} ", target);
                    return true;
                }
            }
        } else if v[left] == target || v[right] == target {
            println!("find target: {}  left value: {} right value: {}", target, v[left], v[right]);
            return true;
        } else if target > v[right] {
            println!("next row!");
            continue;
        } else if target < v[left] {
            println!("target not exists!");
            return false;
        }
    }
    println!("target not found!");
    return false;
}

fn main() {



}

#[cfg(test)]
mod tests {

    #[test]
    fn test_print_enum() {

        let row1 = vec![1, 2, 3, 34, 40];
        let row2 = vec![14, 18, 37, 70, 79];
        let row3 = vec![37, 40, 57, 90, 120];
        let row4 = vec![50, 60, 90, 130, 400];

        let mut doubleDimonArray = Vec::new();

        doubleDimonArray.push(row1);
        doubleDimonArray.push(row2);
        doubleDimonArray.push(row3);
        doubleDimonArray.push(row4);
        let start = Instant::now();

        find_number_in2_d_array(doubleDimonArray, 400);
        println!("time cost: {:?} ns", start.elapsed().as_nanos());// us
        println!("time cost: {:?} us", start.elapsed().as_micros());
    }
}
