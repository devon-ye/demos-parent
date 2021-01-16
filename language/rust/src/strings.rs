
/// str.replace( from ,to);
fn replace_space(str:String) -> String {
    let mut result = String::new();
    let mut last_end = 0;
    for (start, part) in str.match_indices(' ') {
        result.push_str(unsafe { str.get_unchecked(last_end..start) });
        result.push_str("%20");
        last_end = start + part.len();
    }
    result.push_str(unsafe { str.get_unchecked(last_end..str.len()) });
    result
}