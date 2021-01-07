pub fn print_enum() {
    let numbers = 45..100;

    for i in numbers {
        println!("This is number:{}", i);
    }

    let annimals = vec!["cat", "dog", "pig"];

    for a in annimals.iter() {
        println!("this is annimal:{}", a);
    }

    for (index, a) in annimals.iter().enumerate() {
        println!("this is index:{} annimal:{}", index, a);
    }

    let tuple1 = (1, "mamei", 3.78, true);
    println!("this is tuple1.2={}", tuple1.2);
}

fn direction() {
    let play_direction: Direction = Direction::UP;

    match play_direction {
        Direction::UP => println!("we are heading up!"),
        Direction::DOWN => println!("we are heading up!"),
        Direction::LEFT => println!("we are heading up!"),
        Direction::RIGHT => println!("we are heading up!"),
    }
}

fn reference() {
    let x = 10;
    let xr = &x;
    print!("xr:{}", xr);
}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
}

fn main(){

}

#[test]
fn test(){
    reference();
}





